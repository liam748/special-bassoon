package com.example.book_connect_to_mysql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Min(18)
    @Max(99)
    private int age;
    @Email
    private String email;
    @NotNull
    private String address;
}
