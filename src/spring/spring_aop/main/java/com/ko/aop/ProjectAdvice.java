package com.ko.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Komorebi
 * @date 2022.07.14.13:23
 */

@Component
@Aspect
public class ProjectAdvice {

    //匹配业务层的所有的方法
    @Pointcut("execution(* com.ko.service.*Service.*(..))")
    private void servicePt(){}

    @Around("ProjectAdvice.servicePt()")
    public void runSpeed(ProceedingJoinPoint pjp) throws Throwable {

        //获取执行签名信息
        Signature signature = pjp.getSignature();
        //通过签名获取执行类型（接口名）
        String className = signature.getDeclaringTypeName();
        //通过签名获取执行操作名称（方法名）
        String methodName = signature.getName();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            pjp.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println("万次执行：" + className + "." + methodName + "------>" + (end - start) + "ms");
    }
}
