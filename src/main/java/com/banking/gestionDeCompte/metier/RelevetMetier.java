package com.banking.gestionDeCompte.metier;

import com.banking.gestionDeCompte.entities.Movement;

import java.io.IOException;
import java.util.List;

public interface RelevetMetier {

    boolean generationRelevet(Long idCompte) throws IOException;

    List<Movement> historique(Long idCompte);
}
