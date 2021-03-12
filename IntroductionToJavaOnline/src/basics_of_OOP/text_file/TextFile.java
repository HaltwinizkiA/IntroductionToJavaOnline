package basics_of_OOP.text_file;

import java.util.Scanner;

public class TextFile {
    Directory directory;
    File file;
    Scanner scanner = new Scanner(System.in);

    public TextFile createText() {
        TextFile textFile = new TextFile();
        textFile.file = new File();
        textFile.directory = new Directory();
        int i = 0;
        while (!(i == 4)) {
            i = scanner.nextInt();
            switch (i) {
                case 1 -> supplement(textFile);
                case 2 -> outPut(textFile);
                case 3 -> remove(textFile);


            }
        }
return textFile;
    }

    public void outPut(TextFile textFile) {

        System.out.println("way:" + textFile.directory.way + " Content :" + textFile.file.text);
    }

    public TextFile remove(TextFile textFile) {

        return null;
    }

    public TextFile supplement(TextFile textFile) {
        System.out.println("enter supplements:");

        String app = scanner.next();
        textFile.file.text = textFile.file.text + " " + app;
        return textFile;

    }
}


//    Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//        вывести на консоль содержимое, дополнить, удалить.