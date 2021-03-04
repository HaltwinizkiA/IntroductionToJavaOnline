package Programming_with_classes;

import java.util.Scanner;

public class Test1 {
    double a=0;
    double b=0;
    public void output(){

        System.out.println("a: "+a+" b: "+b);
    }

    public double getA() {
        return a;
    }

    public void setA() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("pls enter a");
        this.a =scanner.nextDouble();
    }

    public double getB() {
        return b;
    }

    public void setB() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("pls enter b");
        this.b =scanner.nextDouble();
    }
    public void sum(){
        System.out.println("Sum: "+(a+b));
    }
    public void comparison(){
        if(a>b){
            System.out.println("Hight a: " +a);
        }
        else {
            System.out.println("Hight b: " +b);
        }
    }
}
