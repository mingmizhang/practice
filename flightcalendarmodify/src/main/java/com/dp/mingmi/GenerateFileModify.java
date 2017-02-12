package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by zhangmingmi on 16/10/1.
 */
public class GenerateFileModify {
    private String fileTitle;
    private String filePath;
    private FlightInfoModify flightInfoModify = new FlightInfoModify();
    private static final Logger logger = LoggerFactory.getLogger(GenerateFileModify.class);

    public GenerateFileModify(String fileTitle, String filePath) {
        this.fileTitle = fileTitle;
        this.filePath = filePath;
    }

    private File createFlightFile() {
        try {

            File flighFile = new File(filePath);
            if (!flighFile.exists()) {
                flighFile.createNewFile();
            }
            return flighFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeFlightFile() {
        try {
            File file = createFlightFile();
            String line;
            FileWriter fileWriter = new FileWriter(file);
            DateToString dateToString = new DateToString();
            int id =0 ;
            try {
                fileWriter.write(fileTitle);
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 3; i++) {
                        flightInfoModify.setName("flight" + i);
                        flightInfoModify.setPhone(String.valueOf(i));
                        flightInfoModify.setPrice(BigInteger.valueOf((int) (Math.random() * 100)));
                        flightInfoModify.setType("上海" + i);
                        //flightInfoModify.setStartDate("08" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9);
                        //flightInfoModify.setEndDate("10" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9);
                        Date now = new Date();
                        Date yesterday = DateToString.getYesterday(now);
                        Date startDate = DateToString.generateRandomDate(StringToDate.changeStringToDate("2016-09-07"),yesterday);
                        Date endDate = DateToString.generateRandomDate(startDate,now);
                        flightInfoModify.setEndDate(endDate);
                        flightInfoModify.setStartDate(startDate);
                        line = id+"\t"+flightInfoModify.getName() + "\t" + flightInfoModify.getPhone() + "\t" + flightInfoModify.getType() + "\t" + flightInfoModify.getPrice() + "\t" + DateToString.changeDateToString(flightInfoModify.getStartDate()) + "~" + DateToString.changeDateToString(flightInfoModify.getEndDate()) + "\n";
                        fileWriter.write(line);
                        id ++ ;
                    }
                }
                fileWriter.flush();
                logger.info("write flight file successfully~~");
            } catch (IOException e) {
                logger.error("write flight file failed~~", e);
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws IOException {
        String title = "id\tname\tphone\ttype\tprice\tdate\n";
        String filepath = "/Users/zhangmingmi/Desktop/test/flightest.txt";
        GenerateFileModify generateFileByObject = new GenerateFileModify(title, filepath);
        generateFileByObject.writeFlightFile();

    }
}
