package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZerlindaLi create at 2020/5/25 13:51
 * @version 1.0.0
 * @description MulService
 */
@Service
public class MulService {

    @Autowired
    private  BookService bookService;

    @Transactional
    public void mulTx(){
        // 都是可以设置的；
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务（使用同一条连接）；
        bookService.checkOut("Tom", "ISBN-001");
        bookService.updatePrice("ISBN-002", 998);
    }

    @Transactional
    public void mulTx2(){
        // 都是可以设置的；
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务（使用同一条连接）；
        // REQUIRED_NEW
        bookService.checkOut("Tom", "ISBN-001");
        // REQUIRED
        bookService.updatePrice("ISBN-002", 998);
    }

    @Transactional
    public void mulTx3(){
        // 都是可以设置的；
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务（使用同一条连接）；
        // REQUIRED_NEW
        bookService.checkOut3("Tom", "ISBN-001");
        // REQUIRED_NEW
        bookService.updatePrice3("ISBN-002", 998);
        // 前面两个事务都与mulTx3开启的事务无关，mulTx3报错，前面两个事务不会回滚
        int i = 10/0;
    }

    @Transactional
    public void mulTx5(){
        // 都是可以设置的；
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务（使用同一条连接）；
        // REQUIRES
        bookService.checkOut5("Tom", "ISBN-001");
        // REQUIRES
        bookService.updatePrice5("ISBN-002", 998);
        // 兄得，都是同一条船上的蚂蚱。mulTx3报错，前面两个事务也会回滚
        int i = 10/0;
    }

    /**
     * 如果是REQUIRED:事务的属性都是继承于大事务的；
     * 而propagation=Propagation.REQUIRES_NEW可以调整
     * 默认：REQUIRED.
     *
     * REQUIRED: 将之前事务用的connection传递给这个方法使用：
     * REQUIRES_NEW: 这个方法直接使用新的connection:
     */
    @Transactional(timeout = 3)
    public void mulTx6(){
        // 都是可以设置的；
        // 传播行为来设置这个事务方法是不是和之前的大事务共享一个事务（使用同一条连接）；
        // REQUIRED 在子事务里面的timeout不起作用
        bookService.checkOut6("Tom", "ISBN-001");
        // REQUIRED
        bookService.updatePrice5("ISBN-002", 998);
        // 兄得，都是同一条船上的蚂蚱。mulTx3报错，前面两个事务也会回滚
    }
}

