package com.mum.edu.se.banking.bankmgmtapp.repository;

import com.mum.edu.se.banking.bankmgmtapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
  //  List<Account> getAccountByAccountType(String accountTypeName);
}
