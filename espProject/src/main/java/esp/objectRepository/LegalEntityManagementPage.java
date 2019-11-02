package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

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
@FindBy(xpath="//div[@id='div_Remarks']/span")
private WebElement remarksEditboxLength;

@FindBy(xpath="//tbody[@id='TBody']/tr[2]/td[1]/a[1]")
private WebElement editIcon;
@FindBy(xpath="//tbody[@id='TBody']/tr[2]/td[1]/a[2]")
private WebElement viewIcon;
@FindBy(xpath="//tbody[@id='TBody']/tr[2]/td[1]/a[3]")
private WebElement deleteIcon;
@FindBy(id="popUpYes")
private WebElement clickYesButton;
@FindBy(xpath="//tbody[@id='TBody']/tr[2]/td[2]")
private WebElement modifiedLegalEntity;
@FindBy(id="LegalEntityComments")
private WebElement commentsEditbox;
@FindBy(id="SaveLegalEntityComments")
private WebElement saveButton;
@FindBy(xpath="//ul[@id='LegalEntityComments_UL']/div[1]/li/p")
private WebElement checkEnteredComments;
@FindBy(xpath="//th[@id='LegalEntity_Name']/a/i")
private WebElement legalEntityFilterIcon;
@FindBy(id="1_SelectAll")
private WebElement selectAllCheckbox;
@FindBy(id="1_Search")
private WebElement filterWinSearchbox;

@FindBy(id="GridColumn")
private WebElement gridColumnIcon;
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[1]/span")
private WebElement gridIconTooltip;
@FindBy(id="DownloadTable")
private WebElement downloadIcon;
@FindBy(xpath="//a[@id='DownloadTable']/span")
private WebElement downloadTooltip;
@FindBy(id="ClearTable")
private WebElement clearTableIcon;
@FindBy(xpath="//a[@id='ClearTable']/span")
private WebElement clearTableTooltip;
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/span")
private WebElement addNewTooltip;
	


/************Getters Usage*************/
public WebElement getClickYesButton()
{
	return clickYesButton;
}
public WebElement getCommentsEditbox() {
	return commentsEditbox;
}
public WebElement getSaveButton() {
	return saveButton;
}
public WebElement getCheckEnteredComments() {
	return checkEnteredComments;
}

public WebElement getRemarksEditboxLength() {
	return remarksEditboxLength;
}
public WebElement getModifiedLegalEntity() {
	return modifiedLegalEntity;
}
public WebElement getLegalEntityFilterIcon() {
	return legalEntityFilterIcon;
}
public WebElement getSelectAllCheckbox() {
	return selectAllCheckbox;
}
public WebElement getFilterWinSearchbox() {
	return filterWinSearchbox;
}
public WebElement getEditIcon() {
	return editIcon;
}
public WebElement getViewIcon() {
	return viewIcon;
}
public WebElement getDeleteIcon() {
	return deleteIcon;
}
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
//Method to capture grid tooltip
public String getGridTooltip()
{
	WebdriverUtils.waitForPageToLoad(BaseClass.driver);
	Actions act= new Actions(BaseClass.driver);
	act.moveToElement(gridColumnIcon).perform();
	String tooltip=gridIconTooltip.getText();
	return tooltip;
}
//Method to capture download tooltip
public String getDownloadTooltip()
{
	WebdriverUtils.waitForPageToLoad(BaseClass.driver);
	Actions act=new Actions(BaseClass.driver);
	act.moveToElement(downloadIcon).perform();
	String tooltip=downloadTooltip.getText();
	return tooltip;
}
//Method to capture Clear Filter tooltip
public String getClearFilterTooltip()
{
	WebdriverUtils.waitForPageToLoad(BaseClass.driver);
	Actions act=new Actions(BaseClass.driver);	
	act.moveToElement(clearTableIcon).perform();
	String tooltip=clearTableTooltip.getText();
	return tooltip;
}
//Method to capture Add new tooltip
public String getAddNewTooltip()
{
	WebdriverUtils.waitForPageToLoad(BaseClass.driver);
	Actions act= new Actions(BaseClass.driver);
	act.moveToElement(addNewButton).perform();
	String tooltip=addNewTooltip.getText();
	return tooltip;
}

}
