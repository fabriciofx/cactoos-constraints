package com.github.fabriciofx.cactoos.constraint.base;

import com.github.fabriciofx.cactoos.constraint.Constraint;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import org.cactoos.text.FormattedText;

public final class ConstraintUpped implements Constraint {
    private final Constraint origin;

    public ConstraintUpped(final String string) {
        this.origin = new ConstraintRegex(
            "[A-Z\\-'\\s]+",
            new FormattedText("%s is not upped", string),
            string
        );
    }

    @Override
    public Evaluation evaluation() {
        return this.origin.evaluation();
    }
}
