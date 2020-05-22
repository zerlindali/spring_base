package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ZerlindaLi create at 2020/4/26 17:37
 * @version 1.0.0
 * @description ValidateApsect
 */
@Aspect
@Component
@Order(2)
public class ValidateAspect {

    @Before("com.atguigu.utils.LogUtils.hahaMyPoint()")
    public static void logStart(JoinPoint joinPoint){
        // 获取到方法参数
        Object args = joinPoint.getArgs();
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【ValidateApsect前置】【"+name+"】方法开始执行,用的参数列表【"+ Arrays.asList(args)+"】");
    }

    @AfterReturning(value = "com.atguigu.utils.LogUtils.hahaMyPoint()", returning="result")
    public static void logReturn(JoinPoint joinPoint, Object result){
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【ValidateApsect返回】【"+name+"】方法执行完成,计算结果是【"+result+"】");
    }

    @AfterThrowing(value = "com.atguigu.utils.LogUtils.hahaMyPoint()", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("【ValidateApsect异常】【"+joinPoint.getSignature().getName()+"】方法执行异常,异常信息是【"+exception+"】。这个异常已经通知测试小组进行排查。");
    }

    @After("com.atguigu.utils.LogUtils.hahaMyPoint()")
    private static void logEnd(JoinPoint joinPoint){
        System.out.println("【ValidateApsect后置】【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }

}
