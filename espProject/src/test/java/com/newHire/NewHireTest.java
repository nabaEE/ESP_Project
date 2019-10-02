package com.newHire;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.CompensationPage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.NewHirePage;

public class NewHireTest extends BaseClass
{

//1. Submit new hire form and verify.
@Test()
public static void submitNewHireForm()
{
	    //Call the landing page
		LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
		//Click on admin icon
		WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
		lnp.getAdminIcon().click();
		//Click on new hire option
		lnp.getNewHireAdminValue().click();
		//Call the new hire page
		NewHirePage nhp= PageFactory.initElements(driver, NewHirePage.class);
		//Click on title dropdown and pick MR
		nhp.getTitleDropdown().click();
		nhp.getPickTitle_MR().click();
		//Enter the first Name
		nhp.getFirstNameEditbox().sendKeys("Rahul");
		//Enter last name
		nhp.getLastNameEditbox().sendKeys("Ghosh");
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
	    nhp.getEmployeeId().sendKeys("MHR123");
	    //Enter email id
	    nhp.getEmailIdEditbox().sendKeys("rahul234");
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
	    nhp.getReportingHiringManagerEditbox().sendKeys("Man");
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
	    cmp.getSaveAndContinueButton().click();
}
}
