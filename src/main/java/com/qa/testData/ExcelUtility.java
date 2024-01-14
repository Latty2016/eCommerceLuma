package com.qa.testData;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility   {
    public String readFromExcel(String fileName,String sheetName,int rowNum, int cellNum){

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet =workbook.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);
        String cellValue = null;
        if (cellValue==null){
            System.out.println("Empty row...");
        }else {
            XSSFCell cell = row.getCell(cellNum);
            CellType cellType = cell.getCellType();
            switch (cellType){
                case NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    System.out.println(cellValue);
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    System.out.println(cellValue);
                    break;
            }
        }
        return cellValue;
    }

}
