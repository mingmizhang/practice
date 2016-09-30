package com.dp.mingmi.fileoperation;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public class DirExtract {
    private String expression;
    private String pathExtract;
    StringWriter stringWriter;

    public DirExtract(String expression,StringWriter stringWriter) {
        this.expression = expression;
        String[] rightString = expression.trim().split("\\s+");
        this.pathExtract = rightString[rightString.length - 1];
        this.stringWriter =  stringWriter;
    }

    //ls command

    public StringWriter lsDir() throws IOException {
        File file = new File(pathExtract);
        if (!file.exists()) {
            System.out.println("File directory is not exists ");
            stringWriter.write("ls dir failed\n");
        } else {
            File[] fileList = file.listFiles();
            stringWriter.write("lsDir start!!!\n");
            for (int j = 0; j < fileList.length; j++) {
                if (fileList[j].isDirectory()) {
                    //System.out.println("Directory  : " + fileList[j].getName());
                    stringWriter.write("Directory  : " + fileList[j].getName() + "\n");
                } else if (fileList[j].isFile()) {
                    //System.out.println("File : " + fileList[j].getName());
                    stringWriter.write("File : " + fileList[j].getName() + "\n");
                }
            }
        }
       // stringWriter.close();
        return stringWriter;
    }
//
    //cd command
    public StringWriter cdDir() {
        //System.out.println("Cd dir start !!!\n");
        stringWriter.write("cdDir start!!!\n");
        File file = new File(pathExtract);
        if (!(file.isDirectory() && file.exists()))
            stringWriter.write("cd dir false\n");
        else
            stringWriter.write("cd dir success\n");
        return stringWriter;
    }


    // show the dir with dot command
    public StringWriter changeDotDirectory() {
        String[] dirPath;
        String pathResult = "";
        //StringWriter stringWriter = new StringWriter();
        stringWriter.write("changeDotDirectory start!!!\n");
        if (expression.contains("/./") || expression.contains("/../") || expression.startsWith("./") || expression.startsWith("../")) {
            dirPath = pathExtract.split("/");
            for (int i = 0; i < dirPath.length; i++) {
                if (dirPath[i].equals("..")) {
                    if (pathResult.lastIndexOf('/') == 0) {
                        pathResult = "/";

                    } else {
                        pathResult = pathResult.substring(0, pathResult.lastIndexOf('/'));

                    }
                } else if (dirPath[i].equals(".")) {
                    pathResult = pathResult;

                } else {
                    if (pathExtract.startsWith("/") && i == 0) {
                        pathResult = "/";
                    } else if (pathExtract.startsWith("/") && i == 1) {
                        pathResult = pathResult + dirPath[i];
                    } else {
                        pathResult = pathResult + "/" + dirPath[i];
                    }
                }
            }

        }
        stringWriter.write(pathResult + "\n");
        return stringWriter;
        //return pathResult;
    }

    // mkdir command
    public StringWriter mkDir() {
        //System.out.println("Make dir start !!!");
        stringWriter.write("mkDir start!!!\n");
        File file = new File(pathExtract);
        if (!file.exists()) {
            file.mkdir();
            stringWriter.write("make dir success\n");
        } else {
            stringWriter.write("make dir failed, dir exists !!!\n");

        }
        return stringWriter;
    }
}
