package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RaceAspect {
    @Pointcut
    public void pointCut() {
    }

    @Around("@annotation(org.example.aop.Benchmark)")
    public Object doAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long before = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();
        long after = System.currentTimeMillis();
        System.out.println("Скачки длились: " + (after - before));
        return result;
    }
}
