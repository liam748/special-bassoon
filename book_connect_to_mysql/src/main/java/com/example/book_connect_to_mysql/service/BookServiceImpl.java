package com.example.book_connect_to_mysql.service;

import com.example.book_connect_to_mysql.model.Book;
import com.example.book_connect_to_mysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public List<Book> retrieveListOfBooks()
    {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book retrieveListById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    @Transactional
    public String addBooks(List<Book> books){
        bookRepository.saveAll(books);
        String message = "SAVING FAILED !";
        if (retrieveListOfBooks() != null){
            message = "SUCCESSFULLY SAVED IN DATA BASE !";
        }
        return message;

    }

    @Override
    @Transactional

    public String updateBook (Book updateBook){
        Book book  = retrieveListById(updateBook.getId());
        String message = "UPDATE FAILED";
        if (book != null){
            book.setAuthor(updateBook.getAuthor());
            book.setPrice(updateBook.getPrice());
            book.setTitle(updateBook.getTitle());
            book.setId(1);
            bookRepository.save(book);
            message = "UPDATED RECORD !";
        }
        return message;
    }

    @Override
    @Transactional
    public String deleteBook(int id) {
        String message = "DOES NOT EXIST";
        if (retrieveListById(id) != null){
            bookRepository.deleteById(id);
            message = "DELETE SUCCESSFULLY !";

        }
        return message;
    }
}
