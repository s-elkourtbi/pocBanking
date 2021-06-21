package com.banking.gestionDeCompte.metier;

import javax.transaction.TransactionalException;

public interface WithdrawalMetier {

    Boolean withdraw(Long bankAccountID, float withdrawAmount) throws TransactionalException;
}
