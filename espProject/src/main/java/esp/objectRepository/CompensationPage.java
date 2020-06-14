package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompensationPage 
{
/****************Initialize******************/
@FindBy(xpath="//form[@id='CompForm']/div[2]/div/div[2]/div[2]/div/p[1]/label/span")
private WebElement clickAbove3Lakh;

@FindBy(id="SKIP")
private WebElement skipButton;

@FindBy(id="Submit")
private WebElement saveAndContinueButton;

@FindBy(xpath="//label[text()='Select Profile ']")
private WebElement selectProfileDropdown;
@FindBy(xpath="//span[text()='NXTGEN - Above 3Lakh with LTA']")
private WebElement selectOneProfile;

@FindBy(id="UserEntered_Amt")
private WebElement userEnteredAmountEditbox;
@FindBy(xpath="//div[@id='Display_ul']/div[4]/li/p")
private WebElement clickHireSummary;
@FindBy(xpath="//div[@id='Display_ul']/div[5]/li/p")
private WebElement clickHireSummaryMUJ;
@FindBy(xpath="//div[@id='Display_ul']/div[3]/li/p")
private WebElement clickHireSummarySpecific;

/************Getters Usage*******************/
public WebElement getClickHireSummarySpecific() {
	return clickHireSummarySpecific;
}
public WebElement getClickHireSummary() {
	return clickHireSummary;
}
public WebElement getUserEnteredAmountEditbox()
{
	return userEnteredAmountEditbox;
}
public WebElement getSelectProfileDropdown() {
	return selectProfileDropdown;
}

public WebElement getSelectOneProfile() {
	return selectOneProfile;
}
public WebElement getClickAbove3Lakh() {
	return clickAbove3Lakh;
}

public WebElement getSkipButton() {
	return skipButton;
}

public WebElement getSaveAndContinueButton() {
	return saveAndContinueButton;
}
public WebElement getClickHireSummaryMUJ() {
	return clickHireSummaryMUJ;
}
	
	
/************Utilization*********************/
}
