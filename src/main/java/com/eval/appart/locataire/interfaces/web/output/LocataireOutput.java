package com.eval.appart.locataire.interfaces.web.output;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
@RegisterForReflection
@Getter
@Setter
public class LocataireOutput {
    private String id;
    private String nom;
    private String prenom;
}
