package by.overone.lesson13;

import java.util.Objects;

public class BYN extends Currency{


    private int x100;
    private int x50;
    private int x20;
    private int x10;

    public BYN() {
        setName("BYN");
        setCoefficient(1);
        int[] cupInBANK=new int[4];
        setAmount(cupInBANK[0]*100+cupInBANK[1]*50+cupInBANK[2]*20+cupInBANK[3]*10);



    }
    public int getx100() {
        return this.x100;
    }
    public int getx50() {
        return this.x50;
    }
    public int getx20() {
        return this.x20;
    }
    public int getx10() {
        return this.x10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BYN byn = (BYN) o;
        return x100 == byn.x100 && x50 == byn.x50 && x20 == byn.x20 && x10 == byn.x10;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+ Integer.hashCode(x100) + Integer.hashCode(x50) + Integer.hashCode(x20) + Integer.hashCode(x10);
    }
}
