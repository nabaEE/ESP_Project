package esp.objectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class HireSummaryPage
{
/*************Initialization*****************/
 @FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[5]/td[1]/a/i")
 private WebElement clickContactDetails;
 
 @FindBy(id="div_Phone_Type")
 private WebElement phoneTypeDropdown;
 @FindBy(xpath="//div[@id='div_Phone_Type']/div/ul/li[2]")
 private WebElement pickPhoneTypeAsHome;
 @FindBy(xpath="//div[@id='div_Phone_Type']/div/ul/li[3]")
 private WebElement pickPhoneTypeAsMobile;
 @FindBy(id="Error_Phone_Type")
 private WebElement phoneTypeBlankErrMessage;
 
 
 @FindBy(id="div_Country_Code")
 private WebElement countryCodeDropdown;
 //@FindBy(id="//div[@id='div_Country_Code']/div/ul/li[2]/span")
 @FindBy(xpath="//html//body//main//div//div[2]//div[2]//div[3]//div//form//div[1]//div//div//div[1]//div[2]//div//ul//li[2]//span")
 private WebElement pickCountryCodeAsIndia;
 @FindBy(id="Error_Country_Code")
 private WebElement countryCodeBlankErrorMessage;
 
 @FindBy(id="Contact_Number")
 private WebElement numberEditbox;
 @FindBy(xpath="//div[@id='div_Contact_Number']/span")
 private WebElement numberEditboxLength;
 @FindBy(id="Error_Contact_Number")
 private WebElement contactNumberBlankErrMessage;
 
 @FindBy(id="Submit")
 private WebElement submitButton;
 
 @FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[6]/td[2]/table/tbody/tr[1]/td[1]/a/i")
 private WebElement clickCurrentAddressPencilIcon;
 @FindBy(id="Effective_FromDate")
 private WebElement effectiveFromDateCalenderWin;
 @FindBy(css=".is-today")
 private WebElement currentDate;
 @FindBy(id="Error_Effective_FromDate")
 private WebElement  EffectiveFromDateBlankErrMessage;
 
 @FindBy(id="Address_Line1")
 private WebElement addressLine1;
 @FindBy(xpath="//div[@id='div_Address_Line1']/span")
 private WebElement addressLine1Length;
 @FindBy(id="Error_Address_Line1")
 private WebElement addressLine1BlankErrMessage;
 
 @FindBy(id="div_Country_Name")
 private WebElement countryDropdownOnAddressDetailsWin;
 @FindBy(xpath="//div[@id='div_Country_Name']/div/ul/li")
 private List<WebElement> countryDropdownValues;
 @FindBy(xpath="//div[@id='div_Country_Name']/div/ul/li[2]")
 private WebElement pickCountryIndiaOnAddressDetailsWin;
 @FindBy(id="Error_Country_Name")
 private WebElement countryBlankErrorMessage;
 
 @FindBy(id="div_State")
 private WebElement stateDropdownOnAddressDetailsWin;
 @FindBy(xpath="//div[@id='div_State']/div/ul/li")
 private List<WebElement> stateDropdownValues; 
 @FindBy(xpath="//div[@id='div_State']/div/ul/li[3]")
 private WebElement pickState;
 
 @FindBy(id="City")
 private WebElement cityEditbox;
 @FindBy(xpath="//div[@id='div_City']/ul/li[2]")
 private WebElement pickCity;
 @FindBy(id="Error_City")
 private WebElement cityBlankErrorMessage;
 
 @FindBy(id="Postal_Code")
 private WebElement postalCode;
 @FindBy(xpath="//div[@id='div_Postal_Code']/span")
 private WebElement postalCodeLength;
 @FindBy(id="Error_Postal_Code")
 private WebElement postalCodeEditboxBlankErrMessage;
 
 @FindBy(xpath="//div[@id='div_Copy_Address']/div/p/label/span")
 private WebElement copyCurrentAddressAsPermanentAddress;
 
 @FindBy(css="#Item_Doc")
 private WebElement uploadButton;
 @FindBy(id="Error_Item_Doc")
 private WebElement uploadBlankErrorMessage;
 
 @FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[7]/td[1]/a/i")
 private WebElement emailDetailsAddIcon;
 
 @FindBy(id="div_Email_Type")
 private WebElement emailTypeDropdown;
 @FindBy(xpath="//div[@id='div_Email_Type']/div/ul/li[2]")
 private WebElement pickPersonalEmail;
 @FindBy(xpath="//div[@id='div_Email_Type']/div/ul/li[2]")
 private WebElement pickEmergencyEmail;
 @FindBy(id="Error_Email_Type")
 private WebElement emailTypeBlankErrorMessage;
 
 @FindBy(id="Email_ID")
 private WebElement emailIdEditbox;
 @FindBy(xpath="//div[@id='div_Email_ID']/span")
 private WebElement emailIdEditboxLength;
 @FindBy(id="Error_Email_ID")
 private WebElement emailIdBlankErrorMessage;
 
 //@FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[10]/td[1]/a/i")
 @FindBy(xpath="//html//body//main//div//div[2]//div[2]//form//div[1]//div//table//tbody//tr[11]//td[2]//table//thead//tr//td//span")
 private WebElement statutoryNumbersAddIcon;
 @FindBy(id="div_Statutory_Type")
 private WebElement statutoryTypeDropdown;
 @FindBy(xpath="//div[@id='div_Statutory_Type']/div/ul/li")
 private List<WebElement> statutoryTypeDropdownValues;
 @FindBy(xpath="//div[@id='div_Statutory_Type']/div/ul/li[2]")
 private WebElement pickAadharStatutoryType;
 @FindBy(xpath="//div[@id='div_Statutory_Type']/div/ul/li[8]")
 private WebElement pickPANStatutoryType;
 @FindBy(xpath="//div[@id='div_Statutory_Type']/div/ul/li[4]")
 private WebElement pickDrivingLincenceStatutoryType;
 @FindBy(id="SaveC")
 private WebElement statutoryDetailsSubmitButton;
 @FindBy(id="Error_Statutory_Type")
 private WebElement statutoryTypeBlankErrorMessage;
 
 @FindBy(id="Statutory_Value")
 private WebElement statutoryValueEditbox;
 @FindBy(xpath="//div[@id='div_Statutory_Value']/span")
 private WebElement statutoryValueEditboxLength;
 @FindBy(id="Error_Statutory_Value")
 private WebElement statutoryValueBlankErrMessage;
 
 @FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[13]/td[1]/a/i") //..........
 private WebElement healthDetailsAddIcon;
 
 @FindBy(id="Emp_Height")
 private WebElement heightEditbox;
 @FindBy(xpath="//div[@id='div_Emp_Height']/span")
 private WebElement heightEditboxLength;
 @FindBy(id="Error_Emp_Height")
 private WebElement heightEditboxBlankErrorMessage;
 
 @FindBy(id="Emp_Weight")
 private WebElement weightEditbox;
 @FindBy(xpath="//div[@id='div_Emp_Weight']/span")
 private WebElement weightEditboxLength;
 @FindBy(id="Error_Emp_Weight_Invalid")
 private WebElement weightEditboxBlankErrorMessage;
 
 @FindBy(id="div_Blood_Group")
 private WebElement bloodGroupDropdown;
 @FindBy(xpath="//div[@id='div_Blood_Group']/div/ul/li")
 private List<WebElement> bloodGroupDropdownvalues;
 @FindBy(xpath="//div[@id='div_Blood_Group']/div/ul/li[2]")
 private WebElement pickBloodGroup;
 @FindBy(id="Error_Blood_Group")
 private WebElement bloodGroupBlankErrMessage;
 
 @FindBy(xpath="//div[@id='div_Differently_Abled']/div/p/label/span")
 private WebElement differentlyAbledSwitchButton;
 @FindBy(id="div_Diff_Abled_Type")
 private WebElement differentlyAbledTypeDropdown;
 @FindBy(xpath="//div[@id='div_Diff_Abled_Type']/div/ul/li")
 private List<WebElement> differentlyAbledTypeDropdownValues;
 @FindBy(xpath="//div[@id='div_Diff_Abled_Type']/div/ul/li[2]")
 private WebElement pickDifferentlyAbledType;
 @FindBy(id="Error_Diff_Abled_Type")
 private WebElement differentlyAbledTypeDropdownBlankErrMessage;
 
 @FindBy(id="div_Diff_Abled_Perce")
 private WebElement differentlyAbledPercentageDropdown;
 @FindBy(xpath="//div[@id='div_Diff_Abled_Perce']/div/ul/li[2]")
 private WebElement pickDifferentlyAbledPercentage;
 @FindBy(id="Error_Diff_Abled_Perce")
 private WebElement differentlyAbledPercentageDropdownBlankErrMessage;
 
 @FindBy(id="div_PT_Exemption")
 private WebElement ptExemptionDropdown;
 @FindBy(xpath="//div[@id='div_PT_Exemption']/div/ul/li[2]")
 private WebElement pickPTExemptionDropdownvalue;
 @FindBy(id="Error_PT_Exemption")
 private WebElement ptExemptionBlankErrMessage;
 
 @FindBy(xpath="//fieldset[@class='custom-fieldset']/div[1]/input")
 private WebElement uploadAppointmentLetterButton;
 @FindBy(id="f_upload")
 private WebElement fileUpload;
 
 @FindBy(xpath="//form[@id='ContentDiv']/div[5]/button")
 private WebElement deleteIcon;
 
 //@FindBy(xpath="//html//body//main//div//div[2]//div[2]//form//div[5]//button[2]")
 @FindBy(xpath="//form[@id=\"ContentDiv\"]/div[5]/button[2]")
 private WebElement activateButton;
 
 
 




/************Getters Usage******************/
	
	
	public WebElement getClickContactDetails() {
	return clickContactDetails;
}



public WebElement getPhoneTypeDropdown() {
	return phoneTypeDropdown;
}



public WebElement getPickPhoneTypeAsHome() {
	return pickPhoneTypeAsHome;
}



public WebElement getPickPhoneTypeAsMobile() {
	return pickPhoneTypeAsMobile;
}



public WebElement getPhoneTypeBlankErrMessage() {
	return phoneTypeBlankErrMessage;
}



public WebElement getCountryCodeDropdown() {
	return countryCodeDropdown;
}



public WebElement getPickCountryCodeAsIndia() {
	return pickCountryCodeAsIndia;
}



public WebElement getCountryCodeBlankErrorMessage() {
	return countryCodeBlankErrorMessage;
}



public WebElement getNumberEditbox() {
	return numberEditbox;
}



public WebElement getNumberEditboxLength() {
	return numberEditboxLength;
}



public WebElement getContactNumberBlankErrMessage() {
	return contactNumberBlankErrMessage;
}



public WebElement getSubmitButton() {
	return submitButton;
}



public WebElement getClickCurrentAddressPencilIcon() {
	return clickCurrentAddressPencilIcon;
}



public WebElement getEffectiveFromDateCalenderWin() {
	return effectiveFromDateCalenderWin;
}



public WebElement getCurrentDate() {
	return currentDate;
}



public WebElement getEffectiveFromDateBlankErrMessage() {
	return EffectiveFromDateBlankErrMessage;
}



public WebElement getAddressLine1() {
	return addressLine1;
}



public WebElement getAddressLine1Length() {
	return addressLine1Length;
}



public WebElement getAddressLine1BlankErrMessage() {
	return addressLine1BlankErrMessage;
}



public WebElement getCountryDropdownOnAddressDetailsWin() {
	return countryDropdownOnAddressDetailsWin;
}



public List<WebElement> getCountryDropdownValues() {
	return countryDropdownValues;
}



public WebElement getPickCountryIndiaOnAddressDetailsWin() {
	return pickCountryIndiaOnAddressDetailsWin;
}



public WebElement getCountryBlankErrorMessage() {
	return countryBlankErrorMessage;
}



public WebElement getStateDropdownOnAddressDetailsWin() {
	return stateDropdownOnAddressDetailsWin;
}



public List<WebElement> getStateDropdownValues() {
	return stateDropdownValues;
}



public WebElement getPickState() {
	return pickState;
}



public WebElement getCityEditbox() {
	return cityEditbox;
}



public WebElement getPickCity() {
	return pickCity;
}



public WebElement getCityBlankErrorMessage() {
	return cityBlankErrorMessage;
}



public WebElement getPostalCode() {
	return postalCode;
}



public WebElement getPostalCodeLength() {
	return postalCodeLength;
}



public WebElement getPostalCodeEditboxBlankErrMessage() {
	return postalCodeEditboxBlankErrMessage;
}



public WebElement getCopyCurrentAddressAsPermanentAddress() {
	return copyCurrentAddressAsPermanentAddress;
}



public WebElement getUploadButton() {
	return uploadButton;
}



public WebElement getUploadBlankErrorMessage() {
	return uploadBlankErrorMessage;
}



public WebElement getEmailDetailsAddIcon() {
	return emailDetailsAddIcon;
}



public WebElement getEmailTypeDropdown() {
	return emailTypeDropdown;
}



public WebElement getPickPersonalEmail() {
	return pickPersonalEmail;
}



public WebElement getPickEmergencyEmail() {
	return pickEmergencyEmail;
}



public WebElement getEmailTypeBlankErrorMessage() {
	return emailTypeBlankErrorMessage;
}



public WebElement getEmailIdEditbox() {
	return emailIdEditbox;
}



public WebElement getEmailIdEditboxLength() {
	return emailIdEditboxLength;
}



public WebElement getEmailIdBlankErrorMessage() {
	return emailIdBlankErrorMessage;
}



public WebElement getStatutoryNumbersAddIcon() {
	return statutoryNumbersAddIcon;
}



public WebElement getStatutoryTypeDropdown() {
	return statutoryTypeDropdown;
}



public List<WebElement> getStatutoryTypeDropdownValues() {
	return statutoryTypeDropdownValues;
}



public WebElement getPickAadharStatutoryType() {
	return pickAadharStatutoryType;
}



public WebElement getPickPANStatutoryType() {
	return pickPANStatutoryType;
}



public WebElement getPickDrivingLincenceStatutoryType() {
	return pickDrivingLincenceStatutoryType;
}



public WebElement getStatutoryTypeBlankErrorMessage() {
	return statutoryTypeBlankErrorMessage;
}



public WebElement getStatutoryValueEditbox() {
	return statutoryValueEditbox;
}



public WebElement getStatutoryValueEditboxLength() {
	return statutoryValueEditboxLength;
}



public WebElement getStatutoryValueBlankErrMessage() {
	return statutoryValueBlankErrMessage;
}
public WebElement getStatutoryDetailsSubmitButton() {
return statutoryDetailsSubmitButton;
}
public WebElement getHealthDetailsAddIcon() {
	return healthDetailsAddIcon;
}



public WebElement getHeightEditbox() {
	return heightEditbox;
}



public WebElement getHeightEditboxLength() {
	return heightEditboxLength;
}



public WebElement getHeightEditboxBlankErrorMessage() {
	return heightEditboxBlankErrorMessage;
}



public WebElement getWeightEditbox() {
	return weightEditbox;
}



public WebElement getWeightEditboxLength() {
	return weightEditboxLength;
}



public WebElement getWeightEditboxBlankErrorMessage() {
	return weightEditboxBlankErrorMessage;
}



public WebElement getBloodGroupDropdown() {
	return bloodGroupDropdown;
}



public List<WebElement> getBloodGroupDropdownvalues() {
	return bloodGroupDropdownvalues;
}



public WebElement getPickBloodGroup() {
	return pickBloodGroup;
}



public WebElement getBloodGroupBlankErrMessage() {
	return bloodGroupBlankErrMessage;
}



public WebElement getDifferentlyAbledSwitchButton() {
	return differentlyAbledSwitchButton;
}



public WebElement getDifferentlyAbledTypeDropdown() {
	return differentlyAbledTypeDropdown;
}



public List<WebElement> getDifferentlyAbledTypeDropdownValues() {
	return differentlyAbledTypeDropdownValues;
}



public WebElement getPickDifferentlyAbledType() {
	return pickDifferentlyAbledType;
}



public WebElement getDifferentlyAbledTypeDropdownBlankErrMessage() {
	return differentlyAbledTypeDropdownBlankErrMessage;
}



public WebElement getDifferentlyAbledPercentageDropdown() {
	return differentlyAbledPercentageDropdown;
}



public WebElement getPickDifferentlyAbledPercentage() {
	return pickDifferentlyAbledPercentage;
}



public WebElement getDifferentlyAbledPercentageDropdownBlankErrMessage() {
	return differentlyAbledPercentageDropdownBlankErrMessage;
}



public WebElement getPtExemptionDropdown() {
	return ptExemptionDropdown;
}



public WebElement getPickPTExemptionDropdownvalue() {
	return pickPTExemptionDropdownvalue;
}



public WebElement getPtExemptionBlankErrMessage() {
	return ptExemptionBlankErrMessage;
}
public WebElement getUploadAppointmentLetterButton() {
	return uploadAppointmentLetterButton;
}



public WebElement getFileUploadButton() {
	return fileUpload;
}



public WebElement getDeleteIcon() {
	return deleteIcon;
}
public WebElement getFileUpload() {
	return fileUpload;
}



public WebElement getActivateButton() {
	return activateButton;
}

/***************************Utilization ***********************************/

 public void uploadAppointmentLetter() throws AWTException, InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
	 js.executeScript("arguments[0].click();", uploadAppointmentLetterButton);
	 Thread.sleep(2000);
	 StringSelection path= new StringSelection("C:\\Users\\Prod\\Desktop\\Doc1.pdf");
		//pass the driver control to system
		Toolkit t= Toolkit.getDefaultToolkit();
		//pass the driver control to mouse
		 Clipboard c=t.getSystemClipboard();
		//Copy the path into mouse clipboard
		 c.setContents(path, null);
		 //Declare the Robot class
		 Robot rob= new Robot();
		 //Press control + V
		 rob.keyPress(KeyEvent.VK_CONTROL);
		 rob.keyPress(KeyEvent.VK_V);
		 //Release control+V
		 rob.keyRelease(KeyEvent.VK_CONTROL);
		 rob.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 //press enter
		 rob.keyPress(KeyEvent.VK_ENTER);
		 //Release Enter
		 rob.keyRelease(KeyEvent.VK_ENTER);	
 }
    public void clickAnduploadDocument() throws AWTException, InterruptedException {
	 JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
	 js.executeScript("arguments[0].click();", uploadButton);
	 Thread.sleep(2000);
	 StringSelection path= new StringSelection("C:\\Users\\Prod\\Desktop\\Doc1.pdf");
		//pass the driver control to system
		Toolkit t= Toolkit.getDefaultToolkit();
		//pass the driver control to mouse
		 Clipboard c=t.getSystemClipboard();
		//Copy the path into mouse clipboard
		 c.setContents(path, null);
		 //Declare the Robot class
		 Robot rob= new Robot();
		 //Press control + V
		 rob.keyPress(KeyEvent.VK_CONTROL);
		 rob.keyPress(KeyEvent.VK_V);
		 //Release control+V
		 rob.keyRelease(KeyEvent.VK_CONTROL);
		 rob.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2000);
		 //press enter
		 rob.keyPress(KeyEvent.VK_ENTER);
		 //Release Enter
		 rob.keyRelease(KeyEvent.VK_ENTER);	
 }
 //Method to pick UAN number
 public void pickUANStatutoryType()
 {
	 for(int i=0; i<statutoryTypeDropdownValues.size(); i++)
	 {
		 if(statutoryTypeDropdownValues.get(i).getText().equalsIgnoreCase("UAN Number")) {
			 statutoryTypeDropdownValues.get(i).click();
		 }
	 }
 }
 //Method to pick PAN number
 public void pickPANStatustoryType()
 {
	for(int i=0; i<statutoryTypeDropdownValues.size(); i++)
	{
		if(statutoryTypeDropdownValues.get(i).getText().equalsIgnoreCase("PAN Number")) {
			statutoryTypeDropdownValues.get(i).click();
			
		}
	}
 }
 //Method to scrolldown the page
 public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor)BaseClass.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
//Method to stop the page load
 public void stopPageLoad() {
	 BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		 * js.executeScript("return window.stop");
		 */
 }
//Method to handle alert windoow
	 public void handleAlert() {
		
		Alert alt= BaseClass.driver.switchTo().alert();
		alt.accept();
		
	 }
}
