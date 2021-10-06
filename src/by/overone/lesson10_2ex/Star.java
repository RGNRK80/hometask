package by.overone.lesson10_2ex;

abstract public class Star extends Starststem{
    String starname;
    String type;
    public int orbit;

    public Star() {

    }

    public Star(String starname, String type, int orbit) {
        this.starname = starname;
        this.type = type;
        this.orbit = orbit;
    }
    public Star(String type, int orbit) {

        this.type = type;
        this.orbit = orbit;
    }

    @Override
    public void setStarlist(Star star) {
        super.setStarlist(star);
    }

    public Star(int coord, String name) {
        super();
    }

    @Override
    public void info() {

    }

    @Override
    public void moovingCrossUnivers() {

    }

    @Override
    public void showIn() {
        super.showIn();
    }
}
