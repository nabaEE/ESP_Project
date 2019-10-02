package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationSetupPage
{
 /**********************Initialization*****************************/
@FindBy(xpath="//div[@id='showGroups']/div[2]/div[4]/div/div/p[1]")
private WebElement compensationItems;
@FindBy(xpath="//div[@id='Display_ul']/div[2]/li/p")
private WebElement compItemGroups;
@FindBy(xpath="//div[@id='Display_ul']/div[3]/li/p")
private WebElement compItems;
	
	
		
	
/*************************Getters Usage*****************************/
	
public WebElement getCompensationItems() {
	return compensationItems;
}
public WebElement getcompItemGroups() {
	return compItemGroups;
}
public WebElement getcompItems() {
	return compItems;
}

	
	
	
	/****************************Utilization*********************************/

}
