package service;
import model.Book;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static Map<Integer, Book> bookMap = new HashMap<>();
    private SecureRandom secureRandom = new SecureRandom();

    static {
        Book bible = new Book();
        bible.setId(1);
        bible.setAuthor("God");
        bible.setTitle("New Testament");
        bible.setPrice(100);

        Book motivational = new Book();
        motivational.setId(2);
        motivational.setAuthor("chinkee");
        motivational.setTitle("Diary ng Pulubi");
        motivational.setPrice(200);
    }

    public List<Book> retrieveAllBooks() {
        return bookMap.values().stream().collect(Collectors.toList());
    }


    public Book retrieveBookById(int id){
        return bookMap.get(id);
    }

    public Book addNewBook(Book newBook) {
        Book book = new Book();
        book.setId(Math.abs(secureRandom.nextInt()));
        book.setAuthor(newBook.getAuthor());
        book.setPrice(newBook.getPrice());
        book.setTitle(newBook.getTitle());
        bookMap.put(book.getId(), book);
        return book;
    }

    public Book updateBookPrice(Book updateBook) {
        Book book = null;
        if (bookMap.containsKey(updateBook.getId())) {
            book = bookMap.get(updateBook.getId());
            book.setPrice(updateBook.getPrice());
        }
        return book;
    }

    public void deleteBookById(int id) {
        if (bookMap.containsKey(id)) {
            bookMap.remove(id);
        }
    }
}