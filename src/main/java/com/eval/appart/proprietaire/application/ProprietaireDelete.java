package com.eval.appart.proprietaire.application;

import com.eval.appart.shared.repository.ProprietaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class ProprietaireDelete {
    @Inject
    ProprietaireRepository proprietaireRepository;

    public void deleteProprietaire(UUID id) {
        proprietaireRepository.deleteById(id);
    }
}
