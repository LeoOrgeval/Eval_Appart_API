package com.eval.appart.immeuble.interfaces.web.output;

import com.eval.appart.equipement.interfaces.web.output.EquipementOutput;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@RegisterForReflection
@Getter
@Setter
public class ImmeubleOutput {
    private String id;
    private String adresse;
    private String codePostal;
    private String ville;
    private LocalDate dateConstruction;
    private EquipementOutput equipement;

}