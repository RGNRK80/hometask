package by.overone.lesson11_hmtsk;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  TEXT ( enter 0 for exit): ");
        String text="";
        String enter="";
        while (true) {
            enter=scanner.nextLine();
            if (enter.equals("0")) break;
            text = text.concat("\n"+enter);
        }

        System.out.println("Enter - n: ");
        int n=scanner.nextInt();

        Paragraph.splitit(text.toString());
       // Paragraph.showParagraphs();
        Proposal.splitit();
       // Proposal.showProposal();
        Word.splitit();
       // Word.showWords();
        Word.change(n);
       // Word.showWords();
        Word.compose();


    }

}
