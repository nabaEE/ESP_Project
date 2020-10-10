package esp.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class LoginPage 
{
	/******************Initialization*********************/
	@FindBy(id="User_Email")
	private WebElement userNameEdt;
	@FindBy(id="Password")
	private WebElement passWordEdt;
	@FindBy(id="Customer_Id")
	private WebElement secureUserName;
	@FindBy(id="Customer_Password")
	private WebElement secureUserPassword;
	@FindBy(id="Cmr_Access")
	private WebElement secureSubmit;
	//@FindBy(xpath="//*[@id=\"login_normal\"]")
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement loginBtn;
	@FindBy(css=".dropdown-icon")
	private WebElement dropDownArrow;
	@FindBy(xpath="//ul[@id='dropdown1']/li[2]/a")
	private WebElement logoutBtn;
	
	
	/************************************Utilization******************************************/
	public void loginToPage(String username, String password) {
		BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frameset//frame")));
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	}

	public void secureLogin(String username, String password) {
		secureUserName.sendKeys(username);
		secureUserPassword.sendKeys(password);
		secureSubmit.click();
	}

	public void logOut() throws Exception {
		//WebdriverUtils.waitForElementPresent(BaseClass.driver, dropDownArrow);
		WebdriverUtils.waitForCompleteElementToLoad(dropDownArrow);
		dropDownArrow.click();
		logoutBtn.click();
	}
	
}
