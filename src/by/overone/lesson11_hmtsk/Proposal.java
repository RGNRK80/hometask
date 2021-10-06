package by.overone.lesson11_hmtsk;

public class Proposal extends Paragraph {
    public static String[][] proposal = new String[paragraphs.length][];

    public static void splitit() {

        for (int i = 0; i < proposal.length; i++) {
            proposal[i] = paragraphs[i].split("(?<=[.!?])");
        }

        for (int i=0; i<proposal.length; i++){
            for (int j = 0; j <proposal[i].length; j++){
                proposal[i][j]=proposal[i][j].trim();

            }
        }
    }

    public static void showProposal() {
        System.out.println();
        for (int i = 0; i < proposal.length; i++) {
            for (String unit : proposal[i]) {
                System.out.println(i + "  " + unit);
            }
        }
    }

}

