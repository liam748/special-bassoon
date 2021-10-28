package com.example.book_connect_to_mysql.controller;


import com.example.book_connect_to_mysql.exception.MethodArgumentNotValidExceptions;
import com.example.book_connect_to_mysql.model.Book;
import com.example.book_connect_to_mysql.model.User;
import com.example.book_connect_to_mysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
// http://localhost:8082/books/books/all
    @GetMapping("/books/all")
    public List<Book> getAllBooks()
    {
        return bookService.retrieveListOfBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBooksById(@PathVariable int id)
    {
        return bookService.retrieveListById(id);
    }

    @PostMapping("/books")
    public String addBooks(@RequestBody List<Book> book)
    {
        return bookService.addBooks(book);
    }

    @PutMapping ("/books")
    public String updateBook(@RequestBody Book book)
    {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id) 
    {
        return bookService.deleteBook(id);
    }

    @PostMapping("/books")
    public ResponseEntity<String> addUser(@Valid @RequestBody Book book) {
        return ResponseEntity.ok("BOOKS VALID ");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidExceptions (final MethodArgumentNotValidExceptions argumentNotValidExceptions){
        Map<String, String> errors = new HashMap<>();
        argumentNotValidExceptions.getBindingResult().getAllErrors().forEach (objectError -> {
            String field = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();

            errors.put(field, errorMessage);

        });

        return errors;

    
}
