package Strings_and_basics_of_text_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsBasics {

    public void CamelInSnake(){
        String[] str={"InCome","ComeBack","BountyHunter","KolBasa","EnglishLanguage"};
        System.out.println(str);
        Pattern p=Pattern.compile("\\B[A-Z]");
        for (int i=0;i<str.length;i++){
            Matcher mather=p.matcher(str[i]);
            StringBuffer s=new StringBuffer();
            while (mather.find()){
                mather.appendReplacement(s,)

            }

        }



        System.out.println(str);;

    }
}
