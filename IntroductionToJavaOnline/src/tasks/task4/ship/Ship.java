package tasks.task4.ship;

import tasks.task4.container.Containter;
import tasks.task4.port.Port;

import java.util.List;

public abstract class Ship extends Thread {
    public Port port;
    public int capacity;
    public List<Containter> containterList;

    abstract public void run();

}


