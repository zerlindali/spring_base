package com.atguigu.bean;

/**
 * @author ZerlindaLi create at 2020/4/10 14:36
 * @version 1.0.0
 * @description Car
 */
public class Car {

    private String carName;
    private Integer price;
    private String color;

    public Car() {
        super();
        System.out.println("Car被创建......");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
