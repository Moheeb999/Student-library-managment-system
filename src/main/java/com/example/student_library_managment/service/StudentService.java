package com.example.student_library_managment.service;


import com.example.student_library_managment.model.Card;
import com.example.student_library_managment.model.Student;
import com.example.student_library_managment.repository.StudentRepository;
import com.example.student_library_managment.requestdto.Studentrequestdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Student findById(int id){
        Optional<Student> studentOptional=studentRepository.findById(id);
        return studentOptional.orElse(null);
    }

    public List<Student> findall(){
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }

    public String updatebyId(int std_id,Studentrequestdto newstudentrequestdto){
        Student existing = findById(std_id);
        if(existing!=null){
            existing.setAddress(newstudentrequestdto.getAddress());
            existing.setDept(newstudentrequestdto.getDept());
            existing.setDob(newstudentrequestdto.getDob());
            existing.setEmail(newstudentrequestdto.getEmail());
            existing.setGender(newstudentrequestdto.getGender());
            existing.setMobile(newstudentrequestdto.getMobile());
            existing.setName(newstudentrequestdto.getName());
            existing.setSem(newstudentrequestdto.getSem());

            studentRepository.save(existing);
            return "The Record "+std_id+" has been updated successfully";
        }
        else{
            return "The Student does not exist";
        }
    }

    public String deleteById(int id){
        Student std = findById(id);
        if(std==null){
            return "The record "+id+"doesn't exist ";
        }
        else{
            studentRepository.deleteById(id);
            return "the record "+id+" has been successfully deleted";
        }
    }


    //PageNo and PageSize
    public List<Student> findPage(int pageNo, int pageSize){
        return studentRepository.findAll(PageRequest.of(pageNo,pageSize)).getContent();
    }

    //Paging + sorting
    public List<Student> findPageSort(int pageNo, int pageSize){
        return studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name").ascending())).getContent();
    }

}
