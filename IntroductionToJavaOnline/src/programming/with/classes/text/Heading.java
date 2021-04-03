package programming.with.classes.text;

public class Heading implements CompositionOfText {
    @Override
    public String getComposition() {
        System.out.println("enter Heading");
        return "\r" + scanner.next() + scanner.nextLine() + "\n";
    }
}
