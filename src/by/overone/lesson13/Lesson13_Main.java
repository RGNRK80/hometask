package by.overone.lesson13;


import java.util.Random;
import java.util.Scanner;

public class Lesson13_Main {
    public static void main(String[] args) {
        System.out.println("git1");
        Scanner scanner = new Scanner(System.in);
        Bankomat bank = new Bankomat();

        System.out.println("-------You are incassator, please, load money-------");
        bank.incassator();

        System.out.println("----------------you are user------------------------");

        // загрузка денег на счет пользователя
        Account account1 = new Account(new Random().nextInt(10000));
        account1.condition();
        user(bank,account1);  // абработка счета account1 в банкомате bank - универсальный


    }

    public static void user (Bankomat bank, Account account1){
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        while (choose != 9) {
            System.out.println("Choose the operation...");
            System.out.println("enter currency to be issued: ");
            System.out.println("1 - BYN" + " (" + bank.getByn().getAmount() + ") " +
                    "\n2 - USD" + " (" + bank.getUsd().getAmount() + ") " +
                    "\n3 - EUR" + " (" + bank.getEur().getAmount() + ") " +
                    "\n9 - Exit");
            choose = scanner.nextInt();

            double chooseSum = 0;
            Currency curr = null;
            switch (choose) {
                case 1: {
                    System.out.println("enter amount");
                    chooseSum = scanner.nextInt();
                    curr = new BYN();
                    curr.setAmount(chooseSum);
                    break;
                }
                case 2: {
                    System.out.println("enter amount");
                    chooseSum = scanner.nextInt();
                    curr = new USD();
                    curr.setAmount(chooseSum);
                    break;
                }
                case 3: {
                    System.out.println("enter amount");
                    chooseSum = scanner.nextInt();
                    curr = new EUR();
                    curr.setAmount(chooseSum);
                    break;
                }
                case 9: {
                    System.out.println("Good day!");
                    continue;
                }
                default: {
                    System.out.println("wrong number, choose again.");
                    continue;
                }
            }
            bank.convert(curr, chooseSum, account1);
            bank.amount();
            account1.condition();
        }
    }

}
