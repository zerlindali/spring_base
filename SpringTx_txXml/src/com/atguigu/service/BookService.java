package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZerlindaLi create at 2020/5/22 10:21
 * @version 1.0.0
 * @description BookService
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;


    public void checkOut(String username, String isbn) {
        Integer price = bookDao.getPrice(isbn);
        // 减库存
        bookDao.updateStock(isbn);
        // 减余额
        bookDao.updateBalance(username, price);
    }

    /**
     * 根据业务特性，进行调整
     * @param isbn
     * @return
     */
    public int getPrice(String isbn){
        return bookDao.getPrice(isbn);

    }

    public void updatePrice(String isbn, int price){
        bookDao.updatePrice(isbn, price);
        int i = 1/0;
    }

    public void mulTx(){
        checkOut("Tom", "ISBN-001");
        updatePrice("ISBN-002", 998);

    }

}
