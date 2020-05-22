package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ZerlindaLi create at 2020/4/23 13:47
 * @version 1.0.0
 * @description LogUtils
 *
 */
public class LogUtils {

    public void hahaMyPoint(){}


    public static void logStart(JoinPoint joinPoint){
        // 获取到方法参数
        Object args = joinPoint.getArgs();
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【LogUtils前置】【"+name+"】方法开始执行,用的参数列表【"+ Arrays.asList(args)+"】");
    }

    public static void logReturn(JoinPoint joinPoint, Object result){
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【LogUtils返回】【"+name+"】方法执行完成,计算结果是【"+result+"】");
    }

    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("【LogUtils异常】【"+joinPoint.getSignature().getName()+"】方法执行异常,异常信息是【"+exception+"】。这个异常已经通知测试小组进行排查。");
    }

    private static void logEnd(JoinPoint joinPoint){
        System.out.println("【LogUtils后置】【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }

    public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Signature signature = pjp.getSignature();
        Object proceed = null;
        try{
            System.out.println("【环绕前置通知】【"+signature.getName()+"】方法开始");
            // 就是利用反射调用目标方法执行即可,就是method.invoke(obj, args)
            proceed = pjp.proceed(args);
            System.out.println("【环绕返回通知】【"+signature.getName()+"】方法返回，返回值【"+proceed+"】");
        }catch (Exception e){
            System.out.println("【环绕异常通知】【"+signature.getName()+"】方法出现异常，异常信息【"+e+"】");
            // 为了让外界知道这个异常，这个异常一定要跑出去
            throw new RuntimeException(e);
        } finally {
            System.out.println("【环绕后置通知】【"+signature.getName()+"】方法最终结束");
        }

        // 反射调用后的返回值也一定要返回出去
        return proceed;
    }
}
