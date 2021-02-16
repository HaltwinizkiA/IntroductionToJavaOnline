package Strings_and_basics_of_text_processing;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsBasics {

    public void CamelInSnake(){
        String[] str={"InCome","ComeBack","BountyHunter","KolBasa","EnglishLanguage"};
        System.out.println(Arrays.toString(str));
        Pattern p=Pattern.compile("\\B[A-Z]");
        for (int i=0;i<str.length;i++){
            Matcher matcher=p.matcher(str[i]);
            StringBuffer sb=new StringBuffer();
            while (matcher.find()){
                matcher.appendReplacement(sb,"_$0");
            }
            matcher.appendTail(sb);
            str[i]=sb.toString().toLowerCase();

        }

        System.out.println(Arrays.toString(str));

    }

    public void WorldOfLetter(){
        String str="world of warcraft its best game in world";
        System.out.println(str);
        System.out.println(str.replace("world","letter"));

    }
    public void CountOfNumbers(){
        String str="i like 3 action in sex 1 dogstyle 2 blowjob and 69";
        Pattern pattern=Pattern.compile("\\d");

        String[] strbox=str.split("\s");

        int count=0;
        for(int i=0;i<strbox.length;i++){
            Matcher matcher=pattern.matcher(strbox[i]);
            while ()

        }
    }
}
