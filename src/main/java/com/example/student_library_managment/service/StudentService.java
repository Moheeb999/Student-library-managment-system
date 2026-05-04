package com.example.student_library_managment.service;


import com.example.student_library_managment.model.Card;
import com.example.student_library_managment.model.Student;
import com.example.student_library_managment.repository.StudentRepository;
import com.example.student_library_managment.requestdto.Studentrequestdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String saveStudent(Studentrequestdto studentrequestdto){
        Student student = new Student();
        student.setAddress(studentrequestdto.getAddress());
        student.setDept(studentrequestdto.getDept());
        student.setDob(studentrequestdto.getDob());
        student.setEmail(studentrequestdto.getEmail());
        student.setGender(studentrequestdto.getGender());
        student.setMobile(studentrequestdto.getMobile());
        student.setName(studentrequestdto.getName());
        student.setSem(studentrequestdto.getSem());

        //Whenever you create a stud or stud added you needed to add card as cascades add by own but we needed
        //to create object
        Card card = new Card();
        card.setCardStatus("Active");
        card.setExpirydate(LocalDateTime.now().plusYears(3).toString());

        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);
        return"Student record is successfully saved";
    }
}
