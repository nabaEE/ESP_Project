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
	@FindBy(xpath="//*[@id=\"login_normal\"]")
	private WebElement loginBtn;
	@FindBy(css=".dropdown-icon")
	private WebElement dropDownArrow;
	@FindBy(xpath="//ul[@id='dropdown1']/li[1]/a")
	private WebElement logoutBtn;
	/************************************Utilization******************************************/
	public void loginToPage(String username, String password)
	{
		BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frameset//frame")));
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	 }
	  public void logOut()
	  {
		  WebdriverUtils.waitForElementPresent(BaseClass.driver, dropDownArrow);
	      dropDownArrow.click();
	      logoutBtn.click();
	  }
	
	
}
