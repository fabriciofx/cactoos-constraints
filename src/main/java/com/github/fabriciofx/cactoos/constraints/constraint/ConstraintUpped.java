package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.Evaluation;
import com.github.fabriciofx.cactoos.constraints.Constraint;
import org.cactoos.text.FormattedText;
import org.cactoos.text.UncheckedText;

public final class ConstraintUpped implements Constraint {
    private final Constraint origin;

    public ConstraintUpped(final String string) {
        this.origin = new ConstraintRegex(
            "[A-Z\\-'\\s]+",
            new UncheckedText(
                new FormattedText("%s is not upped", string)
            ).asString(),
            string
        );
    }

    @Override
    public Evaluation evaluation() {
        return this.origin.evaluation();
    }
}
