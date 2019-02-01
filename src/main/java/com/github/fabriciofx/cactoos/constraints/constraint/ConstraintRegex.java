package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.CheckedResult;
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
    public CheckedResult checked() {
        final CheckedResult result;
        if (!this.pattern.matcher(this.data).matches()) {
            result = new CheckedResult(false, this.reason);
        } else {
            result = new CheckedResult(true);
        }
        return result;
    }
}
