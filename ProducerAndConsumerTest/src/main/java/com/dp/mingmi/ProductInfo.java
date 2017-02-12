package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class ProductInfo {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductInfo(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ProductInfo() {
    }
}
