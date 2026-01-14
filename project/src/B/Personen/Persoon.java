package B.Personen;

import java.time.LocalDate;
// hier is de hoofdklasse Personen.Persoon
public abstract class Persoon {

    private String voornaam;
    private String achternaam;
    private String rijksRegisterNummer;
    private LocalDate geboorteDatum;

    public Persoon(String voornaam, String achternaam, String rijksRegisterNummer, LocalDate geboorteDatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksRegisterNummer = rijksRegisterNummer;
        this.geboorteDatum = geboorteDatum;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public String getAchternaam() {
        return achternaam;
    }
    public String getRijksRegisterNummer() {
        return rijksRegisterNummer;
    }
    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }
    public String getFullName() {
        return voornaam + " " + achternaam;
    }
}
