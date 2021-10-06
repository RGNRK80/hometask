package by.overone.lesson10_2ex;

public class PlanetEarth extends Planet{

    boolean water;
    String atmosfer;


    public PlanetEarth(int coord, String Starsystemname, int weight, String habitance) {
        super(coord, Starsystemname, weight, habitance);
    }

    @Override
    public void info() {
        super.info();
    }

    @Override
    public void moovingCrossUnivers() {
        System.out.println(" Planet Earth is crossing throw universe...");
    }

    @Override
    public void showIn() {
        super.showIn();
    }
}
