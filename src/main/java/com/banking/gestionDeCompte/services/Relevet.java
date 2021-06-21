package com.banking.gestionDeCompte.services;

import com.banking.gestionDeCompte.entities.Movement;

import java.io.IOException;
import java.util.List;

public interface Relevet {

    boolean generationRelevet(Long idCompte) throws IOException;

    List<Movement> historique(Long idCompte);
}
