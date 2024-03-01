package com.eval.appart.appartement.application;

import com.eval.appart.shared.domain.Appartement;
import com.eval.appart.shared.repository.AppartementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class AppartementFinder {
    @Inject
    AppartementRepository appartementRepository;

    public List<Appartement> getAllAppartements() {
        return appartementRepository.listAll();
    }

    public Appartement getAppartement(UUID id) {
        return appartementRepository.findById(id);
    }
}
