package com.example.student_library_managment.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Cards")
@Data
public class Card {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="status",nullable = false)
    private String cardStatus;

    @Column(name="expirydate",nullable = false)
    private String expirydate;

    @Column(name="createddate",nullable = false)
    @CreationTimestamp
    private Date createddate;

    @Column(name="updateddate",nullable = false)
    @UpdateTimestamp
    private Date updateddate;

    @JsonBackReference
    @JoinColumn // it joins the primary key student id from student table as a foreign key in card table
    @OneToOne // one card will be assigned to one student
    private Student student;

    @OneToMany(mappedBy = "card")
    private List<Book> bookList;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;
}
