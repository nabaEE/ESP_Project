package esp.objectRepository;

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
private WebElement currentDate;

@FindBy(id="div_RelieveDate")
private WebElement relieveDate;

@FindBy(id="Feedback")
private WebElement commentsEditbox;

@FindBy(id="Submit")
private WebElement submitButton;

}
