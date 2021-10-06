package by.overone.lesson13;

import java.util.Objects;

public class USD extends Currency {
    private int x100;
    public USD() {
        setName("USD");
        setCoefficient(2.5);
        int[] cupInBANK = new int[1];
        setAmount(cupInBANK[0] * 100);

    }
    public int getx100() {
        return this.x100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        USD usd = (USD) o;
        return x100 == usd.x100;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+ Integer.hashCode(x100);
    }
}
