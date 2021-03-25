package tasks.task3.validator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    protected DataInputStream in;
    protected DataOutputStream out;

    public Validator(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public String loginPass() {

        String enters;
        while (true) {
            try {
                enters = in.readUTF();
                Matcher matcher = Pattern.compile("\\W").matcher(enters);
                if (matcher.find()) {
                    out.writeUTF("wrong enters\n get rid of symbols symbols: !@#$%^&*()");
                    continue;
                }
                break;
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return enters;
    }


}
