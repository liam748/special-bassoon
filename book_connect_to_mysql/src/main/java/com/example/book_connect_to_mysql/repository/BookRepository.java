package com.example.book_connect_to_mysql.repository;

import com.example.book_connect_to_mysql.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
