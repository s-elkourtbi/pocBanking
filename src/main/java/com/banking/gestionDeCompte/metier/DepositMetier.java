package com.banking.gestionDeCompte.metier;

import org.springframework.transaction.TransactionException;

public interface DepositMetier {

    Boolean depot(Long bankAccountID, float amount) throws TransactionException;
}
