package com.eval.appart.appartement.interfaces.web.input;

import com.eval.appart.shared.domain.enumeration.TypeAppartement;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@RegisterForReflection
@Getter
@Setter

public class AppartementInput {
    @NotEmpty
    private String immeubleId;
    @NotEmpty
    private String proprietaireId;
    @NotNull
    private Integer numero;
    @NotNull
    private TypeAppartement type;
    @NotNull
    private Float loyer;
}
