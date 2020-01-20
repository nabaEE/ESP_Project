package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeparationRequestPage 
{
@FindBy(id="div_Separation_Type")
private WebElement separationType;
@FindBy(xpath="//div[@id='div_Separation_Type']/div/ul/li[2]")
private WebElement selectSeparationType;

@FindBy(id="div_Separation_Reason")
private WebElement separationReason;
@FindBy(xpath="//div[@id='div_Separation_Reason']/div/ul/li[2]")
private WebElement selectSeparationReason;

@FindBy(id="div_InitiatedDate")
private WebElement submissionDate;
@FindBy(css=".is-today")
private WebElement selectToday;

@FindBy(xpath="//input[@id='RelieveDate']")
private WebElement relieveDate;
@FindBy(xpath="//tbody//tr//td//button[text()='20']")

private WebElement selectRelieveDate;
@FindBy(id="Feedback")
private WebElement commentsEditbox;

@FindBy(id="Submit")
private WebElement submitButton;

@FindBy(xpath="//tbody/tr[10]/td/ul/li")
private List<WebElement> adminActions;

@FindBy(id="InitiatedText")
private WebElement initiatedText;
@FindBy(id="RelieveText")
private WebElement relieveText;

/*********************Getters Usage**************************/
public WebElement getInitiatedText()
{
	return initiatedText;
}
public WebElement getRelieveText()
{
	return relieveText;
}
public WebElement getSelectRelieveDate()
{
	return selectRelieveDate;
}
public WebElement getSeparationType() {
	return separationType;
}

public WebElement getSelectSeparationType() {
	return selectSeparationType;
}

public WebElement getSeparationReason() {
	return separationReason;
}

public WebElement getSelectSeparationReason() {
	return selectSeparationReason;
}

public WebElement getSubmissionDate() {
	return submissionDate;
}

public WebElement getSelectToday()
{
	return selectToday;
}

public WebElement getRelieveDate() {
	return relieveDate;
}

public WebElement getCommentsEditbox() {
	return commentsEditbox;
}

public WebElement getSubmitButton() {
	return submitButton;
}

/***************************Utilization****************************/

public void clickSeparationOption()
{
for (int i=0; i<adminActions.size(); i++)
{
  if(adminActions.get(i).getText().equalsIgnoreCase("Separation")) {
	  adminActions.get(i).click();
  }
}

}
}
