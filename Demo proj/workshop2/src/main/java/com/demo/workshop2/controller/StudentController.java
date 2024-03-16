package com.demo.workshop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.workshop2.service.StudentService;
import com.demo.workshop2.entity.Student;

@RestController
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
    public List<Student> queryForStudents() {
        return studentService.findAll();
    }
	
	@GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        return studentService.findById(studentId);
    }
	
	@PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        // this is to force a save of new item ... instead of update

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for PUT /students - update existing student

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for DELETE /students/{studentId} - delete student

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student tempStudent = studentService.findById(studentId);

        // throw exception if null

        if (tempStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.delete(studentId);

        return "Deleted student id - " + studentId;
    }
	
	
}
