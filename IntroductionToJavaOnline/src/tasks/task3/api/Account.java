package tasks.task3.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Account {
    private String name;
    private Boolean state;

    public String getName() {
        return name;
    }

    public Boolean getState() {
        return state;
    }

    public Account getAccount() {

        try {
            File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//server", "enteredAccount.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            line = bufferedReader.readLine();
            String[] setter = line.split("/");
            name = setter[0];
            state = Boolean.parseBoolean(setter[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

            return this;

    }


}
