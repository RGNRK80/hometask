package by.overone.lesson13;


import java.util.Arrays;


public abstract class Currency {
    String name;                 // наименование валюты
    private double coefficient;  // курс
    private double amount;       // сумма в банке
    protected int[] cupInBANK;     //купюры

    public int[] getCupInBANK() {
        return cupInBANK;
    }

    public void setCupInBANK(int[] cupInBANK) {
        this.cupInBANK = cupInBANK;
    }



    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return (currency.coefficient == coefficient) && (currency.amount==amount) && currency.name.equals(name) && Arrays.equals(cupInBANK, currency.cupInBANK);
    }

    @Override
    public int hashCode() {
        int result =name.hashCode()+Double.hashCode(coefficient)+ Double.hashCode(amount);
        result = 31 * result + Arrays.hashCode(cupInBANK);
        return result;
    }
}
