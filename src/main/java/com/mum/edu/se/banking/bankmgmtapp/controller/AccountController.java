package com.mum.edu.se.banking.bankmgmtapp.controller;

import com.mum.edu.se.banking.bankmgmtapp.model.Account;
import com.mum.edu.se.banking.bankmgmtapp.service.AccountService;
import com.mum.edu.se.banking.bankmgmtapp.service.AccountTypeService;
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

@Controller
public class AccountController {

    AccountService accountService;
    CustomerService customerService;
    AccountTypeService accountTypeService;
    @Autowired
    public AccountController(AccountService accountService,
                             CustomerService customerService, AccountTypeService accountTypeService){
        this.customerService = customerService;
        this.accountService = accountService;
        this.accountTypeService  =accountTypeService;
    }
    @GetMapping(value = "/bank/account")
    public ModelAndView showAllAccounts(@RequestParam(defaultValue="0") int pageNo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", accountService.displayAllAccounts(pageNo));
        modelAndView.addObject("netAmount", accountService.getNetLuquidity());
        modelAndView.addObject("pageNo",pageNo);
        modelAndView.setViewName("account/list");
        return modelAndView;
    }

    @GetMapping(value = {"/bank/add"})
        public String displayAddForm(Model model){
            model.addAttribute("account", new Account());
            model.addAttribute("customerList",customerService.getAllCustomer());
            model.addAttribute("accountTypeList", accountTypeService.getAllAccountType());
            return "account/add";
        }

    @PostMapping (value = {"/bank/account/save"})
    public String saveAccount(@Valid @ModelAttribute("account") Account account,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "account/add";
        }
        accountService.SaveAccount(account);
        return "redirect:/bank/account";
    }
}
