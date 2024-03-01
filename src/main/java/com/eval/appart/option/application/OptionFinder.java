package com.eval.appart.option.application;

import com.eval.appart.shared.domain.Option;
import com.eval.appart.shared.repository.OptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class OptionFinder {
    @Inject
    OptionRepository optionRepository;

    public List<Option> getAllOptions() {
        return optionRepository.listAll();
    }

    public Option getOption(UUID id) {
        return optionRepository.findById(id);
    }
}
