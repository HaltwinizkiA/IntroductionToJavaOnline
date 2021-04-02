public class Main {

    public static void main(String[] args) {


        try{
            String[] a=new String[1];
            try {
                a[2]="asdf";

            } catch (ArithmeticException s){

            } catch (IndexOutOfBoundsException|ArithmeticException e){
                System.out.println(2);
                int b=123/0;
            }

}
}





