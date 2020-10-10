package esp.objectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class HireSummaryPage {
	/************* Initialization *****************/
	@FindBy(id = "PageName_2304")
	private WebElement hireSummaryPageTitle;
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/legend/a")
	private WebElement clickPersonalData;
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/p/a/i")
	private WebElement clickContactDetails;
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[6]/div/p/span/span")
	private WebElement submittedMobileNumber;

	@FindBy(xpath="//div[@id='div_Phone_Type']/div/input")
	private WebElement phoneTypeDropdown;
	@FindBy(xpath = "//div[@id='div_Phone_Type']/div/ul/li[2]")
	private WebElement pickPhoneTypeAsHome;
	@FindBy(xpath = "//div[@id='div_Phone_Type']/div/ul/li[2]")
	private WebElement pickPhoneTypeAsMobile;
	@FindBy(id = "Error_Phone_Type")
	private WebElement phoneTypeBlankErrMessage;

	@FindBy(id = "div_Country_Code")
	private WebElement countryCodeDropdown;
	// @FindBy(id="//div[@id='div_Country_Code']/div/ul/li[2]/span")
	@FindBy(xpath = "//span[text()='India +91']")
	private WebElement pickCountryCodeAsIndia;
	@FindBy(id = "Error_Country_Code")
	private WebElement countryCodeBlankErrorMessage;

	@FindBy(id = "Contact_Number")
	private WebElement numberEditbox;
	@FindBy(xpath = "//div[@id='div_Contact_Number']/span")
	private WebElement numberEditboxLength;
	@FindBy(id = "Error_Contact_Number")
	private WebElement contactNumberBlankErrMessage;

	@FindBy(id = "Submit")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div/div/div/fieldset/div/div/div[7]/div[1]/p/a")
	private WebElement clickCurrentAddressPencilIcon;
	@FindBy(id = "div_Effective_FromDate")
	private WebElement effectiveFromDateCalenderWin;
	@FindBy(css = ".is-today")
	private WebElement currentDate;
	@FindBy(id = "Error_Effective_FromDate")
	private WebElement EffectiveFromDateBlankErrMessage;

	@FindBy(id = "Address_Line1")
	private WebElement addressLine1;
	@FindBy(xpath = "//div[@id='div_Address_Line1']/span")
	private WebElement addressLine1Length;
	@FindBy(id = "Error_Address_Line1")
	private WebElement addressLine1BlankErrMessage;
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div/div/div/fieldset/div/div/div[7]/div[1]/p[2]/span")
	private WebElement captureSubmittedCurrentAddress;

	@FindBy(id = "div_Country_Name")
	private WebElement countryDropdownOnAddressDetailsWin;
	@FindBy(xpath = "//div[@id='div_Country_Name']/div/ul/li")
	private List<WebElement> countryDropdownValues;
	@FindBy(xpath = "//div[@id='div_Country_Name']/div/ul/li[2]")
	private WebElement pickCountryIndiaOnAddressDetailsWin;
	@FindBy(id = "Error_Country_Name")
	private WebElement countryBlankErrorMessage;

	@FindBy(id = "div_State")
	private WebElement stateDropdownOnAddressDetailsWin;
	@FindBy(xpath = "//div[@id='div_State']/div/ul/li")
	private List<WebElement> stateDropdownValues;
	@FindBy(xpath = "//div[@id='div_State']/div/ul/li[3]")
	private WebElement pickState;

	@FindBy(id = "City")
	private WebElement cityEditbox;
	@FindBy(xpath = "//div[@id='div_City']/ul/li[2]")
	private WebElement pickCity;
	@FindBy(id = "Error_City")
	private WebElement cityBlankErrorMessage;

	@FindBy(id = "Postal_Code")
	private WebElement postalCode;
	@FindBy(xpath = "//div[@id='div_Postal_Code']/span")
	private WebElement postalCodeLength;
	@FindBy(id = "Error_Postal_Code")
	private WebElement postalCodeEditboxBlankErrMessage;

	@FindBy(xpath = "//div[@id='div_Copy_Address']/div/p/label/span")
	private WebElement copyCurrentAddressAsPermanentAddress;

	@FindBy(css = "#Item_Doc")
	private WebElement uploadButton;
	@FindBy(id = "Error_Item_Doc")
	private WebElement uploadBlankErrorMessage;

	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[8]/div/p/a/i")
	private WebElement emailDetailsAddIcon;

	@FindBy(xpath="//div[@id='div_Email_Type']/div/input")
	private WebElement emailTypeDropdown;
	@FindBy(xpath = "//div[@id='div_Email_Type']/div/ul/li[2]")
	private WebElement pickPersonalEmail;
	@FindBy(xpath = "//div[@id='div_Email_Type']/div/ul/li[2]")
	private WebElement pickEmergencyEmail;
	@FindBy(id = "Error_Email_Type")
	private WebElement emailTypeBlankErrorMessage;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[8]/div/div/p/span/span")
	private WebElement submittedPersonalEmail;

	@FindBy(id = "Email_ID")
	private WebElement emailIdEditbox;
	@FindBy(xpath = "//div[@id='div_Email_ID']/span")
	private WebElement emailIdEditboxLength;
	@FindBy(id = "Error_Email_ID")
	private WebElement emailIdBlankErrorMessage;
	
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[9]/div/p/a/i")
	private WebElement clickEmergencyPencilIcon;
	@FindBy(id="Contact_Name")
	private WebElement emergencyContactName;
	@FindBy(id="div_EmrgContact_Relation")
	private WebElement emergencyContactRelationDropdown;
	@FindBy(id="Contact_Phone")
	private WebElement emergencyContactNumber;
	@FindBy(id="Contact_Email")
	private WebElement emergencyContactEmail;
	@FindBy(xpath="//div[@id='div_EmrgContact_Relation']/div/ul/li[3]")
	private WebElement pickContactRelationPersonName;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[9]/div/div/p/span/span")
	private WebElement submittedEmergencyContactDetails;
	
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[10]/div/p/a/i")
	private WebElement clickBankDetailsPencilIcon;
	@FindBy(id="IFSC")
	private WebElement ifscCode;
	@FindBy(xpath="//div[@id='PopUpForm']/form/div/div/div/div/div/ul/li[2]")
	private WebElement pickIfscCode;
	@FindBy(id="Employee_Name")
	private WebElement empNameOnBankAcc;
	@FindBy(id="Account_Number")
	private WebElement accountNumber;
	@FindBy(id="Confirm_Account_Number")
	private WebElement confirmAccountNumber;
	@FindBy(id="div_Account_Type")
	private WebElement accountTypeDropdown;
	@FindBy(xpath="//div[@id='div_Account_Type']/div/ul/li[2]/span")
	private WebElement pickSavingsAccount;
	@FindBy(id="div_Date")
	private WebElement effectiveDateOnBankPage;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[10]/div/p[2]")
	private WebElement submittedBankDetails;

	// @FindBy(xpath="//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[10]/td[1]/a/i")
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[11]/div/p/a/i")
	private WebElement statutoryNumbersAddIcon;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[11]/div/div/p/span/span")
	private WebElement submittedAadhaar;
	@FindBy(id = "div_Statutory_Type")
	private WebElement statutoryTypeDropdown;
	@FindBy(xpath = "//div[@id='div_Statutory_Type']/div/ul/li")
	private List<WebElement> statutoryTypeDropdownValues;
	@FindBy(xpath = "//div[@id='div_Statutory_Type']/div/ul/li[2]")
	private WebElement pickAadharStatutoryType;
	@FindBy(xpath = "//div[@id='div_Statutory_Type']/div/ul/li[8]")
	private WebElement pickPANStatutoryType;
	@FindBy(xpath = "//div[@id='div_Statutory_Type']/div/ul/li[4]")
	private WebElement pickDrivingLincenceStatutoryType;
	@FindBy(id = "SaveC")
	private WebElement statutoryDetailsSubmitButton;
	@FindBy(id = "Error_Statutory_Type")
	private WebElement statutoryTypeBlankErrorMessage;

	@FindBy(id = "Statutory_Value")
	private WebElement statutoryValueEditbox;
	@FindBy(xpath = "//div[@id='div_Statutory_Value']/span")
	private WebElement statutoryValueEditboxLength;
	@FindBy(id = "Error_Statutory_Value")
	private WebElement statutoryValueBlankErrMessage;
	
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[12]/div/p/a/i")
	private WebElement familyDetailsAddIcon;
	@FindBy(id="div_Dependent_Title")
	private WebElement dependentTitle;
	@FindBy(xpath="//div[@id='div_Dependent_Title']/div/ul/li[2]")
	private WebElement pickDependentTitle;
	@FindBy(id="Emp_FirstName")
	private WebElement dependentFirstName;
	@FindBy(id="Last_Name")
	private WebElement dependentLastName;
	@FindBy(id="Radio_M")
	private WebElement dependentGender;
	@FindBy(id="DOB")
	private WebElement dependentDOB;
	@FindBy(id="div_Relation_Type")
	private WebElement dependentRelation;
	@FindBy(xpath="//div[@id='div_Relation_Type']/div/ul/li[2]")
	private WebElement pickDependentRelation;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[12]/div/div/p/span/span")
	private WebElement submittedDependent;
	
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[5]/div/p/a/i")
	private WebElement additionalInfoAdd;
	@FindBy(xpath="//div[@id='div_AdditionalInfo_Type']/div/input")
	private WebElement additionalInfoDropdown;
	@FindBy(xpath="//div[@id='div_AdditionalInfo_Type']/div/ul/li[2]")
	private WebElement pickAdditionalInfoType;
	@FindBy(id="EffectiveFrom_Date")
	private WebElement additionalInfoEffectiveFromDate;
	@FindBy(id="SaveC")
	private WebElement additionalInfoSubmitButton;
	@FindBy(id="AdditionalInfo_Value")
	private WebElement additionalInfoValue;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[5]/div/div[1]/p/span")
	private WebElement submittedShiftIndicator;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[5]/div/div[2]/p/span")
	private WebElement submittedBadgeId;
	
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[13]/div/p/a/i")
	private WebElement educationDetailsAdd;
	@FindBy(xpath="//div[@id='div_Qualifications']/div/input")
	private WebElement qualificationDropdown;
	@FindBy(xpath="//div[@id='div_Qualifications']/div[1]/ul/li[4]/span")
	private WebElement selectQualification;
	@FindBy(id="div_Degree")
	private WebElement degreeDropdown;
	@FindBy(xpath="//div[@id='div_Degree']/div[1]/ul/li[4]")
	private WebElement selectDegree;
	@FindBy(id="div_Specializations")
	private WebElement specializationDropdown;
	@FindBy(xpath="//div[@id='div_Specializations']/div[1]/ul/li[2]")
	private WebElement selectSpecialization;
	@FindBy(id="div_Universities")
	private WebElement university;
	@FindBy(xpath="//div[@id='div_Universities']/div/ul/li[3]")
	private WebElement pickUniversity;
	@FindBy(id="div_Month_Names")
	private WebElement monthCompletionDropdown;
	@FindBy(xpath="//div[@id='div_Month_Names']/div/ul/li[2]")
	private WebElement pickMonth;
	@FindBy(id="Marks")
	private WebElement marks_percentage_gradeEditbox;
	@FindBy(id="div_Course_Type")
	private WebElement courseTypeDropdown;
	@FindBy(xpath="//div[@id='div_Course_Type']/div/ul/li[4]")
	private WebElement pickCourseType;
	@FindBy(id="div_Location_Name")
	private WebElement universityLocationDropdown;
	@FindBy(xpath="//div[@id='div_Location_Name']/div/ul/li[2]")
	private WebElement selectUniversityLocation;
	@FindBy(id="Radio_P")
	private WebElement marksTypePercentage;
	@FindBy(id="Year_of_Completion")
	private WebElement yearOfCompletion;
	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[13]/div/div/p/span")
	private WebElement submittedEducation;
	

	@FindBy(xpath="//div[@id='HireDetailsDiv']/div[1]/div/div/fieldset/div/div/div[14]/div/p/a/i")
	private WebElement passportDetailsAdd;
	
    @FindBy(xpath="//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[3]/div/p[1]/a/i")
    private WebElement modifyOfficialEmail;
    @FindBy(id="Email_ID")
    private WebElement officialEmailEditbox;
    @FindBy(xpath="//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[3]/div/p[2]")
    private WebElement submittedOfficialEmail;

	

	@FindBy(xpath = "//form[@id='ContentDiv']/div[1]/div/table/tbody/tr[15]/td[1]/a/i")
	private WebElement healthDetailsAddIcon;

	@FindBy(id = "Emp_Height")
	private WebElement heightEditbox;
	@FindBy(xpath = "//div[@id='div_Emp_Height']/span")
	private WebElement heightEditboxLength;
	@FindBy(id = "Error_Emp_Height")
	private WebElement heightEditboxBlankErrorMessage;

	@FindBy(id = "Emp_Weight")
	private WebElement weightEditbox;
	@FindBy(xpath = "//div[@id='div_Emp_Weight']/span")
	private WebElement weightEditboxLength;
	@FindBy(id = "Error_Emp_Weight_Invalid")
	private WebElement weightEditboxBlankErrorMessage;

	@FindBy(id = "div_Blood_Group")
	private WebElement bloodGroupDropdown;
	@FindBy(xpath = "//div[@id='div_Blood_Group']/div/ul/li")
	private List<WebElement> bloodGroupDropdownvalues;
	@FindBy(xpath = "//div[@id='div_Blood_Group']/div/ul/li[2]")
	private WebElement pickBloodGroup;
	@FindBy(id = "Error_Blood_Group")
	private WebElement bloodGroupBlankErrMessage;

	@FindBy(xpath = "//div[@id='div_Differently_Abled']/div/p/label/span")
	private WebElement differentlyAbledSwitchButton;
	@FindBy(id = "div_Diff_Abled_Type")
	private WebElement differentlyAbledTypeDropdown;
	@FindBy(xpath = "//div[@id='div_Diff_Abled_Type']/div/ul/li")
	private List<WebElement> differentlyAbledTypeDropdownValues;
	@FindBy(xpath = "//div[@id='div_Diff_Abled_Type']/div/ul/li[2]")
	private WebElement pickDifferentlyAbledType;
	@FindBy(id = "Error_Diff_Abled_Type")
	private WebElement differentlyAbledTypeDropdownBlankErrMessage;

	@FindBy(id = "div_Diff_Abled_Perce")
	private WebElement differentlyAbledPercentageDropdown;
	@FindBy(xpath = "//div[@id='div_Diff_Abled_Perce']/div/ul/li[2]")
	private WebElement pickDifferentlyAbledPercentage;
	@FindBy(id = "Error_Diff_Abled_Perce")
	private WebElement differentlyAbledPercentageDropdownBlankErrMessage;

	@FindBy(id = "div_PT_Exemption")
	private WebElement ptExemptionDropdown;
	@FindBy(xpath = "//div[@id='div_PT_Exemption']/div/ul/li[2]")
	private WebElement pickPTExemptionDropdownvalue;
	@FindBy(id = "Error_PT_Exemption")
	private WebElement ptExemptionBlankErrMessage;

	@FindBy(xpath = "//div[@id='showGroups']/div[3]/div[4]/div/div/div/fieldset/div[1]/input")
	private WebElement uploadAppointmentLetterButton;
	@FindBy(id = "f_upload")
	private WebElement fileUpload;
	@FindBy(xpath="//a[text()='Appointment Letter']")
	private WebElement submittedAppointmentLetter;

	@FindBy(xpath = "//form[@id='ContentDiv']/div[5]/button")
	private WebElement deleteIcon;

	// @FindBy(xpath="//html//body//main//div//div[2]//div[2]//form//div[5]//button[2]")
	@FindBy(xpath = "//form[@id=\"ContentDiv\"]/div[5]/button[2]")
	private WebElement activateButton;

	@FindBy(xpath = "//div[@id='HireDetailsDiv']/../div[3]/div[2]/div/div/fieldset/div/div[4]/div/p[1]/i")
	private WebElement clickCompensationPencilIcon;
	@FindBy(xpath = "//div[@id='HireDetailsDiv']/div[2]/div/div/fieldset/div/div[4]/div/p[2]")
	private WebElement checkCompensationValue;

	/************ Getters Usage ******************/
	public WebElement getCheckCompensationValue() {
		return checkCompensationValue;
	}

	public WebElement getClickCompensationPencilIcon() {
		return clickCompensationPencilIcon;
	}

	public WebElement gethireSummaryPageTitle() {
		return hireSummaryPageTitle;
	}

	public WebElement getclickPersonalData() {
		return clickPersonalData;
	}

	public WebElement getClickContactDetails() {
		return clickContactDetails;
	}

	public WebElement getSubmittedMobileNumber() {
		return submittedMobileNumber;
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

	public WebElement getCaptureSubmittedCurrentAddress() {
		return captureSubmittedCurrentAddress;
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
	public WebElement getSubmittedEmergencyContactDetails() {
		return submittedEmergencyContactDetails;
	}

	public WebElement getEmailIdEditboxLength() {
		return emailIdEditboxLength;
	}
	public WebElement getSubmittedPersonalEmail() {
		return submittedPersonalEmail;
	}

	public WebElement getEmailIdBlankErrorMessage() {
		return emailIdBlankErrorMessage;
	}
    public WebElement getClickEmergencyPencilIcon() {
	   return clickEmergencyPencilIcon;
    }
    public WebElement getClickBankDetailsPencilIcon() {
		return clickBankDetailsPencilIcon;
	}

	public WebElement getIfscCode() {
		return ifscCode;
	}
	public WebElement getPickIfscCode() {
		return pickIfscCode;
	}

	public WebElement getEmpNameOnBankAcc() {
		return empNameOnBankAcc;
	}

	public WebElement getAccountNumber() {
		return accountNumber;
	}

	public WebElement getConfirmAccountNumber() {
		return confirmAccountNumber;
	}

	public WebElement getAccountTypeDropdown() {
		return accountTypeDropdown;
	}

	public WebElement getPickSavingsAccount() {
		return pickSavingsAccount;
	}
	public WebElement getSubmittedBankDetails() {
		return submittedBankDetails;
	}

	public WebElement getEffectiveDateOnBankPage() {
		return effectiveDateOnBankPage;
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
	public WebElement getHireSummaryPageTitle() {
		return hireSummaryPageTitle;
	}

	public WebElement getClickPersonalData() {
		return clickPersonalData;
	}

	public WebElement getEmergencyContactName() {
		return emergencyContactName;
	}

	public WebElement getEmergencyContactRelationDropdown() {
		return emergencyContactRelationDropdown;
	}

	public WebElement getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public WebElement getEmergencyContactEmail() {
		return emergencyContactEmail;
	}

	public WebElement getPickContactRelationPersonName() {
		return pickContactRelationPersonName;
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
	public WebElement getSubmittedAadhaar() {
		return submittedAadhaar;
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
	public WebElement getFamilyDetailsAddIcon() {
		return familyDetailsAddIcon;
	}

	public WebElement getDependentTitle() {
		return dependentTitle;
	}

	public WebElement getPickDependentTitle() {
		return pickDependentTitle;
	}

	public WebElement getDependentFirstName() {
		return dependentFirstName;
	}

	public WebElement getDependentLastName() {
		return dependentLastName;
	}

	public WebElement getDependentGender() {
		return dependentGender;
	}

	public WebElement getDependentDOB() {
		return dependentDOB;
	}

	public WebElement getDependentRelation() {
		return dependentRelation;
	}
	public WebElement getPickDependentRelation() {
		return pickDependentRelation;
	}
	public WebElement getSubmittedDependent() {
		return submittedDependent;
	}
	public WebElement getModifyOfficialEmail() {
		return modifyOfficialEmail;
	}

	public WebElement getOfficialEmailEditbox() {
		return officialEmailEditbox;
	}

	public WebElement getSubmittedOfficialEmail() {
		return submittedOfficialEmail;
	}
	public WebElement getEducationDetailsAdd() {
		return educationDetailsAdd;
	}

	public WebElement getQualificationDropdown() {
		return qualificationDropdown;
	}

	public WebElement getSelectQualification() {
		return selectQualification;
	}

	public WebElement getDegreeDropdown() {
		return degreeDropdown;
	}

	public WebElement getSelectDegree() {
		return selectDegree;
	}

	public WebElement getSpecializationDropdown() {
		return specializationDropdown;
	}

	public WebElement getSelectSpecialization() {
		return selectSpecialization;
	}

	public WebElement getUniversity() {
		return university;
	}

	public WebElement getPickUniversity() {
		return pickUniversity;
	}

	public WebElement getMonthCompletionDropdown() {
		return monthCompletionDropdown;
	}

	public WebElement getPickMonth() {
		return pickMonth;
	}

	public WebElement getCourseTypeDropdown() {
		return courseTypeDropdown;
	}

	public WebElement getPickCourseType() {
		return pickCourseType;
	}

	public WebElement getPassportDetailsAdd() {
		return passportDetailsAdd;
	}
	public WebElement getUniversityLocationDropdown() {
		return universityLocationDropdown;
	}

	public WebElement getSelectUniversityLocation() {
		return selectUniversityLocation;
	}
	public WebElement getMarksTypePercentage() {
		return marksTypePercentage;
	}
	public WebElement getYearOfCompletion() {
		return yearOfCompletion;
	}
	public WebElement getSubmittedEducation() {
		return submittedEducation;
	}
	public WebElement getAdditionalInfoSubmitButton() {
		return additionalInfoSubmitButton;
	}
	public WebElement getAdditionalInfoAdd() {
		return additionalInfoAdd;
	}
	public WebElement getMarks_percentage_gradeEditbox() {
		return marks_percentage_gradeEditbox;
	}


	public WebElement getAdditionalInfoEffectiveFromDate() {
		return additionalInfoEffectiveFromDate;
	}
	public WebElement getAdditionalInfoDropdown() {
		return additionalInfoDropdown;
	}

	public WebElement getPickAdditionalInfoType() {
		return pickAdditionalInfoType;
	}
	public WebElement getAdditionalInfoValue() {
		return additionalInfoValue;
	}
	public WebElement getSubmittedAppointmentLetter() {
		return submittedAppointmentLetter;
	}
	public WebElement getSubmittedShiftIndicator() {
		return submittedShiftIndicator;
	}
	public WebElement getSubmittedBadgeId() {
		return submittedBadgeId;
	}

	/*************************** Utilization ***********************************/

	public void uploadAppointmentLetter() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].click();", uploadAppointmentLetterButton);
		Thread.sleep(2000);
		StringSelection path = new StringSelection("C:\\Users\\Prod\\Desktop\\Doc1.pdf");
		// pass the driver control to system
		Toolkit t = Toolkit.getDefaultToolkit();
		// pass the driver control to mouse
		Clipboard c = t.getSystemClipboard();
		// Copy the path into mouse clipboard
		c.setContents(path, null);
		// Declare the Robot class
		Robot rob = new Robot();
		// Press control + V
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		// Release control+V
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		// press enter
		rob.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		rob.keyRelease(KeyEvent.VK_ENTER);
	}

	public void clickAnduploadDocument() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].click();", uploadButton);
		Thread.sleep(2000);
		StringSelection path = new StringSelection("C:\\Users\\Prod\\Desktop\\Doc1.pdf");
		// pass the driver control to system
		Toolkit t = Toolkit.getDefaultToolkit();
		// pass the driver control to mouse
		Clipboard c = t.getSystemClipboard();
		// Copy the path into mouse clipboard
		c.setContents(path, null);
		// Declare the Robot class
		Robot rob = new Robot();
		// Press control + V
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		// Release control+V
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		// press enter
		rob.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		rob.keyRelease(KeyEvent.VK_ENTER);
	}

	// Method to pick UAN number
	public void pickUANStatutoryType() {
		for (int i = 0; i < statutoryTypeDropdownValues.size(); i++) {
			if (statutoryTypeDropdownValues.get(i).getText().equalsIgnoreCase("UAN Number")) {
				statutoryTypeDropdownValues.get(i).click();
			}
		}
	}

	// Method to pick PAN number
	public void pickPANStatustoryType() {
		for (int i = 0; i < statutoryTypeDropdownValues.size(); i++) {
			if (statutoryTypeDropdownValues.get(i).getText().equalsIgnoreCase("PAN Number")) {
				statutoryTypeDropdownValues.get(i).click();

			}
		}
	}

	// Method to scrolldown the page
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;
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
	//Method to click dob
	public void DatePicker(WebDriver driver, WebElement element, Date date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',' " + date + "');", element);
	}

//Method to handle alert windoow
	public void handleAlert() {

		Alert alt = BaseClass.driver.switchTo().alert();
		alt.accept();

	}

	// Method to move from one pages to another page
	public String moveTopage() {
		Set<String> sessionIds = BaseClass.driver.getWindowHandles();
		Iterator<String> it = sessionIds.iterator();
		String pWin = it.next();
		String cWin = it.next();
		return cWin;
	}
	//Method to click using java script
	public void clickElement(WebElement element) {
	    JavascriptExecutor executor = (JavascriptExecutor)BaseClass.driver;
	    executor.executeScript("arguments[0].click();", element);
	}
}
