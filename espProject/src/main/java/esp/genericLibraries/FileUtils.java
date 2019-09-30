package esp.genericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils
{
	/*Declare the path of property file*/
	   String data="./TestData/myData.property.txt";
	   /*Declare the method to fetch the data from property file*/
	   public Properties getPropertyData() throws IOException
		{
		FileInputStream fis= new FileInputStream(data);
		Properties pObj= new Properties();
		pObj.load(fis);
		return pObj;
		}
	 
}
