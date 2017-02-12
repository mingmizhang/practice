package com.dp.mingmi;

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
 * Created by zhangmingmi on 16/10/8.
 */
public class ReadFlightFileToList {
    private static final Logger logger = LoggerFactory.getLogger(ReadFlightFileToList.class);
    private String filePath;

    public ReadFlightFileToList(String filePath) {
        this.filePath = filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private File openFilghtfile() {
        File file = new File(filePath);
        if (!file.exists()) {
            logger.error("the" + filePath + "is not exist~");
            System.exit(0);
        }
        return file;
    }

    public List<FlightInfoModify> readFileInfoToList() {
        List<FlightInfoModify> list = new ArrayList<FlightInfoModify>();
        try {
            File file = openFilghtfile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] flightValue = StringUtils.split(str, "\t");
                FlightInfoModify flightInfoModify = new FlightInfoModify(flightValue);
                list.add(flightInfoModify);
            }
        }catch(IOException e){
            e.printStackTrace();

        }
        return list;
    }


    public static void main(String[] args) throws IOException {
        ReadFlightFileToList readToMem = new ReadFlightFileToList("/Users/zhangmingmi/Desktop/test/flightest.txt");
        List<FlightInfoModify> flightInfoList = new ArrayList<FlightInfoModify>();
        flightInfoList = readToMem.readFileInfoToList();
        logger.info("test end !!!");


    }


}

