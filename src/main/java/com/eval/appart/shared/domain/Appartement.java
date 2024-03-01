package com.eval.appart.shared.domain;

import com.eval.appart.shared.domain.enumeration.TypeAppartement;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@RegisterForReflection
@Getter
@Setter
@Entity
public class Appartement implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer numero;

    @Enumerated(EnumType.STRING)
    private TypeAppartement type;

    private Float loyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locataire_principal_id")
    private Locataire locatairePrincipal;

    @ManyToMany()
    @JoinTable(
            name = "appartement_option",
            joinColumns = @JoinColumn(name = "appartement_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private Set<Option> options;
}
