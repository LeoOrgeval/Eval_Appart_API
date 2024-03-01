package com.eval.appart.appartement.interfaces.web.output;

import com.eval.appart.immeuble.interfaces.web.output.ImmeubleOutput;
import com.eval.appart.locataire.interfaces.web.output.LocataireOutput;
import com.eval.appart.option.interfaces.web.output.OptionOutput;
import com.eval.appart.proprietaire.interfaces.web.output.ProprietaireOutput;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
@RegisterForReflection
@Getter
@Setter
public class AppartementOutput {
    private String id;
    private Integer numero;
    private String type;
    private Float loyer;
    private ProprietaireOutput proprietaire;
    private ImmeubleOutput immeuble;
    private LocataireOutput locatairePrincipal;
    private OptionOutput option;
}
