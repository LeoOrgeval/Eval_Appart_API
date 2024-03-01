package com.eval.appart.equipement.application;

import com.eval.appart.shared.repository.EquipementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class EquipementDelete {
    @Inject
    EquipementRepository equipementRepository;

    public void deleteEquipement(UUID id) {
        equipementRepository.deleteById(id);
    }
}
