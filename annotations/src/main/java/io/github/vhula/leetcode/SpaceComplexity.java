package io.github.vhula.leetcode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SpaceComplexity {
    Complexity value() default Complexity.CUSTOM;

    String customValue() default "";

    String details() default "";
}
