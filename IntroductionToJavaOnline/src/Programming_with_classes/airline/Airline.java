package Programming_with_classes.airline;

public class Airline {
    double time=0;
    int num=0;
    String type=" ";
    String dayOfWeek=" ";
    String destination=" ";

    @Override
    public String toString() {
        return "Airline{" +
                "time='" + time + '\'' +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public Airline() {
    }

    public Airline(double time, int num, String type, String dayOfWeek, String destination) {
        this.time = time;
        this.num = num;
        this.type = type;
        this.dayOfWeek = dayOfWeek;
        this.destination = destination;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
//10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.