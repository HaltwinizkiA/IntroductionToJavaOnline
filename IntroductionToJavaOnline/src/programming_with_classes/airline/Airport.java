package programming_with_classes.airline;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Airport {
    Airline[] airlines;
    Scanner scanner = new Scanner(System.in);
    Pattern pattern;
    Matcher matcher;

    public void createAirport() {
//            for(int i=0;i<airlines.length;i++){
//                System.out.println("enter count of airplane:");
//                int countOfAirplane=scanner.nextInt();
//                airlines=new Airline[countOfAirplane];
//                airlines[i].setDestination();
//                airlines[i].setDayOfWeek();
//                airlines[i].setTime();
//                airlines[i].setNum();
//                airlines[i].setType();
        airlines = new Airline[4];
        for (int i = 0; i < airlines.length; i++) {
            airlines[i] = new Airline();

        }

        airlines[0].setDestination("Minsk");
        airlines[0].setDayOfWeek("Monday");
        airlines[0].setTime(12.30);
        airlines[0].setNum(1);
        airlines[0].setType("boeing");
        airlines[1].setDestination("Minsk");
        airlines[1].setDayOfWeek("Friday");
        airlines[1].setTime(11.22);
        airlines[1].setNum(2);
        airlines[1].setType("jet");
        airlines[2].setDestination("Brest");
        airlines[2].setDayOfWeek("Thursday");
        airlines[2].setTime(16.00);
        airlines[2].setNum(3);
        airlines[2].setType("boeing");
        airlines[3].setDestination("Minsk");
        airlines[3].setDayOfWeek("Monday");
        airlines[3].setTime(20.00);
        airlines[3].setNum(4);
        airlines[3].setType("carton");
        for (Airline a : airlines) {
            System.out.println(a);
        }
        System.out.println("choose metod:\n 1-list of flights for a given destination;\n 2-list of flights for a given day of the week;" +
                "\n 3-list of flights for a given day of the week, the departure time for which is greater than the specified one.");
        switch (scanner.nextInt()) {
            case 1 -> outputFlightOnDestination();
            case 2 -> outputFlightOnDayOfWeek();
            case 3 -> outputFlightOnDayAtferTime(outputFlightOnDayOfWeek());
            default -> {
                System.out.println("wrong num of metod!!!!!!");
                createAirport();
            }
        }
    }

    public void outputFlightOnDestination() {
        System.out.println("enter Destination:");
        String destination = scanner.next();
        pattern = Pattern.compile(destination);
        for (int i = 0; i < airlines.length; i++) {
            matcher = pattern.matcher(airlines[i].getDestination());

            if (matcher.find()) {
                System.out.println("Flight by destination: " + destination);
                System.out.println(airlines[i]);
            }

        }


    }

    public ArrayList outputFlightOnDayOfWeek() {
        System.out.println("enter day of Week:");
        String day = scanner.next();
        pattern = Pattern.compile(day);
        ArrayList<Airline> cache = new ArrayList<Airline>();
        for (Airline a : airlines) {
            matcher = pattern.matcher(a.getDayOfWeek());


            if (matcher.find()) {
                System.out.println("Flight by day: " + day);
                System.out.println(a);
                cache.add(a);

            }

        }
        return cache;
    }

    public ArrayList outputFlightOnDayAtferTime(ArrayList<Airline> a) {
        System.out.println("enter time in formant /hours,min/  : ");
        double time = scanner.nextDouble();
        ArrayList<Airline> cache = new ArrayList<Airline>();
        for (Airline as : a) {
            if (as.getTime() > time) {
                System.out.println("after " + time);
                cache.add(as);
                System.out.println(as);
            }
        }


        return cache;
    }




}
