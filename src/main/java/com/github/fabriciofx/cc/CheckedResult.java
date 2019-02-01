package com.github.fabriciofx.cc;

import org.cactoos.list.ListOf;

public final class CheckedResult {
    private boolean ok;
    private final Iterable<String> reasons;

    public CheckedResult(final boolean ok) {
        this(ok, new ListOf<>());
    }

    public CheckedResult(final boolean ok, final String... reasons) {
        this(ok, new ListOf<>(reasons));
    }

    public CheckedResult(final boolean ok, final Iterable<String> reasons) {
        this.ok = ok;
        this.reasons = reasons;
    }

    public boolean ok() {
        return this.ok;
    }

    public Iterable<String> reasons() {
        return this.reasons;
    }
}
