package com.example.studentInfo.controller;

import com.example.studentInfo.bean.StudentRank;
import com.example.studentInfo.bean.Students;
import com.example.studentInfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studentInfo")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentInfoService service;
    @PostMapping("/students")
    public void addStudent(@RequestBody Students student ){
         service.saveDetails(student);
    }
    //produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    @GetMapping(value="/students")
    public List<Students> getStudent(){
        List<Students> list;
        try {
            list=  service.getStudents();
        }catch(Exception ex){
            System.out.println("handled in catch");
            list = new ArrayList<>();
        }
        return list;
    }
    @GetMapping("/rank")
    public List<StudentRank> getStudentRank(){
        return service.getRankStandardwise();
    }


}
