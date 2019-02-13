package com.github.fabriciofx.cactoos.constraint.person;

import com.github.fabriciofx.cactoos.constraint.Constraint;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import org.cactoos.text.FormattedText;
import org.cactoos.text.UncheckedText;

public final class ConstraintCpf implements Constraint {
    private final String data;

    public ConstraintCpf(final String cpf) {
        this.data = cpf;
    }

    @Override
    public Evaluation evaluation() {
        int[] digits = new int[11];
        for(int idx = 0; idx < digits.length; idx++) {
            digits[idx] = this.data.charAt(idx) - '0';
        }
        boolean equals = true;
        for (int idx = 0; idx < 8; idx++) {
            equals = equals & (digits[idx] == digits[idx + 1]);
        }
        final Evaluation eval;
        if (equals) {
            eval = new Evaluation(
                false,
                new UncheckedText(
                    new FormattedText(
                        "CPF %s is invalid",
                        this.data
                    )
                ).asString()
            );
        } else {
            int dv1 = 0, dv2 = 0;
            for (int idx = 0; idx < 9; idx++) {
                dv1 = dv1 + digits[idx] * (idx + 1);
                dv2 = dv2 + digits[idx] * idx;
            }
            dv1 = (dv1 % 11) % 10;
            dv2 = dv2 + dv1 * 9;
            dv2 = (dv2 % 11) % 10;
            if (dv1 == digits[9] && dv2 == digits[10]) {
                eval = new Evaluation(
                    true,
                    new UncheckedText(
                        new FormattedText(
                            "CPF %s is invalid",
                            this.data
                        )
                    ).asString()
                );
            } else {
                eval = new Evaluation(
                    false,
                    new UncheckedText(
                        new FormattedText(
                            "CPF %s is invalid",
                            this.data
                        )
                    ).asString()
                );
            }
        }
        return eval;
    }
}
