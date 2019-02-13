package com.github.fabriciofx.cactoos.constraint.base;

import com.github.fabriciofx.cactoos.constraint.Constraint;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import java.util.regex.Pattern;
import org.cactoos.Text;
import org.cactoos.text.UncheckedText;

public final class ConstraintRegex implements Constraint {
    private final Pattern pattern;
    private final Text reason;
    private final String data;

    public ConstraintRegex(
        final String regex,
        final Text reason,
        final String data
    ) {
        this(Pattern.compile(regex), reason, data);
    }

    public ConstraintRegex(
        final Pattern pttrn,
        final Text reason,
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
            eval = new Evaluation(
                false,
                new UncheckedText(this.reason).asString()
            );
        } else {
            eval = new Evaluation(true);
        }
        return eval;
    }
}
