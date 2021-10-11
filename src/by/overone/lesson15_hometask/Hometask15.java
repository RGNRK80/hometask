package by.overone.lesson15_hometask;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hometask15 {
    public static void main(String[] args) {
        task1_3();
        // task_4();
        // task5();
        //  task6();
        // task7();
        // task8();
    }
   public static void task1_3(){
       // 1. Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные
       // строки и их длину.
       // 2. Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания)
       //  значений их длины.
       // 3. Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше)
       // средней, а также длину.

       Scanner scanner=new Scanner(System.in);
       String[] arr;
       int[] arri;
       System.out.println("Enter the number of strings");
       int n;
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
      // showarrs(arri,arr);
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
       System.out.println("Ordered strings references: ");
       showarrs(arri,arr);
       //вывод строк меньше средней
       System.out.println("shorter than middle ");
       for (int i=0; i<n; i++){
           if (arri[i]<center){
               System.out.println(arr[i]+ "  length: " + arr[i].length());
           }
       }
       System.out.println("middle: "+ center);
       //вывод строк длиннее средней
       System.out.println("longer than middle ");
       for (int i=0; i<n; i++){
           if (arri[i]>center){
               System.out.println(arr[i]+ "  length: " + arr[i].length());
           }
       }
   }

   public static void task_4(){
       // #4 -  Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если
       //таких слов несколько, найти первое из них.
       Scanner scanner=new Scanner(System.in);
       int n;
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
   }

    public static void task5(){
        // #5 Ввести n слов с консоли. Найти количество слов, содержащих только символы латинского
        // алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
        Scanner scanner=new Scanner(System.in);
        int n;
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

        int count=0;
        for (int i=0; i<n; i++) {

            int countOFEng = 0;
            int bal = 0;
            for (Character letter : arrWords[i].toCharArray())     //  по буквам с for each
            {

                if (((letter >= 'A') && (letter <= 'Z')) || ((letter >= 'a') && (letter <= 'z'))) {
                    countOFEng++;
                    if ((letter=='A') || (letter=='E') ||
                            (letter=='I') || (letter=='O') ||
                            (letter=='U') || (letter=='Y') ||
                            (letter=='a') || (letter=='e') ||
                            (letter=='i') || (letter=='o') ||
                            (letter=='u') || (letter=='y'))
                    {bal++;}
                    else
                    {bal--;}
                }
            }
            // System.out.println("баланс:" + bal);
            // System.out.println("кол-во латинских символов: " + countOFEng + " количество сиволов: " + arrWords[i].length());
            if (arrWords[i].length()==countOFEng) {
                if (bal==0) {
                    System.out.println(arrWords[i]);
                    count++;
                }
            }
        }
        System.out.println("words with English letters and a balance of consonant and vowel letters:"+count);
    }

    public static void task6(){
        // #6. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом порядке возрастания их
        //кодов. Если таких слов несколько, найти первое из них.
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("  #6   Enter the number of words");
        n=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter  words");
        String[] arrWords = new String[n];
        //ввод слов
        for (int i=0; i<arrWords.length; i++){
            System.out.println("word #"+(i+1)+":");
            arrWords[i]= scanner.nextLine();
        }
        for (int i=0; i<arrWords.length; i++){
            char[] letters = arrWords[i].toCharArray();
            int check = 1;
            for (int j=1; j<letters.length; j++){
                System.out.println();
                int ix1=letters[j-1];
                int ix2=letters[j];
                if (ix2>ix1) {check++;}
            }
            if (check==letters.length) {
                System.out.println("answer: "+ arrWords[i]);
            }
        }
    }

    public static void task7(){
         // #7. Ввести n слов с консоли. Найти слово, состоящее только из различных символов. Если таких слов
         // несколько, найти первое из них.
        int n;
        Scanner scanner=new Scanner(System.in);
        System.out.println("  #7   Enter the number of words");
        n=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter  words");
        String[] arrWords = new String[n];
        char[] letters;
        //ввод слов
        for (int i=0; i<arrWords.length; i++){
            System.out.println("word #"+(i+1)+":");
            arrWords[i]= scanner.nextLine();
        }

        for (int i=0; i<n; i++){
            letters=arrWords[i].toCharArray();
            Arrays.sort(letters); // отсортировано
            int check=1;
            for (int j=0; j<letters.length-1; j++){
                if (letters[j]!=letters[j+1]) {
                    check+=1;
                }
            }
          //вывод соответствующего слова
            if (check==letters.length) {
                System.out.println("answer: "+ arrWords[i]);
                break;
            }
        }
    }

    public static void task8() {
        // 8. Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти слово-палиндром. Если
        //таких слов больше одного, найти второе из них.
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("#8  Enter the number of words");
        n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter  words");
        String[] arrWords = new String[n];
        StringBuffer str = new StringBuffer();
        ArrayList<StringBuffer> listofstringBuffer = new ArrayList<>();
        //ввод слов
        for (int i = 0; i < arrWords.length; i++) {
            System.out.println("word #" + (i + 1) + ":");
            arrWords[i] = scanner.nextLine();
        }
        for (int i = 0; i < arrWords.length; i++) {
            int countOfNum = 0;
            for (Character letter : arrWords[i].toCharArray())     //  по буквам с for each
            {
                if ((letter >= '0') && (letter <= '9')) {
                    countOfNum++;
                }
            }
            str = new StringBuffer();
            if (countOfNum == arrWords[i].length()) {

                str.append(arrWords[i]);
                if (str.toString().equals(str.reverse().toString())) {
                    listofstringBuffer.add(str);
                }
            }
        }
        if (listofstringBuffer.size() == 1) {
            System.out.println(" palindrom is: " + listofstringBuffer.get(0).toString());
        }
        if (listofstringBuffer.size() > 1) {
            System.out.println(" palindrom #2 is: " + listofstringBuffer.get(1).toString());
        }
        if (listofstringBuffer.size() < 1) {
            System.out.println(" there is no palindrom");
        }
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
