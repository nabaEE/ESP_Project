package esp.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;

public class AdditionalCostPage {

	/************** Initialization *******************/

	@FindBy(id = "SIGNB")
	private WebElement signInBonus;
	@FindBy(id = "RELOC")
	private WebElement relocationReimbursement;
	@FindBy(id = "NOTCE")
	private WebElement noticePayReimbursement;
	@FindBy(id = "OTHRS")
	private WebElement otherOneTimePayments;
	@FindBy(id = "Employee_Name")
	private WebElement employeeSearchBonus;
	@FindBy(xpath = "//div[@id='div_Employee_Name']/ul/li[2]")
	private WebElement pickEmployeeForBonus;
	@FindBy(id = "REFB")
	private WebElement referalBonus;
	@FindBy(xpath="//html//body//main//div//div[2]//div[2]//div//form//div//div//div[2]//fieldset//div[2]//div//button")
	private WebElement clickSubmit;

	/******************* Getters Usage **********************/
	public WebElement getClickSubmit() {
		return clickSubmit;
	}

	public WebElement getSignInBonus() {
		return signInBonus;
	}

	public WebElement getRelocationReimbursement() {
		return relocationReimbursement;
	}

	public WebElement getNoticePayReimbursement() {
		return noticePayReimbursement;
	}

	public WebElement getOtherOneTimePayments() {
		return otherOneTimePayments;
	}

	public WebElement getEmployeeSearchBonus() {
		return employeeSearchBonus;
	}

	public WebElement getReferalBonus() {
		return referalBonus;
	}

	public WebElement getPickEmployeeForBonus() {
		return pickEmployeeForBonus;
	}

	/***************** Usage ***********************/

	// Method to click element using java script
	public void clickElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) BaseClass.driver;
		executor.executeScript("arguments[0].click();", element);

	}
}