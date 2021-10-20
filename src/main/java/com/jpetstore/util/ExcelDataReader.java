package com.jpetstore.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Arrays;

public class ExcelDataReader {
    private static XSSFWorkbook readExcelFile (String fileName){
        try {
            XSSFWorkbook workbook = new XSSFWorkbook((fileName));
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns testdata as 2D array object
     * @param fileName
     * @param sheetName
     * @return
     */
    public static Object[][] getData(String fileName, String sheetName){
        XSSFSheet sheet;
        XSSFRow singleRow;

        //Get sheet
        sheet = readExcelFile(fileName).getSheet(sheetName);

        //Needed to get cell count
        singleRow = sheet.getRow(0);

        //Initialize a 2D array object
        Object[][] testData = new Object[sheet.getLastRowNum()][singleRow.getLastCellNum()];

        for (int rowCount =1 ; rowCount <= sheet.getLastRowNum();rowCount++){
            singleRow = sheet.getRow(rowCount);
            for(int cell =0; cell<sheet.getLastRowNum();cell++){
                testData[rowCount-1][cell] = singleRow.getCell(cell).toString();
            }
        }

            return testData;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getData("src/test/resources/data/LoginDDTest copy 2.xlsx","doLogin")));
    }
}
