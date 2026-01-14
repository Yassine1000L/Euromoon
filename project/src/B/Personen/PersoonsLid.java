package B.Personen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class PersoonsLid extends Persoon {

    private List<String> certificaties;

    public PersoonsLid(String voornaam, String achternaam, String rijksRegisterNummer, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksRegisterNummer, geboortedatum);
        this.certificaties = new ArrayList<>();
    }

    //Een certificatie toevoegen aan de lijst van certificaties
    public void voegCertificatieToe(String certificatie) {
        certificaties.add(certificatie);
    }

    //Controleren of de persoon een bepaalde certificatie heeft
    public boolean hebJeEenCertificatie(String certificate) {
        return certificaties.contains(certificate);
    }

    //Lijst van certificaties ophalen
    public List<String> getCertificaties() {
        return new ArrayList<>(certificaties);
    }




}
