package com.mum.edu.se.banking.bankmgmtapp.service.serviceimp;

import com.mum.edu.se.banking.bankmgmtapp.model.AccountType;
import com.mum.edu.se.banking.bankmgmtapp.repository.AccountRepository;
import com.mum.edu.se.banking.bankmgmtapp.repository.AccountTypeRepository;
import com.mum.edu.se.banking.bankmgmtapp.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AccountTypeImp implements AccountTypeService {
    AccountTypeRepository accountTypeRepository;
    @Autowired
    public AccountTypeImp(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }
    @Override
    public List<AccountType> getAllAccountType() {
        return accountTypeRepository.findAll();
    }
}
