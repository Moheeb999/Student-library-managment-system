package com.example.student_library_managment.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="Transactions")
@Data
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="transactionDate",nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name="dueDate",nullable = false)
    private String dueDate;

    @Column(name="transactionType",nullable = false)
    private String transactionType;

    @JoinColumn
    @ManyToOne
    private Card card;

    @JoinColumn
    @ManyToOne
    private Book book;
}
