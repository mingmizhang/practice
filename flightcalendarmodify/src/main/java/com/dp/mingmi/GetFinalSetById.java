package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 16/10/8.
 */
public class GetFinalSetById {
    private static final Logger logger = LoggerFactory.getLogger(GetFinalSetById.class);
    public ReadFlightFileToList readFlightFileToList;
    public List<FlightInfoModify> flightInfoList = new ArrayList();

    public GetFinalSetById(String filePath) {
        this.readFlightFileToList = new ReadFlightFileToList(filePath);
        flightInfoList = readFlightFileToList.readFileInfoToList();
    }

    public BigInteger findPriceByIdFromList(int id) {
        FlightInfoModify flightInfoModify;
        flightInfoModify = flightInfoList.get(id);
        BigInteger price = flightInfoModify.getPrice();
        logger.info("The index ", id, "is", price);
        return price;
    }

    public static void main(String[] args) {
        GetFinalSetById readDateInfoToMap = new GetFinalSetById("/Users/zhangmingmi/Desktop/test/flightest.txt");
        BigInteger price1 = readDateInfoToMap.findPriceByIdFromList(1);;
        BigInteger price10 = readDateInfoToMap.findPriceByIdFromList(10);
        logger.info("The GetFinalSetById test end !!!");
    }
}
