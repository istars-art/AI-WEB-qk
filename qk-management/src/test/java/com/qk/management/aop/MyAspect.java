package com.qk.management.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 33465
 * @created 2026.4.28 下午6:00
 * @desciption
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut(value = "@annotation(com.qk.management.aop.anno.Remark)")
    public void pt(){
    }


    @Around("pt()")
    public Object timeAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("开始计时");
        long start = System.currentTimeMillis();

        Object proceed = pjp.proceed();

        System.out.println("结束计时");
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));

        return proceed;

    }
}
   