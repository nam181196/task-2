package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students") // bắt đầu cho request (ví dụ: localhost:8080/students)
public class StudentController {

    @Autowired
    private StudentService studentService;
// POST không có tham số, body là JSON thông tin sinh viên
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        try {
            return studentService.saveStudent(student);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//GET all không có tham số
    @GetMapping
    public List<Student> getAllStudents() {
        try {
            return studentService.getAllStudents();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//GET a student thì có tham số(chính là id) ví dụ localhost:8080/students/1
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        try {
            Optional<Student> student = studentService.getStudentById(id);
            return student.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/findByName")
    public Student getStudentByName(@RequestParam String name) {
        try {
            Optional<Student> student = studentService.getStudentByName(name);
            return student.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @GetMapping("/sort")
    public List<Student> findStudentSorted(@RequestParam String sortBy) throws IOException {
        return studentService.findBySort(sortBy);
    }
}
