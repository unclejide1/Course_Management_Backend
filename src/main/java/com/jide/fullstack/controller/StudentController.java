package com.jide.fullstack.controller;

import com.jide.fullstack.exceptions.ApiRequestException;
import com.jide.fullstack.model.Gender;
import com.jide.fullstack.model.Student;
import com.jide.fullstack.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
                return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent( @RequestBody @Valid Student student){
        studentService.addNewStudent(student);
    }

}
