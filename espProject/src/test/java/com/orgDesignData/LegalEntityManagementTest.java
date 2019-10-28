package com.orgDesignData;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
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
	 log.debug("Expected message is :"+expTooltip);
	 //Call the method to capture the admin tooltip message
	 String actToolTip= lnp.getAdminTooltipText();
	 Assert.assertEquals(actToolTip, expTooltip);
	 log.info("Tooltip message is :"+actToolTip);
	 log.info("-------verifyAdminOption : Test Ended-------");
	
}
//2. Click on people logo icon and verify the values present.
 @Test()
 public static void printAndVerifyAdminValues() throws Exception
 {
	 log.debug("-------printAndVerifyAdminValues : Test Started-------"); 
	 Thread.sleep(2000);
	//Call the landing page
     LandingPage lnp= PageFactory.initElements(driver, LandingPage.class); 
     //Declare the expected admin values 
     String[] expVal= {"People", "Projects", "Offers", "New Hire", "Relieving","Reports", "Analytics", "Password Management", "Payroll", "Configuration Setup"};
     //Click on admin icon
     lnp.getAdminIcon().click();
     //Capture the actual admin values
     String[] actVal= lnp.printAdminValues();
     log.info("Expected values are :"+Arrays.toString(expVal));
     log.debug("    ");
     log.debug("------Validate the expected values with actual values-------");
     log.debug("    ");
     Assert.assertEquals(actVal.length, expVal.length);
     log.debug("    ");
     log.info("Actual values are :"+Arrays.toString(actVal));
     log.info("------printAndVerifyAdminValues : Test Ended-------");
  }

//3. Submit new Legal Entity and verify.
@Test()
public static void submitNewLegalEntityAndVerify() throws InterruptedException
{
	//driver.findElement(By.id("Not_now")).click();
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();
	//Enter the legal entity name
	String legalEntityName="Test1";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntityName);
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();
	//Click on country dropdown
	Thread.sleep(2000);
	lem.getCountryDropdown().click();
	//Pick the country 
	lem.getPickCountryIndia().click();
	//Enter the remarks
	lem.getRemarksEditbox().sendKeys("Submit");
	//Click on submit
	lem.getSubmitButton().click();
	//Capture the legal entity name
	String actLegalEntityName=lem.verifyLegalEntity();
	//Verify the submitted legal entity
	log.debug("Expected legal entity name is :"+legalEntityName);
	log.debug("--------Verify the submitted legal entity name--------");
	Assert.assertEquals(actLegalEntityName, legalEntityName);
	log.info("------Actual legal entity is :----"+actLegalEntityName);
	
	}
//4. Enter an existing legal entity name then verify it.
@Test()
public static void submitExistingLegalEntity() throws InterruptedException
{
	log.debug("------submitExistingLegalEntity:-test started-------");
	WebdriverUtils.waitForPageToLoad(driver);
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();
	//Enter the legal entity name
	String legalEntityName="Test1";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntityName);
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();
	//Click on country dropdown
	Thread.sleep(2000);
	lem.getCountryDropdown().click();
	//Pick the country 
	lem.getPickCountryIndia().click();
	//Enter the remarks
	lem.getRemarksEditbox().sendKeys("Submit");
	//Click on submit
	lem.getSubmitButton().click();
	//Declare the expected error message
	String expErr="Same legal entity name already exist";
	log.debug("-------Validate the error message------");
    Assert.assertEquals("", expErr);
	log.info("Test case is passed");
	//Close the pop up window
	lem.getClosePopupWin().click();
	
	log.info("------submitExistingLegalEntity:-test ended-------");
 }
//5. Verify the error message for keeping legal entity name blank.
@Test()
public static void submitFormWithKeepingLegalEntityNameBlank() throws InterruptedException
{
	log.debug("------submitFormWithKeepingLegalEntityNameBlank:-test started-------");
	WebdriverUtils.waitForPageToLoad(driver);
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();
	//Click on country dropdown
	Thread.sleep(2000);
	lem.getCountryDropdown().click();
	//Pick the country 
	lem.getPickCountryIndia().click();
	//Enter the remarks
	lem.getRemarksEditbox().sendKeys("Submit");
	//Click on submit
	lem.getSubmitButton().click();
   //Declare the expected error message
   String expErr="Legel Entity Name cannot be empty";
   //Capture the actual error message
   String actErr=lem.getLegalEntityNameEditboxBlankErr().getText();
   log.debug("Expected error message is :"+expErr);
   log.debug("-----Validate the error message-------");
   Assert.assertEquals(actErr, expErr);
   log.info("Actual error message is :"+actErr);
   //Close popup window
   lem.getClosePopupWin().click();
   log.info("------submitFormWithKeepingLegalEntityNameBlank:-test ended-------");
   
}

//6.Verify the error message for keeping Effective from date blank.
@Test()
public static void submitFormWithoutPickingEffectiveFromDate() throws InterruptedException
{
	log.debug("------submitFormWithoutPickingEffectiveFromDate:-test started-------");
	WebdriverUtils.waitForPageToLoad(driver);
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();	
	//Enter the legal entity name
	String legalEntityName="Test1";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntityName);
	//Click on country dropdown
	Thread.sleep(2000);
	lem.getCountryDropdown().click();
	//Pick the country 
	lem.getPickCountryIndia().click();
	//Enter the remarks
	lem.getRemarksEditbox().sendKeys("Submit");
	//Click on submit
	lem.getSubmitButton().click();
	//Declare the expected error message
	String expErr="Effective From cannot be empty";
	log.debug("Expected error message is :"+expErr);
	//Capture the actual error message
	String actErr=lem.getEffectiveFromDateBlankErr().getText();
	Assert.assertEquals(actErr, expErr);
	log.info("Actual error message is :"+actErr);
	//Close pop up window
	lem.getClosePopupWin().click();
	log.info("------submitFormWithoutPickingEffectiveFromDate:-test ended-------");
	
}
//7.Verify the error message for not picking country dropdown
@Test()
public static void submitFormWithoutPickingCountry()
{

	log.debug("------submitFormWithoutPickingCountry:-test started-------");
	WebdriverUtils.waitForPageToLoad(driver);
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();	
	//Enter the legal entity name
	String legalEntityName="Test1";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntityName);
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();	
	//Enter the remarks
	lem.getRemarksEditbox().sendKeys("Submit");
	//Click on submit
	lem.getSubmitButton().click();	
	//Declare the expected error message
	String expErr="Country cannot be empty";
	log.debug("Expected error message is :"+expErr);
	//Capture the actual error message
	String actErr=lem.getCountryDropdownBlankErr().getText();
	Assert.assertEquals(actErr, expErr);
	log.info("Actual error message is :"+actErr);
	//Close pop up window
	lem.getClosePopupWin().click();
	log.info("---------submitFormWithoutPickingCountry :test ended------------");

 }
//8. Check the error message for keeping remarks editbox blank.
@Test()
public static void submitFormWithKeepingRemarksBlank() throws InterruptedException
{
	log.debug("------submitFormWithKeepingRemarksBlank:-test started-------");
	WebdriverUtils.waitForPageToLoad(driver);
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
	//Call legal entity management page
	LegalEntityManagementPage lem= PageFactory.initElements(driver, LegalEntityManagementPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, lem.getAddNewButton());
	lem.getAddNewButton().click();		
	//Enter the legal entity name
	String legalEntityName="Test1";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntityName);
	//Pick the effective from date
	lem.getEffectiveFromDateCalenderWin().click();
	lem.getCurrentDate().click();
	//Click on country dropdown
	Thread.sleep(2000);
	lem.getCountryDropdown().click();
	//Pick the country 
	lem.getPickCountryIndia().click();
	//Click on submit
	lem.getSubmitButton().click();
	//Declare the expected error message
    String expErr="Remarks cannot be empty";
    log.debug("Expected error message is :"+expErr);
    //Capture the actual error message
    String actErr=lem.getRemarksEditboxBlankErr().getText();
    log.debug("--------Validate the error message--------");
    Assert.assertEquals(actErr, expErr);
    log.info("Actual error message is :"+actErr);
    //Close pop up window
    lem.getClosePopupWin().click();
    log.info("------submitFormWithKeepingRemarksBlank:-test ended-------");
    
    }
//9. 


}









