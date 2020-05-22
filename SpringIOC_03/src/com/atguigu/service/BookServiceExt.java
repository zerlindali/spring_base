package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZerlindaLi create at 2020/4/20 16:52
 * @version 1.0.0
 * @description BookServiceExt
 */
@Service
public class BookServiceExt extends BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void saveBook(){
        System.out.println("BookServiceExt正在帮你调用DAO保存图书......");
        bookDao.saveBook();
    }
}
