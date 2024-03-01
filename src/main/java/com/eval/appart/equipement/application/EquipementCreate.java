package com.eval.appart.equipement.application;

import com.eval.appart.equipement.interfaces.web.input.EquipementInput;
import com.eval.appart.shared.domain.Equipement;
import com.eval.appart.shared.domain.enumeration.TypeEquipement;
import com.eval.appart.shared.repository.EquipementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@ApplicationScoped
@Slf4j
public class EquipementCreate {
    @Inject
    EquipementRepository equipementRepository;

    public Equipement createEquipement(EquipementInput equipementInput) {
        Equipement equipement = new Equipement();

        equipement.setType(equipementInput.getType());
        equipement.setSecurite(equipementInput.getSecurite());
        equipement.setDateInspection(LocalDate.parse(equipementInput.getDateInspection()));

        equipementRepository.persist(equipement);

        return equipement;
    }
}
