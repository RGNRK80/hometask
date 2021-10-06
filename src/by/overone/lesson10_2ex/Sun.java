package by.overone.lesson10_2ex;

import java.util.ArrayList;

public class Sun extends Star{

    public Sun() {
    }

    public Sun(String type, int orbit) {
        super(type, orbit);
        setStarlist(this);
        starname="Sun";


    }

    public Sun(String type, int orbit, String starname) {
        super(type, orbit);
        setStarlist(this);
        this.starname=starname;


    }

    @Override
    public void setStarlist(Star star) {
        super.setStarlist(star);
    }

    public Sun(int coord, String name) {
        super(coord, name);
    }

    @Override
    public void info() {
        super.info();
    }

    @Override
    public void moovingCrossUnivers() {
        super.moovingCrossUnivers();
    }


    @Override
    public void showIn() {
        super.showIn();
    }
}
