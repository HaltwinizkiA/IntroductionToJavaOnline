package tasks.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Port {
    private final List<Dock> docks;
    private final List<Ship> ships;
    private final Scanner scanner;
    private List<Container> containers;

    public Port() {
        scanner = new Scanner(System.in);
        docks = new ArrayList<Dock>();
        createDock(2);
        containers = new ArrayList<Container>();
        ships = new ArrayList<Ship>();
        shipInPort(5);
        portMenu();


    }

    private void createDock(int count) {
        for (int i = 0; i < count; i++) {
            docks.add(new Dock());
        }
    }

    public void shipInPort(int count) {
        for (int i = 0; i < count; i++) {
            ships.add(new Ship());
        }
    }

    public void viewPort() {
        for (int i = 0; i < docks.size(); i++) {
            System.out.println("Num: " + i + " " + docks.get(i));
        }
        for (int i = 0; i < ships.size(); i++) {
            System.out.println("Num:" + i + " " + ships.get(i));
        }
    }

    public void portMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("selected action: \n1- view all Port\n2-view Containers in Port\n3-view all Ships in queue\n4-view Docks in Port\n5-Action with Docks\n6-stop");
            int select = scanner.nextInt();
            switch (select) {
                case 1 -> viewPort();
                case 2 -> viewContainerInPort();
                case 3 -> viewShipsInQueue();
                case 4 -> viewDocksInPort();
                case 5 -> portAction();
                case 6 -> flag = false;

            }
        }
    }

    private void viewDocksInPort() {
        for (int i = 0; i < docks.size(); i++) {
            System.out.println("Num: " + i + " " + docks.get(i));
        }
    }

    private void viewShipsInQueue() {
        for (int i = 0; i < ships.size(); i++) {
            System.out.println("Num: " + i + " " + ships.get(i));
        }

    }

    private void viewContainerInPort() {

        for (int i = 0; i < containers.size(); i++) {
            System.out.println("Num: " + i + " " + containers.get(i));
        }
    }

    private void portAction() {


        System.out.println("select Dock dock 0-" + (docks.size() - 1));
        int selectDock = scanner.nextInt();
        System.out.println(docks.get(selectDock));
        if (docks.get(selectDock).getState() == "empty") {
            System.out.println("select a ship to enter in the dock\n: 0-" + ships.size());
            viewShipsInQueue();
            int selectShip = scanner.nextInt();
            docks.get(selectDock).setShip(ships.get(selectShip));
            ships.remove(selectShip);
        } else {
            System.out.println("ship in dock -:  " + docks.get(selectDock).getShip());
        }
        containers = docks.get(selectDock).ShipAction(containers);

    }
}
//Задание 4. Многопоточность. Порт . Корабли заходят в порт для
//разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
//в порту и на корабле, должно быть неотрицательным и превышающим заданную
//грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
//У одного причала может стоять один корабль. Корабль может загружаться у причала
//или разгружаться