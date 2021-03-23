package tasks.task4;

import java.util.List;
import java.util.Scanner;

public class Dock {
    private final String state = "empty";
    private final Scanner scanner;
    private Ship ship;

    public Dock() {
        scanner = new Scanner(System.in);

    }

    @Override
    public String toString() {
        return "Dock{state: " + state + ", ship: " + ship + "}";
    }

    public String getState() {
        return state;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Container> ShipAction(List<Container> container) {

        System.out.println("select Ship action: \n1-unloading \n2-loading");
        int select = scanner.nextInt();
        switch (select) {
            case 1 -> unloading(container);
            case 2 -> loading(container);
        }
        return container;
    }


    private List<Container> unloading(List<Container> containers) {
        for (Container container : ship.getContainers()) {
            containers.add(container);
        }

        ship.empty();

        return containers;
    }

    private void loading(List<Container> container) {
        if (ship.getState() == "empty") {
            container = ship.addContainer(container);
        } else {
            System.out.println("Ship is full");
        }

    }

}
