package com.example.practice21;

import com.example.practice21.services.EmailService;
import com.example.practice21.tables.Gameable;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Autowired
    private EmailService emailService;

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


    @Pointcut("within(com.example.practice21.services.*)")
    public void allServiceMethods() {
    }

    @After("saveMethods()")
    public void sendEmail(JoinPoint joinPoint){
        Gameable item = (Gameable) joinPoint.getArgs()[0];
        log.info("Sending email, item {id = " + item.getId() + ", name = " + item.getName() + "} inserted");
        emailService.sendEmail(item);
    }


    @Pointcut("execution(* com.example.practice21.services.*.save(..))")
    public void saveMethods(){
    }
}
