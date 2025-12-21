package com.example.studentInfo.bean;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    int id;
    String name;
    String ifsc;
    String branch;
    @ManyToOne
    @JoinColumn(name="cust_id")
    Customer custId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }
}
