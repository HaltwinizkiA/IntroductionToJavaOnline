package tasks.task1.library;

import tasks.task1.book.Book;
import tasks.task1.accounts.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> books = new ArrayList<>();

    File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task1//library", "library.txt");

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

    }

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
    }

}
