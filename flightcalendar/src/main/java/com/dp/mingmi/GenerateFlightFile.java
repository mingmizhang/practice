package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by zhangmingmi on 16/9/28.
 */
public class GenerateFlightFile {
    private String fileTitle;
    private String filePath;
    private static final Logger logger = LoggerFactory.getLogger(GenerateFlightFile.class);

    public GenerateFlightFile(String fileTitle, String filePath) {
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
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write(fileTitle.getBytes("utf-8"));
//        for (int i = 0; i < 10; i++) {
//            line = "flight" + i + "\t" + i+ "\t" + "上海" +i+"\t" + (int)(Math.random()*100) + "\t" + "0908"+"\n";
//            fileOutputStream.write(line.getBytes("utf-8"));
//        }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileTitle);
            for(int j=0;j<4;j++){
                for (int i = 0; i < 12; i++) {
                    date = "09" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9 + "~" + "10" + ((int) (Math.random() * 10)) % 3 + ((int) (Math.random() * 10)) % 9;
                    line = "flight" + i + "\t" + i + "\t" + "上海" + j + "\t" + (int) (Math.random() * 100) + "\t" + date + "\n";
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
        GenerateFlightFile generateFlightFile = new GenerateFlightFile(title, filepath);
        boolean generateFlag = generateFlightFile.writeFlightFile();

    }
}
