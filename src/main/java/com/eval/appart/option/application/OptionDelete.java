package com.eval.appart.option.application;

import com.eval.appart.shared.repository.OptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@ApplicationScoped
@Slf4j
public class OptionDelete {
    @Inject
    OptionRepository optionRepository;

    public void deleteOption(UUID id) {
        optionRepository.deleteById(id);
    }
}
