package com.atguigu.dao;


import com.atguigu.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @author ZerlindaLi create at 2020/4/23 9:43
 * @version 1.0.0
 * @description BookDao
 */
@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("BookDao.....保存图书.....");
    }
}
