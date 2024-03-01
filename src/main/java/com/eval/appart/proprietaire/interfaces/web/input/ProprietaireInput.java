package com.eval.appart.proprietaire.interfaces.web.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@RegisterForReflection
@Getter
@Setter
public class ProprietaireInput {
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotEmpty
    private String numero_compte;
    @NotNull
    private Boolean assujetti_tva;
}
