package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CostCenterManagementPage
{
/**************Utilization*******************/
@FindBy(id="div_CostCenter_Code")
private WebElement costCenterCode;
@FindBy(id="div_CostCenter_Name")
private WebElement costCenterNameEditbox;
@FindBy(id="div_Effective_FromDate")
private WebElement effectiveFromDateCalenderWin;
@FindBy(css=".is-today")
private WebElement currentDate;
@FindBy(id="div_Remarks")
private WebElement remarksEditbox;
@FindBy(id="Submit")
private WebElement submitButton;
@FindBy(xpath="//div[@id='PopUpCont']/div/button/i")
private WebElement closePopupWin;
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")
private WebElement addNewButton;


/********************Getters Usage*********************/
public WebElement getAddNewButton()
{
	return addNewButton;
}
public WebElement getCostCenterCode() {
	return costCenterCode;
}
public WebElement getCostCenterNameEditbox() {
	return costCenterNameEditbox;
}
public WebElement getEffectiveFromDateCalenderWin() {
	return effectiveFromDateCalenderWin;
}
public WebElement getCurrentDate() {
	return currentDate;
}
public WebElement getRemarksEditbox() {
	return remarksEditbox;
}
public WebElement getSubmitButton() {
	return submitButton;
}
public WebElement getClosePopupWin() {
	return closePopupWin;
}

/**********************Utilization*********************/	


}
