package com.example.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.awt.print.Book;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    private int reviewId;
    private int reviewRating;
    private String description;


}
