package com.example.book_connect_to_mysql.exception;

public class MethodArgumentNotValidExceptions extends RuntimeException{
    public MethodArgumentNotValidExceptions (String message){
        super(message);
    }
}
