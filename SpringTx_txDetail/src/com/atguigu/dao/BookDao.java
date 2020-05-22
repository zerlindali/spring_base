package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ZerlindaLi create at 2020/5/8 17:11
 * @version 1.0.0
 * @description BookDao
 */
@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 1. 减余额
     * 减去某个用户的余额
     */
    public void updateBalance(String userName, int price){

        String sql = "update account set balance = balance - ? where username = ?";

            jdbcTemplate.update(sql, price, userName);

    }

    /**
     * 2. 获取某本图书的价格
     */
    public int getPrice(String isbn) {
        String sql = "select  price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    /**
     * 3. 减去某本数的库存，为了简单起见，每次减1
     */
    public void updateStock(String isbn) {
        String sql = "update book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }
}
