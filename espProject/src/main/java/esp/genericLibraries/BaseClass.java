package esp.genericLibraries;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import esp.objectRepository.LoginPage;
import esp.genericLibraries.FileUtils;


public class BaseClass extends FileUtils
{
 public static WebDriver driver;
 
	
 @BeforeClass()
 @Parameters({"browser"})
public void openBrowser(String browserName)
  {
	 /*Call the chrome driver*/
	 System.out.println("********************Launching the browser**********************");
  if(browserName.equalsIgnoreCase("chrome"))
   {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prod\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
	 driver= new ChromeDriver();
    }
  /*call the firefox browser*/
 else if(browserName.equalsIgnoreCase("firefox 68"))
  {
	 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\gecko\\geckodriver.exe");
	 driver= new FirefoxDriver();
   }
  /*call the internet explorer browser*/
 else if(browserName.equalsIgnoreCase("ie"))
   {
	 System.setProperty("webdriver.ie.driver", "");
	 driver= new InternetExplorerDriver();
  }
  driver.manage().window().maximize();
}
@BeforeMethod()
public void login() throws IOException
{
 System.out.println("************Login to the application***************");
	/*Create an object of FileUtils class to get the data from property file*/
 FileUtils fl= new FileUtils();
 Properties pObj=fl.getPropertyData();
 driver.get(pObj.getProperty("URL"));
 /*Call the login page class which is common for all the modules*/
 esp.objectRepository.LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
 //Calling the method declared in login page class
 lp.loginToPage(pObj.getProperty("USERNAME"), pObj.getProperty("PASSWORD"));
 }
@AfterMethod
public void tearDown() throws Exception
{ 
		  esp.objectRepository.LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		 //call the logout method declared in LoginPage
		 lp.logOut();
		 System.out.println("***********Logout from the application*********");
}
@AfterClass
public void closeBrowser()
{ 
	driver.switchTo().defaultContent();
	driver.quit();
	System.out.println("*************Closing the browser***********");
}
	
}
