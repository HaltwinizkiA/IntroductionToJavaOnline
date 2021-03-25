package tasks.task3.menu.action;

import tasks.task3.api.IAction;

import java.io.*;

public class Exit extends IAction {

    protected DataOutputStream out;

    public Exit( DataOutputStream out) {

        this.out = out;
        name="- Exit";
    }

    @Override
    public void action() {
      try {
          File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task3//server", "enteredAccount.txt");
          BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
          outputWriter.write("");


      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
