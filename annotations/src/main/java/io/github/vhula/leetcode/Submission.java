package io.github.vhula.leetcode;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Submission {
  int runtimeMs() default -1;

  double memoryMb() default -1;

  boolean failed() default false;

  String failureReason() default "";
}
