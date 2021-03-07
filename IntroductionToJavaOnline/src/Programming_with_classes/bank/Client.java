package Programming_with_classes.bank;

import java.util.Arrays;

public class Client {
    String name;
    Account[] accounts;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }

    public Client(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }
}
