import tasks.task4.container.Containter;
import tasks.task4.container.SortConatiner;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Containter> containterList=new ArrayList<Containter>();
        containterList.add(new Containter(10));
        containterList.add(new Containter(12));
        containterList.add(new Containter(1));
        containterList.sort(new SortConatiner());


    }
}
