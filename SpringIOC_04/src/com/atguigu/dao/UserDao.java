package com.atguigu.dao;


import com.atguigu.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZerlindaLi create at 2020/4/23 9:43
 * @version 1.0.0
 * @description UserDao
 */
@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("UserDao.....保存用户....");
    }
}
