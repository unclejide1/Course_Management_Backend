package com.jide.fullstack.services;

import com.jide.fullstack.dao.StudentDataAccessService;
import com.jide.fullstack.exceptions.ApiRequestException;
import com.jide.fullstack.model.Gender;
import com.jide.fullstack.model.Student;
import com.jide.fullstack.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService,EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    public void addNewStudent( Student student) {
        addNewStudent(null, student);
    }

    public void addNewStudent( UUID studentId, Student student) {
       UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

       if(!emailValidator.test(student.getEmail())){
           throw new ApiRequestException(student.getEmail() + " is not valid.");
       }
       //TODO: Verify that email is not taken
        if(studentDataAccessService.isEmailTaken(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " is taken.");
        }
        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
