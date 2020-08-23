package com.newHire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class NewHireTestEE extends BaseClass {
	static FileUtils fil= new FileUtils();
	@Test(groups = "Smoke")
	public static void submitNewHireFormAndValidate() throws Throwable {
		FileUtils fil = new FileUtils();
		log.debug("---------submit New Hire Form and validate all mandatory fields are selected----------");
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
		Thread.sleep(2000);
		nhp.getClickAddNewButton().click();
		// Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		// Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Prakash");
		// Enter last name
		nhp.getLastNameEditbox().sendKeys("Test");
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date = fil.getDateFromExcel("EE", 1, 2);
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
		Date joiningDate = fil.getDateFromExcel("EE", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("EE", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys("PT896");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys("prakash.test");
		// Click email domain
		nhp.getEmailDomainDropdown().click();
		// Select the domain type
		nhp.getPickEmailDomain().click();
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		// Pick employment status
		nhp.getEmploymentStatusDropdown().click();
		WebdriverUtils.waitForElementPresent(driver, nhp.getPickEmploymentStatusAsConfirmed());
		nhp.getPickEmploymentStatusAsConfirmed().click();
		// Stop page refresh
		// BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		// Enter three letters in the Department editbox and pick one department
		/*
		 * try { nhp.getDepartmentEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectDepartment(); //nhp.getPickDepartment().click(); }
		 * catch(StaleElementReferenceException e) { nhp.getPickDepartment().click(); }
		 */
		nhp.getDepartmentEditbox().sendKeys("d");
		nhp.chooseDepartment();
		// Enter three letters in the role editbox
		/*
		 * try { nhp.getRoleEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectRole(); } catch(StaleElementReferenceException e) {
		 * //nhp.selectRole(); nhp.selectRole(); }
		 */
		WebdriverUtils.waitForElementPresent(driver, nhp.getRoleEditbox());
		nhp.getRoleEditbox().sendKeys("r");
		Thread.sleep(1000);
		nhp.chooseRole();
		// Enter three letters and select Designation
		/*
		 * try { nhp.getDesignationEditbox().sendKeys("Sal"); Thread.sleep(2000);
		 * nhp.getPickDesignation().click(); } catch(StaleElementReferenceException e) {
		 * nhp.getPickDesignation().click(); }
		 */
		nhp.getDesignationEditbox().sendKeys("r");
		Thread.sleep(1000);
		nhp.getPickDesignation().click();
		//click on grade dropdown
		nhp.getGradeDropdown().click();
		nhp.selectGrade();
		// Enter three letters and select reporting hiring manager
		/*
		 * try { nhp.getReportingHiringManagerEditbox().sendKeys("Sar");
		 * Thread.sleep(2000); nhp.getPickReportingHiringManager().click(); }
		 * catch(StaleElementReferenceException e) {
		 * WebdriverUtils.waitForElementPresent(driver,
		 * nhp.getPickReportingHiringManager());
		 * nhp.getPickReportingHiringManager().click(); }
		 */
		nhp.getReportingHiringManagerEditbox().sendKeys("r");
		Thread.sleep(1000);
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
		// Call the compensation page and click on skip button
		CompensationPage cmp = PageFactory.initElements(driver, CompensationPage.class);
		// Click hire summary
		WebdriverUtils.waitForElementPresent(BaseClass.driver, cmp.getClickHireSummarySpecific());
		cmp.getClickHireSummarySpecific().click();
		// Call the Hire Summary page
		HireSummaryPage hs = PageFactory.initElements(driver, HireSummaryPage.class);
		hs.getclickPersonalData().click();
		// Click on save and continue button on new hire page to validate all the
		// mandatory fields
		nhp.getSaveAndContinueButtonMUJ().click();
		// click hire summary
		WebdriverUtils.waitForElementPresent(BaseClass.driver, cmp.getClickHireSummarySpecific());
		cmp.getClickHireSummarySpecific().click();
		// Capture the Hire summary page title to validate
		String hireSummaryTitle = hs.gethireSummaryPageTitle().getText();
		// Validate the page title
		Assert.assertTrue(hireSummaryTitle.contains("Hire Summary for"));
		System.out.println("All new hire mandatory fields has been verified successfully");
		System.out.println("The page title is :--" + hireSummaryTitle);
		log.info("The page title is :--" + hireSummaryTitle);
	}
	//3. Click on title dropdown and verify all the dropdown values. 
	@Test()
	public static void verifyTitleDropdownValues() throws Exception {
		log.info("-------verifyTitleDropdownValues Test started-------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		//Click on add new button
		nhp.getClickAddNewButton().click();
		// Click on title dropdown
		nhp.getTitleDropdown().click();
		// Declare the expected values
		List<String> expValues = new ArrayList<String>();
		expValues.add(fil.getExcelData("Title values", 0, 0));
		expValues.add(fil.getExcelData("Title values", 1, 0));
		expValues.add(fil.getExcelData("Title values", 2, 0));
		expValues.add(fil.getExcelData("Title values", 3, 0));
		expValues.add(fil.getExcelData("Title values", 4, 0));
		expValues.add(fil.getExcelData("Title values", 5, 0));
		expValues.add(fil.getExcelData("Title values", 6, 0));
		expValues.add(fil.getExcelData("Title values", 7, 0));
		expValues.add(fil.getExcelData("Title values", 8, 0));
		expValues.add(fil.getExcelData("Title values", 9, 0));
		expValues.add(fil.getExcelData("Title values", 10, 0));
		expValues.add(fil.getExcelData("Title values", 11, 0));
		expValues.add(fil.getExcelData("Title values", 12, 0));
		log.debug("Expected title values are :" + expValues);
		System.out.println("Expected title values are :" + expValues);
		// Capture the actual data
		List<String> actValues = nhp.printTitleDropdownValues();
		System.out.println("           ");
		log.debug("----------Validate the actual values----------");
		Assert.assertEquals(actValues, expValues);
		System.out.println("                        ");
		log.info("Actual values are :" + actValues);
		System.out.println("Actual values are :" + actValues);

		log.info("-------verifyTitleDropdownValues Test ended-------");
	}	
	}


