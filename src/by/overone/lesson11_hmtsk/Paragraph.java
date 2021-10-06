package by.overone.lesson11_hmtsk;

public  class Paragraph {

    public static String[] paragraphs;

    public static void showParagraphs(){
        int i = 0;
        for (String unit :paragraphs) {
            System.out.println(unit);
            i++;
        }
    }

    public static void splitit(String text){
         paragraphs=text.split("\n");
    }

}
