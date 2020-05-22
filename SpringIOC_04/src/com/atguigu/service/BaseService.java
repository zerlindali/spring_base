package com.atguigu.service;

import com.atguigu.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZerlindaLi create at 2020/4/23 9:56
 * @version 1.0.0
 * @description BaseService
 */
public class BaseService<T> {

    @Autowired
    BaseDao<T> baseDao;

    public void save(){
        System.out.println("自动注入的dao....."+baseDao);
        baseDao.save();
    }
}
