package com.github.fabriciofx.cactoos.constraint.person;

import com.github.fabriciofx.cactoos.constraint.Constraints;
import com.github.fabriciofx.cactoos.constraint.Evaluation;
import com.github.fabriciofx.cactoos.constraint.base.ConstraintUpped;
import com.github.fabriciofx.cactoos.constraint.person.ConstraintName;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.IsTrue;
import org.llorllale.cactoos.matchers.TextIs;

public final class ConstraintNameTest {
    @Test
    public void checkIsValidName() {
        new Assertion<>(
            "Can't check if is an valid name",
            () -> new ConstraintName("Fabricio Barros Cabral").evaluation().success(),
            new IsTrue()
        ).affirm();
    }

    @Test
    public void checkIsInvalidName() throws Exception {
        final String name = "Fabrici0 Barros Cabral";
        final Evaluation result = new ConstraintName(name).evaluation();
        new Assertion<>(
            "Can't check if is an invalid name",
            () -> result.success(),
            new IsEqual<>(false)
        ).affirm();
        new Assertion<>(
            "Can't check if is an invalid name",
            () -> result.reasons().iterator().next(),
            new IsEqual<>(
                new FormattedText(
                    "Name %s is invalid",
                    name
                ).asString()
            )
        ).affirm();
    }

    @Test
    public void checkIsUppedValidName() {
        final String name = "FABRICIO BARROS CABRAL";
        new Assertion<>(
            "It's a valid name",
            () -> new Constraints(
                new ConstraintName(name),
                new ConstraintUpped(name)
            ).evaluation().success(),
            new IsTrue()
        ).affirm();
    }

    @Test
    public void checkIsUppedInvalidName() throws Exception {
        final String name = "F4BRICIo BARROS CABRAL";
        final Evaluation result = new Constraints(
            new ConstraintName(name),
            new ConstraintUpped(name)
        ).evaluation();
        new Assertion<>(
            "Can't check if is an upped invalid name",
            () -> new JoinedText(", ", result.reasons()),
            new TextIs(
                new FormattedText(
                    "Name %s is invalid, %s is not upped",
                    name,
                    name
                )
            )
        ).affirm();

    }
}
