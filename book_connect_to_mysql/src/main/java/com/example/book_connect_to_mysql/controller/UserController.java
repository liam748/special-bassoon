package com.example.book_connect_to_mysql.controller;

import com.example.book_connect_to_mysql.exception.MethodArgumentNotValidExceptions;
import com.example.book_connect_to_mysql.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("USER VALID ");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidExceptions (final MethodArgumentNotValidExceptions argumentNotValidExceptions){
        Map<String, String> error = new HashMap<>();
        argumentNotValidExceptions.getBindingResult().getErrors().forEach (objectError -> {
            String field = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();

            error.put(failed, errorMessage)

        });

        return error;
    }
}
