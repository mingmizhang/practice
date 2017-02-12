package com.dp.mingmi;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangmingmi on 16/10/8.
 */
public class DateToString {
    private static final Logger logger = LoggerFactory.getLogger(DateToString.class);
    public static Calendar calendar = new GregorianCalendar();

    public static String changeDateToString(Date dateToString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String changeString;
        changeString = sdf.format(dateToString);
        return changeString;
    }

    public static Date generateRandomDate(Date startDate, Date endDate) {
        long randomDate;
        if (endDate.getTime() < startDate.getTime()) {
            logger.error("The endDate is smaller than startDate ~~~");
            return null;
        } else {
            randomDate = random(startDate.getTime(), endDate.getTime());
        }
        Date date = new Date(randomDate);
        return date;

    }

    public static long random(long start, long end) {
        long randomTime;
        randomTime = start + (long) (Math.random() * (end - start));
        if (randomTime == start || randomTime == end)
            return random(start, end);
        else
            return randomTime;
    }

    public static Date getYesterday(Date date){
        //Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1);
        date=calendar.getTime();
        return date;
    }

    public static Date getTomorrow(Date date){
        //Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);
        date=calendar.getTime();
        return date;
    }

    public static List<Date> splitDate(String dateInput){
        String[] dateArray = StringUtils.split(dateInput,"~");
        List<Date> dateSplitList =  new ArrayList<Date>();
        Date beginDate = StringToDate.changeStringToDate(dateArray[0]);
        Date endDate= StringToDate.changeStringToDate(dateArray[1]);
        if(beginDate.getTime()>endDate.getTime())
            return null;
        else {
            dateSplitList.add(beginDate);
            dateSplitList.add(endDate);
            return dateSplitList;
        }
    }

}
