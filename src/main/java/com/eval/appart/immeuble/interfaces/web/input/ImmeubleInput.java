package com.eval.appart.immeuble.interfaces.web.input;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@RegisterForReflection
@Getter
@Setter
public class ImmeubleInput {
    @NotEmpty
    private String adresse;
    @NotEmpty
    private String codePostal;
    @NotEmpty
    private String ville;
    @NotNull
    private LocalDate dateConstruction;
}
