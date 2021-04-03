package programming.with.classes.car;

public class Engine {
    double volume;
    String type;

    public Engine(double volume, String type) {
        this.volume = volume;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume=" + volume +
                ", type='" + type + '\'' +
                '}';
    }
}
