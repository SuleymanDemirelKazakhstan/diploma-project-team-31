package com.project.bookberry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "checkout_id", referencedColumnName = "id")
    private Checkouts checkout;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books book;

    @Column(name = "amount")
    private int amount;
}
