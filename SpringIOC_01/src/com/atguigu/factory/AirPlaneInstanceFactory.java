package com.atguigu.factory;

import com.atguigu.bean.AirPlane;

/**
 * @author ZerlindaLi create at 2020/4/16 14:49
 * @version 1.0.0
 * @description 实例工厂
 */
public class AirPlaneInstanceFactory {

    // new AirPlaneInstanceFactory().getAirPlane("jzName");
    public AirPlane getAirPlane(String jzName) {
        System.out.println("AirPlaneInstanceFactory正在为您造飞机.....");
        AirPlane ap = new AirPlane();
        ap.setFdj("太行");
        ap.setFjs("李程");
        ap.setPersonNum(300);
        ap.setYc("198.98m");
        ap.setJzName(jzName);
        return ap;
    }
}
