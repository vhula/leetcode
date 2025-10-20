package io.github.vhula.leetcode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Problem {

    String name();

    String leetcodeUrl();

    Topic[] topics();

    ProblemComplexity complexity();

}
