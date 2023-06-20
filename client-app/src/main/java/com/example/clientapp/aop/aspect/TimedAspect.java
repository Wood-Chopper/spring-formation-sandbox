package com.example.clientapp.aop.aspect;

import com.example.clientapp.aop.annotation.Timed;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimedAspect {

    //@Pointcut("@annotation(timed)")
    private void timedAnnotation(){}

    @Around("@annotation(timed)")
    public Object timedAspect(ProceedingJoinPoint proceedingJoinPoint, Timed timed) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println(proceedingJoinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
