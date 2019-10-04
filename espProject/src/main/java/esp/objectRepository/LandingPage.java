package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;

public class LandingPage
{
/************Utilization*************/
	@FindBy(xpath="//ul[@class='right hide-on-med-and-down']/li")
	private List<WebElement> landingPageValues;
	@FindBy(xpath="/html/body/header/div[2]/nav/div/ul/li[2]/a/img")
	private WebElement adminIcon;
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

	


}
