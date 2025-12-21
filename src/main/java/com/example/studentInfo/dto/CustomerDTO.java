package com.example.studentInfo.dto;

import java.util.List;

public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private List<String> accounts; // or List<AccountDTO>

    public CustomerDTO(Long customerId, String customerName, List<String> accounts) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.accounts = accounts;
    }

    // getters and setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
}
