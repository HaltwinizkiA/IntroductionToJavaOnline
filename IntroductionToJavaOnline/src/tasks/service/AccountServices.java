package tasks.service;

import tasks.book.Book;

import java.util.ArrayList;

public interface AccountServices {
    public void search(ArrayList<Book> books);
    public void view(ArrayList<Book> books);
}
