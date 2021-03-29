package tasks.task4.port;

import tasks.task4.container.Containter;
import tasks.task4.ship.ShipLoader;
import tasks.task4.ship.ShipUnLoader;

public class PortBuilder {
    public void build() {

        Containter containterS = new Containter(2);
        Containter containterM = new Containter(10);
        Containter containterL = new Containter(15);


        Thread t = Thread.currentThread();
        t.setName("Ship waiting");
        Port port = new Port(6, 350);
        Thread ship1 = new Thread(new ShipUnLoader(10, port, containterL), "Ship IKEA");
        Thread ship2 = new Thread(new ShipUnLoader(20, port, containterS), "Ship SAMSUNG");
        Thread ship3 = new Thread(new ShipUnLoader(15, port, containterM), "Ship MERCEDES");
        Thread ship4 = new Thread(new ShipUnLoader(10, port, containterL), "Ship 21VEK");
        Thread ship5 = new Thread(new ShipUnLoader(15, port, containterM), "Ship APPLE");
        Thread ship6 = new Thread(new ShipLoader(port, 30), "Ship DHL 1");
        Thread ship7 = new Thread(new ShipLoader(port, 30), "Ship DHL 2");
        Thread ship8 = new Thread(new ShipLoader(port, 120), "Ship AMAZON 1");
        Thread ship9 = new Thread(new ShipLoader(port, 135), "Ship AMAZON 2");
        Thread ship10 = new Thread(new ShipLoader(port, 75), "Ship AMAZON 3");
        Thread ship11 = new Thread(new ShipLoader(port, 30), "Ship DHL 3");
        Thread ship12 = new Thread(new ShipLoader(port, 70), "Ship DHL 4");
        ship1.start();
        ship2.start();
        ship3.start();
        ship4.start();
        ship5.start();
        ship6.start();
        ship7.start();
        ship8.start();
        ship9.start();
        ship10.start();
        ship11.start();
        ship12.start();

        try {
            ship1.join();
            ship2.join();
            ship3.join();
            ship4.join();
            ship5.join();
            ship6.join();
            ship7.join();
            ship8.join();
            ship9.join();
            ship10.join();
            ship11.join();
            ship12.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
