package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.Evaluation;
import com.github.fabriciofx.cactoos.constraints.Constraint;
import java.util.regex.Pattern;

public final class ConstraintRegex implements Constraint {
    private final Pattern pattern;
    private final String reason;
    private final String data;

    public ConstraintRegex(
        final String regex,
        final String reason,
        final String data
    ) {
        this(Pattern.compile(regex), reason, data);
    }

    public ConstraintRegex(
        final Pattern pttrn,
        final String reason,
        final String data
    ) {
        this.pattern = pttrn;
        this.reason = reason;
        this.data = data;
    }

    @Override
    public Evaluation evaluation() {
        final Evaluation eval;
        if (!this.pattern.matcher(this.data).matches()) {
            eval = new Evaluation(false, this.reason);
        } else {
            eval = new Evaluation(true);
        }
        return eval;
    }
}
