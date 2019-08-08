package com.mum.edu.se.banking.bankmgmtapp.service;

import com.mum.edu.se.banking.bankmgmtapp.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface CustomerService {
    Page<Customer> getAllCustomer(int pageNo);
    void saveCustomer(Customer customer);
    List<Customer> getAllCustomer();

}
