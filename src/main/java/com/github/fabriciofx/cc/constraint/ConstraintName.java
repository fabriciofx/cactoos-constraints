package com.github.fabriciofx.cc.constraint;

import com.github.fabriciofx.cc.CheckedResult;
import com.github.fabriciofx.cc.Constraint;
import org.cactoos.text.FormattedText;
import org.cactoos.text.UncheckedText;

public final class ConstraintName implements Constraint {
    private final Constraint origin;

    public ConstraintName(final String name) {
        this.origin = new ConstraintRegex(
            "[a-zA-Z\\-'\\s]+",
            new UncheckedText(
                new FormattedText("Name %s is invalid", name)
            ).asString(),
            name
        );
    }

    @Override
    public CheckedResult checked() {
        return this.origin.checked();
    }
}
