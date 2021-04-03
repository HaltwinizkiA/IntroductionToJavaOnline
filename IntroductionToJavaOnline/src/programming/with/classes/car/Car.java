package programming.with.classes.car;

import java.util.Scanner;

public class Car {
    String mark;
    Wheel wheel;
    Engine engine;
    double gasTank = 0;
    Scanner scanner = new Scanner(System.in);
    Boolean ride = false;

    public Car(String mark) {
        this.mark = mark;
    }

    public Car() {
    }

    public Car(String mark, Wheel wheel, Engine engine) {
        this.mark = mark;
        this.wheel = wheel;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", wheel=" + wheel +
                ", engine=" + engine +
                ", gasTank=" + gasTank +
                ", ride=" + ride +
                '}';
    }

    public Car getcar() {
        Car car = new Car("Ford");
        car.engine = new Engine(1.6, "diesel");
        car = changeWheel(car);
        car = refueling(car);
        car = ride100km(car);
        car.outputMark(car);


        return car;
    }

    public Car ride100km(Car car) {
        car.ride = true;
        car.gasTank -= 8;


        return car;
    }

    public Car refueling(Car car) {
        car.gasTank = 50;
        return car;
    }

    public Car changeWheel(Car car) {
        System.out.println("choose wheel type 1- winter 2- summer; ");
        switch (scanner.nextInt()) {
            case 1 -> {
                car.wheel = new Wheel("Winter");
                return car;
            }
            case 2 -> {
                car.wheel = new Wheel("Summer");
                return car;
            }
            default -> {
                return car;
            }
        }


    }

    public void outputMark(Car car) {
        System.out.println(" car mark: " + car.mark);
    }
}
