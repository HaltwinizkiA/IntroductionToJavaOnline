package decomposition;

import java.util.Scanner;

public class Decomposition {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    public Decomposition(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


    public int nok() {
        int a = getA();
        int b = getB();
        int i = 0;
        if (Math.abs(a) > 0 & Math.abs(b) > 0) {
            i = 2;
            while (a % i != 0 | b % i != 0) {
                i++;
                if (i == a | i == b)
                    return 1;
                break;
            }

            return i;
        } else return 1;
    }

    public int nod() {
        int a = getA();
        int b = getB();
        int i = 0;
        if (a > 0 & b > 0) {
            i = Math.min(a, b);

            while (a % i != 0 | b % i != 0) {
                i--;
            }
            return i;

        } else return 0;

    }

    public int equation() {
        return (getA() * getB()) / nod();

    }

    public int nodFour() {
        int a = getA();
        int b = getB();
        int d = getD();
        int c = getC();
        int i = Math.min(Math.min(a, b), Math.min(d, c));
        if (a > 0 & b > 0 & d > 0 & c > 0) {

            while (a % i != 0 | b % i != 0 | d % i != 0 | c % i != 0) {
                i--;
            }
            return i;

        } else return 0;


    }

    public double areaOfAHexagon() {
        double a = getA();
        return (3 * Math.sqrt(3) * Math.pow(a, 2)) / 2;

    }

    public double distanceOfDot() {
        System.out.println("Enter count of dot ==/2");

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] area = new int[count];
        for(int i=0;i<area.length;i++){
            area[i]= (int) (Math.random() * 40) +1;
        }
        double maxDistance=Math.sqrt((Math.pow(area[2]-area[0],2)+Math.pow(area[3]-area[1],2)));
        for(int i=0;i<area.length-7;i++){
            if (Math.sqrt((Math.pow(area[i+2]-area[i],2)+Math.pow(area[i+3]-area[i+1],2)))>Math.sqrt((Math.pow(area[i+6]-area[i+4],2)+Math.pow(area[i+7]-area[i+5],2))))
            {

                maxDistance=Math.sqrt((Math.pow(area[i+2]-area[i],2)+Math.pow(area[i+3]-area[i+1],2)));

            }
        }
return maxDistance;
    }
    public int secondLargest() {
        System.out.println("Enter count of dot ==/2");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        int max = array[0];
        int secondmax = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 40) + 1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondmax = max;
                max = array[i];
            }

        }
        return secondmax;
    }



}
