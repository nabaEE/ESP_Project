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
@FindBy(xpath="//div[@id='showGroups']/div[2]/div[1]/div/div/p[1]")
private WebElement orgDesignData;
@FindBy(xpath="//div[@id='Display_ul']/div[4]/li/p[text()='Legal Entity Management']")
private WebElement clickLegalEntityManagement;
@FindBy(xpath="//div[@id='Display_ul']/div[3]/li/p")
private WebElement clickCostCenterManagement;
@FindBy(xpath="//div[@id='Display_ul']/div[2]/li/p[text()='Department Management']")
private WebElement clickDepartment;


	
		
	

/*************************Getters Usage*****************************/
public WebElement getClickDepartment() {
	return clickDepartment;
}
public WebElement getCompItemGroups() {
	return compItemGroups;
}
public WebElement getCompItems() {
	return compItems;
}
public WebElement getOrgDesignData() {
	return orgDesignData;
}
public WebElement getClickLegalEntityManagement() {
	return clickLegalEntityManagement;
}
public WebElement getClickCostCenterManagement() {
	return clickCostCenterManagement;
}
	
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
