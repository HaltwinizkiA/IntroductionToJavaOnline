package tasks.task4.port;

import tasks.task4.container.Containter;
import tasks.task4.container.SortConatiner;
import tasks.task4.ship.Ship;

import java.util.LinkedList;
import java.util.List;

public class Port {
    private final List<Ship> queueUnload;
    private final List<Ship> queueLoad;
    private final int countOfLoadDock;
    private final int countOfUnLoadDock;
    private final int portMaxWeight;
    private final List<Containter> containterList;
    private int portWeight;

    public Port(int countOfDock, int portMaxWeight) {
        containterList = new LinkedList<>();
        int max1 = countOfDock / 2;
        countOfLoadDock = max1;
        countOfUnLoadDock = max1;
        queueUnload = new LinkedList();
        queueLoad = new LinkedList();
        this.portMaxWeight = portMaxWeight;
        portWeight = 0;
    }

    public synchronized void unload(Ship ship) throws InterruptedException {
        while (this.queueUnload.size() == countOfUnLoadDock) {
            System.out.println("*UNLOAD*: Not empty dock " + Thread.currentThread().getName() + " waiting ");
            wait();
        }
        while (this.portWeight >= portMaxWeight) {
            System.out.println("*UNLOAD*: Not  enough space for containers " + Thread.currentThread().getName() + " waiting ");
            wait();
        }

        Thread.sleep(2000);
        this.queueUnload.add(ship);
        while (true) {
            try {
                if (this.portWeight + ship.getContainterList().get(0).getWeight() > portMaxWeight) {
                    System.out.println("*UNLOAD*: port storage is full  " + Thread.currentThread().getName() + " waiting. storage:" + portWeight + "/" + portMaxWeight);
                    wait();
                    continue;
                }
                this.containterList.add(ship.getContainterList().get(0));
                this.portWeight += ship.getContainterList().get(0).getWeight();
                ship.getContainterList().remove(0);
            } catch (Exception e) {
                break;
            }

        }
        System.out.println("*UNLOAD*: " + Thread.currentThread().getName() + " Unload the cargo,Count of ships in dock " + (this.queueUnload.size() - 1) + "");
        this.queueUnload.remove(ship);
        System.out.println("*UNLOAD*: Count of Container in Port: " + (containterList.size() - 1) + ". weight: " + portWeight + "/" + portMaxWeight);
        notifyAll();
    }

    public synchronized void load(Ship ship) throws InterruptedException {
        while (this.queueLoad.size() == countOfLoadDock | this.containterList.size() == 0) {
            System.out.println("*LOAD*: Not empty dock or not Container in port " + Thread.currentThread().getName() + " waiting in Port ");
            System.out.println("*LOAD*: Ship in port: " + queueLoad.size());
            wait();
            Thread.sleep(1000);
        }
        this.queueLoad.add(ship);
        int weightOfContainer = 0;
        this.containterList.sort(new SortConatiner());
        while (true) {
            try {
                if (weightOfContainer + this.containterList.get(0).getWeight() <= ship.getMaxWeight()) {
                    ship.getContainterList().add(this.containterList.get(0));
                    this.portWeight -= this.containterList.get(0).getWeight();
                    this.containterList.remove(0);
                    weightOfContainer += this.containterList.get(0).getWeight();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("*LOAD*: not container in port. " + Thread.currentThread().getName() + " waiting in Dock");
                wait();
            }
        }
        this.queueLoad.remove(ship);
        System.out.println("*LOAD*: " + Thread.currentThread().getName() + " loaded, capacity : " + weightOfContainer + "/" + ship.getMaxWeight() + " current queue:" + queueLoad.size() +
                "\n Count of containers in port: " + (this.containterList.size() - 1));
        System.out.println("Remainder of weight in port: " + portWeight + "/" + portMaxWeight);
        notifyAll();

    }
}


