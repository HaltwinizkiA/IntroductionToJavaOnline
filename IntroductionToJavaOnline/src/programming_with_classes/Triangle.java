package programming_with_classes;

import java.util.Scanner;

public class Triangle {
    double x1, y1, x2, y2, x3, y3;


    double a;
    double b;
    double c;

    public Triangle createTriangle() {
        Triangle triangle = new Triangle();
        System.out.println("enter triangles coordinate \n a  :\n x1: ");
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextInt();
        System.out.println(" y1 : ");
        y1 = scanner.nextInt();
        System.out.println("enter coordinate b: \n x2: ");
        x2 = scanner.nextInt();
        System.out.println(" y2 : ");
        y2 = scanner.nextInt();
        System.out.println("enter coordinate  c: \n x3: ");
        x3 = scanner.nextInt();
        System.out.println(" y3 : ");
        y3 = scanner.nextInt();
        a = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        b = Math.sqrt((y3 - y2) * (y3 - y2) + (x3 - x2) * (x3 - x2));
        c = Math.sqrt((y1 - y3) * (y1 - y3) + (x1 - x3) * (x1 - x3));
        median();
//        triangle.c = scanner.nextInt();


        return triangle;
    }

    public double square() {

        if (a == b) {

            double h = Math.sqrt((a * a) - ((c * c) / 4));
            return (c * h) / 2;
        }//3 случая равнобедренного треугольника.
        if (c == b) {
            double h = Math.sqrt((c * c) - ((a * a) / 4));
            return (a * h) / 2;
        }
        if (c == a) {
            double h = Math.sqrt((c * c) - ((b * b) / 4));
            return (b * h) / 2;
        }
        if (a == c & c == b) {
            return (Math.sqrt(3) / 4) * Math.pow(2, 2);
        }//равносторонний
        else {
            double h = 2 * perimetr() / a;
            double p = perimetr() / 2;
            double h2 = (2 * Math.sqrt(p * (p - a) * (p - b) * (p - c))) / a;
            return (a / 2) * h2;
        }
    }


    public double perimetr() {

        return a + b + c;
    }

    public void median() {

        System.out.println(" Median intersection point  x  : " + medianX() + "  y  : " + medianY());
    }

    public double medianX() {
        return (x1 + x2 + x3) / 3;
    }

    public double medianY() {
        return (y1 + y2 + y3) / 3;
    }


}
//7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
//площади, периметра и точки пересечения медиан.