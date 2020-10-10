package esp.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;

public class CompensationPage 
{
/****************Initialize******************/
@FindBy(xpath="//form[@id='CompForm']/div[2]/div/div[2]/div[2]/div/p[1]/label/span")
private WebElement clickAbove3Lakh;

@FindBy(id="SKIP")
private WebElement skipButton;
@FindBy(xpath="//form[@id='CompForm']/div[2]/div/div/div[1]/div/div/div[3]/div/div/span/div/input")
private WebElement selectProfileDropdown;
@FindBy(xpath="//span[text()='NXTGEN - Above 3Lakh with LTA ']")
private WebElement selectCompProfileNextgen;
@FindBy(xpath="//form[@id='CompForm']/div[2]/div/div/div/div/div/div[3]/div/div/span/div/ul/li[2]")
private WebElement selectIPEprofile;
@FindBy(xpath="//span[text()='Fixed with Variable pay ']")
private WebElement selectBluestoneProfile;
@FindBy(id="UserEntered_Amt")
private WebElement annualFixedAmountNextgen;
@FindBy(id="UserEntered_Amt")
private WebElement annualFixedAmount;
@FindBy(id="BAS")
private WebElement basicPayIPE;
@FindBy(xpath="//div[@id='Display_ul']/div[4]/li/p")
private WebElement clickHireSummary;
@FindBy(xpath="//div[@id='Display_ul']/div[5]/li/p")
private WebElement clickHireSummaryMUJ;
@FindBy(xpath="//div[@id='Display_ul']/div[3]/li/p")
private WebElement clickHireSummarySpecific;
@FindBy(xpath="//div[@id='FinalSubmitDiv']/button[@id='Submit']")
private static WebElement saveAndContinue;

/************Getters Usage*******************/
public WebElement getBasicPayIPE() {
	return basicPayIPE;
}
public WebElement getSelectIPEprofile() {
	return selectIPEprofile;
}
public WebElement getsaveAndContinue() {
	return saveAndContinue;
}
public WebElement getClickHireSummarySpecific() {
	return clickHireSummarySpecific;
}
public WebElement getClickHireSummary() {
	return clickHireSummary;
}
public WebElement getAnnualFixedAmountNextgen()
{
	return annualFixedAmountNextgen;
}
public WebElement getSelectProfileDropdown() {
	return selectProfileDropdown;
}

public WebElement getSelectCompProfileNextgen() {
	return selectCompProfileNextgen;
}
public WebElement getClickAbove3Lakh() {
	return clickAbove3Lakh;
}

public WebElement getSkipButton() {
	return skipButton;
}
public WebElement getClickHireSummaryMUJ() {
	return clickHireSummaryMUJ;
}
public WebElement getSelectBluestoneProfile() {
	return selectBluestoneProfile;
}
public WebElement getAnnualFixedAmount() {
	return annualFixedAmount;
}
	
	
/************Utilization*********************/

//Method to click element using java script
public void clickElement(WebElement element) {
    JavascriptExecutor executor = (JavascriptExecutor)BaseClass.driver;
    executor.executeScript("arguments[0].click();", element);
}
// Method to click while stale element exception
public boolean retryingFindClick(WebElement element) {
    boolean result = false;
    int attempts = 0;
    while(attempts < 2) {
        try {
             ((WebElement) element).click();
            result = true;
            break;
        } catch(StaleElementReferenceException e) {
        }
        attempts++;
    }
    return result;
}
	
}

