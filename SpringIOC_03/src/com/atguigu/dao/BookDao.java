package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author ZerlindaLi create at 2020/4/20 10:02
 * @version 1.0.0
 * @description BookDao
 *
 */
@Repository("bookDao")
@Scope(value = "prototype")
public class BookDao {

    @Autowired
    private DataSource dataSource;

    public void saveBook(){
        System.out.println("图书已经保存......");
    }
}
