package com.eval.appart.appartement.application;

import com.eval.appart.shared.repository.AppartementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class AppartementDelete {
    @Inject
    AppartementRepository appartementRepository;

    public void deleteAppartement(UUID id) {
        appartementRepository.deleteById(id);
    }
}
