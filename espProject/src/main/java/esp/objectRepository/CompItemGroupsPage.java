package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompItemGroupsPage 
{
/**************************Initialization**************************/
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")
private WebElement addNewButton;
@FindBy(xpath="//div[@id='div_Comp_Type']/div/input")
private WebElement compensationType;
@FindBy(xpath="//div[@id='div_Comp_Type']/div/ul/li")
private List<WebElement> compensationTypeDropdownValues;
@FindBy(id="Comp_Group")
private WebElement compensationGroup;
@FindBy(id="Effective_FromDate")
private WebElement effectiveFromDateCalenderWin;
@FindBy(id="Remarks")
private WebElement remarksEditbox;
@FindBy(id="Submit")
private WebElement submitButton;
@FindBy(css=".is-today")
private WebElement currentDate;
@FindBy(id="DBError_Comp_Group")
private WebElement existGroupNameError;
@FindBy(xpath="//div[@id='PopUpCont']/div/button/i")
private WebElement closePopupWin;



	
/*****************************Getters Usage*************************/
public WebElement getClosePopupWin() {
	return closePopupWin;
}

public WebElement getExistGroupNameError() {
	return existGroupNameError;
}
public WebElement getCurrentDate() {
	return currentDate;
}

public WebElement getAddNewButton() {
	return addNewButton;
}
public WebElement getCompensationType() {
	return compensationType;
}
public WebElement getCompensationGroup() {
	return compensationGroup;
}
public WebElement getEffectiveFromDateCalenderWin() {
	return effectiveFromDateCalenderWin;
}
public WebElement getRemarksEditbox() {
	return remarksEditbox;
}
public WebElement getSubmitButton() {
	return submitButton;
}

	
/*******************************Utilization**************************/
public void pickCompensationTypeValue()
{
	for(int i=0; i<compensationTypeDropdownValues.size(); i++)
	{
		if(compensationTypeDropdownValues.get(i).getText().equalsIgnoreCase("Payments")) {
			compensationTypeDropdownValues.get(i).click();
		}
	}
}
}
