package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhangmingmi on 16/9/29.
 */
public class GenerateFileByObject {
    private String fileTitle;
    private String filePath;
    private FlightInfo flightInfo = new FlightInfo();
    private static final Logger logger = LoggerFactory.getLogger(GenerateFileByObject.class);

    public GenerateFileByObject(String fileTitle, String filePath) {
        this.fileTitle = fileTitle;
        this.filePath = filePath;
    }

    private File createFlightFile() throws IOException {
        File flighFile = new File(filePath);
        if (!flighFile.exists()) {
            flighFile.createNewFile();
        }
        return flighFile;
    }

    public boolean writeFlightFile() {
        boolean writeFlag = false;
        try {
            File file = createFlightFile();
            String line;
            String date;
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileTitle);
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 13; i++) {
                    flightInfo.setName("flight" + i);
                    flightInfo.setPhone(String.valueOf(i));
                    flightInfo.setPrice((int) (Math.random() * 100));
                    flightInfo.setType("上海" + i);
                    flightInfo.setDate("08" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9 + "~" + "10" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9);
                    line = flightInfo.getName() + "\t" + flightInfo.getPhone() + "\t" + flightInfo.getType() + "\t" + flightInfo.getPrice() + "\t" + flightInfo.getDate() + "\n";
                    fileWriter.write(line);
                }

            }
            fileWriter.flush();
            fileWriter.close();
            writeFlag = true;
            logger.info("write flight file successfully~~");
        } catch (IOException e) {
            writeFlag = false;
            logger.info("write flight file failed~~", e);
        }
        return writeFlag;
    }

    public static void main(String[] args) throws IOException {
        String title = "name\tphone\ttype\tprice\tdate\n";
        String filepath = "/Users/zhangmingmi/Desktop/test/flightest.txt";
        GenerateFileByObject generateFileByObject = new GenerateFileByObject(title, filepath);
        boolean generateFlag = generateFileByObject.writeFlightFile();

    }
}
