package com.atguigu.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author ZerlindaLi create at 2020/4/10 9:50
 * @version 1.0.0
 * @description Person
 */
public class Person {

    // 基本类型，直接使用property
    // <property name="lastName" value="Lee"></property> 自动进行类型转换
    private String lastName;
    private Integer age;
    private String email;
    private String gender;
    private Double salary;

    private Car car;

    private List<Book> books;

    private Map<String, Object> maps;

    private Properties properties;

    public Person() {
        super();
        System.out.println("Person 创建了...");
    }

    public Person(Car car) {
        this.car = car;
        System.out.println("可以为car赋值的有参构造器.....");
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("setLastName....."+lastName);
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
