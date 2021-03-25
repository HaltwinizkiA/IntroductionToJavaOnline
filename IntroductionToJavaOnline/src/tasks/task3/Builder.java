package tasks.task3;

import tasks.task3.api.Account;
import tasks.task3.api.IAction;
import tasks.task3.menu.Menu;
import tasks.task3.menu.StartWindow;
import tasks.task3.menu.action.Exit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Builder {
    private DataInputStream in;
    private DataOutputStream out;
    List<IAction> actionList;
    Account account;
    public Builder(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void build() {
        try {

            actionList=new ArrayList<>();
            actionList.add(0,new Exit(out));
            actionList.add(1, new StartWindow(in, out));
            out.writeUTF(actionList.get(1).name);
            account=new Account();
            actionList.get(1).action();
            actionList.add(2,new Menu(in,out,account.getAccount()));
            out.writeUTF(actionList.get(2).name);
            actionList.get(2).action();




        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

}
