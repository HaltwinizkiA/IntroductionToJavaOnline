package tasks.task4.ship;

import tasks.task4.container.Containter;
import tasks.task4.port.Port;

import java.util.List;

public abstract class Ship extends Thread {
    public Port port;

    public void setContainterList(List<Containter> containterList) {
        this.containterList = containterList;
    }

    private List<Containter> containterList;
    private int maxWeight;

    public List<Containter> getContainterList() {
        return containterList;
    }

    abstract public void run();

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}


