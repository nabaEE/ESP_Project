package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompItemsPage 
{
/***********************Initialization****************************/
@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")
private WebElement addNewButton;
@FindBy(xpath="//div[@id='div_Comp_Type']/div/input")
private WebElement compensationTypeDropdown;
@FindBy(xpath="//div[@id='div_Comp_Group']/div/input")
private WebElement compensationGroupDropdown;
@FindBy(xpath="//div[@id='div_Comp_Type']/div/ul/li[2]")
private WebElement pickCompensationTypePayment;
@FindBy(xpath="//div[@id='div_Comp_Group']/div/ul/li")
private List<WebElement> compensationGroupDropdownValues;
@FindBy(id="CompItem_Name")
private WebElement compensationItemName;
@FindBy(xpath="//div[@id='div_Tax_Indicator']/div/p/label/span")
private WebElement taxIndicator;
@FindBy(id="Remarks")
private WebElement remarksEditbox;
@FindBy(id="Submit")
private WebElement submitButton;
@FindBy(xpath="//div[@id='PopUpCont']/div/button/i")
private WebElement closePopupWin;

/***************Getters Usage*******************/
public WebElement getAddNewButton() {
	return addNewButton;
}
public WebElement getCompensationTypeDropdown() {
	return compensationTypeDropdown;
}
public WebElement getpickCompensationTypePayment()
{
	return pickCompensationTypePayment;
}
public WebElement getCompensationGroupDropdown() {
	return compensationGroupDropdown;
}
public WebElement getCompensationItemName() {
	return compensationItemName;
}
public WebElement getTaxIndicator() {
	return taxIndicator;
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






/***********************Utilization********************/

public String checkCompensationGroup()
{
	String val=null;
	for(int i=0; i<compensationGroupDropdownValues.size(); i++)
	{
	  if(compensationGroupDropdownValues.get(i).getText().equals("Payment1")) {
		  val=compensationGroupDropdownValues.get(i).getText();
	  }
	}
	return val;
	
}









}
