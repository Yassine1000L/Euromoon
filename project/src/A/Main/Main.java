package A.Main;

import B.Personen.Passagier;
import B.Personen.PersoonsLid;
import C.Trein.*;
import D.Reis.Reis;
import E.Ticket.Ticket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Scanner voor invoer
    private static Scanner scanner = new Scanner(System.in);


    // Lijsten om alles bij te houden
    private static List<Passagier> passagiers = new ArrayList<>();
    private static List<PersoonsLid> personeelsleden = new ArrayList<>();

    // Je kunt, maar 1 keer een reis per keer aanmaken
    private static Reis reis = null;

    // MAIN
    public static void main(String[] args) {

        boolean stoppen = false;

        while (!stoppen) {
            toonMenu();
            int keuze = scanner.nextInt();
            scanner.nextLine(); // buffer leegmaken

            switch (keuze) {
                case 1 -> registreerPassagier();
                case 2 -> maakReisAan();
                case 3 -> verkoopTicket();
                case 4 -> printBoardingLijsten();
                case 0 -> stoppen = true;
                default -> System.out.println("Ongeldige keuze");
            }
        }

        System.out.println("Programma afgesloten.");
    }

    // MENU
    private static void toonMenu() {
        System.out.println("\n--- EUROMOON MENU ---");
        System.out.println("1. Registreer passagier");
        System.out.println("2. Maak reis aan");
        System.out.println("3. Verkoop ticket");
        System.out.println("4. Print boardinglijsten");
        System.out.println("0. Afsluiten");
        System.out.print("Keuze: ");
    }

    // PASSAGIER
    private static void registreerPassagier() {

        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();

        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();

        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        System.out.print("Geboortedatum (YYYY-MM-DD): ");
        LocalDate geboorte = LocalDate.parse(scanner.nextLine());

        Passagier passagier = new Passagier(voornaam, achternaam, rrn, geboorte);
        passagiers.add(passagier);

        System.out.println("Passagier geregistreerd.");
    }

    // REIS
    private static void maakReisAan() {

        System.out.print("Vertrekstation: ");
        String vertrek = scanner.nextLine();

        System.out.print("Aankomststation: ");
        String aankomst = scanner.nextLine();

        LocalDateTime tijdstip = LocalDateTime.now();

        // Locomotief kiezen
        System.out.println("Locomotief type:");
        System.out.println("1. Class 373");
        System.out.println("2. Class 374");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        Locomotief loco = (keuze == 1) ? new Class373() : new Class374();
        Trein trein = new Trein(loco);

        // Wagons toevoegen
        trein.voegWagonToe(new Wagon(20, 40));
        trein.voegWagonToe(new Wagon(20, 40));

        // Personeel aanmaken
        personeelsleden.clear();

        PersoonsLid bestuurder = new PersoonsLid(
                "Wassim", "Elzalzouli", "38901738910", LocalDate.of(1986, 9, 30));
        bestuurder.voegCertificatieToe("Bestuurder");

        PersoonsLid s1 = new PersoonsLid(
                "Imane", "Ounahi", "17392019489", LocalDate.of(2000, 11, 23));
        PersoonsLid s2 = new PersoonsLid(
                "Imran", "Amrabat", "12904782992", LocalDate.of(1991, 8, 9));
        PersoonsLid s3 = new PersoonsLid(
                "Ayoub", "Ziyech", "27590128918", LocalDate.of(1992, 6, 17));

        s1.voegCertificatieToe("Steward");
        s2.voegCertificatieToe("Steward");
        s3.voegCertificatieToe("Steward");

        personeelsleden.add(bestuurder);
        personeelsleden.add(s1);
        personeelsleden.add(s2);
        personeelsleden.add(s3);

        // Reis maken
        reis = new Reis(vertrek, aankomst, tijdstip, trein, personeelsleden);

        System.out.println("Reis aangemaakt.");
    }

    // TICKET
    private static void verkoopTicket() {

        if (reis == null) {
            System.out.println("Maak eerst een reis aan.");
            return;
        }

        if (passagiers.isEmpty()) {
            System.out.println("Geen passagiers geregistreerd.");
            return;
        }

        // Voor eenvoud: eerste passagier nemen
        Passagier passagier = passagiers.get(0);

        System.out.print("Kies klasse (1 of 2): ");
        int klasse = scanner.nextInt();
        scanner.nextLine();

        // geeft een Ticket terug
        Ticket ticket = reis.verkoopTicket(passagier, klasse);

        if (ticket != null) {
            System.out.println("Ticket verkocht.");
            // Boardinglijst meteen maken voor deze passagier
            reis.printBoardingLijstVoorTicket(ticket);
        } else {
            System.out.println("Geen plaats meer beschikbaar.");
        }
    }

    // BOARDINGLIJST
    private static void printBoardingLijsten() {

        if (reis == null) {
            System.out.println("Geen reis beschikbaar.");
            return;
        }

        System.out.println("Boardinglijsten worden aangemaakt bij ticketverkoop.");
    }
}
