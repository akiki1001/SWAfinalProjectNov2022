package com.example.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.awt.print.Book;
import java.util.Date;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Borrowing {

    private int borrowingNumber;
    private Date date;

}
