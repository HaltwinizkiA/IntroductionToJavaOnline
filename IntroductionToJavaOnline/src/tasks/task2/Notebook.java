package tasks.task2;

import tasks.task1.book.Book;

import java.io.*;
import java.util.List;

public class Notebook {
List<Note> noteList;
    BufferedWriter   outputWriter;
    File file = new File("C://Users//37533//EducationJava//IntroductionToJavaOnline//src//tasks//task2", "notebook.txt");
    public void readingNote() throws IOException {
        FileReader reader = null;

            reader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();

        while (line != null) {
            String[] readsbook = line.split(";");
            Note note = new Note
                    (readsbook[0], readsbook[1], readsbook[2]);
            noteList.add(note)
            line = bufferedReader.readLine();


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