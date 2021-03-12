package programming_with_classes.text;

public class Sentence implements CompositionOfText {


    @Override
    public String getComposition() {
        System.out.println("enter sentence");


        return " " + scanner.next() + scanner.nextLine() + ".";
    }
}
