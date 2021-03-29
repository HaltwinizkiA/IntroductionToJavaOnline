package tasks.task4.container;

import java.util.Comparator;

public class SortConatiner implements Comparator<Containter> {
    @Override
    public int compare(Containter o1, Containter o2) {
        return o2.weight -o1.weight;
    }
}
