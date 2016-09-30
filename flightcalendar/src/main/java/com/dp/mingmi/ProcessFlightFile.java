package com.dp.mingmi;

import com.dp.mingmi.calculatortest.ReadFromScreen;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangmingmi on 16/9/28.
 */
public class ProcessFlightFile {
    private FlightPriceCalendar flightPriceCalendar;
    private List<FlightInfo> list = Lists.newArrayList();
    private static final Logger logger = LoggerFactory.getLogger(ProcessFlightFile.class);
    private Map<Integer, Integer> monthDays = new HashMap<Integer, Integer>();


    public ProcessFlightFile(FlightPriceCalendar flightPriceCalendar) throws IOException {
        this.flightPriceCalendar = flightPriceCalendar;
        this.list = flightPriceCalendar.saveFlightFileToList();
    }

    public List<FlightInfo> getList() {
        return list;
    }

    public List<FlightInfo> dateAvailable(String string, List<FlightInfo> list) {
        int inputDate = Integer.valueOf(string);
        List<FlightInfo> dateAvailableList = Lists.newArrayList();
        String value;
        String beforeDate;
        String afterDate;
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                value = list.get(i).getDate();
                if (value.contains("~")) {
                    beforeDate = StringUtils.split(value, "~")[0];
                    afterDate = StringUtils.split(value, "~")[1];

                } else {
                    beforeDate = value;
                    afterDate = value;
                }

                if (inputDate < Integer.valueOf(beforeDate) || inputDate > Integer.valueOf(afterDate)) {
                    continue;
                } else {
                    dateAvailableList.add(list.get(i));
                }
            }

        } else {
            logger.info("the list is null,cannot excute dateAvailable~~~");
        }

        return dateAvailableList;
    }

    public List<FlightInfo> typeAvailable(String string, List<FlightInfo> list) {
        String value;
        List<FlightInfo> typeAvailableList = Lists.newArrayList();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                value = list.get(i).getType();
                if (!string.equals(value)) {
                    continue;
                } else {
                    typeAvailableList.add(list.get(i));
                }
            }
        } else {
            logger.info("the list is null,cannot excute typeAvailable~~~");

        }
        return typeAvailableList;
    }


    private List<FlightInfo> selectOptimal(List<FlightInfo> list) {
        List<FlightInfo> smallLeast = Lists.newArrayList();
        Collections.sort(list);
        smallLeast.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(0).compareTo(list.get(i)) == 0)
                smallLeast.add(list.get(1));
            else
                break;
        }
        return smallLeast;
    }

    public List<FlightInfo> optimalPriceAvailable(String date, List<FlightInfo> list) {
        if (!list.isEmpty()) {
            List<FlightInfo> priceOptimalList = selectOptimal(list);
            System.out.println(date + ":");
            for (int i = 0; i < priceOptimalList.size(); i++) {
                System.out.println(priceOptimalList.get(i));
            }
            return priceOptimalList;
        } else {
            logger.info("date" + date + "list is null,there is no choice for your date~~~");
            return null;
        }
    }


    public static void main(String[] args) throws IOException {
        ProcessFlightFile processFlightFile = new ProcessFlightFile(new FlightPriceCalendar("/Users/zhangmingmi/Desktop/test/flightest.txt"));
        System.out.println("What the type you want to select?");
        ReadFromScreen readScreen = new ReadFromScreen();
        String type = readScreen.readlinefromscreen();
        List<FlightInfo> typeAvailableList = processFlightFile.typeAvailable(type, processFlightFile.getList());
        if (typeAvailableList.isEmpty()) {
            logger.info("Don't contains the type, there is no choice provided for your type~~~");
            System.exit(0);
        }else {
            System.out.println("What the date you want to select?");
            String date = readScreen.readlinefromscreen();
            List<String> dateResolveValue = new DateProcess(date).resolveDate();
            for (int i = 0; i < dateResolveValue.size(); i++) {
                List<FlightInfo> dateAvailableList = processFlightFile.dateAvailable(dateResolveValue.get(i), typeAvailableList);
                if(!dateAvailableList.isEmpty()){
                    List<FlightInfo> priceOptimalList = processFlightFile.optimalPriceAvailable(dateResolveValue.get(i), dateAvailableList);
                } else{
                    logger.info("Don't contains the date, there is no choice provided for your date~~~");
                }
            }
        }
    }
}
