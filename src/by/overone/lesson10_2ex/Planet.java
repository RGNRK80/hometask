package by.overone.lesson10_2ex;


public abstract class Planet extends Starststem{
    String planetname;
    int weight;
    String habitance;

    public Planet(int coord, String name, int weight, String habitance) {
        super();
        this.weight = weight;
        this.habitance = habitance;
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
