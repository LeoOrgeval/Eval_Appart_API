package com.eval.appart.option.application;

import com.eval.appart.option.interfaces.web.input.OptionInput;
import com.eval.appart.shared.domain.Option;
import com.eval.appart.shared.domain.enumeration.TypeOption;
import com.eval.appart.shared.repository.OptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class OptionCreate {
    @Inject
    OptionRepository optionRepository;

    public Option createOption(OptionInput optionInput) {
        Option option = new Option();

        option.setType(optionInput.getType());

        optionRepository.persist(option);

        return option;
    }
}
