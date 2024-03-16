package com.demo.workshop2.service;
import com.demo.workshop2.entity.Student;
import java.util.List;

public interface StudentService {
	
	List<Student> findAll();

	Student findById(int studentId);
	
	Student save(Student theStudent);

    void delete(int theId);
}
