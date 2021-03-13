package tasks.service.impl;

import tasks.accounts.Admin;
import tasks.accounts.User;
import tasks.book.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {

    Scanner scanner = new Scanner(System.in);

    public AccountService entry() throws IOException {
        System.out.println("enter login");
        String login = scanner.next();
        System.out.println("enter password");
        String password = scanner.next();

        return authentication(login, password);
    }

    public void menu(List<Book> books) {
        boolean flag = true;
        while (flag) {
            System.out.println("menu:\n1-View Library\n2-Search book\n3-send book\n9-for stop");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1 -> view(books);
                case 2 -> search(books);
//            case 3 -> sendBook();
                case 9 -> flag = false;
            }
        }

    }

    public AccountService authentication(String name, String password) throws IOException {
        File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//service", "admin.txt");
        File file2 = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//service", "user.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        String[] authent = line.split("/");
        int check = Integer.parseInt(authent[0]);
        if ((name.hashCode()) == check) {
            check = Integer.parseInt(authent[1]);
            if (password.hashCode() == check) {
                System.out.println("your permissions -admin");
                return new Admin();
            }
        }
        reader = new FileReader(file2);
        bufferedReader = new BufferedReader(reader);
        line = bufferedReader.readLine();
        authent = line.split("/");
        check = Integer.parseInt(authent[0]);
        if ((name.hashCode()) == check) {
            check = Integer.parseInt(authent[1]);
            if (password.hashCode() == check) {
                System.out.println("your permissions -user");
                return new User();
            }
        } else {
            System.out.println("ERROR :no such user exists");
            return null;
        }


        return null;
    }

//    public void sendBook() {
//
//        Book book = new Book();
//        System.out.println("User : " + user.name + ""pismo otpravlenno");
//
//    }

    public void search(List<Book> books) {
        System.out.println("book search\n" +
                "Enter the title");
        String title = scanner.next();
        Pattern pattern = Pattern.compile(title);
        for (int i = 0; i < books.size(); i++) {
            Book cache = books.get(i);
            Matcher matcher = pattern.matcher(cache.getName());
            if (matcher.find()) {
                System.out.println(books.get(i).toString());
            }
        }

    }


    public void view(List<Book> books) {

        System.out.println("select view type: \n1-page\n2-list");
        int select = scanner.nextInt();
        switch (select) {
            case 1: {
                System.out.println("enter count of book on page");
                int count = scanner.nextInt();
                List<List> pages = new ArrayList<List>();
                for (int i = 0; i < books.size();) {
                    List<Book> cache = new ArrayList<Book>();

                    for (int j = 0; j <count; j++) {
                        if (i==books.size()){
                            break;
                        }
                        cache.add(j, books.get(i));
                        i++;
                    }
                    pages.add(cache);
                }
                boolean flag = true;
                while (flag) {
                    System.out.println("enter num of page first-0  last- " + pages.size() + "enter -1 for stop");
                    int enter = scanner.nextInt();
                    if (enter>pages.size()){
                        System.out.println("there are not many pages)");
                        continue;

                    }

                    for (int i = 0; i < pages.get(enter).size(); i++)
                        System.out.println(pages.get(enter).get(i).toString());

                }

                break;
            }
            case 2: {
                for (int i = 0; i < books.size(); i++) {
                    System.out.println(i + " : Title: " + books.get(i).getName() + " Page: " + books.get(i).getCountOfPage() + " Type: " + books.get(i).getType());

                }
                break;
            }
        }


    }
}
