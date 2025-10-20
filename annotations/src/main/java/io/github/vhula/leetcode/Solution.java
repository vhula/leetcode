package io.github.vhula.leetcode;

public @interface Solution {
    String description() default "";
    TimeComplexity timeComplexity() default TimeComplexity.UNKNOWN;
    SpaceComplexity spaceComplexity() default SpaceComplexity.UNKNOWN;
    Submission submission() default @Submission(runtimeMs = -1, memoryMb = -1.0);
}
