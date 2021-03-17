package tasks.task2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notebook {
    private final List<Note> noteList;
    private final Scanner scanner;
    private final File file;

    public Notebook() {
        noteList = new ArrayList<Note>();
        scanner = new Scanner(System.in);
        file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task2", "notebook.txt");
        char smile = 0x263A;
        System.out.println("Hello user this is NOTEBOOKGOLDEDDISHION " + smile);


    }

    public void menu() throws IOException {
        List<Note> noteBuffer = new ArrayList<Note>();
        readingNote();
        int select;
        boolean flag = true;
        while (flag) {
            while (true) {
                System.out.println("Select an action\n1-view all note\n2-search \n3-add Note\n4-for stop");
                while (true) {
                    try {
                        select = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("ERROR enter num 1-4\n");
                        scanner.nextLine();
                    }
                }
                if (select <= 4 & select >= 1) {
                    break;
                }
            }

            switch (select) {
                case 1 -> noteView(noteList);
                case 2 -> search();
                case 3 -> addNote();
                case 4 -> flag = false;

            }
        }
        try {
            writingToFile(noteList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readingNote() throws IOException {
        FileReader reader = null;
        reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            if (line.equals(" ")) {
                break;
            }
            String[] noteLine = line.split("/");
            Note note = new Note(Long.parseLong(noteLine[0]), noteLine[1], noteLine[2], noteLine[3]);
            noteList.add(note);
            line = bufferedReader.readLine();

        }


    }

    void writingToFile(List<Note> list) throws IOException {

        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(file));
        for (Note note : list) {
            outputWriter.write(note.toString() + "\n");

        }
        outputWriter.flush();
        outputWriter.close();

    }

    void addNote() {
        Matcher matcher;
        System.out.println("Enter theme");
        String theme = scanner.nextLine();
        theme = theme + scanner.nextLine();

        if (theme.equals(" ")) {
            theme = "empty";
        }
        System.out.println("Enter you email ");
        String email;
        while (true) {
            email = scanner.next();
            Pattern pattern = Pattern.compile("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");//valid mail
            matcher = pattern.matcher(email);
            if (matcher.find()) {
                break;
            } else {
                scanner.nextLine();
                System.out.println("ERROR--Wrong email!");
            }
        }
        System.out.println("Enter message:");
        String message = scanner.nextLine();
        message = scanner.nextLine();
        if (message.equals(" ")) {
            message = "empty";
        }

        Date date = new Date();
        long a = date.getTime();
        Note note = new Note(a, email, theme, message);
        noteList.add(note);
        try {
            writingToFile(noteList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void noteView(List<Note> list) {
        sortOnDate(list);
        for (int i = 0; i < list.size(); i++) {

            System.out.println("Note " + i + list.get(i).toString(1));
        }
    }

    void search() {
        int select;
        while (true) {
            System.out.println("Select search criteria\n1-mail\n2-theme\n3-date\n4-word in message\n5-theme and word in message");

            try {
                select = scanner.nextInt();
                if (select <= 5 & select > 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("ERROR pls enter num 1-5\n");
                scanner.nextLine();
                continue;
            }


            System.out.println("ERROR Wrong select");
        }
        switch (select) {
            case 1 -> searchMail();
            case 2 -> searchTheme();
            case 3 -> searchDate();
            case 4 -> searchWordInMessage();
            case 5 -> searchWordAndTheme();


        }
    }

    void searchMail() {
        List<Note> noteBuffer = new ArrayList<Note>();
        System.out.println("Enter mail to search");
        String mail;
        while (true) {
            mail = scanner.next();
            Pattern pattern = Pattern.compile("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");//valid mail
            Matcher matcher = pattern.matcher(mail);
            if (matcher.find()) {
                break;
            } else {
                scanner.nextLine();
                System.out.println("ERROR--Wrong email!");
            }
        }

        Pattern pattern = Pattern.compile(mail);

        for (Note note : noteList) {
            Matcher matcher = pattern.matcher(note.getEmail());
            if (matcher.find()) {
                noteBuffer.add(note);

            }
        }

        if (noteBuffer.size() == 0) {
            System.out.println(" Not found ");
        } else {
            System.out.println(" Searched Note: ");
            noteView(noteBuffer);
        }

    }

    void searchTheme() {
        List<Note> noteBuffer = new ArrayList<Note>();
        System.out.println("Enter Theme to search");
        String theme = scanner.next();
        Pattern pattern = Pattern.compile(theme);
        for (Note note : noteList) {
            Matcher matcher = pattern.matcher(note.getTheme());
            if (matcher.find()) {
                noteBuffer.add(note);

            }
        }

        if (noteBuffer.size() == 0) {
            System.out.println(" Not found ");
        } else {
            System.out.println("Searched Note: ");
            noteView(noteBuffer);
        }
    }

    void searchWordInMessage() {
        List<Note> noteBuffer = new ArrayList<Note>();
        System.out.println("Enter word in message to search");
        String word = scanner.next();
        Pattern pattern = Pattern.compile(word);
        for (Note note : noteList) {
            Matcher matcher = pattern.matcher(note.getMessage());
            if (matcher.find()) {
                noteBuffer.add(note);

            }
        }

        if (noteBuffer.size() == 0) {
            System.out.println(" Not found ");
        } else {
            System.out.println("Searched Note: ");
            noteView(noteBuffer);
        }
    }

    void searchDate() {
        Matcher matcher;
        List<Note> noteBuffer = new ArrayList<Note>();
        String date = " ";
        Pattern validDate = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        System.out.println("Enter date to search in format year-month-day");

        while (true) {
            date = scanner.next();
            matcher = validDate.matcher(date);
            if (matcher.find()) {
                break;
            }
            System.out.println("wrong date pls enter correct format year-month-day\n(Example 2020-03-17)");
        }
        Pattern pattern = Pattern.compile(date);
        for (Note note : noteList) {
            note.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String buffer = simpleDateFormat.format(note.getDate());
            if (date.equals(buffer)) {
                noteBuffer.add(note);

            }
        }

        if (noteBuffer.size() == 0) {
            System.out.println(" Not found ");
        } else {
            System.out.println("Searched Note: ");
            sortOnDate(noteBuffer);
            noteView(noteBuffer);
        }


    }

    void searchWordAndTheme() {
        List<Note> noteBuffer = new ArrayList<Note>();
        System.out.println("Enter Theme to search");
        String theme = scanner.next();
        System.out.println("Enter word in message to search");
        String word = scanner.next();
        for (Note note : noteList) {
            Pattern pattern = Pattern.compile(theme);
            Matcher matcher = pattern.matcher(note.getTheme());
            if (matcher.find()) {
                pattern = Pattern.compile(word);
                matcher = pattern.matcher(note.getMessage());
                if (matcher.find()) {
                    noteBuffer.add(note);

                }
            }
        }
        noteView(noteBuffer);


    }

    void sortOnDate(List<Note> list) {
        Collections.sort(list, new SortDate());
    }

    class SortDate implements Comparator<Note> {
        @Override
        public int compare(Note o1, Note o2) {
            if (o1.getDate() > o2.getDate()) {
                return 1;
            }
            if (o1.getDate() < o2.getDate()) {
                return -1;
            } else {
                return 0;
            }

        }
    }
}


//Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
//в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
//Общие пояснения к практическому заданию.
//• В начале работы приложения данные должны считываться из файла, в конце
//работы – сохраняться в файл.
//• У пользователя должна быть возможность найти запись по любому параметру
//или по группе параметров (группу параметров можно определить
//самостоятельно), получить требуемые записи в отсортированном виде, найти
//записи, текстовое поле которой содержит определенное слово, а также
//добавить новую запись.
//• Особое условие: поиск, сравнение и валидацию вводимой информации
//осуществлять с использованием регулярных выражений.
//• Особое условие: проверку введенной информации на валидность должен
//осуществлять код, непосредственно добавляющий информацию.