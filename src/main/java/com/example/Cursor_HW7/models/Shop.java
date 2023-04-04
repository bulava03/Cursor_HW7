package com.example.Cursor_HW7.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    private Long id;
    private String city;
    private String street;
    private String name;
    private int employees;
    private boolean hasWebsite;

    public Shop (String city, String street, String name, int employees, boolean hasWebsite) {
        this.city = city;
        this.street = street;
        this.name = name;
        this.employees = employees;
        this.hasWebsite = hasWebsite;
    }
}
