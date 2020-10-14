package esp.objectRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class LeaveFormPage {
	/****************** Initialization ************************/
	@FindBy(xpath = "//html/body/main//div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/a/div/div[2]/span")
	private WebElement clickLeaveForm;
	@FindBy(xpath = "//div[@id='div_Leave_Type']/div/input")
	private WebElement clickLeaveTypeDropdown;
	@FindBy(xpath = "//div[@id='div_Leave_Type']/div/ul/li")
	private List<WebElement> leaveTypeValues;
	@FindBy(xpath = "//div[@id='div_Leave_Type']/div/ul/li[2]")
	private WebElement pickRandomLeaveType;
	@FindBy(xpath = "//div[@id='div_Leave_Reason']/div/input")
	private WebElement clickLeaveTypeReasonDropdown;
	@FindBy(xpath = "//div[@id='div_Leave_Reason']/div/ul/li")
	private List<WebElement> leaveTypeReasonValues;
	@FindBy(id = "Start_Date")
	private WebElement startDate;
	@FindBy(id = "End_Date")
	private WebElement endDate;
	@FindBy(xpath = "//div[@id='div_Session_StartDt']/div/input")
	private WebElement clickStartSession;
	@FindBy(xpath = "//div[@id='div_Session_EndDt']/div/input")
	private WebElement clickEndSession;
	@FindBy(xpath = "//div[@id='div_Session_EndDt']/div/ul/li[3]")
	private WebElement defaultEndSessionValue;
	@FindBy(xpath = "//div[@id='div_Session_StartDt']/div/ul/li")
	private List<WebElement> session1Values;
	@FindBy(xpath = "//div[@id='div_Session_EndDt']/div/ul/li/span")
	private List<WebElement> session2Values;
	@FindBy(id = "Leave_Details")
	private WebElement leaveDetailsEditbox;
	@FindBy(id = "Error_Leave_Details")
	private WebElement leaveDetailsBlankError;
	@FindBy(id = "Leave_Description")
	private WebElement leaveDetailsODform;
	@FindBy(id = "Leave_Doc")
	private WebElement uploadDocument;
	@FindBy(id = "Check")
	private WebElement checkButton;
	@FindBy(id = "Submit")
	private WebElement submitButton;
	@FindBy(xpath = "//div[@id='PopUpDiv']/div/div/a/i")
	private WebElement maximizeLeaveForm;
	@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[11]")
	private WebElement leaveStatus;
	@FindBy(xpath = "//div[@id='Display_ul']/div[3]/li/p")
	private WebElement clickOutDoorDutyForm;
	@FindBy(xpath = "//div[@id='Display_ul']/div/li/p")
	private List<WebElement> leavePageValues;
	@FindBy(xpath = "//nav[@class='custom-navbar']/div/ul/li[3]")
	private WebElement clickHomeIcon;
	@FindBy(xpath = "//div[@id='PopUpDiv']/div/div/button/i")
	private WebElement closeLeaveForm;
	@FindBy(xpath = "//div[@id='ListMainDiv']/div/div/table/tbody/tr")
	private List<WebElement> leaveTypeBalances;
	@FindBy(xpath = "//div[@id='ListMainDiv']/div/div/table/tbody")
	private WebElement LeaveBalanceTable;
	@FindBy(id = "Error_Leave_Type")
	private WebElement leaveTypeBlankError;
	@FindBy(id = "Error_Leave_Reason")
	private WebElement leaveReasonBlankError;
	@FindBy(id = "DBError_Leave_Type")
	private WebElement leaveErrorOnAppliedDate;
	@FindBy(id = "DBError_Start_Date")
	private WebElement leaveDateErrorMessage;
	@FindBy(id = "InvalidFile_Leave_Doc")
	private WebElement incorrectFileTypeError;
	@FindBy(id = "snackbar")
	private WebElement documentUploadMessage;
	@FindBy(id = "DBError_Leave_Doc")
	private WebElement documentMandatoryBlankError;
	@FindBy(xpath = "//div[@id='ContentDiv']/table/tr/td[1]/a/span")
	private WebElement checkUploadedDocument;
	@FindBy(xpath = "//html//body//div[@id='snackbar']")
	private WebElement leaveToastMessage;
	@FindBy(id = "Error_Start_Date")
	private WebElement startDateBlankError;
	@FindBy(id = "Error_End_Date")
	private WebElement endDateBlankError;
	@FindBy(xpath="//span[text()='Leave Form for Suresh Prabhu N (#000614)']")
	private WebElement leaveFormTitle;
	@FindBy(xpath="//div[@id='div_Leave_Type']/div/ul/li/span[text()='Adoption Leave']")
	private WebElement clickAdoptionLeaveTypeBS;

	/****************** Getters and Setters Usage *************/
	public WebElement getclickAdoptionLeaveTypeBS() {
		return clickAdoptionLeaveTypeBS;
	}
	public WebElement getLeaveStatus() {
		return leaveStatus;
	}
	public WebElement geLeaveFormTitle() {
		return leaveFormTitle;
	}
	public List<WebElement> getLeaveTypeReasonValues() {
		return leaveTypeReasonValues;
	}

	public List<WebElement> getSession1Values() {
		return session1Values;
	}

	public List<WebElement> getSession2Values() {
		return session2Values;
	}

	public List<WebElement> getLeavePageValues() {
		return leavePageValues;
	}

	public WebElement getCloseLeaveForm() {
		return closeLeaveForm;
	}

	public List<WebElement> getLeaveTypeBalances() {
		return leaveTypeBalances;
	}

	public WebElement getLeaveDateErrorMessage() {
		return leaveDateErrorMessage;
	}

	public WebElement getStartDateBlankError() {
		return startDateBlankError;
	}

	public WebElement getEndDateBlankError() {
		return endDateBlankError;
	}

	public WebElement getLeaveToastMessage() {
		return leaveToastMessage;
	}

	public WebElement getCheckUploadedDocument() {
		return checkUploadedDocument;
	}

	public WebElement getDocumentMandatoryBlankError() {
		return documentMandatoryBlankError;
	}

	public WebElement getDocumentUploadMessage() {
		return documentUploadMessage;
	}

	public WebElement getIncorrectFileTypeError() {
		return incorrectFileTypeError;
	}

	public WebElement getLeaveDetailsBlankError() {
		return leaveDetailsBlankError;
	}

	public WebElement getleaveDateErrorMessage() {
		return leaveDateErrorMessage;
	}

	public WebElement getLeaveErrorOnAppliedDate() {
		return leaveErrorOnAppliedDate;
	}

	public WebElement getLeaveReasonBlankError() {
		return leaveReasonBlankError;
	}

	public WebElement getLeaveTypeBlankError() {
		return leaveTypeBlankError;
	}

	public WebElement getPickRandomLeaveType() {
		return pickRandomLeaveType;
	}

	public WebElement getLeaveBalanceTable() {
		return LeaveBalanceTable;
	}

	public WebElement getcloseLeaveForm() {
		return closeLeaveForm;
	}

	public WebElement getClickHomeIcon() {
		return clickHomeIcon;
	}

	public WebElement getMaximizeLeaveForm() {
		return maximizeLeaveForm;
	}

	public WebElement getClickOutDoorDutyForm() {
		return clickOutDoorDutyForm;
	}

	public WebElement getClickLeaveForm() {
		return clickLeaveForm;
	}

	public WebElement getClickLeaveTypeDropdown() {
		return clickLeaveTypeDropdown;
	}

	public List<WebElement> getLeaveTypeValues() {
		return leaveTypeValues;
	}

	public WebElement getDefaultEndSessionValue() {
		return defaultEndSessionValue;
	}

	public WebElement getClickLeaveTypeReasonDropdown() {
		return clickLeaveTypeReasonDropdown;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getClickStartSession() {
		return clickStartSession;
	}

	public WebElement getClickEndSession() {
		return clickEndSession;
	}

	public WebElement getLeaveDetailsEditbox() {
		return leaveDetailsEditbox;
	}

	public WebElement getUploadDocument() {
		return uploadDocument;
	}

	public WebElement getCheckButton() {
		return checkButton;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getLeaveDetailsODform() {
		return leaveDetailsODform;
	}

	/****************** Utilization ***************************/
	// Methold to print all leave types
	public List<String> printleaveTypeValues() {
		List<String> val = new ArrayList<String>();
		for (int i = 1; i < leaveTypeValues.size(); i++) {
			val.add(leaveTypeValues.get(i).getText());
		}
		return val;

	}

//Method to select the Earned Leave
	public void selectEarnedLeave() {
		for (int i = 0; i < leaveTypeValues.size(); i++) {
			if (leaveTypeValues.get(i).getText().equalsIgnoreCase("Earned Leave")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeValues.get(i));
				leaveTypeValues.get(i).click();
			}
		}

	}

//Method to select Sick Leave
	public void selectSickLeave() {
		for (int i = 0; i < leaveTypeValues.size(); i++) {
			if (leaveTypeValues.get(i).getText().equalsIgnoreCase("Sick Leave")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeValues.get(i));
				leaveTypeValues.get(i).click();
			}
		}
	}

//Method to select Work From Home 
	public void selectWFH() {
		for (int i = 0; i < leaveTypeValues.size(); i++) {
			if (leaveTypeValues.get(i).getText().equalsIgnoreCase("Work From Home")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeValues.get(i));
				leaveTypeValues.get(i).click();
			}
		}
	}

//Method to select leave reasons
	public void selectLeaveReasons() {
		for (int i = 0; i < leaveTypeReasonValues.size(); i++) {
			if (leaveTypeReasonValues.get(i).getText().equalsIgnoreCase("Planned Leave")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeReasonValues.get(i));
				leaveTypeReasonValues.get(i).click();
			}
		}
	}
	//Method to select leave reasons for other customers except TBI
	public void selectReasonEE() {
		for (int i = 0; i < leaveTypeReasonValues.size(); i++) {
			if (leaveTypeReasonValues.get(i).getText().equalsIgnoreCase("Personal")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeReasonValues.get(i));
				leaveTypeReasonValues.get(i).click();
			}
		}
	}

	// Method to select OD leave reason
	public void selectODLeaveReason() {
		for (int i = 0; i < leaveTypeReasonValues.size(); i++) {
			if (i == 1) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeReasonValues.get(i));
				leaveTypeReasonValues.get(i).click();
			}
		}
	}

	// Method to select a date
	public void DatePicker(WebDriver driver, WebElement element, Date date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',' " + date + "');", element);
	}

//Method to select session 1
	public void pickFirstHalfStartSession() {
		for (int i = 0; i < session1Values.size(); i++) {
			if (session1Values.get(i).getText().equalsIgnoreCase("Session 1")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, session1Values.get(i));
				session1Values.get(i).click();

			}
		}
	}

//Method to select session 2
	public void pickFirstHalfEndSession() {
		for (int i = 0; i < session2Values.size(); i++) {
			if (session2Values.get(i).getText().equalsIgnoreCase("Session 1")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, session2Values.get(i));
				session2Values.get(i).click();
			}
		}
	}

//Method to select session 2
	public void pickSecondHalfStartSession() {
		for (int i = 0; i < session1Values.size(); i++) {
			if (session1Values.get(i).getText().equalsIgnoreCase("Session 2")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, session1Values.get(i));
				session1Values.get(i).click();

			}
		}
	}

//Method to select session 2
	public void pickSecondHalfEndSession() {
		for (int i = 0; i < session2Values.size(); i++) {
			if (session2Values.get(i).getText().equalsIgnoreCase("Session 2")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, session2Values.get(i));
				session2Values.get(i).click();
			}
		}
	}

//Method to select OD
	public void selectOutDoorDutyOnLeaveForm() {
		for (int i = 0; i < leavePageValues.size(); i++) {
			if (leavePageValues.get(i).getText().equalsIgnoreCase("OD Form")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leavePageValues.get(i));
				leavePageValues.get(i).click();
			}
		}
	}
	
	//Method to click on Leave/History page
	public void clickLeaveHistory() throws Exception {
		for(int i=0; i<leavePageValues.size(); i++) {
			if (leavePageValues.get(i).getText().equalsIgnoreCase("Leave/OD History")) {
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leavePageValues.get(i));
				WebdriverUtils.clickElement(leavePageValues.get(i));
			}
			
		}
	}

	// Method to print leave balances
	public List<String> printLeaveBalances() {
		List<String> val = new ArrayList<String>();
		for (int i = 1; i < leaveTypeBalances.size(); i++) {
			val.add(leaveTypeBalances.get(i).getText());
		}
		return val;
	}

//Method to print leave reasons based on leave type
	public ArrayList<String> leaveReasonsForLeaveType() {
		ArrayList<String> val = new ArrayList<String>();
		for (int i = 1; i < leaveTypeValues.size(); i++) {
			// Click on the leave type dropdown
			WebdriverUtils.waitForElementPresent(BaseClass.driver, clickLeaveTypeDropdown);
			clickLeaveTypeDropdown.click();
			// Pick the leave type
			WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeValues.get(i));
			leaveTypeValues.get(i).click();
			WebdriverUtils.waitForElementPresent(BaseClass.driver, clickLeaveTypeReasonDropdown);
			clickLeaveTypeReasonDropdown.click();
			for (int j = 0; j < leaveTypeReasonValues.size(); j++) {
				// Click on the leave Reason dropdown
				WebdriverUtils.waitForElementPresent(BaseClass.driver, leaveTypeReasonValues.get(j));
				val.add(leaveTypeReasonValues.get(j).getText());
			}

			continue;
		}
		return val;
	}

	// Method to verify leave sessions
	public List<String> printLeaveSessions() {
		ArrayList<String> sessions = new ArrayList<String>();
		for (int i = 1; i < session1Values.size(); i++) {
			sessions.add(session1Values.get(i).getText());
		}
		return sessions;
	}

	// Method to check if leave is exist else submit the leave
	public void leaveCheckAndApply() throws Exception {
		WebdriverUtils.clickElement(submitButton);
		if(leaveErrorOnAppliedDate.isDisplayed()) {
			String error=leaveErrorOnAppliedDate.getText();
			WebdriverUtils.clickElement(closeLeaveForm);
			BaseClass.log.info(error);
		 }
	  else {
		  BaseClass.log.info("Leave submitted");
	  
		   }
		

   }
}
