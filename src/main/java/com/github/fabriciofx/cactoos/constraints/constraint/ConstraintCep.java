package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.CheckedResult;
import com.github.fabriciofx.cactoos.constraints.Constraint;
import org.cactoos.text.FormattedText;
import org.cactoos.text.UncheckedText;

public final class ConstraintCep implements Constraint {
    private final Constraint origin;

    public ConstraintCep(final String cep) {
        this.origin = new ConstraintRegex(
            "[0-9]{3}-[0-9]{5}",
            new UncheckedText(
                new FormattedText("CEP %s is invalid", cep)
            ).asString(),
            cep
        );
    }

    @Override
    public CheckedResult checked() {
        return this.origin.checked();
    }
}
