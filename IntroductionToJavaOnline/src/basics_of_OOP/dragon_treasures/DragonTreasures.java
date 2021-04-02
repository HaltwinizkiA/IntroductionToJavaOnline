package basics_of_OOP.dragon_treasures;

public class DragonTreasures {
    NameOfTreasure name;
    int price=0;

    public DragonTreasures(NameOfTreasure name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DragonTreasures{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }
}
