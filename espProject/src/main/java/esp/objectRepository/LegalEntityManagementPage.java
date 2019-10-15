package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalEntityManagementPage
{
	
/*************Initialization************/
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")	
private WebElement addNewButton;
@FindBy(id="LegalEntity_Name")
private WebElement legalEntityNameEditbox;
@FindBy(id="Effective_FromDate")
private WebElement effectiveFromDateCalenderWin;
@FindBy(id="div_Country")
private WebElement countryDropdown;
@FindBy(id="Remarks")
private WebElement remarksEditbox;
@FindBy(xpath="//div[@id='div_LegalEntity_Name']/span")
private WebElement legalEntityNameEditboxLength;
@FindBy(css=".is-today")
private WebElement currentDate;
@FindBy(id="Submit")
private WebElement submitButton;
@FindBy(xpath="//div[@id='PopUpCont']/div/button/i")
private WebElement closePopupWin;

	
	
	
	
	
/************Getters Usage*************/
public WebElement getAddNewButton() {
	return addNewButton;
}
public WebElement getLegalEntityNameEditbox() {
	return legalEntityNameEditbox;
}
public WebElement getEffectiveFromDateCalenderWin() {
	return effectiveFromDateCalenderWin;
}
public WebElement getCountryDropdown() {
	return countryDropdown;
}
public WebElement getRemarksEditbox() {
	return remarksEditbox;
}
public WebElement getLegalEntityNameEditboxLength() {
	return legalEntityNameEditboxLength;
}
public WebElement getCurrentDate() {
	return currentDate;
}
public WebElement getSubmitButton() {
	return submitButton;
}
public WebElement getClosePopupWin() {
	return closePopupWin;
}	
	
	
/**************Utilization***********/
}
