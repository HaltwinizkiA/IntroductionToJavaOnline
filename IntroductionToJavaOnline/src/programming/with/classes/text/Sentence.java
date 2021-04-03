package programming.with.classes.text;

public class Sentence implements CompositionOfText {


    @Override
    public String getComposition() {
        System.out.println("enter sentence");


        return " " + scanner.next() + scanner.nextLine() + ".";
    }
}
