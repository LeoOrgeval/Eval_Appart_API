package com.eval.appart.shared.domain;

import com.eval.appart.shared.domain.enumeration.TypeOption;
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
public class Option implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TypeOption type;

    @ManyToMany()
    @JoinTable(
            name = "appartement_option",
            joinColumns = @JoinColumn(name = "option_id"),
            inverseJoinColumns = @JoinColumn(name = "appartement_id")
    )
    private Set<Appartement> appartement;
}
