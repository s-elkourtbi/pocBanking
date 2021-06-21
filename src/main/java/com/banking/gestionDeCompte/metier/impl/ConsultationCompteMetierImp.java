package com.banking.gestionDeCompte.metier.impl;

import com.banking.gestionDeCompte.entities.BankAccount;
import com.banking.gestionDeCompte.metier.ConsultationCompteMetier;
import com.banking.gestionDeCompte.repository.BankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

/**
 * Classe métier pour la consultation du solde d'un compte client.
 */
@Slf4j
@Service
public class ConsultationCompteMetierImp implements ConsultationCompteMetier {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    /**
     * Méthode pour la consultation du solde pour un compte client.
     * @param bankAccountID
     * @return
     * @throws TransactionException
     */
    @Override
    public Float consultationCompte(Long bankAccountID) throws TransactionException {
        Float balance = 0F;
        try {
            if(bankAccountID != 0 && bankAccountRepository.findById(bankAccountID).isPresent()) {
                BankAccount bankAccount = bankAccountRepository.findById(bankAccountID).get();
                balance = bankAccount.getBalance();
                log.info("Le solde du compte =" + balance);

            }

        } catch (TransactionException e)
        {
            log.error(e.getMessage());
        }
        return  balance;
    }
}
