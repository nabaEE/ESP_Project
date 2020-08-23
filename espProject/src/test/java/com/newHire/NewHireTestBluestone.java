package com.newHire;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
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

public class NewHireTestBluestone extends BaseClass {
	static FileUtils fil= new FileUtils();
	//1. Fill in the details on new hire page then click on save and continue and verify it.
	@Test(priority=-1)
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
		nhp.getFirstNameEditbox().sendKeys(fil.getExcelData("Bluestone", 1, 0));
		// Enter last name
		nhp.getLastNameEditbox().sendKeys(fil.getExcelData("Bluestone", 1, 1));
		// Pick date of birth
		WebElement element = nhp.getDateOfBirthCalenderWindow();
		Date date=fil.getDateFromExcel("Bluestone", 1, 2);
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
		Date joiningDate = fil.getDateFromExcel("Bluestone", 1, 4);
		nhp.DatePicker(driver, joiningDateElement, joiningDate);
		// Pick the group joining
		WebElement groupJoiningDateElement = nhp.getGroupJoiningDate();
		Date groupJoiningDate = fil.getDateFromExcel("Bluestone", 1, 5);
		nhp.DatePicker(driver, groupJoiningDateElement, groupJoiningDate);
		// Enter the employee Id
		nhp.getEmployeeId().sendKeys(fil.getExcelData("Bluestone", 1, 6));
		// Enter email id
		nhp.getEmailIdEditbox().sendKeys(fil.getExcelData("Bluestone", 1, 7));
		//Click email domain
		nhp.getEmailDomainDropdown().click();
		//Select the domain type
		nhp.getPickEmailDomain().click();
		// Pick employment type
		nhp.getEmploymentTypeDropdown().click();
		WebdriverUtils.waitForElementPresent(driver, nhp.getPickEmploymentType());
		nhp.getPickEmploymentType().click();
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
		nhp.getDepartmentEditbox().sendKeys("sal");
		nhp.chooseDepartment();
		// Enter three letters and select Designation
		/*
		 * try { nhp.getDesignationEditbox().sendKeys("Sal"); Thread.sleep(2000);
		 * nhp.getPickDesignation().click(); } catch(StaleElementReferenceException e) {
		 * nhp.getPickDesignation().click(); }
		 */
		nhp.getDesignationEditbox().sendKeys("Sal");
		Thread.sleep(1000);
		nhp.getPickDesignation().click();
		// Click on grade dropdown and pick the grade
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
		nhp.getSaveAndContinueButton().click();
		//Call the compensation page and click on skip button
		CompensationPage cmp=PageFactory.initElements(driver, CompensationPage.class);
		//Click hire summary
		WebdriverUtils.waitForElementPresent(BaseClass.driver, cmp.getClickHireSummary());
		cmp.getClickHireSummary().click();
		//Call the Hire Summary page
		HireSummaryPage hs=PageFactory.initElements(driver, HireSummaryPage.class);
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
	//2. Enter the compensation and verify it on hire summary page.
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
			//pick employee
			nhp.getPickEmployee().click();
			//Click on Compensation on Hire Summary page
			HireSummaryPage hsp= PageFactory.initElements(driver, HireSummaryPage.class);
			WebdriverUtils.waitForElementPresent(driver, hsp.getClickCompensationPencilIcon());
		    hsp.getClickCompensationPencilIcon().click();
			//Call the compensation page and click on skip button
			CompensationPage cmp=PageFactory.initElements(driver, CompensationPage.class);	
			//Call the method to click on select profile
            cmp.retryingFindClick(cmp.getSelectProfileDropdown());
		//	driver.switchTo().window(hsp.moveTopage());
			//Select the specific profile
            WebdriverUtils.waitForElementPresent(driver, cmp.getSelectBluestoneProfile());
			cmp.getSelectBluestoneProfile().click();
			//clear the annual amount
			cmp.getAnnualFixedAmountNextgen().clear();
			//Enter the annual amount
			cmp.getAnnualFixedAmountNextgen().sendKeys("40000", Keys.ENTER);
			WebdriverUtils.waitForElementPresent(driver, cmp.getsaveAndContinue());
			cmp.clickElement(cmp.getsaveAndContinue());	
			//Call the additional cost page and click on submit
			AdditionalCostPage ap= PageFactory.initElements(driver, AdditionalCostPage.class);
			WebdriverUtils.waitForElementPresent(driver, ap.getClickSubmit());
			ap.getClickSubmit().click();
			//get the compensation value and validate
			WebdriverUtils.waitForElementPresent(driver, hsp.getCheckCompensationValue());
			String compCTC=hsp.getCheckCompensationValue().getText();
			//Validate the ctc
			Assert.assertFalse(compCTC.isEmpty());
			System.out.println("The expected ctc is :"+compCTC);
			log.info("-------Validate Compensation Test ended-------");
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
	//4. First Name mandatory.
	@Test()
	public static void firstNameMandatory() throws Exception {
		log.info("----------FirstNameMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 0, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't enter the first name then click on save and continue
		nhp.getFirstNameEditbox().sendKeys("");
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the error message
		String actErrorMessage = nhp.getFirstNameBlankErrMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------FirstNameMandatory Test ended---------");
		}
	//5. Last Name mandatory
	@Test()
	public static void lastNameMandatory() throws Exception {
		log.info("----------LastNameMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 1, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't enter the Last name then click on save and continue
		nhp.getLastNameEditbox().sendKeys("");
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the error message
		String actErrorMessage = nhp.getLastNameEditboxBlankErrMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------LastNameMandatory Test ended---------");
	}
	//6. Education Details mandatory
	@Test() 
	public static void educationDetailsMandatory() throws Exception {
		log.info("----------EducationDetailsMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 2, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't select the education dropdown and verify the error message
		nhp.getEducationDetailsDropdown();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the error message
		String actErrorMessage =nhp.getEducationDetailsBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------EducationDetailsMandatory Test ended---------");
		}
	//7. Country dropdown is mandatory.
	@Test()
	public static void countryMandatory() throws Exception {
		log.info("----------CountryMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 3, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't select the country then click on save and continue
		nhp.getCountryDropdown();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getCountryBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------CountryMandatory Test ended---------");
		}

	// 8. Legal Entity is mandatory
	@Test()
	public static void legalEntityMandatory() throws Exception {
		log.info("----------LegalEntityMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 4, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the legal entity
		nhp.getLegalEntityDropdown();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getLegalEntityBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------LegalEntityMandatory Test ended---------");
	}
//9.  Location is mandatory
 @Test() 
 public static void locationMandatory() throws Exception {
	 log.info("----------LocationMandatory Test Started---------"); 
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 5, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		//Don't click on location	
		nhp.getLocationDropdown();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		WebdriverUtils.waitForElementPresent(driver, nhp.getLocationDropdown());
		String actErrorMessage = nhp.getLocationBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------LocationMandatory Test ended---------");
	}
 //10. Joining Date is Mandatory
 @Test() 
 public static void joiningDateMandatory() throws Exception {
		log.info("----------joiningDateMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 6, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the joining date
		nhp.getJoiningDate();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getJoiningDateBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------joiningDateMandatory Test ended---------");

	}
 //11. Employee Id is mandatory
 @Test()
 public static void employeeIdMandatory() throws Exception {
	 log.info("----------employeeIdMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 7, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the joining date
		nhp.getJoiningDate();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getEmployeeIdBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------joiningDateMandatory Test ended---------");
		
 }
 //12. Email Id is mandatory
 @Test()
 public static void emailIdMandatory() throws Exception {
		log.info("----------emailIdMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 8, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the joining date
		nhp.getEmailIdEditbox();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		WebdriverUtils.waitForElementPresent(driver, nhp.getEmaildIdBlankErrorMessage());
		String actErrorMessage = nhp.getEmaildIdBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------emailIdMandatory Test ended---------");
 }
 //13. Employment Type is mandatory
 @Test()
 public static void employmentTypeMandatory() throws Exception {
		log.info("----------employmentTypeMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 9, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the employment type
		nhp.getEmploymentTypeDropdown().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		WebdriverUtils.waitForElementPresent(driver, nhp.getEmploymentTypeBlankErrorMessage());
		String actErrorMessage = nhp.getEmploymentTypeBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------employmentTypeMandatory Test ended---------");
		
 }
 //14. Employment Status is mandatory
 @Test()
	public static void employmentStatusMandatory() throws Exception {
		log.info("----------employmentStatusMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 10, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the employment type
		nhp.getEmploymentStatusDropdown().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getEmploymentStatusBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------employmentStatusMandatory Test ended---------");
 }
 //15. Department is mandatory
	@Test()
	public static void departmentMandatory() throws Exception {
		log.info("----------departmentMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 11, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the department
		nhp.getDepartmentEditbox().sendKeys("");
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getDepartmentBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------departmentMandatory Test ended---------");
	}
 
 //16. Designation is mandatory
	@Test()
	public static void designationMandatory() throws Exception {
		log.info("----------designationMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 12, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the designation
		nhp.getDesignationEditbox().sendKeys("");
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getDesignationBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------designationMandatory Test ended---------");
	}
 //17. Grade is mandatory
	@Test()
	public static void gradeMandatory() throws Exception {
		log.info("----------gradeMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 13, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't pick the grade
		nhp.getGradeDropdown().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getGradeBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------gradeMandatory Test ended---------");
}
 //18. Reporting/Hiring Manager is mandatory
    @Test()
	public static void reportingHiringManagerMandatory() throws Exception {
		log.info("----------reportingHiringManagerMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 14, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't enter the reporting hiring manager
		nhp.getReportingHiringManagerEditbox().sendKeys("");
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getReportingHiringManagerBlankErrorMesage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------reportingHiringManagerMandatory Test ended---------");
	
}
 //19. FT/PT Indicator is mandatory
    @Test()
    public static void ft_ptIndictorMandatory() throws Exception {
    	log.info("----------ft_ptIndictorMandatory Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		// Click on new hire section
		lp.clickNewHire();
		// Call the new hire page
		NewHirePage nhp = PageFactory.initElements(driver, NewHirePage.class);
		// Click on add new button
		nhp.getClickAddNewButton().click();
		// Declare the expected error message
		String expErrorMessage = fil.getExcelData("Error Messages", 15, 1);
		log.info("Expected error message is :" + expErrorMessage);
		System.out.println("Expected error message is :" + expErrorMessage);
		// Don't select FT/PT indicator
		nhp.getFtptIndicatorDropdown().click();
		// Click on submit
		nhp.getSaveAndContinueButton().click();
		// Capture the actuall error message
		String actErrorMessage = nhp.getFtptBlankErrorMessage().getText();
		// Validate the error message
		Assert.assertEquals(actErrorMessage, expErrorMessage);
		log.info("Actual error message is :" + actErrorMessage);
		System.out.println("Actual error message is :" + expErrorMessage);
		log.info("----------ft_ptIndictorMandatory Test ended---------");
    }
    //20. Enter the contact details then verify it
    @Test() 
    public static void submitContactDetailsAndValidate() throws Exception {
    	log.info("----------submitContactDetailsAndValidate Test Started---------");
		// Call the landing page
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// click on people icon
		lp.getAdminIcon().click();
		//Click on new hire button
		lp.clickNewHire();
		//Call the new hire page and click on pencil icon
		NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
		//Click on pencil icon to add the contact details
		nhp.getPickEmployee().click();
		//Call the HireSummary page
		HireSummaryPage hsp= PageFactory.initElements(driver, HireSummaryPage.class);
		//Click on contact details
		hsp.getClickContactDetails().click();
		//Click on phone type dropdown
		hsp.getPhoneTypeDropdown().click();
		//Select the mobile
		hsp.getPickPhoneTypeAsMobile().click();
		//Select the country code as India
		hsp.getCountryCodeDropdown().click();
		hsp.getPickCountryCodeAsIndia().click();
		//Enter the mobile number
		hsp.getNumberEditbox().sendKeys("9874563012");
		//Click on submit
		hsp.getSubmitButton().click();
		//Capture the submitted mobile number
		String actNumber=hsp.getSubmittedMobileNumber().getText();
		//Validate the added mobile number
		Assert.assertEquals(actNumber.contains("9874563012"), true);
		System.out.println("Mobile number is verified and the submitted number is :"+actNumber);
		log.info("Mobile number is verified and the submitted number is :"+actNumber);
		log.info("----------submitContactDetailsAndValidate Test Ended---------");
		
    }

}
	
	


