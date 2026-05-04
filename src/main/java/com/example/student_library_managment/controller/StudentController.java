package com.example.student_library_managment.controller;


import com.example.student_library_managment.requestdto.Studentrequestdto;
import com.example.student_library_managment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/savestudent")
    public String saveStudent(@RequestBody Studentrequestdto studentrequestdto){
        return studentService.saveStudent(studentrequestdto);
    }
    @PostMapping("/test")
    public String test(){
        return "testing";
    }
}
