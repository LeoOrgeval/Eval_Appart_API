package com.eval.appart.equipement.interfaces.web.output;

import com.eval.appart.shared.domain.enumeration.TypeEquipement;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@RegisterForReflection
@Getter
@Setter
public class EquipementOutput {
    private String id;
    private TypeEquipement type;
    private LocalDate dateInspection;
}
