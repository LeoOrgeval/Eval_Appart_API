package com.eval.appart.shared.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@RegisterForReflection
@Getter
@Setter
@Entity
public class Immeuble implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String adresse;
    private String codePostal;
    private String ville;
    private LocalDateTime dateConstruction;

    @OneToMany(
            mappedBy = "immeuble",
            cascade = CascadeType.REMOVE
    )
    private Set<Appartement> appartements;
    
    @ManyToMany()
    @JoinTable(
            name = "immeuble_equipement",
            joinColumns = @JoinColumn(name = "immeuble_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipements;
}
