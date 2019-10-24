package esp.objectRepository;

import java.util.List;

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
@FindBy(xpath="//div[@id='div_Country']/div/ul/li/span[text()='India']")
private WebElement pickCountryIndia;
@FindBy(xpath="//tbody[@id='TBody']/tr/td[2]")
private List<WebElement> legalEntities;
@FindBy(id="Error_LegalEntity_Name")
private WebElement legalEntityNameEditboxBlankErr;
@FindBy(id="Error_Effective_FromDate")
private WebElement effectiveFromDateBlankErr;
@FindBy(id="Error_Country")
private WebElement countryDropdownBlankErr;
@FindBy(id="Error_Remarks")
private WebElement remarksEditboxBlankErr;

	
	
	
	
	

/************Getters Usage*************/
public List<WebElement> getLegalEntities() {
	return legalEntities;
}
public WebElement getLegalEntityNameEditboxBlankErr() {
	return legalEntityNameEditboxBlankErr;
}
public WebElement getEffectiveFromDateBlankErr() {
	return effectiveFromDateBlankErr;
}
public WebElement getCountryDropdownBlankErr() {
	return countryDropdownBlankErr;
}
public WebElement getRemarksEditboxBlankErr() {
	return remarksEditboxBlankErr;
}
public WebElement getPickCountryIndia()
{
	return pickCountryIndia;
}
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
public String verifyLegalEntity()
{
	String val=null;
	for(int i=0; i<legalEntities.size(); i++)
	{
		if(legalEntities.get(i).getText().equals("Test1"))
		{
			val=legalEntities.get(i).getText();
		}
	}
	return val;
}


}
