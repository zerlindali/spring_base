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
 * 如何将这个类(切面类)中的这些方法(通知方法)动态的在目标方法运行的各个位置切入
 */
@Aspect
@Component
@Order(1)
public class LogUtils {

    /**
     * 抽取可重用的切入点表达式：
     * 1. 随便声明一个没有实现的返回void的空方法
     * 2. 给方法上标注 @Pointcut注解
     *
     */
    @Pointcut("execution(public int com.atguigu.inter.Calculator.*(int, *))")
    public void hahaMyPoint(){}

    /**
     * 告诉Spring每个方法都什么时候运行：
     * try{
     *    @Before
     *    method.invoke(obj, args);
     *    @AfterReturning
     * } catch(e) {
     *    @AfterThrowing
     * } finally {
     *    @After
     * }
     *
     *
     * 5个通知注解
     * @Before ：在目标方法之前运行                       前置通知
     * @After : 在目标方法结束之后                        后置通知
     * @AfterReturning : 在目标方法正常返回之后           返回通知
     * @AfterThrowing ： 在目标方法抛出异常之后运行        异常通知
     * @Around : 环绕                                   环绕通知
     */
    // 想在执行目标方法之前运行, 切入点表达式
    // execution(访问权限 返回值类型 方法签名)
    @Before(value = "hahaMyPoint()")
    public static void logStart(JoinPoint joinPoint){
        // 获取到方法参数
        Object args = joinPoint.getArgs();
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【LogUtils前置】【"+name+"】方法开始执行,用的参数列表【"+ Arrays.asList(args)+"】");
    }

    /**
     * @param joinPoint
     * @param result
     * 告诉Spring ,这个result是用来接收返回值的 ：
     * returning = "result";
     *
     */
    // 想在目标方法正常执行完成之后
    @AfterReturning(value = "hahaMyPoint()" ,returning = "result")
    public static void logReturn(JoinPoint joinPoint, Object result){
        // 获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【LogUtils返回】【"+name+"】方法执行完成,计算结果是【"+result+"】");
    }

    /**
     * 细节四：我们可以在通知方法运行的时候，拿到目标方法的详细信息
     * 1) 只需要为通知方法的参数列表上写一个参数
     *      JoinPoint joinPoint ：连接点，封装了当前目标方法的详细信息
     * 2) 告诉Spring哪个参数是用来接收异常
     *      Throwing="exception" : 告诉Spring哪个参数是用来接收异常
     * 3) Exception exception : 指定通知方法可以接收哪些异常
     */
    // 想在目标方法出现异常时执行
    @AfterThrowing(value = "hahaMyPoint()", throwing = "exception")
    public static void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("【LogUtils异常】【"+joinPoint.getSignature().getName()+"】方法执行异常,异常信息是【"+exception+"】。这个异常已经通知测试小组进行排查。");
    }

    /**
     * Spring对通知方法的要求不严格
     * 而唯一有要求的就是方法的参数列表一定不能乱写？
     * 因为通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值。
     * 参数表上的每一个参数，Spring都得知道是什么?
     * JoinPoint：认识
     * 不知道的参数一定要告诉Spring这是什么
     *
     * @param joinPoint
     */
    // 想在目标方法结束的时候执行
    @After("hahaMyPoint()")
    private static void logEnd(JoinPoint joinPoint){
        System.out.println("【LogUtils后置】【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }

    /**
     * @Around : 环绕：是Spring中最强大的通知
     * @Around : 环绕：动态代理：
     *
     * try{
     *    // 前置通知
     *    method.invoke(obj, args);
     *    // 返回通知
     * } catch(e) {
     *    // 异常通知
     * } finally {
     *   // 后置通知
     * }
     *
     * 四合一通知就是环绕通知:
     * 环绕通知中有一个参数：ProceedingJoinPoint pjp
     *
     * 环绕通知：是优先于普通通知执行，执行顺序：
     * [普通前置]
     * {
     *  try{
     *      环绕前置
     *      环绕执行：目标方法执行
     *      环绕返回
     *  }catch(){
     *      环绕出现异常
     *  }finally{
     *      环绕后置
     *  }
     * }
     * [普通后置]
     * [普通方法返回/普通方法异常]
     *
     * 新的顺序：
     *  环绕前置==普通前置==目标方法执行==环绕正常返回/出现异常==环绕后置==普通后置==普通返回或者异常
     */
    @Around(value = "hahaMyPoint()")
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
