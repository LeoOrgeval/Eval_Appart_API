package com.eval.appart.immeuble.application;

import com.eval.appart.shared.repository.ImmeubleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class ImmeubleDelete {
    @Inject
    ImmeubleRepository immeubleRepository;

    public void deleteImmeuble(UUID id) {
        immeubleRepository.deleteById(id);
    }
}
