package com.project.bookberry.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checkouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checkout")
    @JsonIgnore
    private List<Orders> orders;

}
