package com.eval.appart.appartement.interfaces.web.output;

import com.eval.appart.shared.domain.Appartement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "cdi")
public interface AppartementOutputMapper {
    @Mapping(target = "option", ignore = true)
    AppartementOutput map(Appartement appartement);

    List<AppartementOutput> map(List<Appartement> appartements);
}
