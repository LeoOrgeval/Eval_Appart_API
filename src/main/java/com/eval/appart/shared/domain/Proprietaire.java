package com.eval.appart.shared.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@RegisterForReflection
@Getter
@Setter
@Entity
public class Proprietaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nom;
    private String prenom;
    private String numero_compte;
    private Boolean assujetti_tva;
}
