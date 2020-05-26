package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZerlindaLi create at 2020/5/26 15:21
 * @version 1.0.0
 * @description MulService
 */
@Service
public class MulService {
    @Autowired
    private BookService bookService;

    public void mulTx(){
        bookService.checkOut("Tom", "ISBN-001");
        bookService.updatePrice("ISBN-002", 998);
    }
}
