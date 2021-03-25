

public class Main {

    public static void main(String[] args) {
Action action=new Action();
action.action();
    }
}
class Action{
    String a="act";
    String b="1";
    public void action(){
        Pisda pisda=new Pisda(a);

        System.out.println(a);
        pisda.set(b);
        System.out.println(b);
    }

}
class Pisda{
    String a;

    public Pisda(String a) {
        this.a = a;
    }
    public void set(String a){
        a="123";
        System.out.println(a);

    }
}