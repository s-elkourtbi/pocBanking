package com.banking.gestionDeCompte.services.impl;

import com.banking.gestionDeCompte.entities.Movement;
import com.banking.gestionDeCompte.metier.impl.RelevetMetierImp;
import com.banking.gestionDeCompte.services.Relevet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class RelevetImp implements Relevet {

    @Autowired
    private RelevetMetierImp relevetMetier;

    @Override
    @RequestMapping(value = "/relevet", method = RequestMethod.GET)
    public boolean generationRelevet(@RequestParam Long  idCompte) {
        boolean succes = false;
        try {
            succes =  relevetMetier.generationRelevet(idCompte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/historique", method = RequestMethod.GET)
    public List<Movement> historique(@RequestParam Long idCompte) {

        return relevetMetier.historique(idCompte);
    }

}
