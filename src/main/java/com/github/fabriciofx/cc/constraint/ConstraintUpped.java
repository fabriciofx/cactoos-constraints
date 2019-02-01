package com.github.fabriciofx.cc.constraint;

import com.github.fabriciofx.cc.CheckedResult;
import com.github.fabriciofx.cc.Constraint;
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
    public CheckedResult checked() {
        return this.origin.checked();
    }
}
