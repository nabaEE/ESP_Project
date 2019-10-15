package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class LandingPage
{
/************Utilization*************/
	@FindBy(xpath="//ul[@class='right hide-on-med-and-down']/li")
	private List<WebElement> landingPageValues;
	@FindBy(xpath="/html/body/header/div[2]/nav/div/ul/li[2]/a/img")
	private WebElement adminIcon;
	@FindBy(xpath="//div[@class='nav-wrapper']/ul/li[2]/a/span")
	private WebElement adminToolTip;
	@FindBy(xpath="//ul[@id='AdminDropDowns']/li[9]/a")
	private WebElement configurationSetupAdminValue;
	@FindBy(xpath="//div[@class='nav-wrapper']/ul/li[4]/ul/li")
	private List<WebElement> adminDropdownValues;
	@FindBy(xpath="//ul[@id='AdminDropDowns']/li[4]/a")
	private WebElement newHireAdminValue;
	
/***********Getters Usage************/
	
	public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getConfigurationSetupAdminValue() {
		return configurationSetupAdminValue;
	}
	public WebElement getNewHireAdminValue() {
		return newHireAdminValue;
	}
	public WebElement getAdminToolTip() {
		return adminToolTip;
	}
	
/***********Utilization*************/
	
	public void clickAdminIcon() {
		for(int i=0; i<landingPageValues.size(); i++)
		{
			if(landingPageValues.get(i).equals(2)) {
				landingPageValues.get(i).click();
			}
		}
		
	}
	
	public void clickNewHire()
	{
		for(int i=0; i<adminDropdownValues.size(); i++)
		{
			if(adminDropdownValues.get(i).getText().equalsIgnoreCase("New Hire")) {
				adminDropdownValues.get(i).click();
			}
		}
	}

//Method to verify Admin tooltip
public String getAdminTooltipText() throws InterruptedException
{
 WebdriverUtils.waitForPageToLoad(BaseClass.driver);
Actions act= new Actions(BaseClass.driver);
act.moveToElement(adminIcon).perform();
 String tooltip=adminToolTip.getText();
 System.out.println("Tooltip message is "+tooltip);
 return tooltip;
}
//Method to print all admin values
public String[] printAdminValues()
{
 String[] val= new String[9];
 for(int i=0; i<adminDropdownValues.size(); i++)
 {
	 val[i]=adminDropdownValues.get(i).getText();
 }
 return val;
 
}


}
