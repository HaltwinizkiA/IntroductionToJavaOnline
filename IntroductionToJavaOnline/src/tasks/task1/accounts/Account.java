package tasks.task1.accounts;

import tasks.task1.book.Book;
import tasks.task1.book.Type;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    File fileA = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task1//service", "admin.txt");
    File fileU = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task1//service", "user.txt");

    Scanner scanner = new Scanner(System.in);

    public Account entry() {
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
                case 3 -> sendBookForAdmin();
                case 9 -> flag = false;
            }
        }

    }

    public Account authentication(String name, String password) {

        FileReader reader = null;
        try {
            reader = new FileReader(fileA);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] authent = line.split("/");
        int check = Integer.parseInt(authent[0]);
        if ((name.hashCode()) == check) {
            check = Integer.parseInt(authent[1]);
            if (password.hashCode() == check) {
                System.out.println("Hello " + authent[2] + " your permissions -admin");
                return new Admin();
            }
        }
        try {
            reader = new FileReader(fileU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(reader);
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        authent = line.split("/");
        check = Integer.parseInt(authent[0]);
        if ((name.hashCode()) == check) {
            check = Integer.parseInt(authent[1]);
            int a=password.hashCode();
            if (password.hashCode() == check) {
                System.out.println("Hello " + authent[2] + "your permissions -user " + " name:");
                return new User();
            }
        } else {
            System.out.println("ERROR :no such user exists");
            return null;
        }


        return null;
    }

    public void sendingNotifications(Book book) {
        System.out.println("Book : " + book.toString() + "  sent to :");
        for (String mail : getUserMails()) {
            System.out.println(mail);
        }


    }

    public void sendBookForAdmin() {
        Book book = null;
        System.out.println("enter name");
        String name = scanner.next();
        System.out.println("enter number of pages");
        int num = scanner.nextInt();
        System.out.println("Choose  type 1-Paper or 2 - Electronic ");
        switch (scanner.nextInt()) {
            case 1 -> book = new Book(name, num, Type.Paper);
            case 2 -> book = new Book(name, num, Type.Electronic);
        }
        System.out.println("\n");
        List<String> mails = null;
        mails = getAdminMails();
        for (int i = 0; i < mails.size(); i++) {
            System.out.println(i + " " + mails.get(i));

        }
        boolean flag = true;
        while (flag){
            System.out.println("select admin mail");
        int select = scanner.nextInt();
        if (select>=mails.size()) {
            System.out.println("wrong num");
            continue;

        }
        System.out.println(book.toString() + " sent to : " + mails.get(select));
    }
    }

    public List<String> getAdminMails() {
        List<String> mail = new ArrayList<>();
        FileReader reader = null;
        try {
            reader = new FileReader(fileA);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            String[] user = line.split("/");
            mail.add(user[3]);
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return mail;
    }

    public List<String> getUserMails() {
        List<String> mail = new ArrayList<>();
        FileReader reader = null;
        try {
            reader = new FileReader(fileU);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            String[] user = line.split("/");
            mail.add(user[3]);
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return mail;
    }

    public void search(List<Book> books) {
        System.out.println("book search\n" +
                "Enter the title");
        String title = scanner.next();
        boolean flag=true;
        Pattern pattern = Pattern.compile(title);
        for (int i = 0; i < books.size(); i++) {
            Book cache = books.get(i);
            Matcher matcher = pattern.matcher(cache.getName());
            if (matcher.find()) {
                System.out.println("found");
                System.out.println(i + " : Title: " + books.get(i).getName() + " Page: " + books.get(i).getCountOfPage() + " Type: " + books.get(i).getType());
                flag=false;

            }
        }
        if (flag){
            System.out.println("no such book found");
        };

    }


    public void view(List<Book> books) {

        System.out.println("select view type: \n1-page\n2-list");
        int select = scanner.nextInt();
        switch (select) {
            case 1: {
                System.out.println("enter count of book on page");
                int count = scanner.nextInt();
                List<List> pages = new ArrayList<List>();
                for (int i = 0; i < books.size(); ) {
                    List<Book> cache = new ArrayList<Book>();

                    for (int j = 0; j < count; j++) {
                        if (i == books.size()) {
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
                    if (enter > pages.size()) {
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
