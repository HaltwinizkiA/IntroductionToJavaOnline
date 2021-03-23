package strings_and_basics_of_text_processing;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsBasics {

    public void CamelInSnake() {
        String[] str = {"InCome", "ComeBack", "BountyHunter", "KolBasa", "EnglishLanguage"};
        System.out.println(Arrays.toString(str));
        Pattern p = Pattern.compile("\\B[A-Z]");
        for (int i = 0; i < str.length; i++) {
            Matcher matcher = p.matcher(str[i]);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "_$0");
            }
            matcher.appendTail(sb);
            str[i] = sb.toString().toLowerCase();

        }

        System.out.println(Arrays.toString(str));

    }

    public void worldOfLetter() {
        String str = "world of warcraft its best game in world";
        System.out.println(str);
        System.out.println(str.replace("world", "letter"));

    }

    public void countOfNumbers() {
        String str = "i like 3 action in sex 1 dogstyle 2 blowjob and 69";
        Pattern pattern = Pattern.compile("\\d");
//        Matcher matcher=pattern.matcher(str);     //new metod java9+;
//        System.out.println((int) matcher.results().count());//new metod java9+
        int count = 0;
        String[] strarr = str.split("\s");// old;
        for (int i = 0; i < strarr.length; i++) {
            Matcher matcher = pattern.matcher(strarr[i]);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
//
    }

    public void countOfNum() {
        String str = "i like 3 action in sex 1 dogstyle 2 blowjob and 69";
        Pattern pattern = Pattern.compile("\\d");
        int count = 0;
        String[] strarr = str.split("\s");// old;
        for (int i = 0; i < strarr.length; i++) {
            Matcher matcher = pattern.matcher(strarr[i]);
            while (matcher.find()) {
                count++;
                break;

            }
        }
        System.out.println(count);
    }

    public void deleteExcessSpace() {
        String str = "  leha Opekun  kurit Onoshu  a ja  tozhe  hochu ";
        System.out.println(str);
        Pattern pattern = Pattern.compile("\s\s");

        StringBuffer stringBuffer = new StringBuffer(str);
        Matcher matcher = pattern.matcher(str);
        str = matcher.replaceAll("\s");
        System.out.println(str);
        pattern = Pattern.compile("\s$");
        matcher = pattern.matcher(str);
        str = matcher.replaceAll("");
        pattern = Pattern.compile("^\s");
        matcher = pattern.matcher(str);
        str = matcher.replaceAll("");
        System.out.println(str);


    }

    public void greatesCountOfSpace() {
        String str = "one two  three   six      two  ";
        String[] strarr = str.split("");
        int count = 0;
        int max = 0;
        for (String element : strarr) {
            if (element.equals(" ")) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }

                count = 0;
            }


        }
        System.out.println(max);


    }

    public void symbolBafterA() {
        String str = "pisos alizi arbuz asskiller bigboobs sasiloh";
        System.out.println(str);
        StringBuffer strb = new StringBuffer();
        String[] strarr = str.split("");
        for (String element : strarr) {
            if (element.equals("a")) {
                strb.append(element).append("b");
            } else {
                strb.append(element);
            }

        }

        System.out.println(strb);


    }

    public void palindrom() {

        StringBuffer s = new StringBuffer("СОСОС");
        StringBuffer rev = new StringBuffer(s).reverse();

        if ((s.toString()).equals(rev.toString())) {
            System.out.println("palindrom");
        }
    }

    public void informatica() {
        StringBuffer str = new StringBuffer("информатика");

        System.out.println(str.charAt(7) + "" + str.charAt(3) + "" + str.charAt(4) + "" + str.charAt(7));
    }

    public void searchA() {
        String str = "devo4ki bivayut raznie sinie belie kraaasnie";
        Pattern pattern = Pattern.compile("a");
        Matcher matcher = pattern.matcher(str);     //new metod java9+;
        System.out.println((int) matcher.results().count());
    }

    public void doubleSimbol() {
        String str = "NAKAMOTO IDI NAHUI SO SVOIM bitkom";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i++) {
            strb.append(stringBuffer.charAt(i) + "" + stringBuffer.charAt(i));
        }
        str = strb.toString();
        System.out.println(str);
        //6. Из заданной строки получить новую, повторив каждый символ дважды.

    }

    public void deleteRepeat() {
        String str = "KKoshkal lubit moolokoo  ";
        System.out.println(str);
        StringBuffer strB = new StringBuffer(str);
        for (int i = 0; i < strB.length(); i++) {
            if (String.valueOf(strB.charAt(i)).equals(" ")) {
                strB.deleteCharAt(i);
            }
        }

        System.out.println(strB.toString());
        for (int i = 0; i < strB.length() - 1; i++) {

            if (String.valueOf(strB.charAt(i)).equals(String.valueOf(strB.charAt(i + 1)))) {
                strB.deleteCharAt(i);
            }

        }
        System.out.println(strB.toString());

    }

    public void bigWord() {
        String str = "i have big balls and biget  cock";
        String maxword = "";
        String[] strarr = str.split(" ");
        for (String word : strarr) {
            if (word.length() > maxword.length()) {
                maxword = word;
            }
        }
        int i = 0;
        for (String max : strarr) {

            if (maxword.length() == max.length()) {
                i++;
                if (i == 2) {
                    System.out.println("pizda vashei hate uberai");
                    break;

                }
            }
        }
        if (i != 2)
            System.out.println(maxword);
    }

    public void countOfLowerAndBigCase() {
        String str = "OnE TwoEE thReE";
        System.out.println("bigcase : " + str.replaceAll("[^A-Z]", "").length() + " lowcase :" + str.replaceAll("[^a-z]", "").length());
        int lowcase = 0;
        int bigcase = 0;
        for (int i = 0; i < str.length(); i++) {

            if (Character.isUpperCase(str.charAt(i))) {
                bigcase++;
            }
            if (Character.isLowerCase(str.charAt(i))) {
                lowcase++;
            }


        }
        System.out.println("low : " + lowcase + " big : " + bigcase);
    }

    public void punctuationMarks() {
        String str = "Lesha pedik. Max PIDOR! sasha normalnii?";
        int countOfsentence = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(".") || String.valueOf(str.charAt(i)).equals("!") || String.valueOf(str.charAt(i)).equals("?")) {
                countOfsentence++;
            }
        }
        System.out.println(countOfsentence);
    }

}


//


