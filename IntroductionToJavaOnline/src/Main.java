

public class Main {

    public static void main(String[] args) {
        a(12,123,123);
        a(12);

    }
    public static void a(int...d){
        System.out.println(1);
    }
    public static void a(int d){
        System.out.println(2);
    }
}
