package tasks.accounts;

import tasks.book.Book;
import tasks.book.Type;

import java.util.List;
import java.util.Scanner;

public class Admin extends Account {
    Scanner scanner = new Scanner(System.in);

    public Admin() {
    }

    public void menu(List<Book> books) {
        boolean flag = true;
        while (flag) {
            System.out.println("menu:\n1-View Library\n2-Search book\n3-modify Library\n9-for stop");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> view(books);
                case 2 -> search(books);
                case 3 -> modifyLibrary(books);
                case 9 -> flag = false;
            }
        }

    }

    private List<Book> modifyLibrary(List<Book> books) {
        System.out.println("enter num of modify 1-add 2 -delete");

        int num = scanner.nextInt();
        switch (num) {
            case 1 -> addBook(books);
            case 2 -> deleteBook(books);
        }
        System.out.println("library changed");

        return books;
    }

    private List<Book> addBook(List<Book> books) {
        Book book = null;
        System.out.println("enter name");
        String name = scanner.next();

        int num = 0;

        while (true) {

            try {
                System.out.println("enter num of page");
                num = scanner.nextInt();
                break;

            } catch (Exception e) {
                System.out.println("Error wrong num " + e);
                scanner.nextLine();
            }
        }

        System.out.println("Choose  type 1-Paper or 2 - Electronic ");

        switch (scanner.nextInt()) {
            case 1 -> book = new Book(name, num, Type.Paper);
            case 2 -> book = new Book(name, num, Type.Electronic);
        }

        books.add(book);
        sendingNotifications(book);
        return books;
    }

    private List<Book> deleteBook(List<tasks.book.Book> books) {
        System.out.println("choose num of book");
        int num = scanner.nextInt();
        books.remove(num);

        return books;

    }

}
//login admin  password qwerty