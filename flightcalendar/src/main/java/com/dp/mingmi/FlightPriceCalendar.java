package com.dp.mingmi;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 16/9/28.
 */
public class FlightPriceCalendar {
    private String flightPath;
    private static final Logger logger = LoggerFactory.getLogger(FlightPriceCalendar.class);

    public FlightPriceCalendar(String flightPath) {
        this.flightPath = flightPath;
    }

    private File openFilghtfile() {
        File file = new File(flightPath);
        if (!file.exists()) {
            logger.error("the" + flightPath + "is not exist~");
            System.exit(0);
        }
        return file;
    }

    private List<FlightInfo> readFlightFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<FlightInfo> list = new ArrayList<FlightInfo>();
        String str = bufferedReader.readLine();
        while ((str = bufferedReader.readLine()) != null) {
            String[] flightValue = StringUtils.split(str,"\t");
            FlightInfo flightInfo =  new FlightInfo(flightValue);
            list.add(flightInfo);
        }
        return list;
    }

    public List<FlightInfo> saveFlightFileToList() throws IOException {
        FlightPriceCalendar flightPriceCalendar = new FlightPriceCalendar(flightPath);
        List<FlightInfo> list = Lists.newArrayList();
        File file = openFilghtfile();
        list =  flightPriceCalendar.readFlightFile(file);
        return list;
    }


}
