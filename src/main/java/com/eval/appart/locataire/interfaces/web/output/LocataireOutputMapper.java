package com.eval.appart.locataire.interfaces.web.output;

import com.eval.appart.shared.domain.Equipement;
import com.eval.appart.shared.domain.Locataire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface LocataireOutputMapper {
    LocataireOutput map(Locataire locataire);

    List<LocataireOutput> map(List<Locataire> locataires);
}
