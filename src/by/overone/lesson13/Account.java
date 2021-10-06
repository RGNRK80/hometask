package by.overone.lesson13;

public class Account extends Currency{
    double account;
    public Account(double account){
        setName("Account");
        setCoefficient(1);
        this.account=account;
    }
    public void condition(){
        System.out.println("you have " + this.account + " BYN on your Bank Account");
    }
}
