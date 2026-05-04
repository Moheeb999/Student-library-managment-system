package com.example.student_library_managment.requestdto;

import lombok.Data;

@Data
public class Bookrequestdto {

    //These are used for input request for API requestdto(Data transfer Object)

    private String title;
    private String publishername;
    private String publishedDate;
    private int pages;
    private boolean availability;
    private String category;
    private String rackNo;
}
