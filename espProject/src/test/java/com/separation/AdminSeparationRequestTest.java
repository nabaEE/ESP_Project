package com.separation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.LandingPage;
import esp.objectRepository.PeopleListPage;

public class AdminSeparationRequestTest extends BaseClass
{
//1. Click on people icon and select one employee then click on separation
@Test()
public static void submitSeparationRequest()
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
    plp.getPickSeparation().click();
    
  }
}
