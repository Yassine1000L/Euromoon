package E.Ticket;

import B.Personen.Passagier;
import D.Reis.Reis;

public class Ticket {

    private Passagier passagier;
    private Reis reis;
    private int klasse;

    public Ticket(Passagier passagier, Reis reis, int klasse) {
        this.passagier = passagier;
        this.reis = reis;
        this.klasse = klasse;
    }

    public int getKlasse() {
        return klasse;
    }


    public Passagier getPassagier() {
        return passagier;
    }

    public Reis getReis() {
        return reis;
    }


}

