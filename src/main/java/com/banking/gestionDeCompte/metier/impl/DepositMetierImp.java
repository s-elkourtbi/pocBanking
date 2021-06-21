package com.banking.gestionDeCompte.metier.impl;

import com.banking.gestionDeCompte.entities.BankAccount;
import com.banking.gestionDeCompte.entities.Movement;
import com.banking.gestionDeCompte.metier.DepositMetier;
import com.banking.gestionDeCompte.repository.BankAccountRepository;
import com.banking.gestionDeCompte.repository.MovementRepository;
import com.banking.gestionDeCompte.utils.MovementEnum;
import com.banking.gestionDeCompte.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

/**
 * Classe métier pour le dépot.
 */
@Slf4j
@Service
public class DepositMetierImp implements DepositMetier {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private MovementRepository movementRepository;

    /**
     * Méthode pour éffectuer un dépot dans un compte client.
     * @param bankAccountID
     * @param amount
     * @return
     * @throws TransactionException
     */
    @Override
    public Boolean depot(Long bankAccountID, float amount) throws TransactionException {
        Boolean succes = Boolean.FALSE;
        try {
            if(bankAccountID != null && amount != 0) {

                if (bankAccountRepository.findById(bankAccountID).isPresent()) {
                    BankAccount bankAccount = bankAccountRepository.findById(bankAccountID).get();
                    Movement movement = new Movement();
                    float newBalance;

                    newBalance = bankAccount.getBalance() + amount;
                    bankAccount.setBalance(newBalance);
                    bankAccountRepository.saveAndFlush(bankAccount);

                    movement.setDate(Utilities.getCurrentDate());
                    movement.setAmount(amount);
                    movement.setBankAccount(bankAccount);
                    movement.setMovementEnum(MovementEnum.DEPOT);
                    movementRepository.saveAndFlush(movement);
                    log.info("Le dépot est prit en compte");
                    succes = Boolean.TRUE;
                }

            }

        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return succes;
    }

}
