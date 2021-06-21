package com.banking.gestionDeCompte.services.impl;

import com.banking.gestionDeCompte.metier.impl.DepositMetierImp;
import com.banking.gestionDeCompte.services.Deposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DepositImp implements Deposit {

    @Autowired
    private DepositMetierImp depositMetier;

    /**
     * Méthode pour éffectuer un dépot dans un compte client.
     * @param bankAccountID
     * @param amount
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping(value = "/depot", method = RequestMethod.POST)
    public Boolean depot(@RequestParam Long bankAccountID, @RequestParam float amount) throws TransactionException {
        Boolean succes = Boolean.FALSE;
        try {
            succes = depositMetier.depot(bankAccountID, amount);
        } catch (TransactionException e) {
        log.error(e.getMessage());
        }
        return succes;
    }

}
