package io.github.vhula.leetcode;

public @interface Submission {
    int runtimeMs() default -1;
    double memoryMb() default -1;
    boolean failed() default false;
    String failureReason() default "";
}
