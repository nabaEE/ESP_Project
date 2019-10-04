package com.newHire;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.CompensationPage;
import esp.objectRepository.HireSummaryPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.NewHirePage;

public class NewHireTest extends BaseClass
{

//1. Submit new hire form and verify.
@Test(groups="Smoke")
public static void submitNewHireForm() throws AWTException, InterruptedException
{
	    //Call the landing page
		LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
		//Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		//Click on new hire option
		//lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		//Call the new hire page
		NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
		//Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		//Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Samir");
		//Enter last name
		nhp.getLastNameEditbox().sendKeys("Gantayat");
		//Pick date of birth
		WebElement element=nhp.getDateOfBirthCalenderWindow();
		String date="1-Feb-1990";
		nhp.DatePicker(driver, element, date);
		//Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		//Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		//Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		//Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		//Select the gender Male
		nhp.getMaleRadioButton().click();
		//select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		//Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		//Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
	  //Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		//Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		//Select the country
		nhp.getCountryDropdown().click();
	    nhp.getPickCountryIndia().click();
	    //Select Legal Entity
	    nhp.getLegalEntityDropdown().click();
	    nhp.getPickLegalEntity().click();
	    //Select the location
	    nhp.getLocationDropdown().click();
	    nhp.getPickLocation().click();
	    //Pick the joining date
	    WebElement joiningDateElement=nhp.getJoiningDate();
	    String joiningDate="1-Sept-2019";
	    nhp.DatePicker(driver, joiningDateElement, joiningDate);
	    //Pick the group joining
	    WebElement groupJoiningDateElement=nhp.getGroupJoiningDate();
	    String groupJoiningDate="1-Sept-2019";
	    nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
	    //Enter the employee Id
	    nhp.getEmployeeId().sendKeys("NEKUR23");
	    //Enter email id
	    nhp.getEmailIdEditbox().sendKeys("nexkur12");
	    //Pick employment type 
	    nhp.getEmploymentTypeDropdown().click();
	    nhp.getPickEmploymentType().click();
	    //Pick employment status
	    nhp.getEmploymentStatusDropdown().click();
	    nhp.getPickEmploymentStatusAsConfirmed().click();
	    //Enter three letters in the role editbox
	    nhp.getRoleEditbox().sendKeys("ass");
	    nhp.getPickRole().click();
	    //Enter three letters in the Department editbox and pick one department
	    nhp.getDepartmentEditbox().sendKeys("sal");
	    nhp.getPickDepartment().click();
	    //Enter three letters in the designation editbox and pick one.
	    nhp.getDesignationEditbox().sendKeys("sal");
	    nhp.getPickDesignation().click();
	    //Enter three letters in the reporting Hiring Manager and pick one.
	    nhp.getReportingHiringManagerEditbox().sendKeys("sar");
	    nhp.getPickReportingHiringManager().click();
	    //Select paytype
	    nhp.getPickTypeDropdown().click();
	    nhp.getPickPayType().click();
	    //Pick pay frequency
	    nhp.getPayFrequencyDropdown().click();
	    nhp.getPickPayFrequencyDropdownValue().click();
	    //Pick FT/PT indicator
	    nhp.getFtptIndicatorDropdown().click();
	    nhp.getPickPartTimeIndicator().click();
	    //Enter FTE Equivalent hours
	    nhp.getFteEditbox().sendKeys("30");
	    //Click on save and Continue
	    nhp.getSaveAndContinueButton().click();
	    //Call the compensation page
	    CompensationPage cmp= PageFactory.initElements(driver, CompensationPage.class);
	    //select above 3 lakhs
	    cmp.getClickAbove3Lakh().click();
	    //Click on save And continue
	    WebdriverUtils.waitForPageToLoad(driver);
	    cmp.getSaveAndContinueButton().click();
	  //Call Hire summary page
	    HireSummaryPage hsp= PageFactory.initElements(driver, HireSummaryPage.class);
	   /****************************Adding mobile contact details******************************/
	    WebdriverUtils.waitForElementPresent(driver, hsp.getClickContactDetails());
	    hsp.getClickContactDetails().click();
	    //Click phone type and pick mobile
	    hsp.getPhoneTypeDropdown().click();
	    hsp.getPickPhoneTypeAsMobile().click();
	    //Select country code
	    hsp.getCountryCodeDropdown().click();
	    hsp.getPickCountryCodeAsIndia().click();
	    hsp.getNumberEditbox().sendKeys("9681312762");
	    //Click on submit
	    hsp.getSubmitButton().click();
	    /****************************Adding Home contact details******************************/
	    WebdriverUtils.waitForElementPresent(driver, hsp.getClickContactDetails());
	    hsp.getClickContactDetails().click();
	    //Click phone type and pick mobile
	    hsp.getPhoneTypeDropdown().click();
	    hsp.getPickPhoneTypeAsHome().click();
	    //Select country code
	    hsp.getCountryCodeDropdown().click();
	    hsp.getPickCountryCodeAsIndia().click();
	    hsp.getNumberEditbox().sendKeys("9681312763");
	    //Click on submit
	    hsp.getSubmitButton().click();
	    /*******************************Adding current Address and permanent address************/
	    WebdriverUtils.waitForElementPresent(driver, hsp.getClickCurrentAddressPencilIcon());
	    hsp.getClickCurrentAddressPencilIcon().click();
	    //Click on effective from date and pick the date
	    hsp.getEffectiveFromDateCalenderWin().click();
	    hsp.getCurrentDate().click();
	    //Enter address line1
	    hsp.getAddressLine1().sendKeys("Mathura, block1");
	    //Click on country dropdown and Pick country
	    WebdriverUtils.waitForElementPresent(driver, hsp.getCountryDropdownOnAddressDetailsWin());
	    hsp.getCountryDropdownOnAddressDetailsWin().click();
	    hsp.getPickCountryIndiaOnAddressDetailsWin().click();
	    //Click on state dropdown and pick a state
	    hsp.getStateDropdownOnAddressDetailsWin().click();
	    hsp.getPickState().click();
	    //Type three letters in the city search editbox
	    hsp.getCityEditbox().sendKeys("hyd");
	    hsp.getPickCity().click();
	    //Enter postal code
	    hsp.getPostalCode().sendKeys("78452142");
	    //Click on copy current address as permanent addres
	    hsp.getCopyCurrentAddressAsPermanentAddress().click();
	    //upload document
	    hsp.clickAnduploadDocument();
	    //click on submit
	    hsp.getSubmitButton().click();
	  //Stop the page load
	    BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
	    
	  /****************************Adding Personal Email details***********************************/
	   WebdriverUtils.waitForElementPresent(driver, hsp.getEmailDetailsAddIcon());
	   hsp.getEmailDetailsAddIcon().click();
	   //Click on email type dropdown and pick personal email
	   hsp.getEmailTypeDropdown().click();
	   hsp.getPickPersonalEmail().click();
	   //Enter email id
	   hsp.getEmailIdEditbox().sendKeys("ranu@gmail.com");
	   //Click on submit
	   hsp.getSubmitButton().click();
	   WebdriverUtils.waitForPageToLoad(driver);
	  /***************************Adding Emergency email********************************************/
	   WebdriverUtils.waitForElementPresent(driver, hsp.getEmailDetailsAddIcon());
	   hsp.getEmailDetailsAddIcon().click();
	   //Click on email type dropdown and pick personal email
	   hsp.getEmailTypeDropdown().click();
	   hsp.getPickEmergencyEmail().click();
	 //Enter email id
	   hsp.getEmailIdEditbox().sendKeys("ranuj@gmail.com");
	 //Click on submit
	   hsp.getSubmitButton().click();
	  /******************************Adding Aadhar Statutory Details****************************************/
	   WebdriverUtils.waitForElementPresent(driver, hsp.getStatutoryNumbersAddIcon());
	   hsp.getStatutoryNumbersAddIcon().click();
	   //Click on statutorytype
	   hsp.getStatutoryTypeDropdown().click();
	   hsp.getPickAadharStatutoryType().click();
	   //Enter the Aadhar number
	   hsp.getStatutoryValueEditbox().sendKeys("852014796312");
	   hsp.clickAnduploadDocument();
	   //click on submit
	   hsp.getStatutoryDetailsSubmitButton().click();
	   //Stop the page load
	   BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
	   WebdriverUtils.waitForPageToLoad(driver);
	   /******************************Adding UAN Number Statutory Details*****************************/
	   WebdriverUtils.waitForElementPresent(driver, hsp.getStatutoryNumbersAddIcon());
	   
	   hsp.getStatutoryNumbersAddIcon().click();
	   //Click on statutorytype
	   hsp.getStatutoryTypeDropdown().click();
	   hsp.pickUANStatutoryType();
	   //Enter the PAN number
	   hsp.getStatutoryValueEditbox().sendKeys("789654123021");
	   //click on submit
	   hsp.getStatutoryDetailsSubmitButton().click();
	   
	   /***************************Adding Health details********************************/
	   WebdriverUtils.waitForElementPresent(driver, hsp.getHealthDetailsAddIcon());
	  hsp.getHealthDetailsAddIcon().click();
	  //Enter height
	  hsp.getHeightEditbox().sendKeys("165");
	  //Enter weight
	  hsp.getWeightEditbox().sendKeys("64");
	  //Click on blood group and pick one
	  hsp.getBloodGroupDropdown().click();
	  hsp.getPickBloodGroup().click();
	  //Click on submit
	  hsp.getSubmitButton().click();
	  /***************************Uploading appointment Letter************************/
	  hsp.scrollDown();
	  hsp.uploadAppointmentLetter();
	  WebdriverUtils.waitForPageToLoad(driver);
	  WebdriverUtils.waitForElementPresent(driver, hsp.getFileUploadButton());
	  //Click on upload document
	  hsp.getFileUploadButton().click();
	  System.out.println("Expected to view the activate button");
	  Assert.assertTrue(hsp.getActivateButton().isDisplayed());
	  System.out.println("                             ");
	  //Click on activate button
	  WebdriverUtils.waitForElementPresent(driver, hsp.getActivateButton());
	  hsp.getActivateButton().click();
	  System.out.println("Activate button is displayed and activated successfully");
	  }
//2. Enter an existing email and validate the error message.

@Test()
public static void checkErrorMessageForEnteringExistingEmail() throws InterruptedException
{
	//Call the landing page
			LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
			//Click on admin icon
			WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
			lnp.getAdminIcon().click();
			//Click on new hire option
			//lnp.getNewHireAdminValue().click();
			lnp.clickNewHire();
			//Call the new hire page
			NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
			//Click on title dropdown and pick MR
			nhp.getTitleDropdown().click();
			nhp.getPickTitle_MR().click();
			//Enter the first Name
			nhp.getFirstNameEditbox().sendKeys("Sadhav");
			//Enter last name
			nhp.getLastNameEditbox().sendKeys("dhawan");
			//Pick date of birth
			WebElement element=nhp.getDateOfBirthCalenderWindow();
			String date="7-Oct-1989";
			nhp.DatePicker(driver, element, date);
			//Pick country of birth as India
			nhp.getCountryOfBirthDropdown().click();
			nhp.getPickCountryOfBirthAsIndia().click();
			//Pick state of birth
			nhp.getStateOfBirthDropdown().click();
			nhp.getPickStateOfBirth().click();
			//Enter the city of birth
			nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
			//Pick citizenship
			nhp.getCitizenshipDropdown().click();
			nhp.getPickCitizenshipAsIndia().click();
			//Select the gender Male
			nhp.getMaleRadioButton().click();
			//select marital status as single
			nhp.getMaritalStatusAsSingle().click();
			//Pick education Details
			nhp.getEducationDetailsDropdown().click();
			nhp.getPickGraduate().click();
			//Click on source of hire dropdown
			nhp.getSourceOfHireDropdown().click();
		  //Pick campus Recruitment
			nhp.getCampusRecruitmentSourceOfHire().click();
			//Click on University dropdown
			nhp.getUniversityNameDropdown().click();
			nhp.getPickUniversity().click();
			//Select the country
			nhp.getCountryDropdown().click();
		    nhp.getPickCountryIndia().click();
		    //Select Legal Entity
		    nhp.getLegalEntityDropdown().click();
		    nhp.getPickLegalEntity().click();
		    //Select the location
		    nhp.getLocationDropdown().click();
		    nhp.getPickLocation().click();
		    //Pick the joining date
		    WebElement joiningDateElement=nhp.getJoiningDate();
		    String joiningDate="1-Sept-2019";
		    nhp.DatePicker(driver, joiningDateElement, joiningDate);
		    //Pick the group joining
		    WebElement groupJoiningDateElement=nhp.getGroupJoiningDate();
		    String groupJoiningDate="1-Sept-2019";
		    nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		    //Enter the employee Id
		    nhp.getEmployeeId().sendKeys("SADH24");
		    //Enter email id
		    nhp.getEmailIdEditbox().sendKeys("dhawan25");
		    //Pick employment type 
		    nhp.getEmploymentTypeDropdown().click();
		    nhp.getPickEmploymentType().click();
		    //Pick employment status
		    nhp.getEmploymentStatusDropdown().click();
		    nhp.getPickEmploymentStatusAsConfirmed().click();
		    //Enter three letters in the role editbox
		    nhp.getRoleEditbox().sendKeys("ass");
		    nhp.getPickRole().click();
		    //Enter three letters in the Department editbox and pick one department
		    nhp.getDepartmentEditbox().sendKeys("sal");
		    nhp.getPickDepartment().click();
		    //Enter three letters in the designation editbox and pick one.
		    nhp.getDesignationEditbox().sendKeys("sal");
		    nhp.getPickDesignation().click();
		    //Enter three letters in the reporting Hiring Manager and pick one.
		    nhp.getReportingHiringManagerEditbox().sendKeys("sar");
		    nhp.getPickReportingHiringManager().click();
		    //Select paytype
		    nhp.getPickTypeDropdown().click();
		    nhp.getPickPayType().click();
		    //Pick pay frequency
		    nhp.getPayFrequencyDropdown().click();
		    nhp.getPickPayFrequencyDropdownValue().click();
		    //Pick FT/PT indicator
		    nhp.getFtptIndicatorDropdown().click();
		    nhp.getPickPartTimeIndicator().click();
		    //Enter FTE Equivalent hours
		    nhp.getFteEditbox().sendKeys("30");
		    //Click on save and Continue
		    nhp.getSaveAndContinueButton().click();	
		    Thread.sleep(2000);
		    //Declare the expected error message
		    String expErr="Mail Id already Exists. ";
		    System.out.println("Expected error message is :"+expErr);
		    //Capture the actual error
		    String actErr=nhp.getEmailAlreadyExistErr().getText();
		    System.out.println(actErr);
		    System.out.println("********Validate the error message**********");
		    Assert.assertEquals(actErr, expErr);
		    System.out.println("                  ");
		    System.out.println("Actual error message is :"+actErr);
}

//3. Enter an existing Employee Id and validate the error message.

@Test()
public static void enterExistEmployeeIdAndValidateErrorMessage() throws InterruptedException
{
	//Call the landing page
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on title dropdown and pick MR
	nhp.getTitleDropdown().click();
	nhp.getPickTitle_MR().click();
	//Enter the first Name
	nhp.getFirstNameEditbox().sendKeys("Sadhav");
	//Enter last name
	nhp.getLastNameEditbox().sendKeys("dhawan");
	//Pick date of birth
	WebElement element=nhp.getDateOfBirthCalenderWindow();
	String date="7-Oct-1989";
	nhp.DatePicker(driver, element, date);
	//Pick country of birth as India
	nhp.getCountryOfBirthDropdown().click();
	nhp.getPickCountryOfBirthAsIndia().click();
	//Pick state of birth
	nhp.getStateOfBirthDropdown().click();
	nhp.getPickStateOfBirth().click();
	//Enter the city of birth
	nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
	//Pick citizenship
	nhp.getCitizenshipDropdown().click();
	nhp.getPickCitizenshipAsIndia().click();
	//Select the gender Male
	nhp.getMaleRadioButton().click();
	//select marital status as single
	nhp.getMaritalStatusAsSingle().click();
	//Pick education Details
	nhp.getEducationDetailsDropdown().click();
	nhp.getPickGraduate().click();
	//Click on source of hire dropdown
	nhp.getSourceOfHireDropdown().click();
  //Pick campus Recruitment
	nhp.getCampusRecruitmentSourceOfHire().click();
	//Click on University dropdown
	nhp.getUniversityNameDropdown().click();
	nhp.getPickUniversity().click();
	//Select the country
	nhp.getCountryDropdown().click();
    nhp.getPickCountryIndia().click();
    //Select Legal Entity
    nhp.getLegalEntityDropdown().click();
    nhp.getPickLegalEntity().click();
    //Select the location
    nhp.getLocationDropdown().click();
    nhp.getPickLocation().click();
    //Pick the joining date
    WebElement joiningDateElement=nhp.getJoiningDate();
    String joiningDate="1-Sept-2019";
    nhp.DatePicker(driver, joiningDateElement, joiningDate);
    //Pick the group joining
    WebElement groupJoiningDateElement=nhp.getGroupJoiningDate();
    String groupJoiningDate="1-Sept-2019";
    nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
    //Enter the employee Id
    nhp.getEmployeeId().sendKeys("SADH24");
    //Enter email id
    nhp.getEmailIdEditbox().sendKeys("dhawan25");
    //Pick employment type 
    nhp.getEmploymentTypeDropdown().click();
    nhp.getPickEmploymentType().click();
    //Pick employment status
    nhp.getEmploymentStatusDropdown().click();
    nhp.getPickEmploymentStatusAsConfirmed().click();
    //Enter three letters in the role editbox
    nhp.getRoleEditbox().sendKeys("ass");
    nhp.getPickRole().click();
    //Enter three letters in the Department editbox and pick one department
    nhp.getDepartmentEditbox().sendKeys("sal");
    nhp.getPickDepartment().click();
    //Enter three letters in the designation editbox and pick one.
    nhp.getDesignationEditbox().sendKeys("sal");
    nhp.getPickDesignation().click();
    //Enter three letters in the reporting Hiring Manager and pick one.
    nhp.getReportingHiringManagerEditbox().sendKeys("sar");
    nhp.getPickReportingHiringManager().click();
    //Select paytype
    nhp.getPickTypeDropdown().click();
    nhp.getPickPayType().click();
    //Pick pay frequency
    nhp.getPayFrequencyDropdown().click();
    nhp.getPickPayFrequencyDropdownValue().click();
    //Pick FT/PT indicator
    nhp.getFtptIndicatorDropdown().click();
    nhp.getPickPartTimeIndicator().click();
    //Enter FTE Equivalent hours
    nhp.getFteEditbox().sendKeys("30");
    //Click on save and Continue
    nhp.getSaveAndContinueButton().click();	
    Thread.sleep(2000);
    //Declare the expected error message
    String expErr="Emp Id already Exists.";
    System.out.println("Expected error message is :"+expErr);
    //Capture the actual error
    String actErr=nhp.getExistEmployeeIdErr().getText();
    System.out.println(actErr);
    System.out.println("********Validate the error message**********");
    Assert.assertEquals(actErr, expErr);
    System.out.println("                  ");
    System.out.println("Actual error message is :"+actErr);
}

//4. Click on title dropdown and verify the values present.
@Test()
public static void clickAndverifyTitleDropdownValues()
{
	//Call the landing page
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on title dropdown
	nhp.getTitleDropdown().click();
	//Declare the expected values
	List<String> expValues= new ArrayList<String>();
	expValues.add("Mr.");
	expValues.add("Ms.");
	expValues.add("Mrs.");
	expValues.add("Dr.");
	expValues.add("Jr.");
	expValues.add("Col.");
	expValues.add("Lt.Col.");
	expValues.add("Brig.");
	expValues.add("Maj");
	expValues.add("Prof.");
	expValues.add("Capt.");
	expValues.add("Master");
	expValues.add("Lt.CDR.");
	System.out.println("Expected title values are :"+expValues);
	//Capture the actual data
	List<String> actValues=nhp.printTitleDropdownValues();
	System.out.println("           ");
	System.out.println("****************Validate the actual values********************");
	Assert.assertEquals(actValues, expValues);
	System.out.println("                        ");
	System.out.println("Actual values are :"+actValues);
	
	
	
}













}
