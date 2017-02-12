package com.dp.mingmi;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Date;

public class FlightInfoModify implements Comparable<FlightInfoModify> {
    private static final Logger logger = LoggerFactory.getLogger(FlightInfoModify.class);

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

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    private String name;
    private String phone;
    private String type;
    private BigInteger price;
    private Date startDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private Date endDate;


    public FlightInfoModify() {
    }


    public FlightInfoModify(String name, String phone, String type, BigInteger price) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.price = price;
    }

    public FlightInfoModify(String name, String phone, String type, BigInteger price, String startDate, String endDate) {
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.price = price;
        this.startDate = StringToDate.changeStringToDate(startDate);
        this.endDate = StringToDate.changeStringToDate(endDate);
    }

    public FlightInfoModify(String[] strings) {
        this.name = strings[1];
        this.phone = strings[2];
        this.type = strings[3];
        this.price = new BigInteger(strings[4]);
        String[] dateString = StringUtils.split(strings[5], "~");
        this.startDate = StringToDate.changeStringToDate(dateString[0]);
        this.endDate = StringToDate.changeStringToDate(dateString[1]);
    }

    public int compareTo(FlightInfoModify flightInfoModify) {
        return this.getPrice().compareTo(flightInfoModify.getPrice());
    }

    @Override
    public String toString() {
        return "FlightInfoModify{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", startDate=" + DateToString.changeDateToString(startDate) +
                ", endDate=" + DateToString.changeDateToString(endDate) +
                '}';
    }
}
