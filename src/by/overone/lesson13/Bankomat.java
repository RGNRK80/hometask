package by.overone.lesson13;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bankomat implements IConv {
    private Currency byn = new BYN();
    private Currency usd = new USD();
    private Currency eur = new EUR();

    public Currency getByn() {
        return byn;
    }
    public Currency getUsd() {
        return usd;
    }
    public Currency getEur() {
        return eur;
    }

    public Bankomat() {

    }

    public void incassator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("number of banknotes BYN: 100 ");
        int x100=scanner.nextInt();
        System.out.println("number of banknotes BYN: 50 ");
        int x50=scanner.nextInt();
        System.out.println("number of banknotes BYN: 20 ");
        int x20=scanner.nextInt();
        System.out.println("number of banknotes BYN: 10 ");
        int x10=scanner.nextInt();
        int[] cup={x100,x50,x20,x10};
        this.byn.setAmount(cup[0]*100+cup[1]*50+cup[2]*20+cup[3]*10);
        this.byn.setCupInBANK(cup);

        System.out.println("number of banknotes USD:100 ");
        int ux100=scanner.nextInt();
        int[] cup1={ux100};
        this.usd.setAmount(cup1[0]*100);
        this.usd.setCupInBANK(cup1);

        System.out.println("number of banknotes  EUR:100 ");
        int ex100=scanner.nextInt();
        int[] cup2={ex100};
        this.eur.setAmount(cup2[0]*100);
        this.eur.setCupInBANK(cup2);

        amount();
    }


    @Override
    public void convert(Currency currency, double sum, Account account) {
      //  System.out.println("test" + byn.cupInBANK[0]);
        double account_in_currency = account.account / currency.getCoefficient();
        if (account_in_currency < sum) {
            System.out.println("to low money on account");       // проверка хватит ли денег на счету
        } else {
            int rezult = (int) (sum / currency.getCoefficient());

            //белорусские рубли

            if (currency instanceof BYN) {
                if (rezult * currency.getCoefficient() <= this.byn.getAmount()) {   // проверка хватит ли денег в банкмате по бел руб.

                    // вставка проверка наличие купюр
                    int cupval = 10;
                    if (byn.cupInBANK[3] > 0) {
                        cupval = 10;
                    } else {
                        if (byn.cupInBANK[2] > 0) {
                            cupval = 20;
                        } else {
                            if (byn.cupInBANK[1] > 0) {
                                cupval = 50;
                            }
                        }
                    }

                    // проверка по минимальной купюрк

                    if (sum%cupval>0) {
                        System.out.println("too low sum, enter more than " + cupval); // крайняя купюра
                    }

                    if (sum%cupval==0) {

                    if (issueBYN((int)sum, byn.cupInBANK)){;   // ------------------------------------------------------------    метод выдачи

                    System.out.println(" to issue :" + sum + " " + currency.getName());
                    account.account = account.account - sum * currency.getCoefficient();
                    this.byn.setAmount(this.byn.getAmount() - sum);}}

                } else {
                    System.out.println(" no enough money in this bankomat ");
                }

            }



            // евры


            if (currency instanceof EUR) {
                if (sum%100>0) {
                    System.out.println("too low sum, enter more than " + 100);
                } else {

                issueVal((int) sum, eur.cupInBANK);  //-------------------------------------------выдача евров

                if (rezult * currency.getCoefficient() <= this.eur.getAmount()) {
                    System.out.println(" to issue :" + sum + " " + currency.getName());
                    account.account = account.account - sum * currency.getCoefficient();
                    this.eur.setAmount(this.eur.getAmount() - sum);
                } else {
                    System.out.println(" no enough money in this bankomat ");
                }
            }
            }

            //доллары

            if (currency instanceof USD) {
                if (sum%100>0) {
                    System.out.println("too low sum, enter more than " + 100);
                } else {

                    issueVal((int) sum, usd.cupInBANK);  //-------------------------------------------выдача долл

                    if (rezult * currency.getCoefficient() <= this.usd.getAmount()) {
                        System.out.println(" to issue :" + sum + " " + currency.getName());
                        account.account = account.account - sum * currency.getCoefficient();
                        this.usd.setAmount(this.usd.getAmount() - sum);
                    } else {
                        System.out.println(" no enough money in this bankomat ");
                    }
                }
            }

        }

    }

    public void amount() {
        System.out.println("total byn in bank: " + byn.getAmount());
        System.out.println("total usd in bank: " + usd.getAmount());
        System.out.println("total eur in bank: " + eur.getAmount());

    }

    public boolean  issueBYN(int amount, int[] cupInBANK){
        // нужно выдать
        boolean chechbanknotes=true;
        int[] cup=new int[4]; //  клон купюр
        int[][] cupissue= new int[2][4];                                                         // пачка к выдаче

        int choose=0;
        if (amount*10<cupInBANK[1]*50) {choose=1;}


        for (int k=0; k<=choose; k++) {                             //начало
            cupissue[k][0]=0;
            int counter=0;
            for (int j = 0; j < cupInBANK.length; j++) {   //копия банкомата
                cup[j] = cupInBANK[j];
            }

            int counteLast = amount;
            int value=0;


            for (int i = k; i < cup.length; i++) {

                switch (i) {
                    case 0:
                        value = 100;
                        break;
                    case 1:
                        value = 50;
                        break;
                    case 2:
                        value = 20;
                        break;
                    case 3:
                        value = 10;
                        break;
                }

                cupissue[k][i] = counteLast / value; //12
                if (cup[i] > cupissue[k][i]) {
                    cup[i] -= cupissue[k][i];
                } else {
                    cupissue[k][i] = cup[i];
                    cup[i] = 0;
                }
                counter += cupissue[k][i] * value;
                counteLast = amount - counter;

            }
           // System.out.println(counter); - отображение счетчика

            if (counter!=amount) {
                System.out.println(" mistake of availability of banknotes try agane");
                chechbanknotes=false;
                return false;

            }
        } // окончание

        if (chechbanknotes) {
            System.out.println("choose type to issue:");
            //System.out.println(" 1: " + "100x: " + cupissue[0][0] + "  50x: " + cupissue[0][1] + "  20x: " + cupissue[0][2] + "  10x: " + cupissue[0][3]);
            System.out.print("1:   ");
            if (cupissue[0][0]>0) {System.out.print(" 100x: " + cupissue[0][0]);}
            if (cupissue[0][1]>0) {System.out.print(" 50x: " + cupissue[0][1]);}
            if (cupissue[0][2]>0) {System.out.print(" 20x: " + cupissue[0][2]);}
            if (cupissue[0][3]>0) {System.out.print(" 20x: " + cupissue[0][3]);}
            System.out.print(" --BYN\n");
            if (choose == 1 && !Arrays.equals(cupissue[0],cupissue[1])) {
              //  System.out.println(" 2: " + "100x: " + cupissue[1][0] + "  50x: " + cupissue[1][1] + "  20x: " + cupissue[1][2] + "  10x: " + cupissue[1][3]);
                System.out.print("2:    ");

                if (cupissue[1][0]>0) {System.out.print("100x: " + cupissue[1][0]);}
                if (cupissue[1][1]>0) {System.out.print("50x: " + cupissue[1][1]);}
                if (cupissue[1][2]>0) {System.out.print("20x: " + cupissue[1][2]);}
                if (cupissue[1][3]>0) {System.out.print("20x: " + cupissue[1][3]);}
                System.out.print(" --BYN\n");


            }
            int type;   // выбор пачки к выдаче
            Scanner scanner = new Scanner(System.in);
            type = scanner.nextInt() - 1;
            if (type == 0 || type == 1) {
                for (int w = 0; w < 3; w++) {
                    cupInBANK[w] -= cupissue[type][w];
                }
                System.out.println(" forr issue " + "  100x: " + cupissue[type][0] + "  50x: " + cupissue[type][1] + "  20x: " + cupissue[type][2] + "  10x: " + cupissue[type][3]);
            }
        }
        return true;
    }



    public static void issueVal(int amount,int[] cupInBANK){
        // нужно выдать
        int[] cup=new int[1]; //  клон купюр
            int[][] cupissue= new int[1][1];                                                         // пачка к выдаче
                int counter=0;
               //копия банкомата
                cup[0] = cupInBANK[0];

            int counteLast = amount;
            int value=100;

                cupissue[0][0] = counteLast / value;
                if (cup[0] > cupissue[0][0]) {
                    cup[0] -= cupissue[0][0];
                } else {
                    cupissue[0][0] = cup[0];
                    cup[0] = 0;
                }
                counter += cupissue[0][0] * value;
                counteLast = amount - counter;

                cupInBANK[0] -= cupissue[0][0];

            System.out.println(" for issue " + "  100x: " + cupissue[0][0]);
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bankomat bankomat = (Bankomat) o;
        return Objects.equals(byn, bankomat.byn) && Objects.equals(usd, bankomat.usd) && Objects.equals(eur, bankomat.eur);
    }

    @Override
    public int hashCode() {
        return 31*(byn.hashCode()+ usd.hashCode()+ eur.hashCode());
    }
}


