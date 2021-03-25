package tasks.task3.menu.action;

import tasks.task3.api.IAction;
import tasks.task3.validator.Validator;

import java.io.*;

public class Login extends IAction {
    protected DataOutputStream out;
    protected DataInputStream in;



    public Login(DataInputStream in,DataOutputStream out) {
        this.out = out;
        this.in = in;
        name = "- Login";
    }


    @Override
    public void action() {
        try {

            Validator validator = new Validator(in, out);
            out.writeUTF("enter login: ");
            String login = validator.loginPass();
            out.writeUTF("enter password");
            String password = validator.loginPass();
            File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//server", "accounts.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            line = bufferedReader.readLine();

            while (line != null) {
                String[] account = line.split("/");
                if (login.equals(account[0]) & password.equals(account[1])) {
                    file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//server", "enteredAccount.txt");
                    BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
                    String authInf = account[0] + "/" + account[2];
                    outputWriter.write(authInf);
                    outputWriter.flush();
                    outputWriter.close();
                    break;
                }
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

