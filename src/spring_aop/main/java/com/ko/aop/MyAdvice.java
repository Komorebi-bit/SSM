package com.ko.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Komorebi
 * @date 2022.07.12.17:12
 */

//通知类必须配置成Spring管理的bea
@Component
//设置当前类为切面类
@Aspect
public class MyAdvice {
    /**
     * 切点表达式标准格式：动作关键字(访问修饰符 返回值 包名.类/接口名.方法名(参数) 异常名)
     * 通配符
     *      * 单个独立的任意字符
     *      .. 多个连续的任意字符
     *      + 专用于匹配子类类型
     * 书写技巧
     * 所有代码按照标准规范开发，否则以下技巧全部失效
     * 描述切入点通常描述接口，而不描述实现类
     * 访问控制修饰符针对接口开发均采用public描述（可省略访问控制修饰符描述)
     * 返回值类型对于增删改类使用精准类型加速匹配，对于查询类使用*通配快速描述
     * 包名书写尽量不使用..匹配，效率过低，常用*做单个包描述匹配，或精准匹配
     * 接口名/类名书写名称与模块相关的采用*匹配，例如UserService书写成*Service，绑定业务层接口名
     * 方法名书写以动词进行精准匹配，名词采用*匹配，例如getByld书写成getBy*,selectAll书写成selectAll
     * 参数规则较为复杂，根据业务方法灵活调整
     * 通常不使用异常作为匹配规则
     */

    //设置切入点，要求配置在方法上方

    @Pointcut("execution(void com.ko.dao.BrandDao.update())")
    // @Pointcut("execution(* com.ko.dao.BrandDao.update())")
    // @Pointcut("execution(* com.ko.dao.BrandDao.update(*))") //no
    // @Pointcut("execution(void com.*.*.*.update())")
    // @Pointcut("execution(void *..update())")
    // @Pointcut("execution(* *..*(..))")  //匹配所有的
    // @Pointcut("execution(* *..u*(..))")
    // @Pointcut("execution(* *..*e(..))")
    // @Pointcut("execution(void com..*())") //从后往前看
    // @Pointcut("execution(* com.ko.*.*Service.find*(..))")
    public void pt(){}

    @Pointcut("execution(int com.ko.dao.BrandDao.select())")
    public void pt2(){}
    //设置在切入点pt()的前面运行当前操作（前置通知）
    //@Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }

    // @Before("pt()")
    public void before(){
        System.out.println("before advice ...");
    }

    // @After("pt()")
    public void after(){
        System.out.println("after advice ...");
    }

    // @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before advice ...");
        //表示对原始操作的调用
        Object ret = pjp.proceed();
        System.out.println("around after advice ...");
        // System.out.println(ret);
        return ret;
    }

    @Around("pt2()")
    public Object aroundSelect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundSelect before advice ...");
        //表示对原始操作的调用
        Object ret = pjp.proceed();
        System.out.println("aroundSelect after advice ...");
        return ret;
    }

    // @AfterReturning("pt2()")
    public void afterReturning(){
        System.out.println("afterReturning advice ...");
    }

    // @AfterThrowing("pt2()")
    public void afterThrowing(){
        System.out.println("afterThrowing advice ...");
    }

}
