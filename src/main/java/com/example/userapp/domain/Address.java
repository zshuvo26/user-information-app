package com.example.userapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Please enter state name")
    @Size(max = 40)
    @Column(name = "state", length = 40)
    private String state;

    @Size(max = 40)
    @Column(name = "city", length = 40)
    private String city;

    @Size(max = 10)
    @Column(name = "zip", length = 10)
    private String zip;

    @Size(max = 50)
    @Column(name = "street", length = 50)
    private String street;


    public Address(String defaultState, String defaultCity, String defaultZip, String defaultStreet) {
    }
}
