package com.eval.appart.proprietaire.interfaces.web.output;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
@RegisterForReflection
@Getter
@Setter
public class ProprietaireOutput {
    private String id;
    private String nom;
    private String prenom;
    private String numero_compte;
    private Boolean assujetti_tva;
}
