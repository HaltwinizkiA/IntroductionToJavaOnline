package tasks.task1.book;

public class Book {
    String name="";
    int countOfPage=0;
    Type type;
    public Book(String name, String countOfPage, String type) {
        this.name = name;
        this.countOfPage =Integer.parseInt(countOfPage);
        if (type.equals("Paper")){
            this.type=Type.Paper;}
        else if (type.equals("Electronic")){
        this.type = Type.Electronic;}
    }

    public String getName() {
        return name;
    }

    public int getCountOfPage() {
        return countOfPage;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name +";"+ countOfPage + ";" + type;
    }

    public Book(String name, int countOfPage, Type type) {
        this.name = name;
        this.countOfPage = countOfPage;
        this.type = type;
    }
}

