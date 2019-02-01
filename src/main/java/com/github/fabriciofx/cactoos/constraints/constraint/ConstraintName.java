package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.Constraint;
import com.github.fabriciofx.cactoos.constraints.Evaluation;
import org.cactoos.text.FormattedText;

public final class ConstraintName implements Constraint {
    private final Constraint origin;

    public ConstraintName(final String name) {
        this.origin = new ConstraintRegex(
            "[a-zA-Z\\-'\\s]+",
            new FormattedText("Name %s is invalid", name),
            name
        );
    }

    @Override
    public Evaluation evaluation() {
        return this.origin.evaluation();
    }
}
