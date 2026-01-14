package D.Reis;

import B.Personen.Passagier;
import B.Personen.PersoonsLid;
import C.Trein.Trein;
import E.Ticket.Ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Reis {

    // ========================
    // VELDEN (eigenschappen)
    // ========================
    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime tijdstip;
    private Trein trein;
    private List<PersoonsLid> personeelsleden;
    private List<Ticket> tickets;

    // ========================
    // CONSTRUCTOR
    // ========================
    public Reis(String vertrekStation,
                String aankomstStation,
                LocalDateTime tijdstip,
                Trein trein,
                List<PersoonsLid> personeelsleden) {

        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.tijdstip = tijdstip;
        this.trein = trein;
        this.personeelsleden = personeelsleden;
        this.tickets = new ArrayList<>();
    }

    // ========================
    // PERSONEEL
    // ========================
    public void voegPersoneelsLidToe(PersoonsLid lid) {
        personeelsleden.add(lid);
    }

    private int telBestuurders() {
        int count = 0;
        for (PersoonsLid p : personeelsleden) {
            if (p.hebJeEenCertificatie("Bestuurder")) {
                count++;
            }
        }
        return count;
    }

    private int telStewards() {
        int count = 0;
        for (PersoonsLid p : personeelsleden) {
            if (p.hebJeEenCertificatie("Steward")) {
                count++;
            }
        }
        return count;
    }

    public boolean isKlaarOmTeVertrekken() {
        return telBestuurders() >= 1 && telStewards() >= 3;
    }

    // ========================
    // TICKET VERKOOP
    // ========================
    public Ticket verkoopTicket(Passagier passagier, int klasse) {

        int verkocht = 0;
        int capaciteit;

        // Tel reeds verkochte tickets van deze klasse
        for (Ticket t : tickets) {
            if (t.getKlasse() == klasse) {
                verkocht++;
            }
        }

        // Bepaal capaciteit
        if (klasse == 1) {
            capaciteit = trein.getTotaleEersteKlassePlaatsen();
        } else if (klasse == 2) {
            capaciteit = trein.getTotaleTweedeKlassePlaatsen();
        } else {
            return null; // ongeldige klasse
        }

        // Is er nog plaats?
        if (verkocht < capaciteit) {
            Ticket ticket = new Ticket(passagier, this, klasse);
            tickets.add(ticket);
            return ticket;
        }

        return null;
    }

    // ========================
    // BOARDINGLIJST
    // ========================
    public void printBoardingLijstVoorTicket(Ticket ticket) {

        Passagier p = ticket.getPassagier();

        String bestandsNaam =
                vertrekStation + "_" +
                        aankomstStation + "_" +
                        p.getVoornaam() + "_" +
                        p.getAchternaam() + "_" +
                        tijdstip.toString().replace(":", "-") +
                        ".txt";

        try (FileWriter writer = new FileWriter(bestandsNaam)) {

            writer.write("=========== BOARDINGLIJST ===========\n");
            writer.write("Traject: " + vertrekStation + " -> " + aankomstStation + "\n");
            writer.write("Datum & uur: " + tijdstip + "\n");
            writer.write("Locomotief: " + trein.getLocomotief().getType() + "\n");
            writer.write("------------------------------------\n");
            writer.write("Naam: " + p.getVoornaam() + " " + p.getAchternaam() + "\n");
            writer.write("Rijksregisternummer: " + p.getRijksRegisterNummer() + "\n");
            writer.write("Geboortedatum: " + p.getGeboorteDatum() + "\n");
            writer.write("Klasse: " + (ticket.getKlasse() == 1 ? "Eerste klasse" : "Tweede klasse") + "\n");
            writer.write("====================================\n");

            System.out.println("✅ Boardinglijst aangemaakt voor " + p.getFullName());

        } catch (IOException e) {
            System.out.println("❌ Kan boardinglijst niet aanmaken");
        }
    }
}
