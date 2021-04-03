package programming.with.classes.airline;

public class Airline {
    double time = 0;
    int num = 0;
    String type = " ";
    String dayOfWeek = " ";
    String destination = " ";

    public Airline() {
    }

    public Airline(double time, int num, String type, String dayOfWeek, String destination) {
        this.time = time;
        this.num = num;
        this.type = type;
        this.dayOfWeek = dayOfWeek;
        this.destination = destination;
    }

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
