package com.example.student1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student1.Entity.Student;




@Repository
public interface SudentRepository extends JpaRepository<Student,Long>{

}
