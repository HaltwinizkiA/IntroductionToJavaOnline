package basics_of_OOP.dragon_treasures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DragonCave implements Comparator<DragonTreasures> {
    DragonTreasures[] treasures = new DragonTreasures[100];
    NameOfTreasure[] name = NameOfTreasure.values();
    Scanner scanner = new Scanner(System.in);

    public DragonTreasures[] createTreasures() {
        for (int i = 0; i < treasures.length; i++) {
            treasures[i] = new DragonTreasures(name[(int) (Math.random() * name.length)], (int) (Math.random() * 918) + 82);
        }
        treasureView(treasures);
        System.out.println("\n expensive :" + expensiveTreasure(treasures));
        treasures = choiceForAGivenAmount(treasures);
        treasureView(treasures);
        return treasures;
    }

    public void treasureView(DragonTreasures[] dragonTreasures) {
        for (DragonTreasures d : dragonTreasures) {
            System.out.println(d);
        }
    }

    public DragonTreasures expensiveTreasure(DragonTreasures[] dragonTreasures) {
        Arrays.sort(dragonTreasures, new DragonCave());

        return dragonTreasures[99];
    }

    public DragonTreasures[] choiceForAGivenAmount(DragonTreasures[] dragonTreasures) {
        ArrayList<DragonTreasures> treasures = new ArrayList<DragonTreasures>();
        System.out.println("enter amount ");
        int max = scanner.nextInt();
        int amount = 0;

        while (amount < max) {
            int rand = (int) (Math.random() * 99) + 1;
            if ((amount + dragonTreasures[rand].price) < max) {
                amount += dragonTreasures[rand].price;
                treasures.add(dragonTreasures[rand]);
            } else {
                Arrays.sort(dragonTreasures, new DragonCave());
                if (amount + dragonTreasures[0].price > max) {
                    break;
                }
            }
        }
        dragonTreasures = new DragonTreasures[treasures.size()];
        for (int i = 0; i < treasures.size(); i++) {
            dragonTreasures[i] = treasures.get(i);

        }

        System.out.println("total price: "+amount);
        return dragonTreasures;
    }


    @Override
    public int compare(DragonTreasures o1, DragonTreasures o2) {
        return o1.price - o2.price;
    }


}
//Задача 4.
//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.

//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.