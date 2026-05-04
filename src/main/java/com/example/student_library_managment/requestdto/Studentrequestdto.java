package com.example.student_library_managment.requestdto;


import jakarta.persistence.Column;
import lombok.Data;

@Data

public class Studentrequestdto {

    private String name;

    private String email;

    private String mobile;

    private String dept;

    private String sem;

    private String gender;

    private String address;

    private String dob;
}
