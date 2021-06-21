package com.banking.gestionDeCompte.metier;

import com.banking.gestionDeCompte.entities.BankAccount;

public interface NouveauClientMetier {

    Boolean nouvauClient(BankAccount bankAccount);
}
