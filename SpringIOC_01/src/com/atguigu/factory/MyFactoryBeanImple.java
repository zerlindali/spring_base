package com.atguigu.factory;

import com.atguigu.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * @author ZerlindaLi create at 2020/4/16 15:55
 * @version 1.0.0
 * @description
 * 实现了FactoryBean接口的类是Spring可以识别的工厂类
 * Spring 会自动调用工厂方法 实现实例
 *
 * 1. 编写FactoryBean的实现类
 * 2. 在spring配置文件中进行注册
 */
public class MyFactoryBeanImple implements FactoryBean<Book> {

    /**
     * getObject:工厂方法：
     *      返回创建的对象
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImple帮你创建对象....");
        Book bk = new Book();
        bk.setBookName(UUID.randomUUID().toString());
        return bk;
    }

    /**
     * getObjectType 返回创建的对象的类型
     * Spring会自动调用这个方法，来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是单例吗
     * false: 不是单例
     *  true: 是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
