package programming.with.classes.counter;

import java.util.Scanner;

public class Counter {
    int min = 0;
    int max = 322;
    int count = 0;

    public Counter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Counter() {
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void increase() {
        if (count < max) {
            count++;
        }
    }

    public void decrease() {
        if (count == min) {
            count = -1;
        }
    }

    public void state() {
        System.out.println("\n counter : " + count);
    }

    public void initialisation() {

        while (count < max | count > min) {
            System.out.println("1- increase; 2-decrease; 3-state;");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1 -> increase();
                case 2 -> decrease();
                case 3 -> state();
            }
            if (count > max || count < min) {
                System.out.println("counter out of bounds\n");
                break;
            }
        }

    }
}
