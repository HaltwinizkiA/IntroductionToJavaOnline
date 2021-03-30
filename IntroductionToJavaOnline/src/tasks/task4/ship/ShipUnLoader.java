package tasks.task4.ship;

import tasks.task4.container.Containter;
import tasks.task4.port.Port;

import java.util.ArrayList;

public class ShipUnLoader extends Ship {


    public ShipUnLoader(int countOfContainer, Port port, Containter containter) {
        this.port = port;
        setContainterList(new ArrayList<>());
        for (int i = 0; i <=countOfContainer; i++) {
            getContainterList().add(containter);
        }


    }

    @Override
    public void run() {

        try {
            this.port.unload(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
