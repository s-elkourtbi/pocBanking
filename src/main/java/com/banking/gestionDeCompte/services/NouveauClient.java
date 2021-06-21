package com.banking.gestionDeCompte.services;

import com.banking.gestionDeCompte.entities.BankAccount;

public interface NouveauClient {

    Boolean nouvauClient(BankAccount bankAccount) throws Exception;
}
