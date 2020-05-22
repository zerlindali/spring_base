package com.atguigu.bean;

/**
 * @author ZerlindaLi create at 2020/4/16 14:40
 * @version 1.0.0
 * @description AirPlane
 */
public class AirPlane {

    private String fdj; // 发动机
    private String yc; // 机翼长度
    private Integer personNum; // 载客量
    private String jzName; // 机长名字
    private String fjs; // 副驾驶

    @Override
    public String toString() {
        return "AirPlane{" +
            "fdj='" + fdj + '\'' +
                    ", yc='" + yc + '\'' +
                    ", personNum=" + personNum +
                    ", jzName='" + jzName + '\'' +
                    ", fjs='" + fjs + '\'' +
                    '}';
        }

        public String getFdj() {
            return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    public String getFjs() {
        return fjs;
    }

    public void setFjs(String fjs) {
        this.fjs = fjs;
    }
}
