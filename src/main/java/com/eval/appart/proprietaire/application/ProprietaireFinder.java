package com.eval.appart.proprietaire.application;

import com.eval.appart.shared.domain.Proprietaire;
import com.eval.appart.shared.repository.ProprietaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class ProprietaireFinder {
    @Inject
    ProprietaireRepository proprietaireRepository;

    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepository.listAll();
    }

    public Proprietaire getProprietaire(UUID id) {
        return proprietaireRepository.findById(id);
    }
}
