package com.atguigu.impl;

import com.atguigu.inter.Calculator;
import com.atguigu.utils.LogUtils;

import java.util.concurrent.Callable;

/**
 * @author ZerlindaLi create at 2020/4/23 13:17
 * @version 1.0.0
 * @description MyMathCalculator
 */
public class MyMathCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
