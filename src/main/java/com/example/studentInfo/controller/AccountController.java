package com.example.studentInfo.controller;

import com.example.studentInfo.bean.Customer;
import com.example.studentInfo.dto.CustomerDTO;
import com.example.studentInfo.repository.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accountData")
public class AccountController {
    @Autowired
    private CustomerAccountRepository customerRepository;

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id){
        Customer customer= customerRepository.findCustomerWithAccounts(1001l).get();
        return new CustomerDTO(Long.valueOf(customer.getId()), customer.getName(), customer.getAccounts().stream().map(e->e.getName()).toList());
    }
}
