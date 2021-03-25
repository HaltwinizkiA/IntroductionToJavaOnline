package tasks.task3.menu;

import tasks.task3.api.IAction;
import tasks.task3.menu.action.Exit;
import tasks.task3.menu.action.Login;
import tasks.task3.menu.action.Registration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StartWindow extends IAction {

    protected DataOutputStream out;
    protected DataInputStream in;
    List<IAction> actionsList;

    public StartWindow(DataInputStream in, DataOutputStream out) {
        this.out = out;
        this.in = in;
        name = "Start Windows";
    }

    @Override
    public void action() {

        try {
            createActionList();
            for (int i = 0; i < actionsList.size(); i++) {
                out.writeUTF(i + actionsList.get(i).name);
            }
            while (true) {
                try {
                    int select = Integer.parseInt(in.readUTF());
                    actionsList.get(select).action();
                    break;
                } catch (Exception e) {
                    out.writeUTF("wrong input!");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void createActionList() {
        actionsList = new ArrayList<>();
        actionsList.add(0, new Exit(out));
        actionsList.add(1, new Login(in, out));
        actionsList.add(2, new Registration(in, out));


    }


}
