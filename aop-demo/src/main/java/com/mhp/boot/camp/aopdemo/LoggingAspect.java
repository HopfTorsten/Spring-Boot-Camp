package com.mhp.boot.camp.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = Logger.getGlobal();

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RestController)")
    private void log() {
    }

    @Around("@annotation(PerformanceLogging)")
    public void logIt(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = new Date().getTime();
        System.out.println("Calling " + joinPoint.getSignature().toLongString());
        joinPoint.proceed();

        long end = new Date().getTime();
        System.out.println("Finished the call in " + (end - start) + "ms");
    }

}
