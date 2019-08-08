package com.mum.edu.se.banking.bankmgmtapp.service;

import com.mum.edu.se.banking.bankmgmtapp.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    Page<Account> displayAllAccounts(int pageNo);
    void SaveAccount(Account account);
    double getNetLuquidity();
}
