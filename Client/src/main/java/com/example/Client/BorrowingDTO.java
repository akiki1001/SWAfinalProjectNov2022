package com.example.Client;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Date;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class BorrowingDTO {
    private int borrowingNumber;
   // private LocalDate date;
    private Customer customer;
    private Book book;
}
