package com.github.fabriciofx.cactoos.constraint.person;

import com.github.fabriciofx.cactoos.constraint.Constraint;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import com.github.fabriciofx.cactoos.constraint.base.ConstraintRegex;
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
