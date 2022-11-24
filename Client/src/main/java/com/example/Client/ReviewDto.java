package com.example.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDto {
    private int reviewId;
    private int reviewRating;
    private String description;
    private Customer customers;
    private Book books;


}
