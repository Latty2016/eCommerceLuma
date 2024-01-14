package com.qa.testData;

import com.qa.pages.BasePage;
import com.qa.pages.Page;
import org.openqa.selenium.WebDriver;

public class ReadDataFromExcel{
    public static void main(String[] args) {
        String fileName = "testData.xlsx";
        ExcelUtility excelUtility = new ExcelUtility();
        excelUtility.readFromExcel(fileName,"login",1,0);
        excelUtility.readFromExcel(fileName,"login",1,1);
    }
}
