package strings_and_basics_of_text_processing.app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    static String text = "Cоздать приложение. Разбирающее текст текст хранится в строке. И позволяющее выполнять с текстом три различных операции.\n" +//3
            "   Отсортировать абзацы по количеству предложений. В каждом предложении отсортировать слова по длине.\n" +//2
            "   Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа. А В случае равенства – по алфавиту.\n" +//2
            "   Леха ты такой леха. А макс такой макс. А я кибергений опа. Люблю пельмешки со сметанкою.\n" +//4
            "   Всем ку с вами Терминатор и Диииимон ставьте класс, ну все пака.\n" +//1
            "   MMMM понятно.\n" +
            "   молоко опа ты олололо полочка.\n";

    StringBuffer buffer = new StringBuffer();

    public void inicialization() {
        System.out.println("select metod 1 - sort Paragraph; 2 - sort Word Lenght; 3 - sort lexem;");
        Scanner scanner = new Scanner(System.in);
        int metod = scanner.nextInt();
        switch (metod) {
            case 1 -> paragraphSort();
            case 2 -> sentenceSort();
            case 3 -> lexemeSort();
        }
    }

    public void paragraphSort() {

        String[] paragraph = text.split("\\s{4}"); //array parahraph.
        System.out.println(text + "\n");
        Pattern pattern = Pattern.compile("[!?\\.]");
        Matcher matcher;
        long a = pattern.matcher(paragraph[0]).results().count();
        long b = 123;
        Arrays.sort(paragraph, new SortParagraph());

        for (int i = 0; i < paragraph.length; i++) {
            buffer = buffer.append(paragraph[i] + "\n    ");
        }

        System.out.println(buffer);


    }

    public void sentenceSort() {

        System.out.println(text);
        String[] sentence = text.split("[!?\\.]");
        StringBuffer newText = new StringBuffer();
        for (int i = 0; i < sentence.length; i++) {
            String[] sentenceArr = sentence[i].split(" ");//предложения
            Arrays.sort(sentenceArr, new SortSentenceWord());
            StringBuffer sentenceCache = new StringBuffer();
            for (String element : sentenceArr) {

                sentenceCache.append(element + " ");
            }
            newText.append(sentenceCache + ". ");

        }
        System.out.println(newText.toString());


    }

    public void lexemeSort() {
        System.out.println(text);
        String[] sentence = text.split("[!?\\.]");
        StringBuffer newText = new StringBuffer();
        System.out.println("PLs enter lexeme");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.next();

        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].replaceAll("^\\s+", "");

            String[] word = sentence[i].split(" ");//слова
            Arrays.sort(word, new SortInputLexeme(letter));
            Arrays.sort(word, new SortInputLexemeAlphavit(letter));

            StringBuffer sentenceCache = new StringBuffer();
            for (String element : word) {
                newText.append(element + " ");
            }
            newText.append(". \n");

        }

        System.out.println(newText.toString());


    }

    class SortParagraph implements Comparator<String> {
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher;

        @Override
        public int compare(String o1, String o2) {
            return (int) (pattern.matcher(o1).results().count() - pattern.matcher(o2).results().count());

        }
    }//соритровка абзацей по кол-ву предложений

    class SortSentenceWord implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }// соритровка слов по длине

    class SortInputLexemeAlphavit implements Comparator<String> {
        String letter = "о";
        Pattern pattern = Pattern.compile(letter);


        public SortInputLexemeAlphavit(String letter) {
            this.letter = letter;
        }

        @Override
        public int compare(String o1, String o2) {
            Matcher matcher;
            long a = pattern.matcher(o1).results().count();
            long b = pattern.matcher(o2).results().count();
            if (pattern.matcher(o1).results().count() == pattern.matcher(o2).results().count()) {

                if (o1.charAt(0) > o2.charAt(0)) {
                    return 1;
                }
                if (o1.charAt(0) < o2.charAt(0)) {
                    return -1;
                } else {
                    return 0;
                }
            } else {

                return 0;
            }

        }

    }//сортировка по алфавивуту в случае равенства кол-валексем

    class SortInputLexeme implements Comparator<String> {
        String letter = " ";
        Pattern pattern = Pattern.compile(letter);


        public SortInputLexeme(String letter) {
            this.letter = letter;
        }

        @Override
        public int compare(String o1, String o2) {
            Matcher matcher;
            long a = pattern.matcher(o1).results().count();
            long b = pattern.matcher(o2).results().count();

            return (int) (pattern.matcher(o2).results().count() - pattern.matcher(o1).results().count());


        }

    }  //сортировка по количеству входных лексем по убыв
}

//1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
//        операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
//        отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
//        алфавиту.