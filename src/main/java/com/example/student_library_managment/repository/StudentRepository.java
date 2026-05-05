package com.example.student_library_managment.repository;


import com.example.student_library_managment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //writing custom defined user query
    @Query(nativeQuery = true,value="select * from Students where email = :inputEmail")
    public Student getStudentByEmail(String inputEmail);

}
