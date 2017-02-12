package com.dp.mingmi;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by zhangmingmi on 16/10/8.
 */
public class SelectOptimalChoice {
    public List<FlightInfoModify> flightInfoList = new ArrayList<FlightInfoModify>();
    public Map<Date, List<Integer>> dateMappingListId = new HashMap<Date, List<Integer>>();
    public  FlightInfoModify flightInfoModify;

    public SelectOptimalChoice(List<FlightInfoModify> flightInfoList, Map<Date, List<Integer>> dateMappingListId) {
        this.flightInfoList = flightInfoList;
        this.dateMappingListId = dateMappingListId;
    }

    public List<Integer> selectDate(Date date) {
        for (Map.Entry<Date, List<Integer>> entry : dateMappingListId.entrySet()) {
            if (entry.getKey().getTime() == date.getTime()) {
                return entry.getValue();
            }
        }
        return null;
    }

    public List<Integer> selectType(String type,List<Integer> list){
        List<Integer> typeList = new ArrayList<Integer>();
        FlightInfoModify flightInfoModify = new FlightInfoModify();
        for (int i =0;i<list.size();i++){
            flightInfoModify = flightInfoList.get(list.get(i));
            if(flightInfoModify.getType().equals(type)){
                typeList.add(list.get(i));
            }
        }

        return typeList;

    }


    public List<Integer> selectPrice(List<Integer> list){
        List<Integer> priceList = new ArrayList<Integer>();
        FlightInfoModify flightInfoModify = new FlightInfoModify();
        BigInteger price = flightInfoList.get(list.get(0)).getPrice();
        priceList.add(list.get(0));
        for (int i =1;i<list.size();i++){
            flightInfoModify = flightInfoList.get(list.get(i));
            if(flightInfoModify.getPrice().compareTo(price)==-1){
                price = flightInfoModify.getPrice();
                //priceList.clear();
                priceList.removeAll(priceList);
                priceList.add(list.get(i));
            } else if (flightInfoModify.getPrice().compareTo(price)==0){
                priceList.add(list.get(i));
            }
        }
        return priceList;
    }
}
