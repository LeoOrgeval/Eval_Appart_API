package com.eval.appart.appartement.application;

import com.eval.appart.appartement.interfaces.web.input.AppartementInput;
import com.eval.appart.shared.domain.Appartement;
import com.eval.appart.shared.domain.Immeuble;
import com.eval.appart.shared.domain.Proprietaire;
import com.eval.appart.shared.domain.enumeration.TypeAppartement;
import com.eval.appart.shared.repository.AppartementRepository;
import com.eval.appart.shared.repository.ImmeubleRepository;
import com.eval.appart.shared.repository.ProprietaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class AppartementCreate {
    @Inject
    AppartementRepository appartementRepository;
    @Inject
    ImmeubleRepository immeubleRepository;
    @Inject
    ProprietaireRepository proprietaireRepository;

    public Appartement createAppartement(AppartementInput appartementInput) {
        Appartement appartement = new Appartement();
        Immeuble immeuble = immeubleRepository.findById(UUID.fromString(appartementInput.getImmeubleId()));
        Proprietaire proprietaire = proprietaireRepository.findById(UUID.fromString(appartementInput.getProprietaireId()));

        appartement.setNumero(appartementInput.getNumero());
        appartement.setType(appartementInput.getType());
        appartement.setLoyer(appartementInput.getLoyer());
        appartement.setImmeuble(immeuble);
        appartement.setProprietaire(proprietaire);

        appartementRepository.persist(appartement);

        return appartement;
    }
}
