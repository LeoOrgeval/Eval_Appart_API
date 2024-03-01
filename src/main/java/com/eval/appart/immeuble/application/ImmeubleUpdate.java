package com.eval.appart.immeuble.application;

import com.eval.appart.immeuble.interfaces.web.input.ImmeubleInput;
import com.eval.appart.immeuble.interfaces.web.output.ImmeubleOutput;
import com.eval.appart.shared.domain.Equipement;
import com.eval.appart.shared.domain.Immeuble;
import com.eval.appart.shared.repository.EquipementRepository;
import com.eval.appart.shared.repository.ImmeubleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class ImmeubleUpdate {
    @Inject
    ImmeubleRepository immeubleRepository;
    @Inject
    EquipementRepository equipementRepository;

    public Immeuble updateImmeuble(UUID id, ImmeubleInput immeubleInput) {
        Immeuble immeuble = immeubleRepository.findById(id);

        immeuble.setAdresse(immeubleInput.getAdresse());
        immeuble.setCodePostal(immeubleInput.getCodePostal());
        immeuble.setVille(immeubleInput.getVille());
        immeuble.setDateConstruction(immeubleInput.getDateConstruction());

        immeubleRepository.persist(immeuble);

        return immeuble;
    }

    public Immeuble addEquipement(UUID id, UUID equipementId) {
        Immeuble immeuble = immeubleRepository.findById(id);
        Equipement equipement = equipementRepository.findById(equipementId);

        Set<Equipement> equipements = immeuble.getEquipements();
        equipements.add(equipement);
        immeuble.setEquipements(equipements);

        immeubleRepository.persist(immeuble);

        return immeuble;
    }

}
