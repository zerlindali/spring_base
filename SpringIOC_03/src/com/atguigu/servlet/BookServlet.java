package com.atguigu.servlet;

import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author ZerlindaLi create at 2020/4/20 10:01
 * @version 1.0.0
 * @description BookServlet
 *
 * 属性的自动注解
 *  @Autowired : Spring会自动的为这个属性赋值；
 *               一定是去容器中找到这个属性对应的组件
 */
@Controller
public class BookServlet {

    /**
     * 自动装配，自动的为这个属性赋值
     * @Qualifier 指定一个名作为id,让spring别使用变量名作为id
     */
    @Qualifier("bookServiceExt")
    @Autowired(required = false)
    private BookService bookServiceExt2;

    public void doGet(){
        System.out.println(bookServiceExt2);
        bookServiceExt2.saveBook();
    }

    /**
     * 方法上有Autowired的话：
     * 1) 这个方法也会在所属的bean创建的时候，自动运行
     * 2) 这个方法上的每条数据都会自动注入值
     * @param bookDao
     */
    @Autowired(required = false)
    public void AutowiredForParam(BookDao bookDao, @Qualifier("bookServiceExt") BookService bookService){
        System.out.println("Spring 运行了这个方法...."+bookDao +"   " + bookService);
        System.out.println("bookService...."+bookService);
        System.out.println("bookServiceExt2...."+bookServiceExt2);
    }
}
