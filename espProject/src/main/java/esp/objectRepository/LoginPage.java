package esp.objectRepository;

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
	@FindBy(xpath="//*[@id=\"login_normal\"]")
	private WebElement loginBtn;
	@FindBy(xpath="//i[text()='arrow_drop_down']")
	private WebElement dropDownArrow;
	@FindBy(linkText="Logout")
	private WebElement logoutBtn;
	/************************************Utilization******************************************/
	public void loginToPage(String username, String password)
	{
		BaseClass.driver.switchTo().frame(0);
		
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	 }
	  public void logOut()
	  {
	  WebdriverUtils.waitForPageToLoad(BaseClass.driver);
	  dropDownArrow.click();
	  logoutBtn.click();
	  }
	
	
}
