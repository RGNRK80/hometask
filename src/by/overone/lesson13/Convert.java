package by.overone.lesson13;

public class Convert {



  public  void convert(Currency currency, int bYnAmount) {
        System.out.print(currency.getName()+ ": ");
        System.out.print(  (bYnAmount/currency.getCoefficient()>=1)?  bYnAmount/currency.getCoefficient() :  "to low money" );
        System.out.println();

    }
}

