package com.banking.gestionDeCompte.metier.impl;

import com.banking.gestionDeCompte.entities.BankAccount;
import com.banking.gestionDeCompte.metier.NouveauClientMetier;
import com.banking.gestionDeCompte.repository.BankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

/**
 * Classe métier pour la création d'un nouveau client.
 */
@Slf4j
@Service
public class NouveauClientMetierImp implements NouveauClientMetier {

    @Autowired
    private BankAccountRepository repository;

    /**
     * Création d'un nouveau client.
     * @param bankAccount
     * @return
     */
    @Override
    public Boolean nouvauClient(BankAccount bankAccount) {
        Boolean success = Boolean.FALSE;
        try {
            repository.saveAndFlush(bankAccount);
            success = Boolean.TRUE;
            log.info("Un nouveau client vient d'étre ajouter à la Base");
        }catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return success;
    }
}
