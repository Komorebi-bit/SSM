package com.ko.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Komorebi
 * @date 2022.07.14.15:54
 *
 * 获取切入点方法参数 前置，后置，环绕，返回后，抛出异常后通知
 * 获取切入点方法返回值  返回后通知，环绕通知
 * 获取切入点方法运行异常信息  抛出异常后通知，环绕通知
 *
 * trim() 方法去掉字符串前后的空格
 */

@Component
@Aspect
public class MyAdvice2 {
    //设置切入点，要求配置在方法上方

    @Pointcut("execution(* com.ko.dao.BrandDao.findName(..))")
    public void pt(){}


    //设置在切入点pt()的前面运行当前操作（前置通知）

    // @Before("pt()")
    public void before(JoinPoint jp){
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("before advice ...");
    }

    // @After("pt()")
    public void after(JoinPoint jp){
        Object[] args = jp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("after advice ...");
    }

    // @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        args[0]=200;
        // System.out.println("around before advice ...");
        //表示对原始操作的调用
        Object ret = null;
        try {
            ret = pjp.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
            //就可以拿到异常信息了
        }
        // System.out.println("around after advice ...");
        return ret;
    }

    //获取返回值
    //若有JoinPoint参数，必须放到第一位
    // @AfterReturning(value = "pt()",returning = "ret")
    public void afterReturning(JoinPoint jp,Object ret){
        System.out.println("afterReturning advice ..."+ret);
    }

    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Throwable t){
        System.out.println("afterThrowing advice ..." + t);
    }

}
