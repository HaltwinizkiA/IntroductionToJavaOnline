package programming.with.classes.book;

public class Book {
    int id;
    String name;
    String publishing;
    String autor;
    int year;
    int countOfPage;
    double price;
    String bindingType;

    public Book(int id, String name, String publishing, String autor, int year, int countOfPage, double price, String bindingType) {
        this.id = id;
        this.name = name;
        this.publishing = publishing;
        this.autor = autor;
        this.year = year;
        this.countOfPage = countOfPage;
        this.price = price;
        this.bindingType = bindingType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCountOfPage() {
        return countOfPage;
    }

    public void setCountOfPage(int countOfPage) {
        this.countOfPage = countOfPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishing='" + publishing + '\'' +
                ", autor='" + autor + '\'' +
                ", year=" + year +
                ", countOfPage=" + countOfPage +
                ", price=" + price +
                ", bindingType='" + bindingType + '\'' +
                '}';
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

