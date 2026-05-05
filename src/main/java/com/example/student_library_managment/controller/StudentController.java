package com.example.student_library_managment.controller;


import com.example.student_library_managment.model.Student;
import com.example.student_library_managment.requestdto.Studentrequestdto;
import com.example.student_library_managment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/savestudent")
    public String saveStudent(@RequestBody Studentrequestdto studentrequestdto){
        return studentService.saveStudent(studentrequestdto);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable int id){
        return studentService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findall();
    }

    @PutMapping("/updateById/{id}")
    public String updateById(@PathVariable int id,@RequestBody Studentrequestdto newstudentrequestdto){
        return studentService.updatebyId(id,newstudentrequestdto);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id){
        return studentService.deleteById(id);
    }

    //Paging
    @GetMapping("/findPage")
    public List<Student> findPage(@RequestParam int pageNo,@RequestParam int pageSize){
        return studentService.findPage(pageNo,pageSize);
    }

    //Paging + sorting
    @GetMapping("/findPageSort")
    public List<Student> findPageSort(@RequestParam int pageNo,@RequestParam int pageSize){
        return studentService.findPage(pageNo,pageSize);
    }


}
