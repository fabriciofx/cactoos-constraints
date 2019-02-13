package com.github.fabriciofx.cactoos.constraint;

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
    public Evaluation evaluation() {
        final List<String> reasons = new LinkedList<>();
        boolean success = true;
        for (final Constraint constraint : this.constraints) {
            final Evaluation eval = constraint.evaluation();
            success = success && eval.success();
            if (!eval.success()) {
                reasons.addAll(new ListOf<>(eval.reasons()));
            }
        }
        return new Evaluation(success, reasons);
    }
}
