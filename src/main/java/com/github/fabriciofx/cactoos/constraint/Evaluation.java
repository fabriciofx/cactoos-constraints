package com.github.fabriciofx.cactoos.constraint;

import org.cactoos.list.ListOf;

public final class Evaluation {
    private boolean success;
    private final Iterable<String> reasons;

    public Evaluation(final boolean success) {
        this(success, new ListOf<>());
    }

    public Evaluation(final boolean success, final String... reasons) {
        this(success, new ListOf<>(reasons));
    }

    public Evaluation(
        final boolean success,
        final Iterable<String> reasons
    ) {
        this.success = success;
        this.reasons = reasons;
    }

    public boolean success() {
        return this.success;
    }

    public Iterable<String> reasons() {
        return this.reasons;
    }
}
