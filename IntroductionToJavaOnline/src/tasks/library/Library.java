package tasks.library;

import tasks.book.Book;
import tasks.book.Type;
import tasks.service.impl.AccountServicesImpl;

import java.io.*;
import java.util.ArrayList;

public class Library {
    ArrayList<Book[]> books = new ArrayList<>();
    File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//library", "library.txt");

    public void inicialization() throws IOException {
        System.out.println("start library");
        books=createLibrary(createBooks());
        AccountServicesImpl accountServices=new AccountServicesImpl();
        accountServices=accountServices.entry();




    }
    public ArrayList<Book[]> createLibrary(Book[] book) {

        int countOfBookOnPage = 2;
        Book[] page = new Book[countOfBookOnPage];


        for (int i = 0; i < book.length; ) {
            for (int j = 0; j < 2; j++) {
                if (i==book.length){
                    page[j]=null;
                }
                else {
                page[j] = book[i];}
                i++;
            }
            books.add(page.clone());

        }
        return books;
    }//разделение на страницы
    public Book[] createBooks(){
        Book[] book = new Book[5];
        book[0] = new Book("cat", 12, Type.Electronic);
        book[1] = new Book("HarryPotter", 24, Type.Electronic);
        book[2] = new Book("Warcraft", 45, Type.Paper);
        book[3] = new Book("notBook", 123, Type.Paper);
        book[4] = new Book("Kislo", 32, Type.Electronic);
return book;
    }//создание книг
    public void writingToFile(Book[] books) throws IOException {


        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
        for (int i=0;i<books.length;i++){
            outputWriter.write(books[i].toString()+"\n");
        }
        outputWriter.flush();
        outputWriter.close();
    }//запись в файл
    public Book[] gettingBooksOutFile() throws IOException {
        ArrayList<Book> books=new ArrayList<Book>();
        FileReader reader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String line=bufferedReader.readLine();
        while (line!=null){
            String readsbook[]=line.split(";");
            Book book=new Book(readsbook[0],readsbook[1],readsbook[2]);
            books.add(book);
            line=bufferedReader.readLine();

        }
            Book[]book=new Book[books.size()];
        for (int i=0;i<book.length;i++){
            book[i]=books.get(i);
        }
        return book;
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