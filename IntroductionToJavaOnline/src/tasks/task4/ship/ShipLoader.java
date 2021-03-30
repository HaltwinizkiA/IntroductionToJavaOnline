package tasks.task4.ship;

import tasks.task4.port.Port;

import java.util.ArrayList;

public class ShipLoader extends Ship {


    public ShipLoader(Port port, int maxWeight) {
        this.port = port;
        setContainterList(new ArrayList<>()) ;
        setMaxWeight(maxWeight);
    }

    @Override
    public void run() {
        try {
            this.port.load(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
