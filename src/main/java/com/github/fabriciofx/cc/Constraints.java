package com.github.fabriciofx.cc;

import java.util.LinkedList;
import java.util.List;
import org.cactoos.list.ListOf;

public final class Constraints implements Constraint {
    private final Iterable<Constraint> constraints;

    public Constraints(final Constraint... constraints) {
        this(new ListOf<>(constraints));
    }

    public Constraints(final Iterable<Constraint> constraints) {
        this.constraints = constraints;
    }

    @Override
    public CheckedResult checked() {
        final List<String> reasons = new LinkedList<>();
        boolean valid = true;
        for (final Constraint constraint : this.constraints) {
            final CheckedResult result = constraint.checked();
            valid = valid && result.ok();
            if (!result.ok()) {
                reasons.addAll(new ListOf<>(result.reasons()));
            }
        }
        return new CheckedResult(valid, reasons);
    }
}
