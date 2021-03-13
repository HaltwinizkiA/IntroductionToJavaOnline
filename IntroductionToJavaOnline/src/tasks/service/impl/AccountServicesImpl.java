package tasks.service.impl;

import tasks.accounts.Admin;
import tasks.accounts.User;
import tasks.book.Book;
import tasks.service.AccountServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountServicesImpl implements AccountServices {

    Scanner scanner = new Scanner(System.in);

    public AccountServicesImpl entry() throws IOException {
        System.out.println("enter login");
        String log = scanner.next();
        System.out.println("enter password");
        String pass = scanner.next();

        return authentication(log,pass);
    }

    public AccountServicesImpl authentication(String name, String password) throws IOException {
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
        line=bufferedReader.readLine();
        authent=line.split("/");
        check=Integer.parseInt(authent[0]);
        if ((name.hashCode()) == check) {
            check = Integer.parseInt(authent[1]);
            if (password.hashCode() == check) {
                System.out.println("your permissions -user");
                return new User();
            }
        }
        else {
            System.out.println("ERROR :no such user exists");
            return null;
        }


            return null;
    }

    @Override
    public void search(ArrayList<Book> books) {
        System.out.println("book search\n" +
                "Enter the title");
        String title = scanner.next();
        Pattern pattern = Pattern.compile(title);
        for (int i = 0; i < books.size(); i++) {
            Book cache = books.get(i);
            Matcher matcher = pattern.matcher(cache.getName());
            if (matcher.find()) {
                System.out.println(books.get(i).toString());
            } else {
                System.out.println("not found");
            }
        }

    }

    @Override
    public void view(ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + " : Title: " + books.get(i).getName() + " Page: " + books.get(i).getCountOfPage() + " Type: " + books.get(i).getType());

        }

    }
}
