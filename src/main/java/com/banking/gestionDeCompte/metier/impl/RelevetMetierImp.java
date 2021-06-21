package com.banking.gestionDeCompte.metier.impl;;

import com.banking.gestionDeCompte.entities.BankAccount;
import com.banking.gestionDeCompte.entities.Movement;
import com.banking.gestionDeCompte.metier.RelevetMetier;
import com.banking.gestionDeCompte.repository.BankAccountRepository;
import com.banking.gestionDeCompte.repository.MovementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe métier pour la création d'un relevet.
 */
@Slf4j
@Service
public class RelevetMetierImp implements RelevetMetier {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    /**
     * Méthode pour génératon d'un relevet.
     * @param idCompte
     * @return
     * @throws IOException
     */
    @Override
    public boolean generationRelevet(Long idCompte) throws IOException {
        boolean succes = false;
        List<Movement> movements;
        FileWriter file = new FileWriter("Relevet"+idCompte+".json");
        try {
            if (idCompte != 0) {
                Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(idCompte);
                if (bankAccountOptional.isPresent()) {
                    movements = bankAccountOptional.get().getMovements();
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
                    writer.writeValue(file, movements);
                    succes =true;
                    log.info("Le relevet est pret pour l'impression.");
                }

            }
        } catch (IOException e) {
            log.error("Error when opening the file", e);
        }
        return succes;
    }

    /**
     * Méthode pour la consultation de l'historique des mouvements pour un compte bancaire.
     * @param idCompte
     * @return
     */
    @Override
    public List<Movement> historique(Long idCompte) {

        return movementRepository.historique(idCompte);
    }
}
