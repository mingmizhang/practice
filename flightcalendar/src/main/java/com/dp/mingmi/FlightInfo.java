package com.dp.mingmi;

/**
 * Created by zhangmingmi on 16/9/28.
 */
public class FlightInfo implements Comparable<FlightInfo> {
    private String name;
    private String phone;
    private String type;
    private double price;
    private String date;

    public FlightInfo() {
    }


    public FlightInfo(String[] flightValue) {
        this.name = flightValue[0];
        this.phone = flightValue[1];
        this.type = flightValue[2];
        this.price = Double.valueOf(flightValue[3]);
        this.date = flightValue[4];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int compareTo(FlightInfo flightInfo) {
        return Double.valueOf(this.getPrice()).compareTo(flightInfo.getPrice());
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
