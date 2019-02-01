package com.github.fabriciofx.cactoos.constraints.constraint;

import com.github.fabriciofx.cactoos.constraints.CheckedResult;
import com.github.fabriciofx.cactoos.constraints.Constraints;
import org.cactoos.text.FormattedText;
import org.cactoos.text.JoinedText;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.IsTrue;

public final class ConstraintNameTest {
    @Test
    public void checkIsValidName() {
        new Assertion<>(
            "Can't check if is an valid name",
            () -> new ConstraintName("Fabricio Barros Cabral").checked().ok(),
            new IsTrue()
        ).affirm();
    }

    @Test
    public void checkIsInvalidName() throws Exception {
        final String name = "Fabrici0 Barros Cabral";
        final CheckedResult result = new ConstraintName(name).checked();
        new Assertion<>(
            "Can't check if is an invalid name",
            () -> result.ok(),
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
            ).checked().ok(),
            new IsTrue()
        ).affirm();
    }

    @Test
    public void checkIsUppedInvalidName() throws Exception {
        final String name = "F4BRICIo BARROS CABRAL";
        final CheckedResult result = new Constraints(
            new ConstraintName(name),
            new ConstraintUpped(name)
        ).checked();
        new Assertion<>(
            "Can't check if is an upped invalid name",
            () -> new JoinedText(", ", result.reasons()).asString(),
            new IsEqual<>(
                new FormattedText(
                    "Name %s is invalid, %s is not upped",
                    name,
                    name
                ).asString()
            )
        ).affirm();

    }
}
