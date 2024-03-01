package com.eval.appart.locataire.application;

import com.eval.appart.locataire.interfaces.web.input.LocataireInput;
import com.eval.appart.shared.domain.Appartement;
import com.eval.appart.shared.domain.Locataire;
import com.eval.appart.shared.repository.AppartementRepository;
import com.eval.appart.shared.repository.LocataireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class LocataireCreate {
    @Inject
    LocataireRepository locataireRepository;
    @Inject
    AppartementRepository appartementRepository;

    public Locataire createLocataire(LocataireInput locataireInput) {
        Locataire locataire = new Locataire();
        Appartement appartement = appartementRepository.findById(UUID.fromString(locataireInput.getAppartementId()));

        locataire.setNom(locataireInput.getNom());
        locataire.setPrenom(locataireInput.getPrenom());
        locataire.setAppartement(appartement);

        locataireRepository.persist(locataire);

        return locataire;
    }
}
