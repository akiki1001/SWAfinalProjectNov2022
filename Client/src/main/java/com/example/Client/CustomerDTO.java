package com.example.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class CustomerDTO {
    private int customerNumber;
    private String name;
    private Contact contact;
    private Address address;
}
