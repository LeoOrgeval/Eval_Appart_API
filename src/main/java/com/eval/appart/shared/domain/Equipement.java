package com.eval.appart.shared.domain;

import com.eval.appart.shared.domain.enumeration.TypeEquipement;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@RegisterForReflection
@Getter
@Setter
@Entity
public class Equipement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TypeEquipement type;

    private Boolean securite;
    private LocalDate dateInspection;

    @ManyToMany()
    @JoinTable(
            name = "immeuble_equipement",
            joinColumns = @JoinColumn(name = "equipement_id"),
            inverseJoinColumns = @JoinColumn(name = "immeuble_id")
    )
    private Set<Immeuble> immeubles;
}
