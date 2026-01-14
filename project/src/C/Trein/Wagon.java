package C.Trein;

public class Wagon {


    private int zitplaatsen1eKlasse;
    private int zitplaatsen2eKlasse;

    public Wagon(int zitplaatsen1eKlasse, int zitplaatsen2eKlasse) {
        this.zitplaatsen1eKlasse = zitplaatsen1eKlasse;
        this.zitplaatsen2eKlasse = zitplaatsen2eKlasse;
    }

    public int getZitplaatsen1eKlasse() {
        return zitplaatsen1eKlasse;
    }

    public int getZitplaatsen2eKlasse() {
        return zitplaatsen2eKlasse;
    }


}
