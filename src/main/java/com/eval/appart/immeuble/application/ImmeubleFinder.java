package com.eval.appart.immeuble.application;

import com.eval.appart.shared.domain.Immeuble;
import com.eval.appart.shared.repository.ImmeubleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class ImmeubleFinder {
    @Inject
    ImmeubleRepository immeubleRepository;

    public List<Immeuble> getAllImmeubles() {
        return immeubleRepository.listAll();
    }

    public Immeuble getImmeuble(UUID id) {
        return immeubleRepository.findById(id);
    }
}
