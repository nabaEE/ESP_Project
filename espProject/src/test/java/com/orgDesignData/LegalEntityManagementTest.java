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
     Assert.assertEquals(actVal, expVal);
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
	WebdriverUtils.waitForElementPresent(driver, lem.getSubmitButton());
	lem.getSubmitButton().click();	
	//Close pop up window
		lem.getClosePopupWin().click();
	//Declare the expected error message
	String expErr="Country cannot be empty";
	log.debug("Expected error message is :"+expErr);
	//Capture the actual error message
	String actErr=lem.getCountryDropdownBlankErr().getText();
	Assert.assertEquals(actErr, expErr);
	log.info("Actual error message is :"+actErr);
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
//9. Click on submit button with changing the legal entity name on edit window.
@Test()
public static void modifyLegalEntity() throws Exception
{
	log.debug("------modifyLegalEntity:-test started-------");
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
	//Click on the pencil icon
	lem.getEditIcon().click();
	String changLegalEntity="SRS";
	//Clear the legal entity name
	lem.getLegalEntityNameEditbox().clear();
	Thread.sleep(2000);
	lem.getLegalEntityNameEditbox().sendKeys(changLegalEntity);
	//Click on submit
	lem.getSubmitButton().click();
	log.debug("Expected legal entity name is :"+changLegalEntity);
	//Capture the actual legal entity name
	String modifiedLegalEntity=lem.getModifiedLegalEntity().getText();
	log.debug("---Verify modified legal entity name------");
	Assert.assertEquals(modifiedLegalEntity, changLegalEntity);
	log.info("Modified legal entity name is :"+modifiedLegalEntity);
	log.debug("------modifyLegalEntity:-test ended-------");
	
}
//10. Click on submit button without making any changes on edit window.
@Test()
public static void clickEditIconAndSubmitWithoutModifying()
{
	log.debug("-------clickEditIconAndSubmitWithoutModifying :test Started-------");
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
	//Click on the pencil icon
	lem.getEditIcon().click();
	log.debug("Picked legal entity is :"+lem.getModifiedLegalEntity().getText());
	//Click on submit
	lem.getSubmitButton().click();
	log.debug("-----Validate the legal entity after submit--------");
	Assert.assertTrue(lem.getModifiedLegalEntity().isDisplayed());
	log.info("Legal entity is :"+lem.getModifiedLegalEntity().getText());
	log.info("-------clickEditIconAndSubmitWithoutModifying :test ended-------");
	
}
//11. Check the maximum size of the legal Entity name editbox on New Legal Entity window.
@Test()
public static void verifySizeOfLegalEntityEditbox()
{
	log.debug("-------verifySizeOfLegalEntityEditbox :test Started-------");
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
	String legalEntity="BRMRC soft tech";
	String expLength=legalEntity.length()+"/50";
	lem.getLegalEntityNameEditbox().sendKeys(legalEntity);
	log.debug("Entererd length is :"+expLength);
	//Capture the actual length
	String actLength=lem.getLegalEntityNameEditboxLength().getText();
	log.debug("-------Verify the length--------");
	Assert.assertEquals(actLength, expLength);
	log.info("Actual length is :"+actLength);
	//Close the pop up window
	lem.getClosePopupWin().click();
	log.info("-------verifySizeOfLegalEntityEditbox :test ended-------");
}
//12. Check the size of Remarks editbox and verify it.
@Test()
public static void verifySizeOfRemarksEditbox()
{
	log.debug("-------verifySizeOfRemarksEditbox :test Started-------");
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
	String remarks="submit";
	lem.getRemarksEditbox().sendKeys(remarks);
	//Declare the expected length
	String expLength=remarks.length()+"/250";
	log.debug("Expected length of entered remarks is :"+expLength);
	//Capture the actual length
	String actLength=lem.getRemarksEditboxLength().getText();
	log.debug("----Verify the length------");
	Assert.assertEquals(actLength, expLength);
	log.info("Actual length is :"+actLength);
	//Close pop up window
	lem.getClosePopupWin().click();
	log.debug("-------verifySizeOfRemarksEditbox :test ended-------");
 }
//13. Enter comments in the view window and verify it.
@Test()
public static void verifyCommentsOnViewWin() throws Exception
{
	log.debug("-------verifyCommentsOnViewWin :test Started-------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
   //Click on the view window
	lem.getViewIcon().click();
	//Enter the comments in the editbox
    lem.getCommentsEditbox().sendKeys("Able to view legal entity details");
    lem.getSaveButton().click();
    Thread.sleep(2000);
    log.debug("-----Verify the entered comments------");
    Assert.assertTrue(lem.getCheckEnteredComments().isDisplayed());
    log.info(lem.getCheckEnteredComments().getText());
  //close the pop up window
    lem.getClosePopupWin().click();
	log.debug("-------verifyCommentsOnViewWin :test ended-------");
}
//14. Try to delete the legal entity and verify it.
@Test()
public static void deleteLegalEntity()
{
	log.debug("------deleteLegalEntity: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Click on the legal entity to delete
	lem.getDeleteIcon().click();
	//Print the selected legal entity to delete
	String legalEntity=lem.getModifiedLegalEntity().getText();
	log.debug("Picked legal entity is :"+legalEntity);
	//Click on yes 
	lem.getClickYesButton().click();
	log.debug("---------Verify the deleted legal entity---------");
	Assert.assertFalse(lem.getModifiedLegalEntity().isDisplayed());
	log.info("Deleted legal entity name is :"+legalEntity);
	
	log.debug("------deleteLegalEntity: Test ended--------");
	
}
//15. Keep the mouse pointer on grid icon and capture the tooltip message.
@Test()
public static void verifyGridIconTooltip()
{
	log.debug("------verifyGridIconTooltip: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Declare the expected grid message
	String expMessage="Data Grid";
	log.debug("Expected message is :"+expMessage);
	//Capture the actual grid message
	String actMessage=lem.getGridTooltip();
	log.debug("------Verify the tooltip message------");
	Assert.assertEquals(actMessage, expMessage);
	log.info("Actual message is :"+actMessage);
	log.info("------verifyGridIconTooltip: Test ended--------");
}
//16. Keep the mouse pointer on download icon and verify the tooltip.
@Test()
public static void verifyDownloadTooltip()
{
	log.debug("------getdownloadTooltip: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Declare expected grid message
	String expMessage="Download";
	log.debug("Expected tooltip is :"+expMessage);
	//Capture the actual grid message
	String actMessage=lem.getDownloadTooltip();
	log.debug("-----Verify the download tooltip message-------");
	Assert.assertEquals(actMessage, expMessage);
	log.info("Actual tooltip is :"+actMessage);
	log.info("------verifyDownloadTooltip: Test ended--------");
	
  }
//17. Keep the mouse pointer on clear filter table icon and capture the tooltip message
@Test()
public static void verifyClearFilterTooltip()
{
	log.debug("------verifyClearFilterTooltip: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Declare the expected tooltip message
	String expTooltip="Clear Filter";
	log.debug("Expected tooltip is :"+expTooltip);
	//Capture the actual tooltip
	String actTooltip=lem.getClearFilterTooltip();
	log.debug("------Verify the tooltip message-------");
	Assert.assertEquals(actTooltip, expTooltip);
	log.info("Actual tooltip is :"+actTooltip);
	log.info("------verifyClearFilterTooltip: Test ended--------");
}
//18. Place the mouse pointer on Add icon and verify the tooltip message.
@Test()
public static void verifyAddNewTooltip()
{
	log.debug("------verifyAddNewTooltip: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Declare the expected tooltip message
	String expTooltip="Add New";
	log.debug("Expected tooltip is :"+expTooltip);
	//Capture the actual tooltip
	String actTooltip=lem.getAddNewTooltip();
	log.debug("------Verify the tooltip message-------");
	Assert.assertEquals(actTooltip, expTooltip);
	log.info("Actual tooltip is :"+actTooltip);
	log.info("------verifyAddNewTooltip: Test ended--------");
}
//19. Click on the data grid Icon and verify column names.
@Test()
public static void clickAndVerifyDataGridValues()
{
	log.debug("------clickAndVerifyDataGridValues: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Click on data grid icon
	lem.getGridColumnIcon().click();
	//Declare the expected column names
	String[] expVal= {"Data Grid", "Legal Entity", "Country","Effective From","Effective End Date", "Created By", "Created On"};
	log.debug("Expected tooltip is :"+Arrays.toString(expVal));
	//Capture the actual tooltip
	String[] actVal=lem.getGridValues();
	log.debug("------Verify the grid values-------");
	Assert.assertEquals(actVal, expVal);
	log.info("Actual tooltip is :"+Arrays.toString(actVal));
	log.info("------clickAndVerifyDataGridValues: Test ended--------");	
}
//20. Download legal entity records in excel format.
@Test()
public static void downloadLegalEntityRecordInExcelFormat()
{
	log.debug("------downloadLegalEntityRecordInExcelFormat: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Click on download icon
	lem.getDownloadIcon().click();
	//Click on excel
	lem.getDownloadExcel().click();
	log.info("------downloadLegalEntityRecordInExcelFormat: Test ended--------");
}
//21. Download legal entity records in pdf format.
@Test()
public static void downloadLegalEntityRecordInPdfFormat()
{
	log.debug("------downloadLegalEntityRecordInPdfFormat: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Click on download icon
	lem.getDownloadIcon().click();
	//Click on pdf
	lem.getDownloadPdf().click();
	log.info("------downloadLegalEntityRecordInPdfFormat: Test ended--------");
}
//22. Search for a legal entity and verify it.
@Test()
public static void searchLegalEntityAndVerify()
{
	log.debug("------searchLegalEntityAndVerify: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
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
	//Click on legal entity filter icon
	lem.getLegalEntityFilterIcon().click();
	//Enter the legal entity in the filter search box
	String expLegalEntity="SRS";
	log.debug("Expected legal entity :"+expLegalEntity);
	lem.getFilterWinSearchbox().sendKeys(expLegalEntity);
	//Capture the actual legal entity
	String actLegalEntity=lem.getSearchedLegalEntity().getText();
	log.info("Searched legal entity is :"+actLegalEntity);
	log.debug("---Verify the searched legal entity----");
	Assert.assertEquals(actLegalEntity, expLegalEntity);
	log.info("Searched legal entity is found :"+actLegalEntity);
	log.info("------searchLegalEntityAndVerify: Test ended--------");
 }

}









