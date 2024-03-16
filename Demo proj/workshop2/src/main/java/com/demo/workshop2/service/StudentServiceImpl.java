package com.demo.workshop2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.workshop2.dao.StudentDAO;
import com.demo.workshop2.entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        studentDAO = theStudentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
    
    @Override
    public Student findById(int studentId) {
        return studentDAO.findById(studentId);
    }
    
    @Transactional
    @Override
    public Student save(Student theStudent) {
        return studentDAO.save(theStudent);
    }

    @Transactional
    @Override
    public void delete(int theId) {
        studentDAO.delete(theId);
    }

}
