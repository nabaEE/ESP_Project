package com.orgDesignData;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.objectRepository.ConfigurationSetupPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.LegalEntityManagementPage;

public class LegalEntityManagementTest extends BaseClass
{
//1. Keep the mouse pointer on peopel logo icon and verify admin option.
 @Test()
 public static void  verifyAdminOption() throws InterruptedException
 {
	 log.debug("-------verifyAdminOption : Test Started-------");
	 //Call the landing page
	 LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	 //Declare the expected tooltip message
	 String expTooltip="Admin";
	 //Call the method to capture the admin tooltip message
	 String actToolTip= lnp.getAdminTooltipText();
	 Assert.assertEquals(actToolTip, expTooltip);
	 log.info("Tooltip message is :"+actToolTip);
	 log.info("-------verifyAdminOption : Test Ended-------");
	
}
//2. Click on people logo icon and verify the values present.
 @Test()
 public static void printAndVerifyAdminValues()
 {
	 log.debug("-------printAndVerifyAdminValues : Test Started-------"); 
	//Call the landing page
     LandingPage lnp= PageFactory.initElements(driver, LandingPage.class); 
     //Declare the expected admin values 
     String[] expVal= new String[]{"People", "Projects", "Offers", "New Hire", "Relieving", "Analytics", "Password Management", "Payroll", "Configuration Setup"};
     //Click on admin icon
     lnp.getAdminIcon().click();
     //Capture the actual admin values
     String[] actVal= lnp.printAdminValues();
     log.info("Expected values are :"+Arrays.toString(expVal));
     log.debug("    ");
     log.debug("------Validate the expected values with actual values-------");
     log.debug("    ");
     Assert.assertEquals(actVal, expVal);
     log.debug("    ");
     log.info("Actual values are :"+Arrays.toString(actVal));
     log.info("------printAndVerifyAdminValues : Test Ended-------");
  }

//3. Submit new Legal Entity and verify.
@Test()
public static void submitNewLegalEntityAndVerify() throws InterruptedException
{
	driver.findElement(By.id("Not_now")).click();
	//Call the landing page
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	lnp.getAdminIcon().click();
	//Click on Configuration setup
	lnp.getConfigurationSetupAdminValue().click();
	//Call the ConfigurationSetup page
	ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
	//Click on org design data
	csp.getOrgDesignData().click();
	//Click on legal entity management page
	csp.getClickDepartment().click();
	csp.getClickLegalEntityManagement().click();
	Thread.sleep(5000);
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	lem.getAddNewButton().click();
	//Enter the legal entity name
	lem.getLegalEntityNameEditbox().sendKeys("");
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();
	//Click on country dropdown
	lem.getCountryDropdown().click();
	//Pick the country 
	
	
}

}









