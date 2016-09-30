package com.dp.mingmi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 16/9/6.
 */
public class ReadExcel {

    String filepath;

    public List<List<String>> read03excelfile(File file) throws IOException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(new FileInputStream(file));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        List<List<String>> filelist = new ArrayList<List<String>>();
        int rowStart = hssfSheet.getFirstRowNum();
        int rowEnd = hssfSheet.getLastRowNum();
        for (int i = rowStart; i <= rowEnd; i++) {
            List<String> filetmp = new ArrayList<String>();
            HSSFRow row = hssfSheet.getRow(i);
            //int column = row.getPhysicalNumberOfCells();
            //System.out.println("The physicalNumber is "+column);
            if (null == row) continue;
            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();
            for (int k = cellStart; k < cellEnd; k++) {
                HSSFCell cell = row.getCell(k);
                if (null == cell) {
                    filetmp.add("");
                    continue;
                }
                filetmp.add(cell.toString());
                switch (cell.getCellType()) {
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                        System.out.print(cell.getNumericCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_STRING: // 字符串
                        System.out.print(cell.getStringCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        System.out.println(cell.getBooleanCellValue()
                                + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
                        System.out.print(cell.getCellFormula() + "   ");
                        break;
                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                        System.out.println(" ");
                        break;
                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                        System.out.println(" ");
                        break;
                    default:
                        System.out.print("未知类型   ");
                        break;
                }

            }
            //System.out.print("\n");
            filelist.add(filetmp);
        }
        return filelist;
    }

    public List<List<String>> read07excelfile(File file) throws IOException, InvalidFormatException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        List<List<String>> filelist = new ArrayList<List<String>>();
        int rowStart = xssfSheet.getFirstRowNum();
        int rowEnd = xssfSheet.getLastRowNum();
        for (int i = rowStart; i <= rowEnd; i++) {
            List<String> filetmp = new ArrayList<String>();
            XSSFRow row = xssfSheet.getRow(i);
            if (null == row) continue;
            int cellStart = row.getFirstCellNum();
            int cellEnd = row.getLastCellNum();
            for (int k = cellStart; k < cellEnd; k++) {
                XSSFCell cell = row.getCell(k);
                if (null == cell)
                {
                    filetmp.add("");
                    continue;
                }
                filetmp.add(cell.toString());
//                switch (cell.getCellType()) {
//                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
//                        System.out.print(cell.getNumericCellValue()
//                                + "   ");
//                        break;
//                    case HSSFCell.CELL_TYPE_STRING: // 字符串
//                        System.out.print(cell.getStringCellValue()
//                                + "   ");
//                        break;
//                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
//                        System.out.println(cell.getBooleanCellValue()
//                                + "   ");
//                        break;
//                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
//                        System.out.print(cell.getCellFormula() + "   ");
//                        break;
//                    case HSSFCell.CELL_TYPE_BLANK: // 空值
//                        System.out.println(" ");
//                        break;
//                    case HSSFCell.CELL_TYPE_ERROR: // 故障
//                        System.out.println(" ");
//                        break;
//                    default:
//                        System.out.print("未知类型   ");
//                        break;
//                }

            }
//            System.out.print("\n");
            filelist.add(filetmp);
            //filetmp.clear();
        }
        return filelist;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        ReadExcel rex = new ReadExcel();
        //String filepath = "/Users/zhangmingmi/Desktop/personinfo.xlsx";
        String filepath = "/Users/zhangmingmi/Desktop/person.xls";
        List<List<String>> excellist=new ArrayList<List<String>>();
        File file = new File(filepath);
        if (filepath.endsWith(".xls")) {
            excellist=rex.read03excelfile(file);
        } else if (filepath.endsWith(".xlsx")) {
            excellist=rex.read07excelfile(file);
        }
        for(int i=0;i<excellist.size();i++){
            for(int j=0;j<excellist.get(i).size();j++){
                System.out.print(excellist.get(i).get(j));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
