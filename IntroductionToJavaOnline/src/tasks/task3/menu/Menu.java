package tasks.task3.menu;

import tasks.task3.api.Account;
import tasks.task3.api.IAction;
import tasks.task3.menu.action.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Menu extends IAction {
    protected DataInputStream in;
    protected DataOutputStream out;
    List<IAction> actionsList;
    Account account;

    public Menu(DataInputStream in, DataOutputStream out, Account account) {
        this.in = in;
        this.out = out;
        this.account = account;
        name = "Menu";

    }

    public void createActionsList() {
        actionsList = new ArrayList<>();
        actionsList.add(0, new Exit(out));
        actionsList.add(1, new ViewDeeds(out));
        actionsList.add(2, new SearchDeed(in, out));
        actionsList.add(3, new ModifyDeed(in, out));
        actionsList.add(4, new AddDeed(in, out));


    }

    @Override
    public void action() {

        try {
            createActionsList();
            if (!account.getState()) {

                while (true) {
                    try {

                        if (actionsList.size() == 3) {
                            break;
                        }
                        actionsList.remove(3);

                    } catch (Exception e) {

                    }
                }
            }
            while (true) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            actionsList.get(0).action();
        }
    }
}
