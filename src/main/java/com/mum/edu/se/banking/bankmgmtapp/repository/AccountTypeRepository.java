package com.mum.edu.se.banking.bankmgmtapp.repository;

import com.mum.edu.se.banking.bankmgmtapp.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
}
