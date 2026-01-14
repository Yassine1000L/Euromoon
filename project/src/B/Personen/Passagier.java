package B.Personen;

import java.time.LocalDate;

public class Passagier extends Persoon {

    public Passagier(String voornaam, String achternaam, String rijksRegisterNummer,
                     LocalDate geboorteDatum) {
        super(voornaam, achternaam, rijksRegisterNummer, geboorteDatum);
    }


}