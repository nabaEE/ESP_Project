package com.newHire;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
@Test(groups="Smoke", priority=-1, enabled=false)
public static void submitNewHireFormAndValidateActivateButton() throws AWTException, InterruptedException
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
		nhp.getFirstNameEditbox().sendKeys("Satya");
		//Enter last name
		nhp.getLastNameEditbox().sendKeys("Reddy");
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
	    nhp.getEmployeeId().sendKeys("MUNK34");
	    //Enter email id
	    nhp.getEmailIdEditbox().sendKeys("cavin12");
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
	    try {
	    hsp.getSubmitButton().click();
	    }
	    	catch (StaleElementReferenceException e) {
	    		hsp.getSubmitButton().click();
	    }
	    
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
	  System.out.println("*********Verify the activate button *******");
	  //hsp.getActivateButton().click();
	 // hsp.handleAlert();
	  Assert.assertTrue(hsp.getActivateButton().isDisplayed());
	  System.out.println("*********Verify the activate button *******");
	  System.out.println("                                 ");
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
		    nhp.getEmployeeId().sendKeys("MXC34");
		    //Enter email id
		    nhp.getEmailIdEditbox().sendKeys("satyak3");
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
		    String expErr="Mail Id already Exists.";
		    Thread.sleep(2000);
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
    nhp.getEmployeeId().sendKeys("AXZ7894222");
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
    String expErr="The Employee Id already exists in the system. Please correct.";
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
//5. Enter the DOB equals to joining date and verify the error message.
@Test()
public static void makeBothDOB_JoiningDateEqualAndverifyError()
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
		String date="1-Sept-2019";
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
	    String joiningDate="1-Sept-1990";
	    nhp.DatePicker(driver, joiningDateElement, joiningDate);
	    //Pick the group joining
	    WebElement groupJoiningDateElement=nhp.getGroupJoiningDate();
	    String groupJoiningDate="1-Sept-2019";
	    nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
	    //Enter the employee Id
	    nhp.getEmployeeId().sendKeys("nxtsar2");
	    //Enter email id
	    nhp.getEmailIdEditbox().sendKeys("sagar45");
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
	    WebdriverUtils.waitForElementPresent(driver, nhp.getSaveAndContinueButton());
	    nhp.getSaveAndContinueButton().click();	
	    String expErr="Joining Date should be greater than Date of Birth";
	    System.out.println("Expected error message :"+expErr);
	    //Capture the actual error message 
	    String actErr=nhp.getJoiningDateAndDOBEqualError().getText();
	    System.out.println("                        ");
	    System.out.println("*********Validate the error message********");
	    Assert.assertEquals(actErr,expErr);
	    System.out.println("                           ");
	    System.out.println("Actual error message is :"+actErr);
}

//6. Make the title dropdown blank and verify the error message.
@Test()
public static void VerifyErrorForkeepingTitleWinBlank()
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
		//Click on submit
		nhp.getSaveAndContinueButton().click();
		//Declare the expected error
		String expErr="Title cannot be empty";
		System.out.println("Expected error message is :"+expErr);
		//Capture the actual error message
		String actErr=nhp.getTitleBlankErrMessage().getText();
		System.out.println("                  ");
		System.out.println("********Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		System.out.println("                        ");
		System.out.println("Actual error message is :"+actErr);
}
//7.check the error message for keeping first name blank.
@Test()
public static void verifyErrorMessageForKeepingFirstNameBlank()
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
			//Click on first name
			nhp.getFirstNameEditbox().click();
			//Click on submit
			nhp.getSaveAndContinueButton().click();
			//Declare the error message
			String expErr="First Name cannot be empty";
			System.out.println("Expected error message is :"+expErr);
			//Capture the actual error
			String actErr=nhp.getFirstNameBlankErrMessage().getText();
			System.out.println("                ");
			System.out.println("*******Validate the error message********");
			System.out.println("                ");
			System.out.println("Actual error message is :"+actErr);
 }

//8. Verify the error message for keeping last name blank.
@Test()
public static void verifyErrorMessageForKeepingLastNameBlank() 
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
	//Click on first name
	nhp.getFirstNameEditbox().click();
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="First Name cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getLastNameEditboxBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);	
}
//9. Don't pick the DOB and verify the error message.
@Test()
public static void checkErrorMessageForNotPickingDOB()
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
		//Click on first name
		nhp.getFirstNameEditbox().click();
		//Click on submit
		nhp.getSaveAndContinueButton().click();
		//Declare the error message
		String expErr="Date Of Birth cannot be empty";
		System.out.println("Expected error message is :"+expErr);
		//Capture the actual error
		String actErr=nhp.getDobBlankErrMessage().getText();
		System.out.println("                ");
		System.out.println("*******Validate the error message********");
		System.out.println("                ");
		System.out.println("Actual error message is :"+actErr);		
}
//10. Check the error message for not picking Country of birth.
@Test()
public static void verifyErrorMessageForNotPickingCountryOfBirth()
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
			//Click on first name
			nhp.getFirstNameEditbox().click();
			//Click on submit
			nhp.getSaveAndContinueButton().click();
			//Declare the error message
			String expErr="Country Of Birth cannot be empty";
			System.out.println("Expected error message is :"+expErr);
			//Capture the actual error
			String actErr=nhp.getCountryOfBirthBlankErrMessage().getText();
			System.out.println("                ");
			System.out.println("*******Validate the error message********");
			System.out.println("                ");
			System.out.println("Actual error message is :"+actErr);			
}
//11. Verify the error message for keeping state of birth blank.
@Test()
public static void checkErrorMessageForNotPickingStateOfBirth()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on first name
	nhp.getFirstNameEditbox().click();
	//Pick the country of birth dropdown
	nhp.getCountryOfBirthDropdown().click();
	nhp.getPickCountryOfBirthAsIndia().click();
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="State Of Birth cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getStateOfBirthBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);			
}
//12. Make city of birth as blank and verify the error message.
@Test()
public static void checkErrorForKeepingCityOfBirthBlank()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on city of birth editbox
	nhp.getCityOfBirthEditbox().click();
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="City Of Birth cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getCityOfBirthErrBlankMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);	
}
//13.Check error message for not picking citizenship.
@Test()
public static void checkErrorForNotPickingCitizenShip()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Citizenship cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getCitizenshipBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);	
}
//14. Don't pick the gender radio button and click on save and continue to check the error message.
@Test()
public static void checkErrorForNotPickingGender()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Gender cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getGenderBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);	
}
//15. Don't select the marital status radio button and click on saveAndContinue to verify the error message.
@Test()
public static void checkErrorForNotSelectingMaritalStatus()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Marital Status cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getMaritalStatusBlankErrorMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);	
}
//16. Check the error message for not picking educational details.
@Test()
public static void checkErrorForNotPickingEducationDetails()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Education Details cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getEducationDetailsBlankErrorMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);
}
//17. Select not a fresher and keep the Relevant experience editbox blank to check the error message.
@Test()
public static void checkErrorForKeepingRelevantExpEditboxBlank()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on fresher switch button
	nhp.getFresherSwitchButton().click();
	//Click on the relevant experience editbox
	nhp.getRelevantExpEditbox().click();
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Relevant Experience (In Months) cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getRelevantExpEditboxBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);
	
}
//18. Pick source of hire as Campus Recruitment and click on saveAndContinue without picking UniversityName.
@Test()
public static void checkErrorForNotPickingUniversityName()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on source of hire editbox
	nhp.getSourceOfHireDropdown().click();
	nhp.getCampusRecruitmentSourceOfHire().click();
	//Click on submit
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="University/College Name cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getUniversityBlankErrMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);

}
//19. Pick source of hire as Referral and click on saveAndContinue without picking Referal Search.
@Test()
public static void checkErrorForKeepingReferalSearchBoxBlank()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on source of hire editbox
	nhp.getSourceOfHireDropdown().click();
	nhp.getReferalSourceOfHire().click();
	//Don't pick the referal
	nhp.getReferalSearchEditbox().click();
	//Click on save and continue
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
	String expErr="Referal Search cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getReferalSearchBlankErr().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);
}
//20. Don't pick the country and check the error message.
@Test()
public static void verifyErrorForNotPickingCountry()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on country dropdown
	nhp.getCountryDropdown().click();
	//Declare the error message
	String expErr="Country cannot be empty";
	System.out.println("Expected error message is :"+expErr);
	//Capture the actual error
	String actErr=nhp.getCountryBlankErrorMessage().getText();
	System.out.println("                ");
	System.out.println("*******Validate the error message********");
	System.out.println("                ");
	System.out.println("Actual error message is :"+actErr);
	
}
//21. Check error message for not picking the legal entity.
@Test()
public static void verifyErrorForNotPickingLegalEntity()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on country dropdown
	nhp.getCountryDropdown().click();	
    nhp.getPickCountryIndia().click();
    //Click on legal entity
    nhp.getLegalEntityDropdown().click();
  //Click on save and continue
  	nhp.getSaveAndContinueButton().click();
  	//Declare the error message
  	String expErr="Legal Entity cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getLegalEntityBlankErrorMessage().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);    
}
//22. Verify error message for not picking the location.
@Test()
public static void verifyErrorForNotPickingLocation()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on location dropdown
	nhp.getLocationDropdown().click();
	nhp.getSaveAndContinueButton().click();
  	//Declare the error message
  	String expErr="Location cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getLocationBlankErrorMessage().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);   
}
//23. Validate the error message for not picking joining date.
@Test()
public static void checkErrorForNotPickingJoiningDate()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on save and continue 
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
  	String expErr="Joining Date cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getJoiningDateBlankErrorMessage().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);
  }
//24. Check the error message for not picking the group joining date.
@Test()
public static void checkErrorForNotPickingGroupJoiningDate()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on save and continue 
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
  	String expErr="Group Joining Date cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getGroupJoiningBlankErr().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);	
}
//25. Verify the error message for keeping employee Id section blank.
@Test()
public static void makeEmployeeIdEditboxBlankAndValidateError()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on employee id editbox 
	nhp.getEmployeeId().click();
	//Click on save and continue 
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
  	String expErr="Employee ID cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getEmployeeIdBlankErrorMessage().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);	
}
//26. Make the email id section blank and check for the error message.
@Test()
public static void keepEmailIdSectionBlankAndVerifyError()
{
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on new hire option
	//lnp.getNewHireAdminValue().click();
	lnp.clickNewHire();
	//Call the new hire page
	NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
	//Click on employee id editbox 
	nhp.getEmployeeId().click();
	//Click on save and continue 
	nhp.getSaveAndContinueButton().click();
	//Declare the error message
  	String expErr="Email Id cannot be empty";
  	System.out.println("Expected error message is :"+expErr);
  	//Capture the actual error
  	String actErr=nhp.getEmaildIdBlankErrorMessage().getText();
  	System.out.println("                ");
  	System.out.println("*******Validate the error message********");
  	System.out.println("                ");
  	System.out.println("Actual error message is :"+actErr);	

}










}
