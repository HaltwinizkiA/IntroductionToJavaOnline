package Strings_and_basics_of_text_processing.analyzer.tag;

public class Tag {
    String open = "";
    String body = "";
    String close = "";



    public Tag(String open, String body, String close) {
        this.open = open;
        this.body = body;
        this.close = close;

    }

    public String getOpen() {
        return open;
    }

    public String getBody() {
        return body;
    }

    public String getClose() {
        return close;
    }


//    public Tag( String body) {
//
//        this.body = body;
//
//        this.tags=new ArrayList<Tag>();
//    }

//    public void lehasearch() {
//        Matcher searchTag = Pattern.compile("(?<=\\<)(.*?)(?=\\>)").matcher(body);
//
//        if (searchTag.find()) {
//            name = searchTag.group();
//        }
//
//        Matcher searchBody = Pattern.compile("(?<=<" + name + ">).*(?=</" + name + ">)").matcher(body);
//        String bodyCache="";
//        if (searchBody.find()) {
//            bodyCache = searchBody.group();
//        }
//        boolean chek=true;
//        while (chek){
//           Matcher seatchOpenTag = Pattern.compile("\\<[^>]+\\>").matcher(bodyCache);
//            if (searchTag.matches()){
//                Matcher searchBodyTag=Pattern.compile("").matcher();
//                Tag tag=new Tag(seatchOpenTag.group());
//            }

    }//ищет в теле имя открывающего тега

//}"<notes>\n" +
//        " <note id = \"1\">\n" +
//        " <to>Вася</to>\n" +
//        " <from>Света</from>\n" +
//        " <heading>Напоминание</heading>\n" +
//        " <body>Позвони мне завтра!</body>\n" +
//        " </note>\n" +
//        " <note id = \"2\">\n" +
//        " <to>Петя</to>\n" +
//        " <from>Маша</from>\n" +
//        " <heading>Важное напоминание</heading>\n" +
//        " <body/>\n" +
//        " </note>\n" +
//        "</notes>\n";
//
//
//