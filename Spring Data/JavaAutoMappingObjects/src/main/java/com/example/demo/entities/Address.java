package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @NonNull
    private String country;
    @NonNull
//    @ManyToOne
    private String city;
    @NonNull
    private String details;
}



