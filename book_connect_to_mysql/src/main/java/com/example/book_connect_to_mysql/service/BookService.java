package com.example.book_connect_to_mysql.service;

import com.example.book_connect_to_mysql.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> retrieveListOfBooks();
    public Book retrieveListById(int id);
    public String addBooks(List<Book> books);
    public String updateBook(Book book);
    public String deleteBook(int id);
}
