package com.nobroker.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelProvider {
    XSSFWorkbook wb;

    public ExcelProvider() {

        File src = new File("./TestData/Data.xlsx");

        try {
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to read excel file" + e.getMessage());
        }

    }


    public String getStringData(String sheetName,int row,int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

}
