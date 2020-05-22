package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZerlindaLi create at 2020/5/20 10:41
 * @version 1.0.0
 * @description BookService
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * 结账
     * @param username
     * @param isbn
     */
//    @Transactional
    public void checkOut(String username, String isbn){
        int price = bookDao.getPrice(isbn);
        // 减库存
        bookDao.updateStock(isbn);
        // 减余额
        bookDao.updateBalance(username,price);
        System.out.println("结账完成...");
    }
}
