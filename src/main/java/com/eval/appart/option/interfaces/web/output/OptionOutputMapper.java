package com.eval.appart.option.interfaces.web.output;

import com.eval.appart.shared.domain.Option;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "cdi")
public interface OptionOutputMapper {
    OptionOutput map(Option option);

    List<OptionOutput> map(List<Option> options);
}
