package esp.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils {
	/* Declare the path of property file */
	String data = "./TestData/myData.property.txt";
	String excelPath = "./TestData/EmpData.xlsx";
	XSSFWorkbook wb;
	FileInputStream fis1;
	XSSFSheet sh;
	XSSFRow row;
	XSSFCell col;
	
	/* Declare the method to fetch the data from property file */
	public Properties getPropertyData() throws IOException {
		FileInputStream fis = new FileInputStream(data);
		Properties pObj = new Properties();
		pObj.load(fis);
		return pObj;
	}
// Declare the method to fetch the string data from the excel sheet
	public String getExcelData(String sheetName, int rowNumber, int colNumber) throws Exception {
		fis1= new FileInputStream(excelPath);
	    wb = new XSSFWorkbook(fis1);
		sh = wb.getSheet(sheetName);
	    row = sh.getRow(rowNumber);
        col =row.getCell(colNumber);
		String data = sh.getRow(rowNumber).getCell(colNumber).getStringCellValue();
		return data;
		}
// Declare a method to fetch the date value from the excel sheet.
	public Date getDateFromExcel(String sheetName, int rowNumber, int colNumber) throws Exception {
		fis1= new FileInputStream(excelPath);
	    wb = new XSSFWorkbook(fis1);
		sh = wb.getSheet(sheetName);
	    row = sh.getRow(rowNumber);
        col =row.getCell(colNumber);
		Date date = sh.getRow(rowNumber).getCell(colNumber).getDateCellValue();
		return date;
		}
	//Declare a method to fetch the number value from the excel sheet
	public double getValueFromExcel(String sheetName, int rowNumber, int colNumber) throws Exception {
		fis1= new FileInputStream(excelPath);
	    wb = new XSSFWorkbook(fis1);
		sh = wb.getSheet(sheetName);
	    row = sh.getRow(rowNumber);
        col =row.getCell(colNumber);
		double val = (double) sh.getRow(rowNumber).getCell(colNumber).getNumericCellValue();
		return val;
		}
		
	}

