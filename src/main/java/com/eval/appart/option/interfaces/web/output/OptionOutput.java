package com.eval.appart.option.interfaces.web.output;

import com.eval.appart.shared.domain.enumeration.TypeOption;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
@RegisterForReflection
@Getter
@Setter
public class OptionOutput {
    private String id;
    private TypeOption type;
}
