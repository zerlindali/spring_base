package com.atguigu.inter;

/**
 * @author ZerlindaLi create at 2020/4/23 13:15
 * @version 1.0.0
 * @description Calculator
 *
 * 接口不加在容器中：
 * 实际上可以加，加了也不创建对象，只要一看这个组件是一个接口，
 * 相当于告诉Spring，ioc容器中可能有这种类型的组件
 */
public interface Calculator {

    public int add(int i, int j);

    public int sub(int i, int j);

    public int mul(int i, int j);

    public int div(int i, int j);
}
