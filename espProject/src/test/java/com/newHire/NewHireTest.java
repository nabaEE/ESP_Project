package com.newHire;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.objectRepository.LandingPage;

public class NewHireTest extends BaseClass
{

//1. Submit new hire form and verify.
@Test()
public static void submitNewHireForm()
{
	    //Call the landing page
		LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
		//Click on admin icon
		lnp.getAdminIcon().click();
		//Click on new hire option
		lnp.getNewHireAdminValue().click();
		
}
}
