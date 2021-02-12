import java.util.Scanner;

public class Branching {

    public void triangle() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = 180 - a - b;
        int sum = a + b + c;
        if (a + b + c == 180) {
            System.out.println("This triangle is exist");
            if ((a == 90) || (b == 90) || (c == 90)) {
                System.out.println("Triangle is straight");

            }
        } else {
            System.out.println("Triangle is not exist ");

        }

    }

    public void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a");
        int a = scanner.nextInt();
        System.out.println("enter b");
        int b = scanner.nextInt();
        System.out.println("enter c");
        int c = scanner.nextInt();
        System.out.println("enter d");
        int d = scanner.nextInt();
        int max = Math.max(Math.min(a, b), Math.min(c, d));

    }

    public void threeDot() {


    }

    public void brick() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter A");
        int a = scanner.nextInt();
        System.out.println("enter B");
        int b = scanner.nextInt();
        System.out.println("enter x");
        int x = scanner.nextInt();
        System.out.println("enter y");
        int y = scanner.nextInt();
        System.out.println("enter z");
        int z = scanner.nextInt();

        if ((z <= a || x <= a || x <= b) && (y <= a || y <= b || z <= b)) {
            System.out.println("brick is passed");
        } else {
            System.out.println("not passed");
        }
    }

    public void equation() {
        double resul = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter x");
        int x = scanner.nextInt();
        if (x > 3) {
            resul = 1 / (Math.pow(x, 3) + 6);
        } else if (3 <= x) {
            resul = Math.pow(x, 2) - 3 * x + 9;

        }
        System.out.println(resul);
    }


}
