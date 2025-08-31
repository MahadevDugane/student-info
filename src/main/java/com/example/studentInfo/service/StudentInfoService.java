package com.example.studentInfo.service;

import com.example.studentInfo.bean.StudentRank;
import com.example.studentInfo.bean.Students;
import com.example.studentInfo.bean.Students;
import com.example.studentInfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    @Autowired
    private StudentRepository repo;

    public StudentInfoService(StudentRepository repo) {
        this.repo = repo;
    }
    public StudentInfoService() {
    }

    public void saveDetails(Students student) {

       repo.saveAndFlush(student);
    }
    public List<Students> getStudents() {
        return repo.findAll();
    }
    public List<StudentRank> getRankStandardwise(){
        return repo.getStudentRank();
    }
}
