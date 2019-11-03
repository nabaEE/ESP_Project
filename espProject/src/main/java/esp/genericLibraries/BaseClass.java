package esp.genericLibraries;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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
 protected static Logger log= LogManager.getLogger(BaseClass.class);
 FirefoxOptions profile = new FirefoxOptions();
@BeforeClass()
 @Parameters({"browser"})
public void openBrowser(String browserName)
  {
	 /*Call the chrome driver*/
	 System.out.println("********************Launching the browser**********************");
	 log.info("*****************Launching the Browser*************************");
  if(browserName.equalsIgnoreCase("chrome"))
   {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prod\\Desktop\\driver\\chromedriver.exe");
	 driver= new ChromeDriver();
    }
  /*call the firefox browser*/
 else if(browserName.equalsIgnoreCase("firefox 68"))
  {
	 profile.addPreference("browser.download.folderList", 2);
	 profile.addPreference("browser.helperApps.neverAsk.SaveToDisk", "Application.excel");
	 profile.addPreference("browser.download.dir", "D:\\app\\");
	 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\gecko\\geckodriver.exe");
	 driver= new FirefoxDriver(profile);
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
 log.info("******************Login to the application********************");
	/*Create an object of FileUtils class to get the data from property file*/
 FileUtils fl= new FileUtils();
 Properties pObj=fl.getPropertyData();
 driver.get(pObj.getProperty("URL"));
 /*Call the login page class which is common for all the modules*/
 esp.objectRepository.LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
 //Calling the method declared in login page class
 lp.loginToPage(pObj.getProperty("USERNAME"), pObj.getProperty("PASSWORD"));
 WebdriverUtils.waitForPageToLoad(driver);
 driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));

 
 }
@AfterMethod
public void tearDown() throws Exception
{ 
	    esp.objectRepository.LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		 //call the logout method declared in LoginPage
		 lp.logOut();
		 System.out.println("***********Logout from the application*********");
		 log.info("*****************Logout from the application***************");
}
@AfterClass
public void closeBrowser()
{ 
	driver.switchTo().defaultContent();
	driver.quit();
	System.out.println("*************Closing the browser***********");
	log.info("**********Closing the Browser**********");
}
	
}
