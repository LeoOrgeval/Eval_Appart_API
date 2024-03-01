package com.eval.appart.equipement.interfaces.web.input;

import com.eval.appart.shared.domain.enumeration.TypeEquipement;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@RegisterForReflection
@Getter
@Setter
public class EquipementInput {
    @NotNull
    private TypeEquipement type;
    @NotNull
    private Boolean securite;
    @NotEmpty
    private String dateInspection;
}
