package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by zhangmingmi on 16/10/8.
 */
public class DateMappingId {
    private static final Logger logger = LoggerFactory.getLogger(DateMappingId.class);
    public ReadFlightFileToList readFlightFileToList;
    public List<FlightInfoModify> flightInfoList = new ArrayList<FlightInfoModify>();
    public Map<Date, List<Integer>> dateMappingListId = new HashMap<Date, List<Integer>>();

    public DateMappingId(String filePath, String beginDate, String endDate) {
        this.readFlightFileToList = new ReadFlightFileToList(filePath);
        flightInfoList = readFlightFileToList.readFileInfoToList();
        dateMappingListId = initDateMap(StringToDate.changeStringToDate(beginDate), StringToDate.changeStringToDate(endDate));
    }

    public Map<Date, List<Integer>> getDateMappingListId() {
        return dateMappingListId;
    }

    public Map<Date, List<Integer>> initDateMap(Date beginDate, Date endDate) {
        Map<Date, List<Integer>> dateMapping = new HashMap<Date, List<Integer>>();
        for (Date date = beginDate; date.getTime() < endDate.getTime(); date = DateToString.getTomorrow(date)) {
            dateMapping.put(date, null);
        }
        return dateMapping;
    }

    public Map<Date, List<Integer>> readListToDateMappingId() {
        Date date;
        for (Map.Entry<Date, List<Integer>> entry : dateMappingListId.entrySet()) {
            date = entry.getKey();
            List<Integer> dateId = new ArrayList<Integer>();
            for (int id = 0; id < flightInfoList.size(); id++) {
                if (dateFitFlightRecord(date, id))
                    dateId.add(id);
            }
            dateMappingListId.put(date, dateId);
        }
        return dateMappingListId;

    }

    public boolean dateFitFlightRecord(Date date, int id) {
        FlightInfoModify flightInfoModify = flightInfoList.get(id);
        if (flightInfoModify.getStartDate().getTime() <= date.getTime() && flightInfoModify.getEndDate().getTime() >= date.getTime()) {
            return true;
        } else {
            return false;
        }
    }


    public List<Integer> getOptimalChoice(SelectOptimalChoice selectOptimalChoice,String dateInput,String typeInput){

        List<Integer> dateList = selectOptimalChoice.selectDate(StringToDate.changeStringToDate(dateInput));
        List<Integer> typeList = selectOptimalChoice.selectType(typeInput, dateList);
        List<Integer> priceList = selectOptimalChoice.selectPrice(typeList);
        return priceList;
    }


    public static void main(String[] args) {
        DateMappingId dateMappingId = new DateMappingId("/Users/zhangmingmi/Desktop/test/flightest.txt", "2016-09-07", "2016-10-08");
        Map<Date, List<Integer>> dateMappingListId = new HashMap<Date, List<Integer>>();
        dateMappingListId = dateMappingId.readListToDateMappingId();
        SelectOptimalChoice selectOptimalChoice = new SelectOptimalChoice(dateMappingId.flightInfoList, dateMappingListId);
        ReadInputFromKeyboard readInputFromKeyboard = new ReadInputFromKeyboard();
        logger.info("Please input the date you want to choose (例: 2016-10-05 或 2016-10-05~2016-10-09) ~~");
        String dateInput = readInputFromKeyboard.readLineFromKeyboard();
        logger.info("Please input the type you want to choose (例:上海0 上海1 上海2)~~");
        String typeInput = readInputFromKeyboard.readLineFromKeyboard();
        if (!dateInput.contains("~")) {
            List<Integer> priceList = dateMappingId.getOptimalChoice(selectOptimalChoice,dateInput,typeInput);
            for (int i = 0; i < priceList.size(); i++) {
                //logger.info("The optimal id is " + priceList.get(i));
                logger.info("The optimal id is {}",priceList.get(i));
                logger.info("The name is " + dateMappingId.flightInfoList.get(priceList.get(i)));
            }
        } else {
            List<Date> dateInputSplit = new ArrayList<Date>();
            dateInputSplit = DateToString.splitDate(dateInput);
            Date beginInputDate = dateInputSplit.get(0);
            Date endInputDate = dateInputSplit.get(1);
            for(Date date=beginInputDate;date.getTime()<=endInputDate.getTime();date=DateToString.getTomorrow(date)){
                logger.info("find date: "+date);
                List<Integer> priceList = dateMappingId.getOptimalChoice(selectOptimalChoice, dateInput, typeInput);
                for (int i = 0; i < priceList.size(); i++) {
                    logger.info("the optimal id is " + priceList.get(i));
                    logger.info("The name is " + dateMappingId.flightInfoList.get(priceList.get(i)));
                }
            }
        }
    }



}
