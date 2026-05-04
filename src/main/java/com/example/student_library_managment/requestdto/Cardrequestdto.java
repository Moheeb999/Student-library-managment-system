package com.example.student_library_managment.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Cardrequestdto {

    private String cardStatus;
    private String expirydate;
}
