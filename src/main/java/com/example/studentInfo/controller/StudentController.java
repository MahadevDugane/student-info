package com.example.studentInfo.controller;

import com.example.studentInfo.bean.StudentRank;
import com.example.studentInfo.bean.Students;
import com.example.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentInfo")
public class StudentController {
    @Autowired
    private StudentInfoService service;
    @PostMapping("/students")
    public void addStudent(@RequestBody Students student ){
         service.saveDetails(student);
    }
    @GetMapping("/students")
    public List<Students> getStudent(){
        return service.getStudents();
    }
    @GetMapping("/rank")
    public List<StudentRank> getStudentRank(){
        return service.getRankStandardwise();
    }


}
