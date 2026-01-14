package C.Trein;

public abstract class Locomotief {

    private String type;
    private int maximumAntalWagons;

    public Locomotief(String type, int maximumAntalWagons) {
        this.type = type;
        this.maximumAntalWagons = maximumAntalWagons;
    }

    public String getType() {
        return type;
    }

    public int getMaximumAntalWagons() {
        return maximumAntalWagons;
    }




}