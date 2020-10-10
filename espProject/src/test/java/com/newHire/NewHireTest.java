package com.newHire;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.FileUtils;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.CompensationPage;
import esp.objectRepository.HireSummaryPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.NewHirePage;

public class NewHireTest extends BaseClass {
	static FileUtils fil = new FileUtils();

//Mark attendance
	@Test(enabled = false)
	public static void markAttendance() {
		log.debug("-------Mark attendance : test started--------");
		driver.findElement(By.id("Not_now")).click();
		log.debug("-------Mark attendance : test ended--------");
	}

//1. Submit new hire form and verify.
	@Test(groups = "Smoke")
	public static void submitNewHireFormAndValidateActivateButton() throws Exception {
		log.debug("---------submit New Hire FormAnd Validate Activate Button:- test started----------");
		// driver.findElement(By.id("Not_now")).click();
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click add new button
		WebdriverUtils.waitForElementPresent(driver, nhp.getClickAddNewButton());
		nhp.getClickAddNewButton().click();
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Suman");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("Patra");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("Nextgen", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("Nextgen", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Nextgen", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("0001112");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("suman.patra");
		// Click email domain
		nhp.getEmailDomainDropdown().click();
		// Select the domain type
		nhp.getPickEmailDomain().click();
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Stop page refresh
		// BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		// Enter three letters in the Department editbox and pick one department
		/*
		 * try { nhp.getDepartmentEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectDepartment(); //nhp.getPickDepartment().click(); }
		 * catch(StaleElementReferenceException e) { nhp.getPickDepartment().click(); }
		 */
		nhp.getDepartmentEditbox().sendKeys("sal");
		Thread.sleep(2000);
		nhp.selectDepartment();
		// Enter three letters in the role editbox
		/*
		 * try { nhp.getRoleEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectRole(); } catch(StaleElementReferenceException e) {
		 * //nhp.selectRole(); nhp.selectRole(); }
		 */
		nhp.getRoleEditbox().sendKeys("sal");
		Thread.sleep(2000);
		nhp.selectRole();
		// Enter three letters and select Designation
		/*
		 * try { nhp.getDesignationEditbox().sendKeys("Sal"); Thread.sleep(2000);
		 * nhp.getPickDesignation().click(); } catch(StaleElementReferenceException e) {
		 * nhp.getPickDesignation().click(); }
		 */
		nhp.getDesignationEditbox().sendKeys("Sal");
		Thread.sleep(2000);
		nhp.getPickDesignation().click();
		// Enter three letters and select reporting hiring manager
		/*
		 * try { nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
		 * Thread.sleep(2000); nhp.getPickReportingHiringManager().click(); }
		 * catch(StaleElementReferenceException e) {
		 * WebdriverUtils.waitForElementPresent(driver,
		 * nhp.getPickReportingHiringManager());
		 * nhp.getPickReportingHiringManager().click(); }
		 */
		nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
		Thread.sleep(2000);
		nhp.getPickReportingHiringManager().click();
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();
		// Call the compensation page
		CompensationPage cmp = PageFactory.initElements(driver, CompensationPage.class);
		// select above 3 lakhs
		cmp.getSelectProfileDropdown().click();
		cmp.getSelectCompProfileNextgen().click();
		// Click on save And continue
		WebdriverUtils.waitForPageToLoad(driver);
		cmp.getsaveAndContinue().click();
		// Call Hire summary page
		HireSummaryPage hsp = PageFactory.initElements(driver, HireSummaryPage.class);
		/****************************
		 * Adding mobile contact details
		 ******************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getClickContactDetails());
		hsp.getClickContactDetails().click();
		// Click phone type and pick mobile
		hsp.getPhoneTypeDropdown().click();
		hsp.getPickPhoneTypeAsMobile().click();
		// Select country code
		hsp.getCountryCodeDropdown().click();
		hsp.getPickCountryCodeAsIndia().click();
		hsp.getNumberEditbox().sendKeys("9681312762");
		// Click on submit
		hsp.getSubmitButton().click();
		/****************************
		 * Adding Home contact details
		 ******************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getClickContactDetails());
		hsp.getClickContactDetails().click();
		// Click phone type and pick mobile
		hsp.getPhoneTypeDropdown().click();
		hsp.getPickPhoneTypeAsHome().click();
		// Select country code
		hsp.getCountryCodeDropdown().click();
		hsp.getPickCountryCodeAsIndia().click();
		hsp.getNumberEditbox().sendKeys("9681312763");
		// Click on submit
		hsp.getSubmitButton().click();
		/*******************************
		 * Adding current Address and permanent address
		 ************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getClickCurrentAddressPencilIcon());
		hsp.getClickCurrentAddressPencilIcon().click();
		// Click on effective from date and pick the date
		hsp.getEffectiveFromDateCalenderWin().click();
		hsp.getCurrentDate().click();
		// Enter address line1
		hsp.getAddressLine1().sendKeys("Mathura, block1");
		// Click on country dropdown and Pick country
		WebdriverUtils.waitForElementPresent(driver, hsp.getCountryDropdownOnAddressDetailsWin());
		hsp.getCountryDropdownOnAddressDetailsWin().click();
		hsp.getPickCountryIndiaOnAddressDetailsWin().click();
		// Click on state dropdown and pick a state
		hsp.getStateDropdownOnAddressDetailsWin().click();
		hsp.getPickState().click();
		// Type three letters in the city search editbox
		hsp.getCityEditbox().sendKeys("hyd");
		hsp.getPickCity().click();
		// Enter postal code
		hsp.getPostalCode().sendKeys("78452142");
		// Click on copy current address as permanent address
		hsp.getCopyCurrentAddressAsPermanentAddress().click();
		// upload document
		WebdriverUtils.waitForCompleteElementToLoad(hsp.getSubmitButton());
		// click on submit
		try {
			hsp.clickAnduploadDocument();
			hsp.getSubmitButton().click();
			WebdriverUtils.waitForCompleteElementToLoad(hsp.getEmailDetailsAddIcon());
		} catch (StaleElementReferenceException e) {
			hsp.getSubmitButton().click();
		}

		// Stop the page load
		BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		/****************************
		 * Adding Personal Email details
		 ***********************************/
		hsp.getEmailDetailsAddIcon().click();

		// Click on email type dropdown and pick personal email
		hsp.getEmailTypeDropdown().click();
		hsp.getPickPersonalEmail().click();
		// Enter email id
		hsp.getEmailIdEditbox().sendKeys("ranu@gmail.com");
		// Click on submit
		hsp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		/***************************
		 * Adding Emergency email
		 ********************************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getEmailDetailsAddIcon());
		hsp.getEmailDetailsAddIcon().click();
		// Click on email type dropdown and pick personal email
		hsp.getEmailTypeDropdown().click();
		hsp.getPickEmergencyEmail().click();
		// Enter email id
		hsp.getEmailIdEditbox().sendKeys("ranuj@gmail.com");
		// Click on submit
		hsp.getSubmitButton().click();
		/******************************
		 * Adding Aadhar Statutory Details
		 ****************************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getStatutoryNumbersAddIcon());
		hsp.getStatutoryNumbersAddIcon().click();
		// Click on statutorytype
		hsp.getStatutoryTypeDropdown().click();
		hsp.getPickAadharStatutoryType().click();
		// Enter the Aadhar number
		hsp.getStatutoryValueEditbox().sendKeys("852014796312");
		hsp.clickAnduploadDocument();
		// click on submit
		hsp.getStatutoryDetailsSubmitButton().click();

		// Stop the page load
		// BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		WebdriverUtils.waitForPageToLoad(driver);
		/******************************
		 * Adding UAN Number Statutory Details
		 *****************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getStatutoryNumbersAddIcon());

		hsp.getStatutoryNumbersAddIcon().click();
		// Click on statutorytype
		hsp.getStatutoryTypeDropdown().click();
		hsp.pickUANStatutoryType();
		// Enter the PAN number
		hsp.getStatutoryValueEditbox().sendKeys("789654123021");
		// click on submit
		hsp.getStatutoryDetailsSubmitButton().click();

		/***************************
		 * Adding Health details
		 ********************************/
		WebdriverUtils.waitForElementPresent(driver, hsp.getHealthDetailsAddIcon());
		hsp.getHealthDetailsAddIcon().click();
		// Enter height
		hsp.getHeightEditbox().sendKeys("165");
		// Enter weight
		hsp.getWeightEditbox().sendKeys("64");
		// Click on blood group and pick one
		hsp.getBloodGroupDropdown().click();
		hsp.getPickBloodGroup().click();
		// Click on submit
		hsp.getSubmitButton().click();
		/***************************
		 * Uploading appointment Letter
		 ************************/
		hsp.scrollDown();
		hsp.uploadAppointmentLetter();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, hsp.getFileUploadButton());
		// Click on upload document
		hsp.getFileUploadButton().click();
		log.debug("Expected to view the activate button");
		Assert.assertTrue(hsp.getActivateButton().isDisplayed());
		log.debug("                             ");
		// Click on activate button
		WebdriverUtils.waitForElementPresent(driver, hsp.getActivateButton());
		log.debug("-------Verify the activate button-------");
		// hsp.getActivateButton().click();
		// hsp.handleAlert();
		Assert.assertTrue(hsp.getActivateButton().isDisplayed());
		log.debug("                                 ");
		log.info("Activate button is displayed and activated successfully");
		log.info("---------submit New Hire Form And Validate Activate Button:- test ended----------.");
	}
//2. Enter an existing email and validate the error message.

	@Test(groups = "Smoke")
	public static void checkErrorMessageForEnteringExistingEmail() throws Exception {
		log.debug("---------check Error Message For Entering Existing Email:- test started.----------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Sadhav");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("dhawan");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("Nextgen", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("Nextgen", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Nextgen", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("NX8520");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("naman.kar");
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Enter three letters in the role editbox
		// Enter three letters in the role editbox
		try {
			nhp.getRoleEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectRole();
		} catch (StaleElementReferenceException e) {
			// nhp.selectRole();
			nhp.selectRole();
		}
		// Enter three letters in the Department editbox and pick one department
		try {
			nhp.getDepartmentEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectDepartment();
			// nhp.getPickDepartment().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDepartment().click();
		}
		// Enter three letters and select Designation
		try {
			nhp.getDesignationEditbox().sendKeys("Sal");
			Thread.sleep(2000);
			nhp.getPickDesignation().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDesignation().click();
		}
		// Enter three letters and select reporting hiring manager
		try {
			nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
			Thread.sleep(2000);
			nhp.getPickReportingHiringManager().click();
		} catch (StaleElementReferenceException e) {
			WebdriverUtils.waitForElementPresent(driver, nhp.getPickReportingHiringManager());
			nhp.getPickReportingHiringManager().click();
		}
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();
		Thread.sleep(2000);
		// Declare the expected error message
		String expErr = "Mail Id already Exists.";
		Thread.sleep(2000);
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getEmailAlreadyExistErr().getText();
		log.debug("-----------Validate the error message----------");
		log.fatal("actual error message is incorrect");
		Assert.assertEquals(actErr, expErr);
		System.out.println("                  ");
		log.info("Actual error message is :" + actErr);
		log.info("---------check Error Message For Entering Existing Email:- test ended.----------");
	}

//3. Enter an existing Employee Id and validate the error message.

	@Test(groups = "Smoke")
	public static void enterExistEmployeeIdAndValidateErrorMessage() throws Exception {
		log.debug("------------Enter existing EemployeeId and validate error Message:- test started---------------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Sadhav");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("dhawan");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("Nextgen", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("Nextgen", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Nextgen", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("AXZ7894222");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("khawan25");
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Enter three letters in the role editbox
		// Enter three letters in the role editbox
		try {
			nhp.getRoleEditbox().sendKeys("sal");
			nhp.selectRole();
		} catch (StaleElementReferenceException e) {
			// nhp.selectRole();
			nhp.selectRole();
		}
		// Enter three letters in the Department editbox and pick one department
		try {
			nhp.getDepartmentEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectDepartment();
			// nhp.getPickDepartment().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDepartment().click();
		}
		// Enter three letters and select Designation
		try {
			nhp.getDesignationEditbox().sendKeys("Sal");
			Thread.sleep(2000);
			nhp.getPickDesignation().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDesignation().click();
		}
		// Enter three letters and select reporting hiring manager
		try {
			nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
			Thread.sleep(2000);
			nhp.getPickReportingHiringManager().click();
		} catch (StaleElementReferenceException e) {
			WebdriverUtils.waitForElementPresent(driver, nhp.getPickReportingHiringManager());
			nhp.getPickReportingHiringManager().click();
		}
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();

		Thread.sleep(2000);
		// Declare the expected error message
		String expErr = "The Employee Id already exists in the system. Please correct.";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getExistEmployeeIdErr().getText();
		log.debug("---------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                  ");
		log.info("Actual error message is :" + actErr);
		log.info("------------Enter existing EemployeeId and validate error Message:- test ended---------------");
	}

//4. Click on title dropdown and verify the values present.
	@Test()
	public static void clickAndverifyTitleDropdownValues() {
		log.debug("-----------Click and verify title dropdown values:- test started-----------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown
		nhp.getTitleDropdown().click();
		// Declare the expected values
		List<String> expValues = new ArrayList<String>();
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
		log.debug("Expected title values are :" + expValues);
		// Capture the actual data
		List<String> actValues = nhp.printTitleDropdownValues();
		System.out.println("           ");
		log.debug("----------Validate the actual values----------");
		Assert.assertEquals(actValues, expValues);
		System.out.println("                        ");
		log.info("Actual values are :" + actValues);
		log.info("-----------Click and verify title dropdown values:- test ended-----------");
	}

//5. Enter the DOB equals to joining date and verify the error message.
	@Test(groups = "Smoke")
	public static void makeBothDOB_JoiningDateEqualAndverifyError() throws Exception {
		log.debug("-----------Make both DOB and Joining Date equal and verify error message:- test started-----------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Sadhav");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("dhawan");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("Nextgen", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("Nextgen", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Nextgen", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("NXTS95");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("tmssagar45");
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Enter three letters in the role editbox
		// Enter three letters in the role editbox
		try {
			nhp.getRoleEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectRole();
		} catch (StaleElementReferenceException e) {
			// nhp.selectRole();
			nhp.selectRole();
		}
		// Enter three letters in the Department editbox and pick one department
		try {
			nhp.getDepartmentEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectDepartment();
			// nhp.getPickDepartment().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDepartment().click();
		}
		// Enter three letters and select Designation
		try {
			nhp.getDesignationEditbox().sendKeys("Sal");
			Thread.sleep(2000);
			nhp.getPickDesignation().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDesignation().click();
		}
		// Enter three letters and select reporting hiring manager
		try {
			nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
			Thread.sleep(2000);
			nhp.getPickReportingHiringManager().click();
		} catch (StaleElementReferenceException e) {
			WebdriverUtils.waitForElementPresent(driver, nhp.getPickReportingHiringManager());
			nhp.getPickReportingHiringManager().click();
		}
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();
		String expErr = "Joining Date should be greater than Date of Birth";
		log.debug("Expected error message :" + expErr);
		// Capture the actual error message
		String actErr = nhp.getJoiningDateAndDOBEqualError().getText();
		log.debug("                        ");
		log.debug("---------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                           ");
		log.info("Actual error message is :" + actErr);
		log.info("-----------Make both DOB and Joining Date equal and verify error message:- test ended-----------");
	}

//6. Make the title dropdown blank and verify the error message.
	@Test()
	public static void VerifyErrorForkeepingTitleWinBlank() {
		log.debug("--------Verify error message for keeping title window blank :-test started---------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown
		nhp.getTitleDropdown().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the expected error
		String expErr = "Title cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error message
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getTitleBlankErrMessage().getText();
		System.out.println("                  ");
		log.debug("--------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                        ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Verify error message for keeping title window blank :-test ended---------");
	}

//7.check the error message for keeping first name blank.
	@Test()
	public static void verifyErrorMessageForKeepingFirstNameBlank() {
		log.debug("---------Verify error message for keeping first name blank:- test started------------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on first name
		nhp.getFirstNameEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "First Name cannot be empty";
		log.info("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getFirstNameBlankErrMessage().getText();
		System.out.println("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.info("                ");
		System.out.println("Actual error message is :" + actErr);
		log.info("---------Verify error message for keeping first name blank:- test ended------------");
	}

//8. Verify the error message for keeping last name blank.
	@Test()
	public static void verifyErrorMessageForKeepingLastNameBlank() {
		log.debug("------Verify error message for keeping last name blank :-test started--------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on first name
		nhp.getFirstNameEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Last Name cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getLastNameEditboxBlankErrMessage().getText();
		System.out.println("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Verify error message for keeping last name blank :-test ended--------");
	}

//9. Don't pick the DOB and verify the error message.
	@Test()
	public static void checkErrorMessageForNotPickingDOB() {
		log.debug("------Check error message for not picking DOB :-test started--------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on first name
		nhp.getFirstNameEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Date Of Birth cannot be empty";
		System.out.println("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getDobBlankErrMessage().getText();
		System.out.println("                ");
		System.out.println("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		System.out.println("                ");
		System.out.println("Actual error message is :" + actErr);
		log.info("------Check error message for not picking DOB :-test ended------");
	}

//10. Check the error message for not picking Country of birth.
	@Test()
	public static void verifyErrorMessageForNotPickingCountryOfBirth() {
		log.debug("------Verify error message for not picking country of birth :-test started------");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on first name
		nhp.getFirstNameEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Country Of Birth cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getCountryOfBirthBlankErrMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Verify error message for not picking country of birth :-test ended------");
	}

//11. Verify the error message for keeping state of birth blank.
	@Test()
	public static void checkErrorMessageForNotPickingStateOfBirth() {
		log.debug("------Check error message for not picking state of birth :-test started------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on first name
		nhp.getFirstNameEditbox().click();
		// Pick the country of birth dropdown
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "State Of Birth cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getStateOfBirthBlankErrMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Check error message for not picking state of birth :-test ended------");
	}

//12. Make city of birth as blank and verify the error message.
	@Test()
	public static void checkErrorForKeepingCityOfBirthBlank() {
		log.debug("------Check error for keeping city of birth blank :-test started------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on city of birth editbox
		nhp.getCityOfBirthEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "City Of Birth cannot be empty";
		System.out.println("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getCityOfBirthErrBlankMessage().getText();
		System.out.println("                ");
		System.out.println("-------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		System.out.println("                ");
		System.out.println("Actual error message is :" + actErr);
		log.info("------Check error for keeping city of birth blank :-test ended------");
	}

//13.Check error message for not picking citizenship.
	@Test()
	public static void checkErrorForNotPickingCitizenShip() {
		log.debug("--------Check error for not picking citizenship:- test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Citizenship cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getCitizenshipBlankErrMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Check error for not picking citizenship:- test ended--------");
	}

//14. Don't pick the gender radio button and click on save and continue to check the error message.
	@Test()
	public static void checkErrorForNotPickingGender() {
		log.debug("------Check error message for not picking Gender :-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Gender cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getGenderBlankErrMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Check error message for not picking Gender :-test ended--------");
	}

//15. Don't select the marital status radio button and click on saveAndContinue to verify the error message.
	@Test()
	public static void checkErrorForNotSelectingMaritalStatus() {
		log.debug("-------Check error message for not selecting marital status:-test started---------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Marital Status cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getMaritalStatusBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("-------Check error message for not selecting marital status:-test ended---------");
	}

//16. Check the error message for not picking educational details.
	@Test()
	public static void checkErrorForNotPickingEducationDetails() {
		log.debug("---------Check error message for not picking education details:-test started-----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Education Details cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getEducationDetailsBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("*******Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("---------Check error message for not picking education details:-test ended-----------");
	}

//17. Select not a fresher and keep the Relevant experience editbox blank to check the error message.
	@Test()
	public static void checkErrorForKeepingRelevantExpEditboxBlank() {
		log.debug(
				"---------Check error message for keeping Relevant experience Editbox blank :-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on fresher switch button
		nhp.getFresherSwitchButton().click();
		// Click on the relevant experience editbox
		nhp.getRelevantExpEditbox().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Relevant Experience (In Months) cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getRelevantExpEditboxBlankErrMessage().getText();
		log.debug("                ");
		log.debug("--------Validate the error message--------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("---------Check error message for keeping Relevant experience Editbox blank :-test ended----------");

	}

//18. Pick source of hire as Campus Recruitment and click on saveAndContinue without picking UniversityName.
	@Test()
	public static void checkErrorForNotPickingUniversityName() {
		log.debug("--------Check error message for not picking university:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on source of hire editbox
		nhp.getSourceOfHireDropdown().click();
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "University/College Name cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getUniversityBlankErrMessage().getText();
		log.debug("                ");
		log.debug("--------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Check error message for not picking university:-test ended----------");

	}

//19. Pick source of hire as Referral and click on saveAndContinue without picking Referal Search.
	@Test()
	public static void checkErrorForKeepingReferalSearchBoxBlank() {
		log.debug("--------Check error message for keeping Referal search box blank:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on source of hire editbox
		nhp.getSourceOfHireDropdown().click();
		nhp.getReferalSourceOfHire().click();
		// Don't pick the referal
		nhp.getReferalSearchEditbox().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Referal Search cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getReferalSearchBlankErr().getText();
		log.debug("                ");
		log.debug("---------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Check error message for keeping Referal search box blank:-test ended----------");
	}

//20. Don't pick the country and check the error message.
	@Test()
	public static void verifyErrorForNotPickingCountry() {
		log.debug("--------Verify error message for not picking country:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Don't pick the country dropdown value
		nhp.getCountryDropdown().click();
		// Click on submit
		WebdriverUtils.waitForElementPresent(driver, nhp.getSaveAndContinueButton());
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Country cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getCountryBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("-------Validate the error message--------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Verify error message for not picking country:-test ended----------");

	}

//21. Check error message for not picking the legal entity.
	@Test()
	public static void verifyErrorForNotPickingLegalEntity() {
		log.debug("--------Verify error message for not picking Legal Entity:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on country dropdown
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Click on legal entity
		nhp.getLegalEntityDropdown().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Legal Entity cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getLegalEntityBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("---------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.debug("--------Verify error message for not picking Legal Entity:-test ended----------");
	}

//22. Verify error message for not picking the location.
	@Test()
	public static void verifyErrorForNotPickingLocation() {
		log.debug("--------Verify error for not picking location:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on location dropdown
		nhp.getLocationDropdown().click();
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Location cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getLocationBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("-------Validate the error message-------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Verify error for not picking location:-test ended----------");
	}

//23. Validate the error message for not picking joining date.
	@Test()
	public static void checkErrorForNotPickingJoiningDate() {
		log.debug("--------Check error for not picking joining date:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Joining Date cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getJoiningDateBlankErrorMessage().getText();
		log.debug("                ");
		Assert.assertEquals(actErr, expErr);
		log.debug("-------*Validate the error message-------");
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Check error for not picking joining date:-test ended----------");
	}

//24. Check the error message for not picking the group joining date.
	@Test()
	public static void checkErrorForNotPickingGroupJoiningDate() {
		log.debug("--------Check error not picking group joining date:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Group Joining Date cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForElementPresent(driver, nhp.getGroupJoiningBlankErr());
		String actErr = nhp.getGroupJoiningBlankErr().getText();
		log.debug("                ");
		log.debug("--------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Check error not picking group joining date:-test ended----------");
	}

//25. Verify the error message for keeping employee Id section blank.
	@Test()
	public static void makeEmployeeIdEditboxBlankAndValidateError() {
		log.debug("--------Make employee Id editbox blank and validate the error:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on employee id editbox
		nhp.getEmployeeId().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Employee ID cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getEmployeeIdBlankErrorMessage().getText();
		System.out.println("                ");
		log.debug("-------Validate the error message--------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Make employee Id editbox blank and validate the error:-test ended--------");
	}

//26. Make the email id section blank and check for the error message.
	@Test()
	public static void keepEmailIdSectionBlankAndVerifyError() {
		log.debug("--------Keep the email id section blank and verify error:-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on employee id editbox
		nhp.getEmailIdEditbox().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Email Id cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		WebdriverUtils.waitForPageToLoad(driver);
		String actErr = nhp.getEmaildIdBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("----------Validate the error message---------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Keep the email id section blank and verify error:-test ended--------");
	}

//27. Don't pick the employment type and verify the error message.
	@Test()
	public static void validateErrorForNotPickingEmploymentType() {
		log.debug("--------Validate error for not picking employment type :-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on employment type
		nhp.getEmploymentTypeDropdown().click();
		// Declare the error message
		String expErr = "Employment Type cannot be empty";
		System.out.println("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getEmploymentTypeBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("---------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Validate error for not picking employment type :-test ended--------");
	}

//28. Check the error message for not picking Employment status.
	@Test()
	public static void verifyErrorForNotPickingEmploymentStatus() {
		log.debug("------Verify error for not picking employment status :-test started-------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Click on employment status
		nhp.getEmploymentStatusDropdown().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Employment Status cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getEmploymentStatusBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("---------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Verify error for not picking employment status :-test ended-------");
	}

//29. Keep the Department section as Blank and verify the error message.
	@Test()
	public static void checkErrorForKeepingDepartmentEditboxBlank() {
		log.debug("---------Check error for keeping department editbox blank:- test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on department editbox
		nhp.getDepartmentEditbox().click();
		// Click on save and continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Department cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getDepartmentBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("--------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("---------Check error for keeping department editbox blank :-test ended-----------");
	}

//30. Select Employment type as Contract/Temporary/ then click on saveAndContinue button to varify the error for not picking Contract End Date.
	@Test()
	public static void verifyErrorForNotPickingContractEndDate() {
		log.debug("--------Verify error for not picking contract end date :-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on employment type
		nhp.getEmploymentTypeDropdown().click();
		// pick employment type as Contract
		nhp.pickEmploymentTypeAsContract();
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Contract End Date cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getContractEndDateBlankErrMessage().getText();
		log.debug("                ");
		log.debug("----------Validate the error message-----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("--------Verify error for not picking contract end date :-test ended----------");

	}

//31.Keep the Role editbox as blank then click on saveAndContinue button to verify the error message.
	@Test()
	public static void CheckErrorForKeepingRoleEditboxBlank() {
		log.debug("---------Check error for keeping Role editbox blank :-test started-----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Don't pick the role
		// Click on saveAndContinue button
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Role cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getRoleEditboxBlankErrorMessage().getText();
		System.out.println("                ");
		log.debug("---------Validate the error message-----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("---------Check error for keeping Role editbox blank :-test ended----------");
	}

//32. Don't enter the designation then click on saveAndContinue to verify Error message.
	@Test()
	public static void verifyErrorForKeepingDesignationBlank() {
		log.debug("------Verify error for keeping designation blank:-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
//Don't pick the designation
		// Click on save and continue button
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Designation cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getDesignationBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("---------Validate the error message-----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Verify error for keeping designation blank:-test ended--------");
	}

//33. Make the Reporting/Hiring Manager section as blank then verify the error message.
	@Test()
	public static void displayErrorForKeepingReportingManagerBlank() {
		log.debug("------Display error for keeping reporting manager blank:-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Dont pick the reporting manager
		// Click on save and continue button
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "Reporting/Hiring Manager cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getReportingHiringManagerBlankErrorMesage().getText();
		log.debug("                ");
		log.debug("--------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Display error for keeping reporting manager blank:-test ended--------");

	}

//34. Display the error message for keeping FT/PT indicator as blank.
	@Test()
	public static void displayErrorForNotPickingFT_Indicator() {
		log.debug("-------Display error for not picking Ft/Pt indicator:-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Don't pick the FT/PT indicator
		// Click on save and continue button
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "FT/PT Indicator cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getFtptBlankErrorMessage().getText();
		log.debug("                ");
		log.debug("----------Validate the error message------------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("-------Display error for not picking Ft/Pt indicator:-test ended----------");
	}

//35. Pick FT/PT indicator as part time then click on save and continue without picking FTE Equivalent hours to verify the error.
	@Test()
	public static void verifyErrorForNotPickingFTE_Equivalent() {
		log.debug("------Verify error for not picking FTE Equivalent:-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on the FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Click on save and continue button
		nhp.getSaveAndContinueButton().click();
		// Declare the error message
		String expErr = "FTE Equivalent(Weekly Hours) cannot be empty";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error
		String actErr = nhp.getFteBlankErrorMessage().getText();
		System.out.println("                ");
		log.debug("-------Validate the error message----------");
		Assert.assertEquals(actErr, expErr);
		log.debug("                ");
		log.info("Actual error message is :" + actErr);
		log.info("------Verify error for not picking FTE Equivalent:-test ended--------");
	}

//36. Submit the new hire form with picking DOB<18 years and validate the error message.
	@Test()
	public static void verifyErrorForPicking_DOB_lessThanEighteen_years() throws Exception {
		log.debug("------Verify error for picking DOB < 18 years:-test started-----");
		// Call the landing page
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Sadhav");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("dhawan");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("Nextgen", 1, 2);
		nhp.DatePicker(driver, element, date);
		// Pick country of birth as India
		nhp.getCountryOfBirthDropdown().click();
		nhp.getPickCountryOfBirthAsIndia().click();
		// Pick state of birth
		nhp.getStateOfBirthDropdown().click();
		nhp.getPickStateOfBirth().click();
		// Enter the city of birth
		nhp.getCityOfBirthEditbox().sendKeys("Hyderabad");
		// Pick citizenship
		nhp.getCitizenshipDropdown().click();
		nhp.getPickCitizenshipAsIndia().click();
		// Select the gender Male
		nhp.getMaleRadioButton().click();
		// select marital status as single
		nhp.getMaritalStatusAsSingle().click();
		// Pick education Details
		nhp.getEducationDetailsDropdown().click();
		nhp.getPickGraduate().click();
		// Click on source of hire dropdown
		nhp.getSourceOfHireDropdown().click();
		// Pick campus Recruitment
		nhp.getCampusRecruitmentSourceOfHire().click();
		// Click on University dropdown
		nhp.getUniversityNameDropdown().click();
		nhp.getPickUniversity().click();
		// Select the country
		nhp.getCountryDropdown().click();
		nhp.getPickCountryIndia().click();
		// Select Legal Entity
		nhp.getLegalEntityDropdown().click();
		nhp.getPickLegalEntity().click();
		// Select the location
		nhp.getLocationDropdown().click();
		nhp.getPickLocation().click();
		// Pick the joining date
		WebElement joiningDateElement = nhp.getJoiningDate();
		Date joiningDate = fil.getDateFromExcel("Nextgen", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Nextgen", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("NMEGTA5");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("tsapan23");
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		nhp.getPickEmploymentType().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Enter three letters in the role editbox
		try {
			nhp.getRoleEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectRole();
		} catch (StaleElementReferenceException e) {
			// nhp.selectRole();
			nhp.selectRole();
		}
		// Enter three letters in the Department editbox and pick one department
		try {
			nhp.getDepartmentEditbox().sendKeys("sal");
			Thread.sleep(2000);
			nhp.selectDepartment();
			// nhp.getPickDepartment().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDepartment().click();
		}
		// Enter three letters and select Designation
		try {
			nhp.getDesignationEditbox().sendKeys("Sal");
			Thread.sleep(2000);
			nhp.getPickDesignation().click();
		} catch (StaleElementReferenceException e) {
			nhp.getPickDesignation().click();
		}
		// Enter three letters and select reporting hiring manager
		try {
			nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
			Thread.sleep(2000);
			nhp.getPickReportingHiringManager().click();
		} catch (StaleElementReferenceException e) {
			WebdriverUtils.waitForElementPresent(driver, nhp.getPickReportingHiringManager());
			nhp.getPickReportingHiringManager().click();
		}
		// Select paytype
		nhp.getPickTypeDropdown().click();
		nhp.getPickPayType().click();
		// Pick pay frequency
		nhp.getPayFrequencyDropdown().click();
		nhp.getPickPayFrequencyDropdownValue().click();
		// Pick FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		nhp.getPickPartTimeIndicator().click();
		// Enter FTE Equivalent hours
		nhp.getFteEditbox().sendKeys("30");
		// Click on save and Continue
		nhp.getSaveAndContinueButton().click();
		Thread.sleep(2000);
		// Declare the expected error message
		log.debug("Error message should be displayed as :DOB should be greater than 18 years.");
		log.debug("                 ");
		log.debug("----------Validate error message------------");
		Assert.assertTrue(nhp.getDateOfBirthCalenderWindow().isDisplayed());
		log.debug("                   ");
		log.info("Test case is passed");
		log.info("------Verify error for picking DOB < 18 years:-test ended-----");
	}

//37. Click on pencil icon to upload the phofile photo with correct format and verify.
	@Test()
	public static void uploadProfilePhotoWithCorrectFormat() throws InterruptedException, AWTException {
		log.debug("-----------Upload profile photo with correct format :-test started----------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		log.debug("Expected to upload the photo");
		// Upload profile photo
		nhp.uploadPhoto();
		log.debug("                    ");
		log.debug("-----------Validate if the image is displayed-------------");
		Assert.assertTrue(nhp.getNewHireImage().isDisplayed());
		log.debug("               ");
		log.info("Profile photo uploaded successfully");
		log.info("-----------Upload profile photo with correct format :-test ended----------");

	}

//38. Click on the pencil icon to upload the profile photo with incorrect format and verify.
	@Test()
	public static void uploadProfilePhotoWithIncorrectFormat() throws InterruptedException, AWTException {
		log.debug("-------Upload profile photo with incorrect format:-test started--------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Upload incorrect profile photo
		nhp.uploadPhotoIncorrectFormat();
		log.debug("Edit button is clicked to upload the pdf document");
		// Declare the expected error message
		String expErr = "*Please select the correct file format.";
		log.debug("Expected error message is :" + expErr);
		// Capture the actual error message
		String actErr = nhp.getIncorrectFileFormatError().getText();
		log.debug("********Validate the error message********");
		Assert.assertEquals(actErr, expErr);
		log.info("              ");
		log.info("The actual error message is :" + actErr);
		log.info("-------Upload profile photo with incorrect format:-test ended--------");
	}

//39. Pick country india and print the Location.
	@Test()
	public static void pickCountryIndiaAndValidateLocation() {
		log.debug("----Pick Country India and Validate Location :-Test Started-----");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on country dropdown
		nhp.getCountryDropdown().click();
		// Pick india
		nhp.getPickCountryIndia().click();
		// Click on location dropdown
		nhp.getLocationDropdown().click();
		// Print the location
		log.debug("Display the locations available under India.");
		List<String> availablelocation = nhp.availableLocations();
		log.debug("-----Validate if the location is displayed------");
		Assert.assertTrue(nhp.getLocationDropdown().isEnabled());
		log.info("Available locations are :" + availablelocation);
		log.debug("----Pick Country India and Validate Location :-Test ended-----");

	}

//40. Pick country Singapore and print the location.
	@Test()
	public static void pickCountrySingaporeAndValidateLocation() {
		log.debug("----Pick Country Singapore and Validate Location :-Test started-----");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on country dropdown
		nhp.getCountryDropdown().click();
		// Pick india
		nhp.getPickCountrySingapore().click();
		// Click on location dropdown
		nhp.getLocationDropdown().click();
		// Print the location
		log.debug("Display the locations available under Singapore.");
		List<String> availablelocation = nhp.availableLocations();
		log.debug("-----Validate if the location is displayed------");
		Assert.assertTrue(nhp.getLocationDropdown().isEnabled());
		log.info("Available locations are :" + availablelocation);
		log.info("----Pick Country Singapore and Validate Location :-Test ended-----");
	}

//41. Pick Country SriLanka and print the location.
	@Test()
	public static void pickCountrySriLankaAndValidateLocation() {
		log.debug("----Pick Country SriLanka and Validate Location :-Test started-----");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on country dropdown
		nhp.getCountryDropdown().click();
		// Pick india
		nhp.getPickCountrySriLanka().click();
		// Click on location dropdown
		nhp.getLocationDropdown().click();
		// Print the location
		log.debug("Display the locations available under Srilanka.");
		List<String> availablelocation = nhp.availableLocations();
		log.debug("-----Validate if the location is displayed------");
		Assert.assertTrue(nhp.getLocationDropdown().isEnabled());
		log.info("Available locations are :" + availablelocation);
		log.info("----Pick Country SriLanka and Validate Location :-Test ended-----");
	}

//42. Pick Country UAE and print the location.
	@Test()
	public static void pickCountryUAEAndValidateLocation() {
		log.debug("----Pick Country UAE and Validate Location :-Test started-----");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on country dropdown
		nhp.getCountryDropdown().click();
		// Pick india
		nhp.getPickCountryUAE().click();
		// Click on location dropdown
		nhp.getLocationDropdown().click();
		// Print the location
		log.debug("Display the locations available under UAE.");
		List<String> availablelocation = nhp.availableLocations();
		log.debug("-----Validate if the location is displayed------");
		Assert.assertTrue(nhp.getLocationDropdown().isEnabled());
		log.info("Available locations are :" + availablelocation);
	}

//43. Pick Employment type Regular and validate probation, Confirmed.
	@Test()
	public static void pickRegularAndValidateEmploymentStatus() throws InterruptedException {
		log.debug("-------pickRegularAndValidateEmploymentStatus:Test Started---------");
		log.debug("----Pick Country UAE and Validate Location :-Test started-----");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
//Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
//Click on new hire option
//lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
//Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
//Click on employment type
		nhp.getEmploymentTypeDropdown().click();
		Thread.sleep(2000);
		nhp.getPickEmploymentType().click();
		nhp.getEmploymentStatusDropdown().click();
//Declare the emp status values for Regular type
		List<String> expVal = new ArrayList<String>();
		expVal.add("Select");
		expVal.add("Confirmed");
		expVal.add("Probation");
		log.debug("Expected values are :" + expVal);
//Capture the actual values
		List<String> actVal = nhp.empStatusValues();
		log.debug("                  ");
		log.debug("--------Validate the expected values------");
		Assert.assertEquals(actVal, expVal);
		log.info("Actual values are :" + actVal);
		log.info("-------pickRegularAndValidateEmploymentStatus:Test Ended---------");

	}

}
