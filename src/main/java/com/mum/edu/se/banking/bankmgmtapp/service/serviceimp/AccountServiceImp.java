package com.mum.edu.se.banking.bankmgmtapp.service.serviceimp;

import com.mum.edu.se.banking.bankmgmtapp.model.Account;
import com.mum.edu.se.banking.bankmgmtapp.repository.AccountRepository;
import com.mum.edu.se.banking.bankmgmtapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;
    @Autowired
    AccountServiceImp(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public Page<Account> displayAllAccounts(int pageNo) {
        return accountRepository.findAll(PageRequest.of(pageNo,3, Sort.by("accountNumber")));
    }

    @Override
    public void SaveAccount(Account account) {
         accountRepository.save(account);
    }

    @Override
    public double getNetLuquidity() {
        List<Account> accountList = accountRepository.findAll();
        double net = 0;
        for(Account account: accountList){
            if(account.getAccountType().getAccountTypeName().equals("Checking")||
            account.getAccountType().getAccountTypeName().equals("Savings")){
                net += account.getBalance();

            }
            else {
                net -= account.getBalance();
            }
        }
        return  net;
    }
}
