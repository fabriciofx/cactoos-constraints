package com.github.fabriciofx.cactoos.constraints.data;

import org.hamcrest.core.IsNot;
import org.junit.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.IsTrue;

public final class ConstraintCpfTest {

    @Test
    public void cpfWithAllSameNumbersIsInvalid() {
        new Assertion<>(
            "Can't check is a CPF with all same numbers is invalid",
            () -> new ConstraintCpf("11111111111").evaluation().success(),
            new IsNot<>(
                new IsTrue()
            )
        ).affirm();
    }

    @Test
    public void cpfIsValid() {
        new Assertion<>(
            "Can't check is a CPF with all same numbers is invalid",
            () -> new ConstraintCpf("57527294833").evaluation().success(),
            new IsTrue()
        ).affirm();
    }
}
