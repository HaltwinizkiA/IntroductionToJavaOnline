package Basics_of_OOP.calendar;

public class Calendar {
    Month[] months = new Month[12];


    public void createHoliday() {
        months[0].name = "january";
        months[1].numOfWeekends = new int[]{1, 5, 6, 7, 12, 13, 19, 20, 26, 27};
        months[0].name = "February";
        months[1].numOfWeekends = new int[]{6, 7, 13, 14, 20, 21, 27, 28};
        months[0].name = "Mart";
        months[1].numOfWeekends = new int[]{6, 7, 8, 13, 14, 20, 21, 27, 28};
        months[0].name = "April";
        months[1].numOfWeekends = new int[]{3, 4, 10, 11, 17, 18, 24, 25};


    }


    class Month {
        String name;
        int[] numOfWeekends;


    }


}
//Задача 3.
//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.