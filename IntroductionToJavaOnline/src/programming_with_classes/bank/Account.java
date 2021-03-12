package programming_with_classes.bank;

public class Account {
    int id;
    double value;
    boolean state;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", value=" + value +
                ", state=" + state +
                '}';
    }

    public Account(int id, double value, boolean state) {
        this.id = id;
        this.value = value;
        this.state = state;
    }
}
