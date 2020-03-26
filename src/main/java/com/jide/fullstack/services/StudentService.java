package com.jide.fullstack.services;

import com.jide.fullstack.dao.StudentDataAccessService;
import com.jide.fullstack.model.Gender;
import com.jide.fullstack.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    public void addNewStudent( Student student) {
        addNewStudent(null, student);
    }

    public void addNewStudent( UUID studentId, Student student) {
       UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());
       //TODO: Verify that email is not taken
        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
