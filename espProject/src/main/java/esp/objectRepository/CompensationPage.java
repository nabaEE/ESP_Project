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

	

/************Getters Usage*******************/
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
