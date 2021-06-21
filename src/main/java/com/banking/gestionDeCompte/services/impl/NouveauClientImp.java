package com.banking.gestionDeCompte.services.impl;


import com.banking.gestionDeCompte.entities.BankAccount;
import com.banking.gestionDeCompte.metier.impl.NouveauClientMetierImp;
import com.banking.gestionDeCompte.services.NouveauClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NouveauClientImp implements NouveauClient {

    @Autowired
    private NouveauClientMetierImp nouveauClientMetier;

    @Override
    @RequestMapping(value = "/nouveauClient", method = RequestMethod.POST)
    public Boolean nouvauClient(@RequestBody BankAccount bankAccount) {
        Boolean succes = Boolean.FALSE;
        try {
           succes = nouveauClientMetier.nouvauClient(bankAccount);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }
}
