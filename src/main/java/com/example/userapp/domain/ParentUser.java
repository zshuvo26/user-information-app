package com.example.userapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "parent_user")
@NoArgsConstructor
@AllArgsConstructor
public class ParentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
