package com.mum.edu.se.banking.bankmgmtapp.service.serviceimp;

import com.mum.edu.se.banking.bankmgmtapp.model.Customer;
import com.mum.edu.se.banking.bankmgmtapp.repository.CustomerRepository;
import com.mum.edu.se.banking.bankmgmtapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerServiceImp implements CustomerService {

    CustomerRepository customerRepository;
    @Autowired
    CustomerServiceImp(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Page<Customer> getAllCustomer(int pageNo) {
        return customerRepository.findAll(PageRequest.of(pageNo,5, Sort.by("lastName","firstName")));
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
