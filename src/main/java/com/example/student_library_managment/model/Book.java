package com.example.student_library_managment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Books")
@Data
public class Book {


    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="publishername",nullable = false)
    private String publishername;

    @Column(name="publishedDate",nullable = false)
    private String publishedDate;

    @Column(name="pages",nullable = false)
    private int pages;

    @Column(name="availability",nullable = false)
    private boolean availability;

    @Column(name="category",nullable = false)
    private String category;

    @Column(name="rackNo",nullable = false)
    private String rackNo;

    @JoinColumn
    @ManyToOne
    private Card card;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;
}
