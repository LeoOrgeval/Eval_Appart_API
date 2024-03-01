package com.eval.appart.equipement.application;

import com.eval.appart.shared.domain.Equipement;
import com.eval.appart.shared.repository.EquipementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class EquipementFinder {
    @Inject
    EquipementRepository equipementRepository;

    public List<Equipement> getAllEquipements() {
        return equipementRepository.listAll();
    }

    public Equipement getEquipement(UUID id) {
        return equipementRepository.findById(id);
    }
}
