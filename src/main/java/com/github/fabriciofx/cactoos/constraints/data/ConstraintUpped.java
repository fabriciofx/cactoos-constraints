package com.github.fabriciofx.cactoos.constraints.data;

import com.github.fabriciofx.cactoos.constraints.Constraint;
import com.github.fabriciofx.cactoos.constraints.Evaluation;
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
