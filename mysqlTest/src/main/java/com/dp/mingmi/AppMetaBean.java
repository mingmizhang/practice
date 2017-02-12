package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/1/20.
 */
public class AppMetaBean {
    private String appName;
    private String bu;
    private int id;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppMetaBean{" +
                "appName='" + appName + '\'' +
                ", bu='" + bu + '\'' +
                ", id=" + id +
                '}';
    }
}
