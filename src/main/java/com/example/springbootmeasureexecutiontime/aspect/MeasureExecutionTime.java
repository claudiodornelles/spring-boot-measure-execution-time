package com.example.springbootmeasureexecutiontime.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used for logging method's execution time.
 * @see MeasureExecutionTimeAspect
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MeasureExecutionTime {

}
