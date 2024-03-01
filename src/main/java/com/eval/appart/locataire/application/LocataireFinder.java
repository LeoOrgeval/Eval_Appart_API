package com.eval.appart.locataire.application;

import com.eval.appart.shared.domain.Locataire;
import com.eval.appart.shared.repository.LocataireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class LocataireFinder {
    @Inject
    LocataireRepository locataireRepository;

    public List<Locataire> getAllLocataires() {
        return locataireRepository.listAll();
    }

    public Locataire getLocataire(UUID id) {
        return locataireRepository.findById(id);
    }
}
