package com.mum.edu.se.banking.bankmgmtapp.service;

import com.mum.edu.se.banking.bankmgmtapp.model.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountTypeService {
    public abstract List<AccountType> getAllAccountType();
}
