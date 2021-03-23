package tasks.task4;

import java.util.List;
import java.util.Scanner;

public class Dock {
    String state = "empty";
    Ship ship;

    @Override
    public String toString() {
        return "Dock{state: " + state +", ship: " + ship +"}";
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    Scanner scanner;
    public Dock() {
        scanner = new Scanner(System.in);

    }

    public String getState() {
        return state;
    }

    public Ship getShip() {
        return ship;
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


    public List<Container> unloading(List<Container> containers) {
        for (Container container:ship.getContainers()){
        containers.add(container);
        }

        ship.empty();

        return containers;
    }

    public void loading(List<Container> container) {
        if (ship.getState() == "empty") {
         container=ship.addContainer(container);
        } else {
            System.out.println("Ship is full");
        }

    }

}
