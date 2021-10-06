package com.example.userapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "child_user")
@NoArgsConstructor
@AllArgsConstructor
public class ChildUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("")
    private ParentUser parentUser;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


}
