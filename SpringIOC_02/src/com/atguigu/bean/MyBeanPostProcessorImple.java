package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ZerlindaLi create at 2020/4/17 9:47
 * @version 1.0.0
 * @description MyBeanPostProcessorImple
 *
 * 1. 编写后置处理器的实现类
 * 2. 将后置处理器注册在配置文件中
 */
public class MyBeanPostProcessorImple implements BeanPostProcessor {

    /**
     * 初始化之前调用
     * @param bean
     * @param beanName
     * @return bean 返回传入的bean
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【"+beanName+"】Bean将要调用初始化方法了...这个bean是这样的【"+bean+"】");
        // 返回传入的bean
        return bean;
    }

    /**
     * 初始化方法之后调用
     * @param bean
     * @param beanName: bean在xml中配置的id
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【"+beanName+"】Bean初始化方法调用完了...这个bean是这样的【"+bean+"】");
        // 返回传入的bean
        return bean;
    }
}
