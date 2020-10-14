package com.leave;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import esp.genericLibraries.BaseClass;
import esp.genericLibraries.FileUtils;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.ApprovalPage;
import esp.objectRepository.AttendancePage;
import esp.objectRepository.LandingPage;
import esp.objectRepository.LeaveFormPage;
import esp.objectRepository.TimeAndAttendancePage;

public class LeaveTestToyota extends BaseClass {
	static FileUtils fil = new FileUtils();

//1. Apply Earned Leave for full day then approve it.
	@Test()
	public static void ApplyAndApproveEL() throws Exception {
		log.info("---------------ApplyAndApproveEL:- Test Started-----------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
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
		WebdriverUtils.waitForElementPresent(driver, lp.getMoveToApprovalPage());
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();

		/*
		 * WebdriverUtils.waitForPageToLoad(driver); esp.objectRepository.LoginPage lp =
		 * PageFactory.initElements(driver, LoginPage.class); // call the logout method
		 * declared in LoginPage lp.logOut(); Thread.sleep(2000);
		 * driver.get(pObj.getProperty("URL")); Call the login page class which is
		 * common for all the modules esp.objectRepository.LoginPage lp2=
		 * PageFactory.initElements(driver, LoginPage.class); //Calling the method
		 * declared in login page class
		 * lp2.loginToPage(pObj.getProperty("APPROVERNAME"),
		 * pObj.getProperty("APPROVERPASSWORD"));
		 * lp2.secureLogin(pObj.getProperty("USERNAME1"),
		 * pObj.getProperty("PASSWORD1")); WebdriverUtils.waitForPageToLoad(driver);
		 * driver.switchTo().frame(BaseClass.driver.findElement(By.xpath(
		 * "//html//frameset//frame"))); // Search the leave request LandingPage lp1=
		 * PageFactory.initElements(driver, LandingPage.class);
		 * 
		 * WebdriverUtils.waitForElementPresent(driver, lp1.getSearchLeaveRequest());
		 * lp1.getSearchLeaveRequest().sendKeys("000614"); // Click on approve
		 * WebdriverUtils.waitForElementPresent(driver, lp1.getApproveRequest());
		 * lp1.clickElement(lp1.getApproveRequest());
		 */
		log.info("---------------ApplyAndApproveEL:- Test Ended-----------");

	}

	// 2. Apply Earned Leave for Full day then reject it.
	@Test()
	public static void applyAndReject() throws Exception {
		log.info("------------------------applyAndReject :-Test Started--------------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date = new Date("11-Oct-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getMoveToApprovalPage());
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getRejectButton().click();
		log.info("------------------------applyAndReject :-Test Ended--------------");

	}

//3. Apply Earned Leave for 1.5 day then approve it.
//4. Apply Sick Leave for 0.5 day then cancel it and verify the leave balance after cancellation.
// 5. Half Day Absent + Half Day Leave then verify the attendance string
	@Test(priority = 1)
	public static void halfDayAbsent_HalfDayLeave() throws IOException, InterruptedException {
		log.info("---------------halfDayAbsent_HalfDayLeave :-Test Started--------------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// System.out.println("Attendance String before applying leave
		// :"+originalAttendace);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		Date date1 = new Date("19-Sept-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Select session 1
		lfp.getClickStartSession().click();
		// Click on session
		lfp.pickFirstHalfStartSession();
		// Click end session
		lfp.getClickEndSession().click();
		lfp.pickFirstHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		WebdriverUtils.clickUsingJavaScript(ap.getApprovalButton());
		// ap.getApprovalButton().click();
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("Absent list after applying leave i  :-" + attendanceAfterLeave);
		log.info("---------------halfDayAbsent_HalfDayLeave :-Test Ended----------------");
	}

//6. Half Day Leave + Half Day Leave then verify the attendance.
	@Test(priority = 2)
	public static void halfDayLeave_HalfDayLeave() throws Exception {
		log.info("---------------halfDayLeave_HalfDayLeave :-Test Started----------------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// System.out.println("Attendance String before applying leave
		// :"+originalAttendace);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		Date date1 = new Date("29-Sept-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Pick second half start session
		lfp.getClickStartSession().click();
		lfp.pickSecondHalfStartSession();
		// Click end session and pick session2
		lfp.getClickEndSession().click();
		lfp.pickSecondHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		WebdriverUtils.clickUsingJavaScript(ap.getApprovalButton());
		// ap.getApprovalButton().click();
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("---------------halfDayLeave_HalfDayLeave :-Test Ended----------------");
	}

//7. Cancel the half day + Cancel the half day then verify the attendance string
	@Test(priority = 3)
	public static void cancelHalfDayAndCancelHalfDay() throws InterruptedException {
		log.info("---------------cancelHalfDayAndCancelHalfDay :-Test Started----------------");
		// Call the langing page then click on T&A Admin
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		lp.clickAdmin();
		// Click on T&A admin
		lp.clickTimeAndAttendance();
		// Put some wait to wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the time and attendance page
		TimeAndAttendancePage tap = PageFactory.initElements(driver, TimeAndAttendancePage.class);
		// Click on Leave List by employee section
		tap.getClickLeaveListByEmployee().click();
		// Enter the employee id
		tap.getSearchEmployeeInLeaveListByEmployee().sendKeys("000614");
		// Click on the searched employee and handle stale if it throws
		WebdriverUtils.handleStale(tap.getClickEmpInEmpLeaveListByEmp());
		// Click on the check box
		tap.getSelectLeave1ToCancel().click();
		// Click on submit
		WebdriverUtils.waitForElementPresent(driver, tap.getClickSubmitToCancel());
		tap.getClickSubmitToCancel().click();
		// Click on home icon
		lp.getClickHomeIcon().click();
		// Wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on attendance
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		lp.getClickAttendanceWindow().click();
		// Call the attendance page
		AttendancePage ap = PageFactory.initElements(driver, AttendancePage.class);
		// Get the attendance method to capture the string
		ap.getAttendanceString();
		// Close the attendance window
		System.out.println("List of Attendance strings after cancellation");
		log.info("List of Attendance strings after cancellation");
		log.info("----------------------");
		ap.getCloseAttendanceWindow().click();
		// Assert.assertTrue(ap.getAttendanceString().contains("18--A"));
		System.out.println("Leave has been successfully cancelled");
	}

//8. Half Day Absent + Half Day Work from home.
	@Test(priority = 4)
	public static void halfDayAbsent_HalfDayWFH() throws Exception {
		log.info("---------------halfDayAbsent_HalfDayWFH :-Test Started----------------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// System.out.println("Attendance String before applying leave
		// :"+originalAttendace);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Click on work from home
		lfp.selectWFH();
		Date date1 = new Date("21-Oct-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Pick second half start session
		lfp.getClickStartSession().click();
		lfp.pickFirstHalfStartSession();
		// Click end session and pick session2
		lfp.getClickEndSession().click();
		lfp.pickFirstHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("Absent list after applying leave i  :-" + attendanceAfterLeave);
		log.info("---------------halfDayAbsent_HalfDayWFH :-Test Ended----------------");
	}

//9. Half Day Work From Home + Half Day Work From Home
	@Test(priority = 5)
	public static void halfDayWFH_halfDayWFH() throws Exception {
		log.info("---------------halfDayWFH_halfDayWFH :-Test Started----------------");
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Call the Attendance page
		AttendancePage atp = PageFactory.initElements(driver, AttendancePage.class);
		// get the attendance string before applying leave
		ArrayList<String> attendanceBeforeLeave = atp.getAttendanceString();
		System.out.println("Absent list before applying leave is :-" + attendanceBeforeLeave);
		log.info("Absent list before applying leave is :-" + attendanceBeforeLeave);
		// System.out.println("Attendance String before applying leave
		// :"+originalAttendace);
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Click on work from home
		lfp.selectWFH();
		Date date1 = new Date("21-Sept-2020");
		WebdriverUtils.waitForElementPresent(driver, lfp.getStartDate());
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		WebdriverUtils.waitForElementPresent(driver, lfp.getEndDate());
		lfp.DatePicker(driver, lfp.getEndDate(), date1);
		// Pick second half start session
		lfp.getClickStartSession().click();
		lfp.pickSecondHalfStartSession();
		// Click end session and pick session2
		lfp.getClickEndSession().click();
		lfp.pickSecondHalfEndSession();
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying half day leave");
		// Click on submit
		lfp.getSubmitButton().click();
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(lp.getMoveToApprovalPage());
		Thread.sleep(2000);
		lp.getMoveToApprovalPage().click();
		// Call Approval page
		ApprovalPage ap = PageFactory.initElements(driver, ApprovalPage.class);
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForElementPresent(driver, ap.getOrganizationApprovalpage());
		ap.getOrganizationApprovalpage().click();
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on approve button
		WebdriverUtils.waitForElementPresent(driver, ap.getApprovalButton());
		ap.getApprovalButton().click();
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		WebdriverUtils.waitForPageToLoad(driver);
		WebdriverUtils.waitForCompleteElementToLoad(ap.getApprovalButton());
		// Handle stale element reference exception
		WebdriverUtils.handleStale(ap.getApprovalButton());
		// Click on home icon
		ap.getClickHomeIcon().click();
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		// Click on attendance
		lp.getClickAttendanceWindow().click();
		// Capture the attendance string after applied leave
		System.out.println("---Attendance string after applied leave-----");
		log.info("---Attendance string after applied leave-----");
		ArrayList<String> attendanceAfterLeave = atp.getAttendanceString();
		// Close the attendance window
		atp.getCloseAttendanceWindow().click();
		// String expAttendance= "D";
		// System.out.println("Expected attendance after applied leave
		// :"+expAttendance);
		// Validate the attendance string
		Assert.assertNotEquals(attendanceAfterLeave, attendanceBeforeLeave);
		System.out.println("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("Absent list after applying leave is  :-" + attendanceAfterLeave);
		log.info("---------------halfDayWFH_halfDayWFH :-Test Ended----------------");
	}

//10. Cancel Half Day WFH and verify the attendance
	@Test(priority = 6)
	public static void cancelHalfDayWFHAndVerifyAttendance() {
		log.info("---------------cancelHalfDayWFHAndVerifyAttendance :-Test Started----------------");
		// Call the langing page then click on T&A Admin
		LandingPage lp = PageFactory.initElements(driver, LandingPage.class);
		lp.clickAdmin();
		// Click on T&A admin
		lp.clickTimeAndAttendance();
		// Put some wait to wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Call the time and attendance page
		TimeAndAttendancePage tap = PageFactory.initElements(driver, TimeAndAttendancePage.class);
		// Click on Leave List by employee section
		tap.getClickLeaveListByEmployee().click();
		// Enter the employee id
		tap.getSearchEmployeeInLeaveListByEmployee().sendKeys("000614");
		// Click on the searched employee and handle stale if it throws
		WebdriverUtils.handleStale(tap.getClickEmpInEmpLeaveListByEmp());
		// Click on the check box
		tap.getSelectLeave1ToCancel().click();
		// Click on submit
		WebdriverUtils.waitForElementPresent(driver, tap.getClickSubmitToCancel());
		tap.getClickSubmitToCancel().click();
		// Click on home icon
		lp.getClickHomeIcon().click();
		// Wait for the page to load
		WebdriverUtils.waitForPageToLoad(driver);
		// Click on attendance
		WebdriverUtils.waitForElementPresent(driver, lp.getClickAttendanceWindow());
		lp.getClickAttendanceWindow().click();
		// Call the attendance page
		AttendancePage ap = PageFactory.initElements(driver, AttendancePage.class);
		// Get the attendance method to capture the string
		System.out.println("List of Attendance strings after cancellation");
		log.info("List of Attendance strings after cancellation");
		log.info("----------------------");
		ap.getAttendanceString();
		// Close the attendance window
		ap.getCloseAttendanceWindow().click();
		// Assert.assertTrue(ap.getAttendanceString().contains("18--D"));
		System.out.println("Leave has been successfully cancelled");
		log.info("-----------cancelHalfDayWFHAndVerifyAttendance :-Test Ended-----------");
	}

//11. Select the drop down and ensure all the leave types applicable for the customer is available
	@Test()
	public static void clickAndVerifyLeaveTypes() throws Exception {
		log.info("------------clickAndVerifyLeaveTypes : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Declare the expected leave types
		List<String> expValues = fil.getLeaveExcelData("Toyota", 1, 0);
		log.info("Expected leave types are :" + expValues);
		// Capture the actual leave types from the UI
		List<String> actualValues = lfp.printleaveTypeValues();
		log.info("Actual leave types are:" + actualValues);
		log.info("-Verify the leave types--");
		// Close the leave form
		lfp.getcloseLeaveForm().click();
		Assert.assertEquals(actualValues, expValues);
		log.info("Leave Types are matching with expected types" + actualValues);
		log.info("------------clickAndVerifyLeaveTypes : Test Ended-------------");
	}

	// 12. View leave balances and verify it
	@Test()
	public static void viewLeaveBalanceAndVerify() {
		log.info("------------viewLeaveBalanceAndVerify : Test Started---------");
		// Call the Leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Capture the actual leave balances
		List<String> actualLeaveBalances = lfp.printLeaveBalances();
		// Close the leave form table
		lfp.getcloseLeaveForm().click();
		log.info("-Verify the leave balance is displayed--");
		Assert.assertTrue(lfp.getLeaveBalanceTable().isDisplayed());
		log.info("The leave balances are :" + actualLeaveBalances);
		log.info("------------viewLeaveBalanceAndVerify : Test Ended-----------");
	}

	// 13. Select the drop down and select on the leave types
	@Test()
	public static void pickTheLeaveTypeAndVerify() {
		log.info("------------pickTheLeaveTypeAndVerify : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		// Select the leave type
		WebdriverUtils.waitForElementPresent(driver, lfp.getPickRandomLeaveType());
		lfp.getPickRandomLeaveType().click();
		String pickedLeaveType = lfp.getPickRandomLeaveType().getText();
		WebdriverUtils.waitForPageToLoad(driver);
		// Close the leave form
		lfp.getcloseLeaveForm().click();
		log.info("Verify if the leave type has selected");
		Assert.assertTrue(lfp.getPickRandomLeaveType().isDisplayed());
		log.info("Leave type is selected :" + pickedLeaveType);
		log.info("------------pickTheLeaveTypeAndVerify : Test Ended-----------");
	}

	// 14. Click on Submit button without selecting Leave Type then verify the error
	// message
	@Test()
	public static void verifyLeaveTypeMandatory() {
		log.info("------------verifyLeaveTypeMandatory : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		String expErrorMessage = "Leave Type cannot be empty";
		// Click on Submit
		lfp.getSubmitButton().click();
		String actualErrorMessage = lfp.getLeaveTypeBlankError().getText();
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Verify the error message");
		Assert.assertEquals(actualErrorMessage, expErrorMessage);
		log.info("Leave type is mandatory and the error message is :" + actualErrorMessage);
		log.info("------------verifyLeaveTypeMandatory : Test Ended-----------");
	}

	// 15. Select the drop down and ensure all the leave reasons applicable for the
	// customer is available
	@Test()
	public void verifyLeaveReasonsForLeaveType() throws Exception {
		log.info("------------verifyLeaveReasonsForLeaveType : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		List<String> expLeaveReasons = fil.getLeaveExcelData("Toyota", 1, 1);
		log.info("Expected Leave Reasons are : " + expLeaveReasons);
		ArrayList<String> actualLeaveReasons = lfp.leaveReasonsForLeaveType();
		log.info(actualLeaveReasons);
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		// Validate the leave reasons
		log.info("-Validate the leave reasons-");
		Assert.assertEquals(actualLeaveReasons, expLeaveReasons);
		log.info("Actual Leave Reasons are matching with expected one");
		log.info("Actual leave reasons are :" + actualLeaveReasons);
		log.info("------------verifyLeaveReasonsForLeaveType : Test Ended-----------");
	}

	// 16. Verify the leave reason mandatory
	@Test()
	public static void verifyLeaveReasonMandatory() {
		log.info("------------verifyLeaveReasonMandatory : Test Started-----------");
		// Call the landing page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		lfp.getClickLeaveTypeDropdown().click();
		String expErrorMessage = "Leave Reason cannot be empty";
		// Click on Submit
		lfp.getSubmitButton().click();
		String actualErrorMessage = lfp.getLeaveTypeBlankError().getText();
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Verify the error message");
		Assert.assertEquals(actualErrorMessage, expErrorMessage);
		log.info("Leave reason is mandatory and the error message is :" + actualErrorMessage);
		log.info("------------verifyLeaveReasonMandatory : Test Ended-----------");
	}

	// 17. Select a date for which there is already Leave applied/approved
	@Test()
	public static void verifyErrorIfLeaveExist() {
		log.info("------------verifyErrorIfLeaveExist : Test Ended-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.waitForElementPresent(driver, lfp.getClickLeaveForm());
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date = new Date("24-Sept-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		lfp.getSubmitButton().click();
		// Click on the leave form
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		WebdriverUtils.waitForElementPresent(driver, lfp.getSubmitButton());
		lfp.getSubmitButton().click();
		// Close the leave window
		lfp.getcloseLeaveForm().click();
		// Declare the expected error message
		String expError = "There are existing leaves that overlap the dates given for this leave. Please check.";
		log.info("Expected error message is :" + expError);
		// Capture the actual error message
		String actError = lfp.getLeaveErrorOnAppliedDate().getText();
		log.info("Validate the error message");
		Assert.assertEquals(actError, expError);
		log.info("Actual Error message is :" + actError);
		log.info("------------verifyErrorIfLeaveExist : Test Ended-----------");
	}

	// 18. Select date which is less than Start Date
	@Test()
	public static void LeaveDateMandatory() throws InterruptedException {
		log.info("------------LeaveDateMandatory : Test Started---------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date1 = new Date("10-Nov-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		Date date2 = new Date("10-Nov-2020");
		lfp.DatePicker(driver, lfp.getEndDate(), date2);
		// Enter the comments then click on submit
		lfp.getLeaveDetailsEditbox().sendKeys("Submit");
		lfp.getSubmitButton().click();
		// Declare the expected error message
		String expErr = "Leave End Date should be equal or greater than the Leave Start Date. Please correct.";
		// Capture the actual error message
		log.info("Expected error message is :" + expErr);
		WebdriverUtils.waitForCompleteElementToLoad(lfp.getleaveDateErrorMessage());
		String actErr = lfp.getleaveDateErrorMessage().getText();
		// Close the leave form
		lfp.getcloseLeaveForm().click();
		log.info("Validate the error message");
		Assert.assertEquals(actErr, expErr);
		log.info("Actual Error message is :" + actErr);
		log.info("------------LeaveDateMandatory : Test Ended-----------");
	}

	// 19. Select the future date and verify it
	@Test()
	public static void selectFutureDateAndVerify() {
		log.info("------------selectFutureDateAndVerify : Test Started----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		log.info("Enter the future date");
		Date date1 = new Date("17-Nov-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		// Select end date
		Date date2 = new Date("17-Nov-2020");
		lfp.DatePicker(driver, lfp.getEndDate(), date2);
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Validate if the future date is selected or not");
		Assert.assertTrue(lfp.getStartDate().isDisplayed());
		log.info("Future date is selected :" + date1);
		log.info("------------selectFutureDateAndVerify : Test Ended-----------");
	}

	// 20. System should allow to Edit the selected date on leave form page.
	@Test()
	public static void modifyStartDateAndVerify() {
		log.info("------------modifyStartDateAndVerify : Test Started----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		log.info("Enter the start date");
		Date date1 = new Date("19-Nov-2020");
		log.info("Entered date is :" + date1);
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		log.info("Clear the start date and enter another date");
		Date date2 = new Date("19-Nov-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date2);
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Validate if the date has modified");
		Assert.assertNotEquals(date1, date2);
		log.info("Modified date from" + " " + date1 + " " + "to" + " " + date2);
		log.info("------------modifyStartDateAndVerify : Test Ended-----------");
	}

	// 21. Check if the start session Drop down has 2 sessions, Session 1 and
	// Session 2
	@Test()
	public static void checkAndVerifyLeaveSessions() {
		log.info("------------checkAndVerifyLeaveSessions : Test Started-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click start session
		lfp.getClickStartSession().click();
		List<String> expSessions = new ArrayList<String>();
		expSessions.add("Session 1");
		expSessions.add("Session 2");
		log.info("Expected leave sessions are :" + expSessions);
		List<String> actSessions = lfp.printLeaveSessions();
		// Close the leave form
		WebdriverUtils.waitForElementPresent(driver, lfp.getcloseLeaveForm());
		lfp.getcloseLeaveForm().click();
		log.info("Verify the leave sessions");
		Assert.assertEquals(actSessions, expSessions);
		log.info("Actual sessions are :" + actSessions.toString());
		log.info("------------checkAndVerifyLeaveSessions : Test Ended-----------");
	}

//22.Check if the End Session automatically picks up where the Leave date is for one day and Session 1 is selected in Start Session
	@Test()
	public static void verifyAutoSelectEndSession() {
		log.info("------------verifyAutoSelectEndSession : Test Started-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		// Click on leave type reason
		lfp.getClickLeaveTypeDropdown().click();
		// Select earned Leave
		lfp.selectEarnedLeave();
		// Select leave reason dropdown
		lfp.getClickLeaveTypeReasonDropdown().click();
		lfp.selectLeaveReasons();
		// Pick the start date
		Date date = new Date("13-Sept-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date);
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date);
		// Verify the end session as session2
		String expSession = "Session 2";
		// Click end session
		lfp.getClickEndSession().click();
		String actSession = lfp.getDefaultEndSessionValue().getText();
		log.info("Expected session is :" + expSession);
		log.info(actSession);
		// Close the leave form window
		lfp.getcloseLeaveForm().click();
		log.info("Verify the end session");
		Assert.assertEquals(actSession, expSession);
		log.info("Auto selected session is :" + actSession);
		log.info("------------verifyAutoSelectEndSession : Test Ended-----------");
	}

	// 23. Comments Section to enter text is mandatory
	@Test()
	public static void commentsBoxMandatory() throws Exception {
		log.info("------------commentsBoxMandatory : Test Started-----------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		String expError = "Leave Details cannot be empty";
		log.info("Expected error message is :" + expError);
		// Click on submit
		WebdriverUtils.clickElement(lfp.getSubmitButton());
		// Capture the actual error message
		String actError = lfp.getLeaveDetailsBlankError().getText();
		// Close the leave form
		WebdriverUtils.clickElement(lfp.getcloseLeaveForm());
		log.info("Verify the error message");
		Assert.assertEquals(actError, expError);
		log.info("The actual error message is :" + actError);
		log.info("------------commentsBoxMandatory : Test Ended-----------");
	}

	// 24. //Verify entered text in comments box
	@Test()
	public static void enterAndVerifyComments() throws Exception {
		log.info("------------enterAndVerifyComments : Test Started---------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		lfp.getClickLeaveForm().click();
		String text = "Apply";
		log.info("Enter the text in the leave details section");
		lfp.getLeaveDetailsEditbox().sendKeys(text);
		// Close the leave form
		WebdriverUtils.clickElement(lfp.getcloseLeaveForm());
		log.info("Verify the entered text");
		Assert.assertTrue(lfp.getLeaveDetailsEditbox().isDisplayed());
		log.info("Entered text is " + text);
		log.info("------------enterAndVerifyComments : Test Ended-----------");
	}

	// 25. check if it displays the file format type and file size that can be
	// uploaded
	@Test()
	public static void verifyFileFormat() throws InterruptedException, Exception {
		log.info("------------verifyFileFormat : Test Started---------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		String expError = "Only JPG, JPEG, PNG, PDF and GIF files are allowed.";
		log.info("Expected error message is :" + expError);
		log.info("Upload the excel file to verify the format.");
		WebdriverUtils.clickAnduploadDocument("C:\\Users\\Prod\\Desktop\\Tasks\\Employee_Information_Sheet.xlsx",
				lfp.getUploadDocument());
		// Capture the actual error message
		WebdriverUtils.waitForElementPresent(driver, lfp.getIncorrectFileTypeError());
		String actError = lfp.getIncorrectFileTypeError().getText();
		Thread.sleep(1000);
		// Close the leave form
		WebdriverUtils.clickElement(lfp.getcloseLeaveForm());
		log.info("Verify the error message");
		Assert.assertEquals(actError, expError);
		log.info("The actual error message is :" + actError);
		log.info("------------verifyFileFormat : Test Ended---------");
	}

	// 26. Upload valid pdf file format and verify it
	@Test()
	public static void uploadValidDocAndVerify() throws InterruptedException, Exception {
		log.info("------------uploadValidDocAndVerify : Test Started------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		// Upload the pdf file
		log.info("Upload the pdf file");
		WebdriverUtils.clickAnduploadDocument("C:\\Users\\Prod\\Desktop\\Tasks\\Doc1.pdf", lfp.getUploadDocument());
		// Capture the actual message after upload
		WebdriverUtils.waitForElementPresent(driver, lfp.getDocumentUploadMessage());
		String uploadedDoc = lfp.getCheckUploadedDocument().getText();
		// Close the leave form
		WebdriverUtils.clickElement(lfp.getcloseLeaveForm());
		Assert.assertTrue(uploadedDoc.contains("Doc"));
		log.info("The uploaded document is :" + uploadedDoc);
		log.info("------------uploadValidDocAndVerify : Test Ended---------");
	}

	// 27.Apply for Leave type more than 3 days of Sick Leave, should prompt to
	// upload document
	@Test()
	public static void verifyDocForThreeDaySickLeave() throws InterruptedException {
		log.info("------------verifyDocForThreeDaySickLeave : Test Started-------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		// Click on leave type dropdown
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeDropdown());
		// Click on sick leave
		lfp.selectSickLeave();
		// Select leave reasons
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeReasonDropdown());
		lfp.selectLeaveReasons();
		// Enter the start date
		Date date1 = new Date("16-Sept-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		Date date2 = new Date("19-Sept-2020");
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date2);
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying");
		// Submit the leave form and verify the document upload mandatory
		WebdriverUtils.clickElement(lfp.getSubmitButton());
		// Capture the expected error message
		String expError = "Upload document is mandatory";
		log.info("Expected error message is :" + expError);
		// Capture the actual error
		WebdriverUtils.waitForElementPresent(driver, lfp.getDocumentMandatoryBlankError());
		String actError = lfp.getDocumentMandatoryBlankError().getText();
		// Close the leave form window
		WebdriverUtils.clickElement(lfp.getcloseLeaveForm());
		log.info("Verify the error message");
		Assert.assertEquals(actError, expError);
		log.info("The actual error message is :" + actError);
		log.info("------------verifyDocForThreeDaySickLeave : Test Ended---------");
	}

	// 27.Apply three days of Sick leave with document and Check if Message appears
	// that the Leave application is submitted successfully
	@Test()
	public static void applyThreeDaySickLeaveWithDocument() throws InterruptedException, Exception {
		log.info("------------applyThreeDaySickLeaveWithDocument : Test Started-------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		// Click on leave type dropdown
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeDropdown());
		// Click on sick leave
		lfp.selectSickLeave();
		// Select leave reasons
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeReasonDropdown());
		lfp.selectLeaveReasons();
		// Enter the start date
		Date date1 = new Date("21-Nov-2020");
		lfp.DatePicker(driver, lfp.getStartDate(), date1);
		Date date2 = new Date("24-Nov-2020");
		// Select end date
		lfp.DatePicker(driver, lfp.getEndDate(), date2);
		// Enter the comments
		lfp.getLeaveDetailsEditbox().sendKeys("Applying");
		log.info("Upload the document with correct size");
		WebdriverUtils.clickAnduploadDocument("C:\\Users\\Prod\\Desktop\\Tasks\\Doc1.pdf", lfp.getUploadDocument());
		// Submit the leave form and verify the document upload mandatory
		WebdriverUtils.clickElement(lfp.getSubmitButton());
		// Declare the expected toast message
		String expMessage = "1 Day(s) Casual/Sick Leave submitted for approval. Please check your leave history for details. Thanks.";
		// Capture the actual leave toast message
		Thread.sleep(2000);
		WebdriverUtils.waitForElementPresent(driver, lfp.getLeaveToastMessage());
		String actMessage = lfp.getLeaveToastMessage().getText();
		log.info("Verify the toast message");
		Assert.assertTrue(actMessage.contains(expMessage));
		log.info("The actual  message is :" + actMessage);
		log.info("------------applyThreeDaySickLeaveWithDocument : Test Ended---------");

	}

	// 28. Without updating any of the fields, Click on submit
	@Test()
	public static void verifyAllMandatoryFields() throws Exception {
		log.info("------------verifyAllMandatoryFields : Test Started---------");
		// Call the leave form page
		LeaveFormPage lfp = PageFactory.initElements(driver, LeaveFormPage.class);
		// Click on leave icon
		WebdriverUtils.clickElement(lfp.getClickLeaveForm());
		// Click on leave type dropdown
		WebdriverUtils.clickElement(lfp.getClickLeaveTypeDropdown());
		String expLeaveTypeBlankError = "Leave Type cannot be empty";
		log.info("Expected :" + expLeaveTypeBlankError);
		String expLeaveReasonBlankError = "Leave Reason cannot be empty";
		log.info("Expected :" + expLeaveReasonBlankError);
		String expStartDateError = "Start Date cannot be empty";
		log.info("Expected :" + expStartDateError);
		String expEndDateError = "End Date cannot be empty";
		log.info("Expected :" + expEndDateError);
		String expLeaveDetails = "Leave Details cannot be empty";
		log.info("Expected :" + expLeaveDetails);
		// Click on submit
		WebdriverUtils.clickElement(lfp.getSubmitButton());
		// Capture the actual message
		String actLeaveTypeBlankError = lfp.getLeaveTypeBlankError().getText();
		String actLeaveReasonBlankError = lfp.getLeaveReasonBlankError().getText();
		String actStartDateError = lfp.getStartDateBlankError().getText();
		String actEndDateError = lfp.getEndDateBlankError().getText();
		String actLeaveDetailsError = lfp.getLeaveDetailsBlankError().getText();
		// Close the leave form
		WebdriverUtils.clickElement(lfp.getCloseLeaveForm());
		log.info("Validate the mandatory fields");
		Assert.assertEquals(actLeaveTypeBlankError, expLeaveTypeBlankError);
		Assert.assertEquals(actLeaveReasonBlankError, expLeaveReasonBlankError);
		Assert.assertEquals(expStartDateError, actStartDateError);
		Assert.assertEquals(actEndDateError, expEndDateError);
		Assert.assertEquals(expLeaveDetails, actLeaveDetailsError);
		log.info("Actual :" + actLeaveTypeBlankError);
		log.info("Actual :" + actLeaveReasonBlankError);
		log.info("Actual :" + expStartDateError);
		log.info("Actual :" + actEndDateError);
		log.info("Actual :" + expLeaveDetails);
		log.info("------------verifyAllMandatoryFields : Test Ended-------");
	}
	
	

}
