package com.eval.appart.option.interfaces.web.input;

import com.eval.appart.shared.domain.enumeration.TypeOption;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@RegisterForReflection
@Getter
@Setter

public class OptionInput {
    @NotNull
    private TypeOption type;
}
