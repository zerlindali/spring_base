package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZerlindaLi create at 2020/4/20 10:02
 * @version 1.0.0
 * @description BookService
 */
@Service
public class BookService {

    @Resource
    private BookDao bookDao;

    public void saveBook(){
        System.out.println("BookService正在帮你调用DAO保存图书......");
        bookDao.saveBook();
    }
}
