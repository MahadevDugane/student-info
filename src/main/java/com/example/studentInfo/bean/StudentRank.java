package com.example.studentInfo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class StudentRank {
    @Id
    private int id;
    private String name;
    private String Standard;
    private int marks;


    public StudentRank(int id, String name, String standard, int marks) {

        this.name = name;
        Standard = standard;
        this.marks=marks;

    }

    public StudentRank() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String standard) {
        Standard = standard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
