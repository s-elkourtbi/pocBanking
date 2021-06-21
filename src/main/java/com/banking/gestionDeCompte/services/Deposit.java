package com.banking.gestionDeCompte.services;

import org.springframework.transaction.TransactionException;

public interface Deposit {

    Boolean depot(Long bankAccount, float amount) throws TransactionException;
}
