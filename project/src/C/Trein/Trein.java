package C.Trein;

import java.util.ArrayList;
import java.util.List;

public class Trein {

    private Locomotief locomotief;
    private List<Wagon> wagons;

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
        this.wagons = new ArrayList<>();
    }

    public boolean voegWagonToe(Wagon wagon) {

        int maxWagons;

        maxWagons = locomotief.getMaximumAntalWagons();

        // Controleer of er nog wagons kunnen worden toegevoegd
        if (wagons.size() < maxWagons) {
            wagons.add(wagon);
            return true;
        } else {
            return false;
        }
    }

    public int getTotaleEersteKlassePlaatsen() {
        int totaal = 80;
        for (int i = 0; i < wagons.size(); i++) {
            Wagon w1 = wagons.get(i);
            totaal += w1.getZitplaatsen1eKlasse();
        }
        return totaal;
    }

    public int getTotaleTweedeKlassePlaatsen() {
        int totaal = 80;
        for (int i = 0; i < wagons.size(); i++) {
            Wagon w2 = wagons.get(i);
            totaal += w2.getZitplaatsen2eKlasse();
        }
        return totaal;
    }

    public Locomotief getLocomotief() {
        return locomotief;
    }





}
