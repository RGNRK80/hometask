package by.overone.lesson10_2ex;

import java.util.ArrayList;

public abstract class Starststem {
    int coord=0;
    private static String Starsystemname="alfa+";
    private static ArrayList<Star> starlist = new ArrayList<Star>();

    public Starststem(){

    }


    public void setStarlist(Star star) {
        this.starlist.add(star);
    }

    public abstract void info();
    public abstract void moovingCrossUnivers();

    public void showIn(){
        for (Star unit: starlist) {
            System.out.println(unit.starname);
        }
    }
}
