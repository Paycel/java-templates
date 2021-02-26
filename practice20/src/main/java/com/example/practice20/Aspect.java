package com.example.practice20;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Around("allServiceMethods()")
    public Object logParamsAndTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("Method: " + joinPoint.getSignature().getName() + " from " + joinPoint.getTarget().getClass() +
                ", Time: " + time + " ms, Parameters: " + Arrays.toString(joinPoint.getArgs()));
        return result;
    }


    @Pointcut("within(com.example.practice20.services.*)")
    public void allServiceMethods() {
    }
}
