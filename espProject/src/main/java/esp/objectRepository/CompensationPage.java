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

@FindBy(xpath="//form[@id='CompForm']/div[2]/div/div/div[2]/div/div/div[3]/div/div/span/div/input")
private WebElement selectProfileDropdown;
@FindBy(xpath="//span[text()='NXTGEN - Above 3Lakh with LTA']")
private WebElement selectOneProfile;

@FindBy(id="UserEntered_Amt")
private WebElement userEnteredAmountEditbox;

/************Getters Usage*******************/
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
	
	
/************Utilization*********************/
}
