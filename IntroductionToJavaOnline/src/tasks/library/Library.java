package tasks.library;

import tasks.book.Book;
import tasks.accounts.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//library", "library.txt");

    public Library() throws IOException {
        System.out.println("start library");
        books = gettingBooksOutFile();
        Account accountServices = new Account();
        accountServices = accountServices.entry();
        accountServices.menu(books);
        writingToFile(books);


    }

    public void writingToFile(List<Book> books) throws IOException {


        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < books.size(); i++) {
            outputWriter.write(books.get(i).toString() + "\n");
        }
        outputWriter.flush();
        outputWriter.close();

    }//запись в файл

    public ArrayList<Book> gettingBooksOutFile() throws IOException {
        ArrayList<Book> books = new ArrayList<Book>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] readsbook = line.split(";");
            Book book = new Book(readsbook[0], readsbook[1], readsbook[2]);
            books.add(book);
            line = bufferedReader.readLine();


        }

        return books;
    }//четние из файла.

}
// File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//library", "library.txt");

//Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
//Общие требования к заданию:
//• Система учитывает книги как в электронном, так и в бумажном варианте.+
//• Существующие роли: пользователь, администратор.+
//• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
//книг в каталоге.+
//• Администратор может модифицировать каталог.+

//• *При добавлении описания книги в каталог оповещение о ней рассылается на
//e-mail всем пользователям----------
//• **При просмотре каталога желательно реализовать постраничный просмотр+
//• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
//администратору на e-mail.
//• Каталог книг хранится в текстовом файле.+
//• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
//не хранится в открытом виде.+


//cериализцаия.
//