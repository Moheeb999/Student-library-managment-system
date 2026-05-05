package com.example.student_library_managment.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="Students")
@Data
public class Student {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This used for automatic filling of the id field
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="mobile",nullable = false,unique = true)
    private String mobile;

    @Column(name="dept",nullable = false)
    private String dept;

    @Column(name="sem",nullable = false)
    private String sem;

    @Column(name="gender",nullable = false)
    private String gender;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="dob",nullable = false)
    private String dob;

    @JsonManagedReference
    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL) // one card will be assigned to one student
    private Card card;
}
