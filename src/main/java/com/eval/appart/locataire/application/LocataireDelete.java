package com.eval.appart.locataire.application;

import com.eval.appart.shared.repository.LocataireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class LocataireDelete {
    @Inject
    LocataireRepository locataireRepository;

    public void deleteLocataire(UUID id) {
        locataireRepository.deleteById(id);
    }
}
