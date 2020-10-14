package com.leave.employee;

import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.LandingPage;
import esp.objectRepository.LeaveFormPage;
import esp.objectRepository.LoginPage;
public class EmpLeaveApplyTestToyota extends BaseClass {
	@Test(priority=1)
	public static void ApplyAndApproveEL() throws Exception {
		Properties pObj = fl.getPropertyData();
		log.info("---------------applyAndApproveEL:- Test Started-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeDropdown());
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeReasonDropdown());
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date = new Date("07-Dec-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		lfp.getSubmitButton().click();
		log.info("Employee has submitted the leave for the date :"+date);
		WebdriverUtils.waitForPageToLoad(driver);
		esp.objectRepository.LoginPage lp1 = PageFactory.initElements(driver, LoginPage.class);
		// call the logout method declared in LoginPage
		lp1.logOut();
		Thread.sleep(2000);
		driver.get(pObj.getProperty("URL"));
		// Call the login page class which is common for all the modules
		esp.objectRepository.LoginPage lp2 = PageFactory.initElements(driver, LoginPage.class);
		// Calling the method declared in login page class
		lp2.loginToPage(pObj.getProperty("APPROVERNAME1"), pObj.getProperty("APPROVERPASSWORD"));
		lp2.secureLogin(pObj.getProperty("USERNAME1"), pObj.getProperty("PASSWORD1"));
		WebdriverUtils.waitForPageToLoad(driver);
		driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));
		// Search the leave request
		LandingPage lp11 = PageFactory.initElements(driver, LandingPage.class);
		WebdriverUtils.waitForElementPresent(driver, lp11.getSearchLeaveRequest());
		//Capture the employee id
		CharSequence empId=pObj.getProperty("USERNAME").subSequence(0, 6);
		lp11.getSearchLeaveRequest().sendKeys(empId);
		// Click on approve
		WebdriverUtils.waitForElementPresent(driver, lp11.getApproveRequest());
		lp11.clickElement(lp11.getApproveRequest());
		log.info("Reporting manager has approved the leave");
		// call the logout method declared in LoginPage
		lp1.logOut();
		Thread.sleep(2000);
		driver.get(pObj.getProperty("URL"));
		// Calling the method declared in login page class
		lp2.loginToPage(pObj.getProperty("APPROVERNAME2"), pObj.getProperty("APPROVERPASSWORD"));
		lp2.secureLogin(pObj.getProperty("USERNAME1"), pObj.getProperty("PASSWORD1"));
		WebdriverUtils.waitForPageToLoad(driver);
		driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));
		// Search the leave request
		WebdriverUtils.waitForElementPresent(driver, lp11.getSearchLeaveRequest());
		//Search for the employee Id
		lp11.getSearchLeaveRequest().sendKeys(empId);
		// Click on approve
		WebdriverUtils.waitForElementPresent(driver, lp11.getApproveRequest());
		lp11.clickElement(lp11.getApproveRequest());
		log.info("Manager's manager has approved the leave");
		log.info("Login as employee to check leave history");
		// call the logout method declared in LoginPage
		lp1.logOut();
		Thread.sleep(2000);
		driver.get(pObj.getProperty("URL"));
		// Calling the method declared in login page class
		lp2.loginToPage(pObj.getProperty("USERNAME"), pObj.getProperty("PASSWORD"));
		lp2.secureLogin(pObj.getProperty("USERNAME1"), pObj.getProperty("PASSWORD1"));
		WebdriverUtils.waitForPageToLoad(driver);
		driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));
		// click on leave form to verify the status
		WebdriverUtils.waitForElementPresent(driver, lfp.getClickLeaveForm());
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		//Maximize the window
		WebdriverUtils.clickElement(lfp.getMaximizeLeaveForm());
		//Click on Leave/OD history
		lfp.clickLeaveHistory();
		log.info("Verify the leave status");
		Assert.assertTrue(lfp.getLeaveStatus().getText().contains("Approved"));
		log.info("Leave status is :"+lfp.getLeaveStatus().getText());
		log.info("---------------applyAndApproveEL:- Test Ended-----------");

	}
	
	@Test(priority=2) 
	public static void applyAndReject() throws Exception {
		Properties pObj = fl.getPropertyData();
		log.info("---------------applyAndReject:- Test Started-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeDropdown());
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeReasonDropdown());
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date = new Date("08-Dec-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		esp.objectRepository.LoginPage lp1 = PageFactory.initElements(driver, LoginPage.class);
		// call the logout method declared in LoginPage
		lp1.logOut();
		Thread.sleep(2000);
		driver.get(pObj.getProperty("URL"));
		// Call the login page class which is common for all the modules
		esp.objectRepository.LoginPage lp2 = PageFactory.initElements(driver, LoginPage.class);
		// Calling the method declared in login page class
		lp2.loginToPage(pObj.getProperty("APPROVERNAME1"), pObj.getProperty("APPROVERPASSWORD"));
		lp2.secureLogin(pObj.getProperty("USERNAME1"), pObj.getProperty("PASSWORD1"));
		WebdriverUtils.waitForPageToLoad(driver);
		driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));
		// Search the leave request
		LandingPage lp11 = PageFactory.initElements(driver, LandingPage.class);
		WebdriverUtils.waitForElementPresent(driver, lp11.getSearchLeaveRequest());
		//Capture the employee id
		CharSequence empId=pObj.getProperty("USERNAME").subSequence(0, 6);
		lp11.getSearchLeaveRequest().sendKeys(empId);
		// Click on approve
		WebdriverUtils.waitForElementPresent(driver, lp11.getRejectRequest());
		lp11.clickElement(lp11.getRejectRequest());
		log.info("Login as employee to check the status");
		// call the logout method declared in LoginPage
		lp2.logOut();
		Thread.sleep(2000);
		driver.get(pObj.getProperty("URL"));
		// Calling the method declared in login page class
		lp2.loginToPage(pObj.getProperty("USERNAME"), pObj.getProperty("PASSWORD"));
		lp2.secureLogin(pObj.getProperty("USERNAME1"), pObj.getProperty("PASSWORD1"));
		WebdriverUtils.waitForPageToLoad(driver);
		driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frame")));
		// click on leave form to verify the status
		Thread.sleep(1000);
		WebdriverUtils.waitForElementPresent(driver, lfp.getClickLeaveForm());
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		// Maximize the window
		WebdriverUtils.clickElement(lfp.getMaximizeLeaveForm());
		// Click on Leave/OD history
		lfp.clickLeaveHistory();
		log.info("--Verify the leave status--");
		Assert.assertTrue(lfp.getLeaveStatus().getText().contains("Rejected"));
		log.info("Leave status is :" + lfp.getLeaveStatus().getText());
		log.info("---------------applyAndReject:- Test Ended-----------");			
	}
	
}
