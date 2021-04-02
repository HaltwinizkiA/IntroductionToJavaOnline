package programming_with_classes.customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bureau {
    int count;
    Customer[] customer = new Customer[3];

    public Bureau(int count) {
        this.count = count;
    }

    public void createCustomer() {
        customer[0] = new Customer();
        customer[1] = new Customer();
        customer[2] = new Customer();
        customer[0].setName("sasha");
        customer[0].setSurName("goltv");
        customer[0].setPatronymic("anatol");
        customer[0].setAdress("grodno");
        customer[0].setBankNum(2341);
        customer[0].setCardNum(556545);
        customer[1].setName("lesha");
        customer[1].setSurName("opekun");
        customer[1].setPatronymic("piskovich");
        customer[1].setAdress("minsk");
        customer[1].setBankNum(3452);
        customer[1].setCardNum(324533);
        customer[2].setName("maxim");
        customer[2].setSurName("agorbunov");
        customer[2].setPatronymic("genovich");
        customer[2].setAdress("popa");
        customer[2].setBankNum(15135);
        customer[2].setCardNum(234234);
        customer = sortSurname(customer);

        outCustomer();
    }

    public Customer[] sortSurname(Customer[] c) {
        Arrays.sort(c, new SortAplh());
        return c;
    }


    public boolean checkInterval(int c, int start, int end) {
        boolean check = false;

        if (c >= start & c <= end) {
            check = true;
        }
        return check;
    }

    public void outCustomer() {
        System.out.println("enter start end interval");
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter start");
        int start = scanner.nextInt();
        System.out.println("enter end");
        int end = scanner.nextInt();
        for (Customer el : customer) {

            if (checkInterval(el.getCardNum(), start, end)) {
                System.out.println(el);
            }

        }


    }


    class SortAplh implements Comparator<Customer> {

        @Override
        public int compare(Customer o1, Customer o2) {

            if (o1.getSurName().compareTo(o2.getSurName()) > 0) {
                return 1;
            } else if (o1.getSurName().compareTo(o2.getSurName()) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
