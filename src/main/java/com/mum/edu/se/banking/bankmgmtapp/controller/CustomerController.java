package com.mum.edu.se.banking.bankmgmtapp.controller;

import com.mum.edu.se.banking.bankmgmtapp.model.Customer;
import com.mum.edu.se.banking.bankmgmtapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLOutput;

@Controller
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(value = {"/bank/customer"})
    public ModelAndView showCustomerList(@RequestParam (defaultValue = "0") int pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer",customerService.getAllCustomer(pageNo));
        modelAndView.addObject("currentPage", pageNo);
        modelAndView.setViewName("customer/list");
        return modelAndView;

    }
    @GetMapping(value = "/bank/register")
    public String registerCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }
    @PostMapping(value = "/bank/customer/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
                               BindingResult bindingResult, Model model){
        System.out.println(customer.getDateOfBirth());
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "customer/add";
        }

        customerService.saveCustomer(customer);
        return "redirect:/bank/customer";
        }
    }
