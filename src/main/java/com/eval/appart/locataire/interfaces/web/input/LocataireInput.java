package com.eval.appart.locataire.interfaces.web.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@RegisterForReflection
@Getter
@Setter
public class LocataireInput {
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotEmpty
    private String appartementId;
}
