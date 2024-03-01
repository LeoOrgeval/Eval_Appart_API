package com.eval.appart.proprietaire.application;

import com.eval.appart.proprietaire.interfaces.web.input.ProprietaireInput;
import com.eval.appart.shared.domain.Proprietaire;
import com.eval.appart.shared.repository.ProprietaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ProprietaireCreate {
    @Inject
    ProprietaireRepository proprietaireRepository;

    public Proprietaire createProprietaire(ProprietaireInput proprietaireInput) {
        Proprietaire proprietaire = new Proprietaire();

        proprietaire.setNom(proprietaireInput.getNom());
        proprietaire.setPrenom(proprietaireInput.getPrenom());
        proprietaire.setNumero_compte(proprietaireInput.getNumero_compte());
        proprietaire.setAssujetti_tva(proprietaireInput.getAssujetti_tva());

        proprietaireRepository.persist(proprietaire);

        return proprietaire;
    }
}
