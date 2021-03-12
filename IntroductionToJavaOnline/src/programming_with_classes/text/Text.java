package programming_with_classes.text;

public class Text implements CompositionOfText {

    StringBuffer text = new StringBuffer();
    Heading head = new Heading();
    Word word = new Word();
    Sentence sentence = new Sentence();

    @Override
    public String getComposition() {
        System.out.println("enter action:\n1-add head\n 2-addWord\n 3-addSentence\n 4-output text\n 5-stop");
        int num = scanner.nextInt();
        switch (num) {
            case 1 -> {
                text.append(head.getComposition());
                getComposition();
            }
            case 2 -> {
                text.append(word.getComposition());
                getComposition();
            }
            case 3 -> {
                String s = sentence.getComposition();
                text.append(s);
                getComposition();
            }
            case 4 -> {
                System.out.println("\n" + "\t TEXT: \n" + text.toString());
                System.out.println("\n 1-stop 2-continue typing\n");
                switch (scanner.nextInt()) {
                    case 1 -> {
                        break;
                    }
                    case 2 -> getComposition();
                }

            }
            case 5 -> {
                break;
            }
            default -> {
                System.out.println("wrong action num \n pls enter correct num");

            }
        }

        return text.toString();
    }
}
//. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на
//        консоль текст, заголовок текста.