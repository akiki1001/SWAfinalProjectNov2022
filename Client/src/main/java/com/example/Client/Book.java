package com.example.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    private String isbn;
    private String title;
    private String description;
    private String author;
}
