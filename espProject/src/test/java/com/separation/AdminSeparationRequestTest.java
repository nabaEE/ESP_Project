package com.separation;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.LandingPage;
import esp.objectRepository.PeopleListPage;
import esp.objectRepository.SeparationRequestPage;

public class AdminSeparationRequestTest extends BaseClass
{
//1. Click on people icon and select one employee then click on separation
@Test()
public static void submitSeparationRequest() throws InterruptedException
{
	//Call the landing page
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on People button
    lnp.getPeopleIcon().click();
    //Call the People page
    PeopleListPage plp= PageFactory.initElements(driver, PeopleListPage.class);
    //Pick an employee
    plp.getPickEmployee().click();
    //Click separation
    plp.getClickSeparationSection().click();
  //  plp.clickSeparationOption();
    //Call the Separation Request page
    SeparationRequestPage srp= PageFactory.initElements(driver, SeparationRequestPage.class);
    //Click on separation type
    srp.getSeparationType().click();
    //Pick separation type
    srp.getSelectSeparationType().click();
    //Click Separation reason
    srp.getSeparationReason().click();
    //Pick separation reason
    WebdriverUtils.waitForElementPresent(driver, srp.getSelectSeparationReason());
    srp.getSelectSeparationReason().click();
    //Click on Submission date
    srp.getSubmissionDate().click();
    //Pick current date
    srp.getSelectToday().click();
    //Click on Requested Relieve Date
    WebdriverUtils.waitForElementPresent(driver, srp.getRelieveDate());
    Thread.sleep(2000);
    srp.getRelieveDate().click();
    // Pick current date
    WebdriverUtils.waitForElementPresent(driver, srp.getSelectRelieveDate()); 
    srp.getSelectRelieveDate().click();
    //Enter feedback
    srp.getCommentsEditbox().sendKeys("Submit the request");
    //Click on submit
    srp.getSubmitButton().click();
   }
//2. Pick the submission date and capture the message.
 @Test()
 public static void verifyInitiatedAndRelieveText()
 {
	  log.debug("-----------verifyInitiatedAndRelieveText :- Test Started");  
	   //Call the landing page
		LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
		//Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		//Click on People button
	    lnp.getPeopleIcon().click();
	    //Call the People page
	    PeopleListPage plp= PageFactory.initElements(driver, PeopleListPage.class);
	    //Pick an employee
	    plp.getPickEmployee().click();
	    //Click separation
	    plp.getClickSeparationSection().click();
	  //  plp.clickSeparationOption();
	    //Call the Separation Request page
	    SeparationRequestPage srp= PageFactory.initElements(driver, SeparationRequestPage.class);
	    //Click on separation type
	    srp.getSeparationType().click();
	    //Pick separation type
	    srp.getSelectSeparationType().click();
	    //Click Separation reason
	    srp.getSeparationReason().click();
	    //Pick separation reason
	    WebdriverUtils.waitForElementPresent(driver, srp.getSelectSeparationReason());
	    srp.getSelectSeparationReason().click();
	    //Click on Submission date
	    srp.getSubmissionDate().click();
	    //Select the date.
	    srp.getSelectToday().click();
	   String initiatedInfo=srp.getInitiatedText().getText();
	   //Verify the text message
	   log.debug("------------------verify the initiated details for Separation-----------------");
	   Assert.assertTrue(initiatedInfo.contains("Submitted Separation Request"));
	   log.info(initiatedInfo);
	   log.info("-----------verifyInitiatedAndRelieveText :- Test ended"); 
	 }
}
