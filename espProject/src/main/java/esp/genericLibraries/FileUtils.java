package esp.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils
{
	/*Declare the path of property file*/
	   String data="./TestData/myData.property.txt";
	   String excelPath="./TestData/excelData.xlsx";
	   /*Declare the method to fetch the data from property file*/
	   public Properties getPropertyData() throws IOException
		{
		FileInputStream fis= new FileInputStream(data);
		Properties pObj= new Properties();
		pObj.load(fis);
		return pObj;
		}
	   
	   public String getExcelData(String sheetName, int rowNumber, int colNumber) throws Throwable
	   {
		FileInputStream fis= new FileInputStream(excelPath);
		XSSFWorkbook wb= new XSSFWorkbook();
		XSSFSheet sh= wb.createSheet(sheetName);
		Row row=sh.getRow(rowNumber);
		Cell col=row.getCell(colNumber);
		String data=sh.getRow(rowNumber).getCell(colNumber).getStringCellValue();
		return data;
		
		
		   
	   }
	 
}
