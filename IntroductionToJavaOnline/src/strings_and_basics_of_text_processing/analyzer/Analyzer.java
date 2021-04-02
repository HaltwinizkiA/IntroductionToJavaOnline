package strings_and_basics_of_text_processing.analyzer;

import strings_and_basics_of_text_processing.analyzer.tag.Tag;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    static String text = "<notes>\n" +
            " <note id = \"1\">\n" +
            " <to>Вася</to>\n" +
            " <from>Света</from>\n" +
            " <heading>Напоминание</heading>\n" +
            " <body>Позвони мне завтра!</body>\n" +
            " </note>\n" +
            " <note id = \"2\">\n" +
            " <to>Петя</to>\n" +
            " <from>Маша</from>\n" +
            " <heading>Важное напоминание</heading>\n" +
            " <body/>\n" +
            " </note>\n" +
            "</notes>\n";


    public void initialization() {


    }

    public void analyzer() {

        Matcher countOfTag = Pattern.compile("/").matcher(text);

        Tag[] tag = new Tag[(int) countOfTag.results().count()];

        String str = text;
        Matcher searchTag = Pattern.compile("(?<=\\<)(.*?)(?=\\>)").matcher(str);

        int i = 0;
        while (searchTag.find()) {
            StringBuffer buffer = new StringBuffer();
            String[] newtext;
            String openTag = searchTag.group();
            Matcher chekClosed = Pattern.compile("^/").matcher(openTag);
            if (chekClosed.find()) {
                Matcher replace = Pattern.compile("</" + openTag + ">").matcher(str);


                continue;
            }
            Matcher emptyTag = Pattern.compile("/$").matcher(openTag);
            if (emptyTag.find()) {
                tag[i] = new Tag("empty tag: " + " <" + openTag + ">", "empty", "empty");
                i++;
                continue;
            }
            String closeTag = "/" + openTag;
            newtext = str.split("<" + openTag + ">");

            Matcher matchClose = Pattern.compile(closeTag).matcher(newtext[1]);
            if (matchClose.find())
            {
                closeTag = matchClose.group();
            }
            Matcher chekingId = Pattern.compile("\\d").matcher(openTag);
            if (chekingId.find()) {
                closeTag = closeTag.substring(0, closeTag.indexOf(" "));
            }
            openTag = "<" + openTag + ">";
            closeTag = "<" + closeTag + ">";

            newtext = newtext[1].split(closeTag);
            tag[i] = new Tag("OPEN TAG : " + openTag, " BODY : " + newtext[0], " CLOSED TAG : " + closeTag);
            i++;


        }
        for (int f = 0; f < tag.length; f++) {
            System.out.println("UNIT NUM : " + (f + 1) + " " + tag[f].getOpen() + tag[f].getBody() + tag[f].getClose() + "\n");
        }

    }
}



