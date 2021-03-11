package Basics_of_OOP.payment;

public class Payment {
    Product[] products;
    int totalPrice;

    public void buy(){
        Product apple=new Product(2,12);
        Product banana=new Product(1,4);
        Product knife=new Product(15,1);


        products=new Product[]{apple,banana,knife};
        for (Product p:products){
            totalPrice+=p.price;
        }
        System.out.println(totalPrice);

    }

    class Product{
        int price;
        int count;

        public Product(int price, int id) {
            this.price = price;
            this.count = id;
        }
    }
}
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.