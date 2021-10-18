package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.retrieveAllBooks();
    }

    @RequestMapping(value  = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id){
        return bookService.retrieveBookById(id);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Book> addNewBook(@RequestBody Book newBook){
        bookService.addNewBook(newBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBookById(@RequestBody Book updateBook){
        bookService.updateBookPrice(updateBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBookById(@PathVariable int id) {
        if (bookService.retrieveBookById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            bookService.deleteBookById(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);  }

}
