package com.eval.appart.immeuble.interfaces.web.output;

import com.eval.appart.shared.domain.Immeuble;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ImmeubleOutputMapper {
    @Mapping(target = "equipement", ignore = true)
    ImmeubleOutput map(Immeuble immeuble);

    List<ImmeubleOutput> map(List<Immeuble> immeubles);

}
