package tasks.task3.menu.action;

import tasks.task3.api.IAction;
import tasks.task3.validator.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Registration extends IAction {
    protected DataInputStream in;
    protected DataOutputStream out;

    public Registration(DataInputStream in,DataOutputStream out) {
        this.out = out;
        this.in = in;
        name = "- Registration";
    }

    @Override
    public void action() {
        try {

            Validator validator=new Validator(in,out);
            out.writeUTF("Enter Login");
            String login = validator.loginPass();
            out.writeUTF("Enter Password");
            String password = validator.loginPass();
            File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//server", "accounts.txt");
            String newAcc = login + "/" + password + "/false";
            List<String> listAccount = new ArrayList<String>();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                listAccount.add(line);

                line = bufferedReader.readLine();
            }
            listAccount.add(newAcc);
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
            for (String acc : listAccount) {
                outputWriter.write(acc + "\n");
            }
            outputWriter.flush();
            outputWriter.close();
            Login logined=new Login(in,out);
            logined.action();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    }
