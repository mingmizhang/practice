package com.dp.mingmi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangmingmi on 16/10/8.
 */
public class StringToDate {

    public static Date changeStringToDate(String stringToDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date changeDate = null;
        try{
            changeDate = sdf.parse(stringToDate);
        }catch (ParseException p){
            p.printStackTrace();

        }finally {
            return changeDate;
        }
    }
}
