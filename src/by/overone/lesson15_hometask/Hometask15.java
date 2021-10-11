package by.overone.lesson15_hometask;


import java.util.Arrays;
import java.util.Scanner;

public class Hometask15 {
    public static void main(String[] args) {
        String[] arr;
        int[] arri;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of strings");
        int n;

        /*
        n=scanner.nextInt();
        arr = new String[n];
        arri=new int[n];
        System.out.println("Enter  strings");
        scanner.nextLine();
        double center=0;
        for (int i=0; i<arr.length; i++){
            System.out.println("string"+i+":");
            arr[i]= scanner.nextLine();
            arri[i]=arr[i].length();
            center+=arri[i];
        }
        center=center/n;
        showarrs(arri,arr);

        // сортировка
        int min=arri[0];
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                if (arri[i]>arri[j]) {
                    swap(arri,arr,i,j);
                }
            }
        }

        //короткие строки
        System.out.println("most shorter string(s)");
        for (int i=0; i<n; i++){
            if (i==0) {System.out.println(arr[i]+ "  lenth: " + arr[i].length());}
            if (i>0) {
                if (arri[i]==arri[i-1]) {
                    System.out.println(arr[i]+ "  lenth: " + arr[i].length());
                } else {break;}
            }
        }

        //длинные строки
        System.out.println("most longer string(s)");
        for (int i=n-1; i>=0; i--){
            if (i==n-1) {System.out.println(arr[i]+ "  lenth: " + arr[i].length());}
            if (i<n-1) {
                if (arri[i]==arri[i+1]) {
                    System.out.println(arr[i]+ "  lenth: " + arr[i].length());
                } else {break;}
            }
        }

        //вывод упорядоченных строк
        System.out.println("Оrdered stringsreferences: ");
        showarrs(arri,arr);

        //вывод строк меньше средней
        System.out.println("shotter than middle ");
        for (int i=0; i<n; i++){
            if (arri[i]<center){
                System.out.println(arr[i]+ "  lenth: " + arr[i].length());
            }
        }

        System.out.println("middle: "+ center);

        //вывод строк длиннее средней
        System.out.println("longer than middle ");
        for (int i=0; i<n; i++){
            if (arri[i]>center){
                System.out.println(arr[i]+ "  lenth: " + arr[i].length());
            }
        }   */

        // Слова

        // ввод
        System.out.println();
        System.out.println("Enter the number of words");
        n=scanner.nextInt();
        String[] arrWords = new String[n];
        int[] arrWordsi=new int[n];
        System.out.println("Enter  words");
        scanner.nextLine();
        char[] charCounter;

        //ввод слов

        for (int i=0; i<arrWords.length; i++){
            System.out.println("word #"+(i+1)+":");
            arrWords[i]= scanner.nextLine();
        }

        // #4 -  Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если
        //таких слов несколько, найти первое из них.

        // разбиваем на символы
        for (int i=0; i<n; i++){
            charCounter=arrWords[i].toCharArray();
            Arrays.sort(charCounter); // отсортировано

            int check=0;
            for (int j=0; j<charCounter.length-1; j++){
                if (charCounter[j]==charCounter[j+1]) {
                    check+=1;
                }
            }
            arrWordsi[i]=check;
        }

        int min=0;
        String strmin=arrWords[0];

        for (int i=0; i< arrWords.length;i++){
            if (min>arrWordsi[i]){
               min=arrWordsi[i];
               strmin=arrWords[i];

            }
        }
        System.out.println("first word with minimal of different characters is: " + strmin);

      // #5 Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского
      // алфавита, а среди них – количество слов с равным числом гласных и согласных букв.















    }

    public static void swap(int[] arri,String[] arr, int x1, int x2) {
        int bufferi=arri[x1];
        String bufferStr=arr[x1];
        arri[x1]=arri[x2];
        arr[x1]=arr[x2];
        arri[x2]=bufferi;
        arr[x2]=bufferStr;
    }

    public static void showarrs(int[] arri,String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("№" +(i+1) + ":   "+ arr[i]+ "  lenth:"+ arri[i]);
        }
    }

}
