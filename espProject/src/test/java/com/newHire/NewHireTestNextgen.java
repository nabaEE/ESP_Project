package com.newHire;

import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.FileUtils;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.AdditionalCostPage;
import esp.objectRepository.CompensationPage;
import esp.objectRepository.HireSummaryPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.NewHirePage;

public class NewHireTestNextgen extends BaseClass {
	static FileUtils fil = new FileUtils();

	// 1. Submit new hire form and verify.
	@Test(groups = "Smoke")
	public static void submitNewHireFormAndValidate() throws Throwable {
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
		nhp.getFirstNameEditbox().sendKeys(fil.getExcelData("Nextgen", 1, 0));
		// Enter last name
		nhp.getLastNameEditbox().sendKeys(fil.getExcelData("Nextgen", 1, 1));
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
		nhp.getCityOfBirthEditbox().sendKeys(fil.getExcelData("Nextgen", 1, 3));
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
		nhp.getEmployeeId().sendKeys("88899");
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys(fil.getExcelData("Nextgen", 1, 6));
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
		// nhp.selectDepartment();
		nhp.chooseDepartment();
		// Enter three letters in the role editbox
		/*
		 * try { nhp.getRoleEditbox().sendKeys("sal"); Thread.sleep(2000);
		 * nhp.selectRole(); } catch(StaleElementReferenceException e) {
		 * //nhp.selectRole(); nhp.selectRole(); }
		 */
		WebdriverUtils.waitForElementPresent(driver, nhp.getRoleEditbox());
		nhp.getRoleEditbox().sendKeys("sal");
		Thread.sleep(1000);
		nhp.selectRole();
		// Enter three letters and select Designation
		/*
		 * try { nhp.getDesignationEditbox().sendKeys("Sal"); Thread.sleep(2000);
		 * nhp.getPickDesignation().click(); } catch(StaleElementReferenceException e) {
		 * nhp.getPickDesignation().click(); }
		 */
		nhp.getDesignationEditbox().sendKeys("Sal");
		Thread.sleep(1000);
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
		WebdriverUtils.waitForElementPresent(driver, nhp.getSaveAndContinueButton());
		nhp.getSaveAndContinueButton().click();
		// Call the compensation page and click on skip button
		CompensationPage cmp = PageFactory.initElements(driver, CompensationPage.class);
		// Click hire summary
		WebdriverUtils.waitForElementPresent(BaseClass.driver, cmp.getClickHireSummary());
		cmp.getClickHireSummary().click();
		// Call the Hire Summary page
		HireSummaryPage hs = PageFactory.initElements(driver, HireSummaryPage.class);
		hs.getclickPersonalData().click();
		// Click on save and continue button on new hire page to validate all the
		// mandatory fields
		nhp.getSaveAndContinueButton().click();
		// click hire summary
		cmp.getClickHireSummary().click();
		// Capture the Hire summary page title to validate
		String hireSummaryTitle = hs.gethireSummaryPageTitle().getText();
		// Validate the page title
		Assert.assertTrue(hireSummaryTitle.contains("Hire Summary for"));
		System.out.println("All new hire mandatory fields has been verified successfully");
		System.out.println("The page title is :--" + hireSummaryTitle);
		log.info("The page title is :--" + hireSummaryTitle);

	}

	@Test()
	public static void validateCompensation() throws Exception {
		log.debug("-------Validate Compensation Test started-------");
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class);
		// Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		// Click on new hire option
		// lnp.getNewHireAdminValue().click();
		lnp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// pick employee
		nhp.getPickEmployee().click();
		// Click on Compensation on Hire Summary page
		HireSummaryPage hsp = PageFactory.initElements(driver, HireSummaryPage.class);
		WebdriverUtils.waitForElementPresent(driver, hsp.getClickCompensationPencilIcon());
		hsp.getClickCompensationPencilIcon().click();
		// Call the compensation page and click on skip button
		CompensationPage cmp = PageFactory.initElements(driver, CompensationPage.class);
		// Click on the comp profile
		// driver.switchTo().window(hsp.moveTopage());
		Thread.sleep(2000);
		WebdriverUtils.waitForElementPresent(driver, cmp.getSelectProfileDropdown());
		try {
			cmp.getSelectProfileDropdown().click();
		} catch (StaleElementReferenceException e) {
			cmp.getSelectProfileDropdown();
			cmp.getSelectProfileDropdown().click();
		}
		// Select the specific profile
		WebdriverUtils.waitForElementPresent(driver, cmp.getSelectCompProfileNextgen());
		cmp.getSelectCompProfileNextgen().click();
		// Clear the editbox then enter the annual amount
		cmp.getAnnualFixedAmountNextgen().clear();
		cmp.getAnnualFixedAmountNextgen().sendKeys("400000", Keys.ENTER);
		WebdriverUtils.waitForElementPresent(driver, cmp.getsaveAndContinue());
		// Call the java script method to click on save and continue button
		// cmp.getsaveAndContinue().click();
		cmp.clickElement(cmp.getsaveAndContinue());
		// Call the addtional cost page
		AdditionalCostPage acp = PageFactory.initElements(driver, AdditionalCostPage.class);
		// Click on submit
		/*
		 * WebdriverUtils.waitForElementPresent(driver, acp.getClickSubmit());
		 * acp.getSignInBonus().clear(); acp.getSignInBonus().sendKeys("1200"); // Enter
		 * relocation amount acp.getRelocationReimbursement().clear();
		 * acp.getRelocationReimbursement().sendKeys("1000"); // Enter notice pay
		 * reimbursement acp.getNoticePayReimbursement().clear();
		 * acp.getNoticePayReimbursement().sendKeys("500"); // Enter onetime payments
		 * acp.getOtherOneTimePayments().clear();
		 * acp.getOtherOneTimePayments().sendKeys("4000"); // Pick employee for refreal
		 * bonus acp.getEmployeeSearchBonus().clear();
		 * acp.getEmployeeSearchBonus().sendKeys("sar");
		 * acp.getPickEmployeeForBonus().click(); // Enter the bonus amount
		 * acp.getReferalBonus().clear(); acp.getReferalBonus().sendKeys("20000");
		 */
		acp.getClickSubmit().click();
		// acp.clickElement(acp.getClickSubmit());
		// get the compensation value and validate
		String compCTC = hsp.getCheckCompensationValue().getText();
		System.out.println(compCTC);
		// Validate the ctc
		Assert.assertTrue(compCTC.contains("400,000"));
		System.out.println("The expected ctc is :" + compCTC);
		log.info("-------Validate Compensation Test ended-------");
	}


}
