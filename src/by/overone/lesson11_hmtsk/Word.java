package by.overone.lesson11_hmtsk;
import java.util.Arrays;

public class Word extends Proposal {

    private static String[][][] word = new String[paragraphs.length][1000][];
    public static void splitit() {
        for (int i = 0; i < paragraphs.length; i++) {
            for (int j = 0; j < proposal[i].length; j++) {
                word[i][j] = proposal[i][j].split("[ ]");
                String str = Arrays.deepToString(word[i][j]);
                int k = word[i][j].length;

            }
        }
    }

    public static void showWords() {
        System.out.println("-----------------WORDS--------------");
        for (int i = 0; i < paragraphs.length; i++) {
            for (int j = 0; j < proposal[i].length; j++) {
                for (int k = 0; k < word[i][j].length; k++) {
                    System.out.println(i + " " + j + " " + k + " " + word[i][j][k]);
                }
            }
        }
    }

    public static void change(int n) {
        for (int i = 0; i < paragraphs.length; i++) {
            for (int j = 0; j < proposal[i].length; j++) {
                for (int k = 0; k < word[i][j].length; k++) {
                    char[] chArray = word[i][j][k].toCharArray(); //разбиваем на символьный массив
                    if ((chArray.length) < n)
                        continue;   //если длина массива меньше длины n - переходим на след цикл
                    int counter = -1; // счетчик совпадение
                    for (int q = 0; q < chArray.length; q++) {
                        boolean check = Character.isLetter(chArray[q]);
                        if (check) {
                            // частное 1
                            if (n == 0) {
                                chArray[q] = '%';
                                continue;
                            }   // если массив из 1 элемента - и n=0 выполняем и на след цикл
                            // рабочее
                            counter += 1;                              // совпадение +
                        }
                        if (!check) {
                            counter = 0;
                        }                   // если фиксируем несовпадение - обнуляем счетчик
                        if (counter == n) {
                            chArray[q] = '%';
                            break;
                        } // если счетчик добрался до числа n - заменяем симовл на %
                    }
                    // собрать массив в слово
                    String str = "";
                    for (int w = 0; w < chArray.length; w++) {
                        str += chArray[w];
                    }
                    word[i][j][k] = str; // готова сбока слова
                }
            }
        }
    }


    public static void compose() {
        for (int i = 0; i < paragraphs.length; i++) {
            String strPar="";
            for (int j = 0; j < proposal[i].length; j++) {
                String strProp="";
                for (int k = 0; k < word[i][j].length; k++) {
                    if (k<word[i][j].length-1)  {strProp+=word[i][j][k]+" ";} else {strProp+=word[i][j][k];}
                }
                proposal[i][j]=strProp;
                strPar+=proposal[i][j];
            }
            paragraphs[i]=strPar;
            System.out.println(paragraphs[i]);
        }
    }
}


