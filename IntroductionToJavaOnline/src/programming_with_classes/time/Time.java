package programming_with_classes.time;

import java.util.Scanner;

public class Time {
    int hours;
    int min;
    int sec;
    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", min=" + min +
                ", sec=" + sec +
                '}';
    }

    public int getHours() {
        return hours;
    }

    public void setHours() {
        System.out.println("enter hours:");
        int hours = scanner.nextInt();
        if (hours > 24 & hours < 0) {
            System.out.println("wrong value ");
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin() {
        System.out.println("enter min:");
        int min = scanner.nextInt();
        if (min > 60 & min < 0) {
            System.out.println("wrong value ");
            this.min = 0;
        } else {
            this.min = min;
        }

    }

    public int getSec() {
        return sec;
    }

    public void setSec() {
        System.out.println("enter sec:");
        int sec = scanner.nextInt();
        if (sec > 60 & sec < 0) {
            System.out.println("wrong value ");
            this.sec = 0;
        } else {
            this.sec = sec;
        }
    }

    public void enterTime() {


        System.out.println("enter time");
        setHours();

        setMin();

        setSec();
        System.out.println("select the part to change 1-hours;2-min;3-sec");
        int change = scanner.nextInt();
        switch (change) {
            case 1 -> setHours();
            case 2 -> setMin();
            case 3 -> setSec();
            default -> System.out.println("wrong change");
        }
        timeModification();

    }

    public int modifTime() {
        int time = scanner.nextInt();

        if (time < 0) {
            System.out.println("wrong time");
            return 0;
        } else {
            return time;

        }


    }

    public void timeModification() {
        System.out.println("enter modif time 1-hours 2-min 3 sec");
        int modif = scanner.nextInt();
        switch (modif) {
            case 1 -> hours = +scanner.nextInt();
            case 2 -> min += modifTime();
            case 3 -> sec += modifTime();
            default -> System.out.println("wrong time");
        }
    }
}
//6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.