package com.atguigu.proxy;

import com.atguigu.inter.Calculator;
import com.atguigu.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZerlindaLi create at 2020/4/23 14:09
 * @version 1.0.0
 * @description CalculatorProxy
 *
 * 帮Calculator.java生成代理对象
 */
public class CalculatorProxy {

    /**
     * 为传入的参数对象创建一个动态代理对象
     * @param calculator
     * @return
     *
     * Calculator calculator: 被代理对象：(宝宝)
     * 返回的：宋喆
     */
    public static Calculator getProxy(final Calculator calculator){
        // 方法执行器，帮我们目标对象执行目标方法
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象：给JDK使用，任何时候都不要动这个对象
             * @param method 当前将要执行的目标对象的方法
             * @param args 这个方法调用时，外界传入的参数值
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    // 利用反射执行目标方法
                    // 目标方法执行后的返回值
                    LogUtils.logStart(method, args);
                    result = method.invoke(calculator,args);
                    LogUtils.logReturn(method,result);
                } catch (Exception e) {
                    LogUtils.logException(method,e);
                } finally {
                    LogUtils.logEnd(method);
                }

                // 返回值必须返回出去，外界才能拿到真正执行后的返回值
                return result;
            }
        };
        // 实现了哪些接口
        Class<?> [] interfaces = calculator.getClass().getInterfaces();
        // 类加载器
        ClassLoader loader = calculator.getClass().getClassLoader();

        // Proxy为目标对象创建代理对象；

        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
