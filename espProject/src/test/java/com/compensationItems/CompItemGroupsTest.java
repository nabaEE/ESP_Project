package com.compensationItems;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.CompItemGroupsPage;
import esp.objectRepository.CompItemsPage;
import esp.objectRepository.ConfigurationSetupPage;
import esp.objectRepository.LandingPage;

public class CompItemGroupsTest extends BaseClass
{
//1. Fill in the new compensation group then click on submit and verify the group name in New Compensation item popup window.
@Test(groups="Smoke")
public static void submitNewCompensationGroup() throws InterruptedException
{
//Call the landing page
LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
//Click notnow if attendance is displayed
lnp.skipAttendance();
//Click on admin icon
lnp.getAdminIcon().click();
//Click on Configuration setup
lnp.getConfigurationSetupAdminValue().click();
//Call the ConfigurationSetup page
ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
//Click on Compensation items
csp.getCompensationItems().click();
//Call the CompItemGroupsPage
CompItemGroupsPage cgp=PageFactory.initElements(driver, CompItemGroupsPage.class);
//Click on add new button
WebdriverUtils.waitForElementPresent(driver, cgp.getAddNewButton());
cgp.getAddNewButton().click();
//Click on the compensation type dropdown
cgp.getCompensationType().click();
//Pick payment type
cgp.pickCompensationTypeValue();
//Enter Compensation group name
String groupName="Payment1";
cgp.getCompensationGroup().sendKeys(groupName);
//Click on effective from date
cgp.getEffectiveFromDateCalenderWin().click();
//Pick the current date
cgp.getCurrentDate().click();
//Enter remarks
cgp.getRemarksEditbox().sendKeys("Submit");
//Click on Submit
WebdriverUtils.waitForElementPresent(driver, cgp.getSubmitButton());
cgp.getSubmitButton().click();
//Click on Comp items
csp.getcompItems().click();
//Call the Comp item page
CompItemsPage cip= PageFactory.initElements(driver, CompItemsPage.class);
//Click on add new button
cip.getAddNewButton().click();
//Click on compensation type 
cip.getCompensationTypeDropdown().click();
//Pick payment type
cip.getpickCompensationTypePayment().click();
//Click compensation group dropdown
cip.getCompensationGroupDropdown().click();
System.out.println("Expected group name is "+groupName);
//Check the groupName
String actGroupName=cip.checkCompensationGroup();
System.out.println("              ");
Assert.assertEquals(actGroupName, groupName);
System.out.println("Group name has found:"+ actGroupName);
//Close the pop up window
cip.getClosePopupWin().click();

}
//2. Enter an existing compensation group name then click on submit and verify the error message.
@Test(groups="Smoke")
public static void submitAnexistingCompensationGroupAndVerifyErrorMessage()
{
	//Call the landing page
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	lnp.getAdminIcon().click();
	//Click on Configuration setup
	lnp.getConfigurationSetupAdminValue().click();
	//Call the ConfigurationSetup page
	ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
	//Click on Compensation items
	csp.getCompensationItems().click();
	//Call the CompItemGroupsPage
	CompItemGroupsPage cgp=PageFactory.initElements(driver, CompItemGroupsPage.class);
	//Click on add new button
	WebdriverUtils.waitForElementPresent(driver, cgp.getAddNewButton());
	cgp.getAddNewButton().click();
	//Click on the compensation type dropdown
	cgp.getCompensationType().click();
	//Pick payment type
	cgp.pickCompensationTypeValue();
	//Enter Compensation group name
	String groupName="Payment1";
	cgp.getCompensationGroup().sendKeys(groupName);
	//Click on effective from date
	cgp.getEffectiveFromDateCalenderWin().click();
	//Pick the current date
	cgp.getCurrentDate().click();
	//Enter remarks
	cgp.getRemarksEditbox().sendKeys("Submit");
	//Click on Submit
	WebdriverUtils.waitForElementPresent(driver, cgp.getSubmitButton());
	cgp.getSubmitButton().click();
	//Declare the expected error message
	String expErr="Same Compensation Group Name already exist";
	//Close the popup window
	cgp.getClosePopupWin().click();
	//Capture the actual error message
	String actErr=cgp.getExistGroupNameError().getText();
	System.out.println("Expected error message is :"+expErr);
	System.out.println("                                    ");
	Assert.assertEquals(actErr, expErr);
	System.out.println("                                ");
	System.out.println("Actual error message is :"+actErr);
	}
}
