package com.eval.appart.proprietaire.interfaces.web.output;

import com.eval.appart.shared.domain.Proprietaire;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "cdi")
public interface ProprietaireOutputMapper {
    ProprietaireOutput map(Proprietaire proprietaire);

    List<ProprietaireOutput> map(List<Proprietaire> proprietaires);
}
