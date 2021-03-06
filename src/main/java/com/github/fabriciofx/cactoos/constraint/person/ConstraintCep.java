package com.github.fabriciofx.cactoos.constraint.person;

import com.github.fabriciofx.cactoos.constraint.Constraint;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import com.github.fabriciofx.cactoos.constraint.base.ConstraintRegex;
import org.cactoos.text.FormattedText;

public final class ConstraintCep implements Constraint {
    private final Constraint origin;

    public ConstraintCep(final String cep) {
        this.origin = new ConstraintRegex(
            "[0-9]{3}-[0-9]{5}",
            new FormattedText("CEP %s is invalid", cep),
            cep
        );
    }

    @Override
    public Evaluation evaluation() {
        return this.origin.evaluation();
    }
}
