package com.banking.gestionDeCompte.services;

public interface Withdrawal {

    Boolean withdraw(Long bankAccount, float withdrawAmount) throws Exception;
}
