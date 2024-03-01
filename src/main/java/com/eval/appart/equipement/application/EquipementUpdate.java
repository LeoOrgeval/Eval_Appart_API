package com.eval.appart.equipement.application;

import com.eval.appart.equipement.interfaces.web.input.EquipementInput;
import com.eval.appart.equipement.interfaces.web.output.EquipementOutput;
import com.eval.appart.shared.domain.Equipement;
import com.eval.appart.shared.domain.enumeration.TypeEquipement;
import com.eval.appart.shared.repository.EquipementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class EquipementUpdate {
    @Inject
    EquipementRepository equipementRepository;

    public Equipement updateEquipement(UUID id, EquipementInput equipementInput) {
        Equipement equipement = equipementRepository.findById(id);

        equipement.setType(equipementInput.getType());
        equipement.setSecurite(equipementInput.getSecurite());
        equipement.setDateInspection(LocalDate.parse(equipementInput.getDateInspection()));

        equipementRepository.persist(equipement);

        return equipement;
    }
}
