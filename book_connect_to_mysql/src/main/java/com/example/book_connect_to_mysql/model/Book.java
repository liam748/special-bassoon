package com.example.book_connect_to_mysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name  = "BOOKS")
public class Book {
    @Id
    @Column (name = "BOOK_ID" )
    private int id;

    @NotNull
    @Column(name = "BOOK_TITLE")
    private String title;

    @NotNull
    @Column(name = "AUTHOR")
    private String author;


    @Min(55)
    @Max(87)
    @Column(name = "BOOK PRICE")
    private int price;


}
