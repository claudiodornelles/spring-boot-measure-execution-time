package com.example.springbootmeasureexecutiontime.aspect;

import java.time.Duration;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging methods execution time.
 */
@Slf4j
@Aspect
@Component
public class MeasureExecutionTimeAspect {

    /**
     * Advice that logs the execution time of methods annotated with @MeasureExecutionTime.
     *
     * @param proceedingJoinPoint The join point representing the intercepted method.
     * @return The result of the method call.
     * @throws Throwable If an error occurs during method invocation.
     */
    @Around("@annotation(MeasureExecutionTime)")
    public Object measureExecutionTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Instant start = Instant.now();
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.debug("Method {}.{} execution failed within {} ms",
                      proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                      proceedingJoinPoint.getSignature().getName(),
                      Duration.between(start, Instant.now()).toMillis(),
                      throwable);
            throw throwable;
        } finally {
            log.debug("Method {}.{} took {} ms to execute",
                      proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                      proceedingJoinPoint.getSignature().getName(),
                      Duration.between(start, Instant.now()).toMillis());
        }
    }

}