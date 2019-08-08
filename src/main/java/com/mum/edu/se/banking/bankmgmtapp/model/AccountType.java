package com.mum.edu.se.banking.bankmgmtapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountTypeId;

    private String accountTypeName;

    @OneToOne(mappedBy = "accountType")
    private Account account;
}
