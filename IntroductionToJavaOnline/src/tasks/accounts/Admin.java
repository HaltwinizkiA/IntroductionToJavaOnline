package tasks.accounts;

import tasks.book.Book;
import tasks.book.Type;
import tasks.service.impl.AccountServicesImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends AccountServicesImpl {
    Scanner scanner=new Scanner(System.in);


    private ArrayList<Book> modifyLibrary(ArrayList<Book> books ){
        System.out.println("enter num of modify 1-add 2 -delete");

        int num=scanner.nextInt();
        switch (num){
            case 1->addBook(books);
            case 2->deleteBook(books);
        }
        System.out.println("library changed");

return books;
    }
    private ArrayList<Book> addBook(ArrayList<Book> books){
        Book book = null;
        System.out.println("enter name");
        String name=scanner.next();
        System.out.println("enter num of page");
        int num=scanner.nextInt();
        System.out.println("Choose  type 1-Paper or 2 - Electronic ");
        switch (scanner.nextInt()){
            case 1-> book=new Book(name,num, Type.Paper);
            case 2-> book=new Book(name,num, Type.Electronic);
        }
        books.add(book);
        return books;
    }
    private ArrayList<Book> deleteBook(ArrayList<tasks.book.Book> books){
        System.out.println("choose num of book");
        int num= scanner.nextInt();
        books.remove(num);

        return books;

    }

}
//login admin  password qwerty