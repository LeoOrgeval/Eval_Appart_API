package com.eval.appart.appartement.application;

import com.eval.appart.appartement.interfaces.web.input.AppartementInput;
import com.eval.appart.shared.domain.*;
import com.eval.appart.shared.domain.enumeration.TypeAppartement;
import com.eval.appart.shared.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class AppartementUpdate {
    @Inject
    AppartementRepository appartementRepository;
    @Inject
    ImmeubleRepository immeubleRepository;
    @Inject
    ProprietaireRepository proprietaireRepository;
    @Inject
    LocataireRepository locataireRepository;
    @Inject
    OptionRepository optionRepository;

    public Appartement updateAppartement(UUID id, AppartementInput appartementInput) {
        Appartement appartement = appartementRepository.findById(id);
        Immeuble immeuble = immeubleRepository.findById(UUID.fromString(appartementInput.getImmeubleId()));
        Proprietaire proprietaire = proprietaireRepository.findById(UUID.fromString(appartementInput.getProprietaireId()));

        appartement.setNumero(appartementInput.getNumero());
        appartement.setType(appartementInput.getType());
        appartement.setLoyer(appartementInput.getLoyer());
        appartement.setImmeuble(immeuble);
        appartement.setProprietaire(proprietaire);

        appartementRepository.persist(appartement);

        return appartement;
    }

    public Appartement addLocatairePrincipal(UUID id, UUID locataireId) {
        Appartement appartement = appartementRepository.findById(id);
        Locataire locataire = locataireRepository.findById(locataireId);

        appartement.setLocatairePrincipal(locataire);
        return appartement;
    }

    public Appartement addOption(UUID id, UUID optionId) {
        Appartement appartement = appartementRepository.findById(id);
        Option option = optionRepository.findById(optionId);

        Set<Option> options = appartement.getOptions();
        options.add(option);
        appartement.setOptions(options);

        appartementRepository.persist(appartement);

        return appartement;
    }

}
