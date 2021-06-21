package com.banking.gestionDeCompte.metier;

import org.springframework.transaction.TransactionException;

public interface ConsultationCompteMetier {

    Float consultationCompte(Long bankAccountID) throws TransactionException;
}
