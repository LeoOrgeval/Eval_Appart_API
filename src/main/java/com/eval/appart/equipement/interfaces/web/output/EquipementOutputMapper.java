package com.eval.appart.equipement.interfaces.web.output;

import com.eval.appart.shared.domain.Equipement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EquipementOutputMapper {
    EquipementOutput map(Equipement equipement);

    List<EquipementOutput> map(List<Equipement> equipements);
}
