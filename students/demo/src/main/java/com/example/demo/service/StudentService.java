package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) throws IOException {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() throws IOException {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) throws IOException {
        return studentRepository.findById(id);
    }
    public Optional<Student> getStudentByName(String name) throws IOException {
        System.out.println(name);
        return studentRepository.findByName(name);
    }
    public List<Student> findBySort(String sortBy) throws IOException {
        return studentRepository.findBySort(sortBy);
    }
}

