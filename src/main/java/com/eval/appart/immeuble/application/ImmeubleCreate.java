package com.eval.appart.immeuble.application;

import com.eval.appart.immeuble.interfaces.web.input.ImmeubleInput;
import com.eval.appart.shared.domain.Immeuble;
import com.eval.appart.shared.repository.ImmeubleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@ApplicationScoped
@Slf4j
public class ImmeubleCreate {
    @Inject
    ImmeubleRepository immeubleRepository;

    public Immeuble createImmeuble(ImmeubleInput immeubleInput) {
        Immeuble immeuble = new Immeuble();

        immeuble.setAdresse(immeubleInput.getAdresse());
        immeuble.setCodePostal(immeubleInput.getCodePostal());
        immeuble.setVille(immeubleInput.getVille());
        immeuble.setDateConstruction(immeubleInput.getDateConstruction());

        immeubleRepository.persist(immeuble);

        return immeuble;
    }


}
