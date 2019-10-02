package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewHirePage 
{

	/*********************Initialization***********************************/
	@FindBy(xpath="//div[@id='div_Emp_Title']/div/input")
	private WebElement titleDropdown;
	@FindBy(xpath="//div[@id='div_Emp_Title']/div/ul/li")
	private List<WebElement> titleDropdownValues;
	@FindBy(xpath="//div[@id='div_Emp_Title']/div/ul/li[2]")
	private WebElement pickTitle_MR;
	@FindBy(id="Error_Emp_Title")
	private WebElement titleBlankErrMessage;
	
    @FindBy(id="Emp_FirstName")
    private WebElement firstNameEditbox;
    @FindBy(id="Error_Emp_FirstName")
    private WebElement firstNameBlankErrMessage;
    @FindBy(xpath="//div[@id='div_Emp_FirstName']/span")
    private WebElement firstNameEditboxLength;
    
    @FindBy(id="Emp_MiddleInitial")
    private WebElement middleNameEditbox;
    @FindBy(xpath="//div[@id='div_Emp_MiddleInitial']/span")
    private WebElement middleNameEditboxLength;
    
    @FindBy(id="Emp_LastName")
    private WebElement lastNameEditbox;
    @FindBy(xpath="//div[@id='div_Emp_LastName']/span")
    private WebElement lastNameEditboxLength;
    @FindBy(id="Error_Emp_LastName")
    private WebElement lastNameEditboxBlankErrMessage;
    
	@FindBy(id="Emp_DateOfBirth")
	private WebElement dateOfBirthCalenderWindow;
	@FindBy(css=".is-today")
    private WebElement currentDate;
	@FindBy(id="Error_Emp_DateOfBirth")
	private WebElement dobBlankErrMessage;
	
	@FindBy(xpath="//div[@id='div_BirthCountry_Code']/div/input")
	private WebElement CountryOfBirthDropdown;
	@FindBy(xpath="//div[@id='div_BirthCountry_Code']/div/ul/li")
	private List<WebElement> countryOfBirthDropdownValues;
	@FindBy(xpath="//div[@id='div_BirthCountry_Code']/div/ul/li[2]")
	private WebElement pickCountryOfBirthAsIndia;
	@FindBy(id="Error_BirthCountry_Code")
	private WebElement countryOfBirthBlankErrMessage;
	
	@FindBy(xpath="//div[@id='div_BirthState_Code']/div/input")
	private WebElement stateOfBirthDropdown;
	@FindBy(xpath="//div[@id='div_BirthState_Code']/div/ul/li")
	private List<WebElement> stateOfBirthDropdownValues;
	@FindBy(id="Error_BirthState_Code")
	private WebElement StateOfBirthBlankErrMessage;
	
	@FindBy(id="Birth_City")
	private WebElement cityOfBirthEditbox;
	@FindBy(xpath="//div[@id='div_Birth_City']/span")
	private WebElement cityOfBirthEditboxLength;
	@FindBy(id="Error_Birth_City")
	private WebElement cityOfBirthErrBlankMessage;
	
	@FindBy(xpath="//div[@id='div_Nationality']/div/input")
	private WebElement citizenshipDropdown;
	@FindBy(xpath="//div[@id='div_Nationality']/div/ul/li")
	private List<WebElement> citizenshipDropdownValues;
	@FindBy(xpath="//div[@id='div_Nationality']/div/ul/li[2]")
	private WebElement pickCitizenshipAsIndia;
	@FindBy(id="Error_Nationality")
	private WebElement citizenshipBlankErrMessage;
	
	@FindBy(id="Radio_M")
	private WebElement maleRadioButton;
	@FindBy(id="Radio_F")
	private WebElement femaleRadioButton;
	@FindBy(id="Error_Gender")
	private WebElement genderBlankErrMessage;
	
	@FindBy(id="Radio_S")
	private WebElement maritalStatusAsSingle;
	@FindBy(id="Radio_M")
	private WebElement maritalStatusAsMarried;
	@FindBy(id="Error_Marital_Status")
	private WebElement maritalStatusBlankErrorMessage;
	
	@FindBy(xpath="//div[@id='div_Fresher']/div/p/label/span")
	private WebElement fresherSwitchButton;
	@FindBy(id="Past_experience")
	private WebElement relevantExpEditbox;
	@FindBy(xpath="//div[@id='div_Past_experience']/span")
	private WebElement relevantExpEditboxLength;
	@FindBy(id="Error_Past_experience")
	private WebElement relevantExpEditboxBlankErrMessage;
	
	@FindBy(xpath="//div[@id='div_Qualification_Code']/div/input")
	private WebElement EducationDetailsDropdown;
	@FindBy(xpath="//div[@id='div_Qualification_Code']/div/ul/li")
	private List<WebElement> educationDetailsDropdownValues;
	@FindBy(xpath="//div[@id='div_Qualification_Code']/div/ul/li[3]")
	private WebElement pickGraduate;
	@FindBy(id="Error_Qualification_Code")
	private WebElement educationDetailsBlankErrorMessage;
	
	@FindBy(xpath="//div[@id='div_SourceOf_Hire']/div/input")
	private WebElement sourceOfHireDropdown;
	@FindBy(xpath="//div[@id='div_SourceOf_Hire']/div/ul/li")
	private List<WebElement> sourceOfHireDropdownValues;
	@FindBy(xpath="//div[@id='div_SourceOf_Hire']/div/ul/li[2]")
	private WebElement campusRecruitmentSourceOfHire;
	@FindBy(xpath="//div[@id='div_SourceOf_Hire']/div/ul/li[3]")
	private WebElement referalSourceOfHire;
	
	@FindBy(id="div_University_Name")
	private WebElement universityNameDropdown;
	@FindBy(xpath="//div[@id='div_University_Name']/div/ul/li")
	private List<WebElement> universityDropdownValues;
	@FindBy(id="Error_University_Name")
	private WebElement universityBlankErrMessage;
	@FindBy(xpath="//div[@id='div_University_Name']/div/ul/li[2]")
	private WebElement pickUniversity;
	
	@FindBy(id="div_Referal_Search")
	private WebElement referalSearchEditbox;
	@FindBy(xpath="//ul[@id='empsearch_Referal_Search']/li[1]")
	private WebElement pickReferalSearch;
	
	@FindBy(id="div_Country_Code")
	private WebElement countryDropdown;
	@FindBy(xpath="//div[@id='div_Country_Code']/div/ul/li")
	private List<WebElement> countryDropdownValues;
	@FindBy(xpath="//div[@id='div_Country_Code']/div/ul/li[2]")
	private WebElement pickCountryIndia;
	@FindBy(id="Error_Country_Code")
	private WebElement countryBlankErrorMessage;
	
	@FindBy(id="div_LegalEntity_Id")
	private WebElement legalEntityDropdown;
	@FindBy(xpath="//div[@id='div_LegalEntity_Id']/div/ul/li")
	private List<WebElement> legalEntityDropdownValues;
	@FindBy(xpath="//div[@id='div_LegalEntity_Id']/div/ul/li[2]")
	private WebElement pickLegalEntity;
	@FindBy(id="Error_LegalEntity_Id")
	private WebElement legalEntityBlankErrorMessage;
	
	@FindBy(id="div_Location_Code")
	private WebElement locationDropdown;
	@FindBy(xpath="//div[@id='div_Location_Code']/div/ul/li")
	private List<WebElement> locationDropdownValues;
	@FindBy(xpath="//div[@id='div_Location_Code']/div/ul/li[2]")
	private WebElement pickLocation;
	@FindBy(id="Error_Location_Code")
	private WebElement locationBlankErrorMessage;
	
	@FindBy(id="Emp_JoiningDate")
	private WebElement joiningDate;
	@FindBy(id="Error_Emp_JoiningDate")
	private WebElement joiningDateBlankErrorMessage;
	
	@FindBy(id="Emp_Id")
	private WebElement employeeId;
	@FindBy(id="Error_Emp_Id")
	private WebElement employeeIdBlankErrorMessage;
	@FindBy(xpath="//div[@id='div_Emp_Id']/span")
	private WebElement employeeIdEditboxLength;
	
	@FindBy(id="Email")
	private WebElement emailIdEditbox;
	@FindBy(xpath="//div[@id='div_Email']/span")
	private WebElement emailIdEditboxLength;
	@FindBy(id="Error_Email")
	private WebElement emaildIdBlankErrorMessage;
	
	@FindBy(id="div_Employment_Type")
	private WebElement employmentTypeDropdown;
	@FindBy(xpath="//div[@id='div_Employment_Type']/div/ul/li")
	private WebElement employmentTypeDropdownValues;
	@FindBy(xpath="//div[@id='div_Employment_Type']/div/ul[2]")
	private WebElement pickEmploymentType;
	@FindBy(id="Error_Employment_Type")
	private WebElement employmentTypeBlankErrorMessage;
	
	@FindBy(id="div_Employment_Status")
	private WebElement employmentStatusDropdown;
	@FindBy(xpath="//div[@id='div_Employment_Status']/div/ul/li")
	private List<WebElement> employmentStatusDropdownValues;
	@FindBy(xpath="//div[@id='div_Employment_Status']/div/ul/li[2]")
	private WebElement pickEmploymentStatusAsConfirmed;
	@FindBy(xpath="//div[@id='div_Employment_Status']/div/ul/li[3]")
	private WebElement pickEmploymentStatusAsProbation;
	@FindBy(id="Error_Employment_Status")
	private WebElement employmentStatusBlankErrorMessage;
	
	@FindBy(id="ContractEnd_Date")
	private WebElement contractEndDateCalenderWin;
	@FindBy(id="Error_ContractEnd_Date")
	private WebElement contractEndDateBlankErrMessage;
	
	@FindBy(id="OrgUnit_Name")
	private WebElement departmentEditbox;
	@FindBy(xpath="//ul[@id='Dept_Search_OrgUnit_Name']/li[1]/b")
	private WebElement pickDepartment;
	@FindBy(id="Error_OrgUnit_Name")
	private WebElement departmentBlankErrorMessage;
	
	@FindBy(id="Role_Id")
	private WebElement roleEditbox;
	@FindBy(id="Error_Role_Id")
	private WebElement roleEditboxBlankErrorMessage;
	
	@FindBy(id="Designation_Id")
	private WebElement designationEditbox;
	@FindBy(xpath="//ul[@id='Desig_Search_Designation_Id']/li[1]")
	private WebElement pickDesignation;
	@FindBy(id="Error_Designation_Id")
	private WebElement designationBlankErrorMessage;
	
	@FindBy(id="Manager_Id")
	private WebElement reportingHiringManagerEditbox;
	@FindBy(xpath="//ul[@id='Mgr_Search_Manager_Id']/li[2]")
	private WebElement pickReportingHiringManager;
	@FindBy(id="Error_Manager_Id")
	private WebElement reportingHiringManagerBlankErrorMesage;
	
	@FindBy(id="div_Pay_Type")
	private WebElement pickTypeDropdown;
	@FindBy(xpath="//div[@id='div_Pay_Type']/div/ul/li")
	private List<WebElement> pickTypeDropdownValues;
	@FindBy(xpath="//div[@id='div_Pay_Type']/div/ul/li[3]")
	private WebElement pickPayType;
	
	@FindBy(id="div_Pay_Frequency")
	private WebElement payFrequencyDropdown;
	@FindBy(xpath="//div[@id='div_Pay_Frequency']/div/ul/li")
	private List<WebElement> payFrequencyDropdownValues;
	@FindBy(xpath="//div[@id='div_Pay_Frequency']/div/ul/li[5]")
	private WebElement pickPayFrequencyDropdownValue;
	
	@FindBy(id="div_FTPT_Indicator")
	private WebElement ftptIndicatorDropdown;
	@FindBy(xpath="//div[@id='div_FTPT_Indicator']/div/ul/li")
	private List<WebElement> ftptIndicatorDropdownValues;
	@FindBy(xpath="//div[@id='div_FTPT_Indicator']/div/ul/li[3]")
	private WebElement pickPartTimeIndicator;
	@FindBy(xpath="//div[@id='div_FTPT_Indicator']/div/ul/li[2]")
	private WebElement pickFullTimeIndicator;
	@FindBy(id="Error_FTPT_Indicator")
	private WebElement ftptBlankErrorMessage;
	
	@FindBy(id="FTE_Weeklyhours")
	private WebElement fteEditbox;
	@FindBy(id="Error_FTE_Weeklyhours")
	private WebElement fteBlankErrorMessage;
	
	
	/************************Getters Usage********************************/
	
	public WebElement getTitleDropdown() {
		return titleDropdown;
	}
	public List<WebElement> getTitleDropdownValues() {
		return titleDropdownValues;
	}
	public WebElement getPickTitle_MR() {
		return pickTitle_MR;
	}
	public WebElement getTitleBlankErrMessage() {
		return titleBlankErrMessage;
	}
	public WebElement getFirstNameEditbox() {
		return firstNameEditbox;
	}
	public WebElement getFirstNameBlankErrMessage() {
		return firstNameBlankErrMessage;
	}
	public WebElement getFirstNameEditboxLength() {
		return firstNameEditboxLength;
	}
	public WebElement getMiddleNameEditbox() {
		return middleNameEditbox;
	}
	public WebElement getMiddleNameEditboxLength() {
		return middleNameEditboxLength;
	}
	public WebElement getLastNameEditbox() {
		return lastNameEditbox;
	}
	public WebElement getLastNameEditboxLength() {
		return lastNameEditboxLength;
	}
	public WebElement getLastNameEditboxBlankErrMessage() {
		return lastNameEditboxBlankErrMessage;
	}
	public WebElement getDateOfBirthCalenderWindow() {
		return dateOfBirthCalenderWindow;
	}
	public WebElement getCurrentDate() {
		return currentDate;
	}
	public WebElement getDobBlankErrMessage() {
		return dobBlankErrMessage;
	}
	public WebElement getCountryOfBirthDropdown() {
		return CountryOfBirthDropdown;
	}
	public List<WebElement> getCountryOfBirthDropdownValues() {
		return countryOfBirthDropdownValues;
	}
	public WebElement getPickCountryOfBirthAsIndia() {
		return pickCountryOfBirthAsIndia;
	}
	public WebElement getCountryOfBirthBlankErrMessage() {
		return countryOfBirthBlankErrMessage;
	}
	public WebElement getStateOfBirthDropdown() {
		return stateOfBirthDropdown;
	}
	public List<WebElement> getStateOfBirthDropdownValues() {
		return stateOfBirthDropdownValues;
	}
	public WebElement getStateOfBirthBlankErrMessage() {
		return StateOfBirthBlankErrMessage;
	}
	public WebElement getCityOfBirthEditbox() {
		return cityOfBirthEditbox;
	}
	public WebElement getCityOfBirthEditboxLength() {
		return cityOfBirthEditboxLength;
	}
	public WebElement getCityOfBirthErrBlankMessage() {
		return cityOfBirthErrBlankMessage;
	}
	public WebElement getCitizenshipDropdown() {
		return citizenshipDropdown;
	}
	public List<WebElement> getCitizenshipDropdownValues() {
		return citizenshipDropdownValues;
	}
	public WebElement getPickCitizenshipAsIndia() {
		return pickCitizenshipAsIndia;
	}
	public WebElement getCitizenshipBlankErrMessage() {
		return citizenshipBlankErrMessage;
	}
	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}
	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}
	public WebElement getGenderBlankErrMessage() {
		return genderBlankErrMessage;
	}
	public WebElement getMaritalStatusAsSingle() {
		return maritalStatusAsSingle;
	}
	public WebElement getMaritalStatusAsMarried() {
		return maritalStatusAsMarried;
	}
	public WebElement getMaritalStatusBlankErrorMessage() {
		return maritalStatusBlankErrorMessage;
	}
	public WebElement getFresherSwitchButton() {
		return fresherSwitchButton;
	}
	public WebElement getRelevantExpEditbox() {
		return relevantExpEditbox;
	}
	public WebElement getRelevantExpEditboxLength() {
		return relevantExpEditboxLength;
	}
	public WebElement getRelevantExpEditboxBlankErrMessage() {
		return relevantExpEditboxBlankErrMessage;
	}
	public WebElement getEducationDetailsDropdown() {
		return EducationDetailsDropdown;
	}
	public List<WebElement> getEducationDetailsDropdownValues() {
		return educationDetailsDropdownValues;
	}
	public WebElement getPickGraduate() {
		return pickGraduate;
	}
	public WebElement getEducationDetailsBlankErrorMessage() {
		return educationDetailsBlankErrorMessage;
	}
	public WebElement getSourceOfHireDropdown() {
		return sourceOfHireDropdown;
	}
	public List<WebElement> getSourceOfHireDropdownValues() {
		return sourceOfHireDropdownValues;
	}
	public WebElement getCampusRecruitmentSourceOfHire() {
		return campusRecruitmentSourceOfHire;
	}
	public WebElement getReferalSourceOfHire() {
		return referalSourceOfHire;
	}
	public WebElement getUniversityNameDropdown() {
		return universityNameDropdown;
	}
	public List<WebElement> getUniversityDropdownValues() {
		return universityDropdownValues;
	}
	public WebElement getUniversityBlankErrMessage() {
		return universityBlankErrMessage;
	}
	public WebElement getPickUniversity() {
		return pickUniversity;
	}
	public WebElement getReferalSearchEditbox() {
		return referalSearchEditbox;
	}
	public WebElement getPickReferalSearch() {
		return pickReferalSearch;
	}
	public WebElement getCountryDropdown() {
		return countryDropdown;
	}
	public List<WebElement> getCountryDropdownValues() {
		return countryDropdownValues;
	}
	public WebElement getPickCountryIndia() {
		return pickCountryIndia;
	}
	public WebElement getCountryBlankErrorMessage() {
		return countryBlankErrorMessage;
	}
	public WebElement getLegalEntityDropdown() {
		return legalEntityDropdown;
	}
	public List<WebElement> getLegalEntityDropdownValues() {
		return legalEntityDropdownValues;
	}
	public WebElement getPickLegalEntity() {
		return pickLegalEntity;
	}
	public WebElement getLegalEntityBlankErrorMessage() {
		return legalEntityBlankErrorMessage;
	}
	public WebElement getLocationDropdown() {
		return locationDropdown;
	}
	public List<WebElement> getLocationDropdownValues() {
		return locationDropdownValues;
	}
	public WebElement getPickLocation() {
		return pickLocation;
	}
	public WebElement getLocationBlankErrorMessage() {
		return locationBlankErrorMessage;
	}
	public WebElement getJoiningDate() {
		return joiningDate;
	}
	public WebElement getJoiningDateBlankErrorMessage() {
		return joiningDateBlankErrorMessage;
	}
	public WebElement getEmployeeId() {
		return employeeId;
	}
	public WebElement getEmployeeIdBlankErrorMessage() {
		return employeeIdBlankErrorMessage;
	}
	public WebElement getEmployeeIdEditboxLength() {
		return employeeIdEditboxLength;
	}
	public WebElement getEmailIdEditbox() {
		return emailIdEditbox;
	}
	public WebElement getEmailIdEditboxLength() {
		return emailIdEditboxLength;
	}
	public WebElement getEmaildIdBlankErrorMessage() {
		return emaildIdBlankErrorMessage;
	}
	public WebElement getEmploymentTypeDropdown() {
		return employmentTypeDropdown;
	}
	public WebElement getEmploymentTypeDropdownValues() {
		return employmentTypeDropdownValues;
	}
	public WebElement getPickEmploymentType() {
		return pickEmploymentType;
	}
	public WebElement getEmploymentTypeBlankErrorMessage() {
		return employmentTypeBlankErrorMessage;
	}
	public WebElement getEmploymentStatusDropdown() {
		return employmentStatusDropdown;
	}
	public List<WebElement> getEmploymentStatusDropdownValues() {
		return employmentStatusDropdownValues;
	}
	public WebElement getPickEmploymentStatusAsConfirmed() {
		return pickEmploymentStatusAsConfirmed;
	}
	public WebElement getPickEmploymentStatusAsProbation() {
		return pickEmploymentStatusAsProbation;
	}
	public WebElement getEmploymentStatusBlankErrorMessage() {
		return employmentStatusBlankErrorMessage;
	}
	public WebElement getContractEndDateCalenderWin() {
		return contractEndDateCalenderWin;
	}
	public WebElement getContractEndDateBlankErrMessage() {
		return contractEndDateBlankErrMessage;
	}
	public WebElement getDepartmentEditbox() {
		return departmentEditbox;
	}
	public WebElement getPickDepartment() {
		return pickDepartment;
	}
	public WebElement getDepartmentBlankErrorMessage() {
		return departmentBlankErrorMessage;
	}
	public WebElement getRoleEditbox() {
		return roleEditbox;
	}
	public WebElement getRoleEditboxBlankErrorMessage() {
		return roleEditboxBlankErrorMessage;
	}
	public WebElement getDesignationEditbox() {
		return designationEditbox;
	}
	public WebElement getPickDesignation() {
		return pickDesignation;
	}
	public WebElement getDesignationBlankErrorMessage() {
		return designationBlankErrorMessage;
	}
	public WebElement getReportingHiringManagerEditbox() {
		return reportingHiringManagerEditbox;
	}
	public WebElement getPickReportingHiringManager() {
		return pickReportingHiringManager;
	}
	public WebElement getReportingHiringManagerBlankErrorMesage() {
		return reportingHiringManagerBlankErrorMesage;
	}
	public WebElement getPickTypeDropdown() {
		return pickTypeDropdown;
	}
	public List<WebElement> getPickTypeDropdownValues() {
		return pickTypeDropdownValues;
	}
	public WebElement getPickPayType() {
		return pickPayType;
	}
	public WebElement getPayFrequencyDropdown() {
		return payFrequencyDropdown;
	}
	public List<WebElement> getPayFrequencyDropdownValues() {
		return payFrequencyDropdownValues;
	}
	public WebElement getPickPayFrequencyDropdownValue() {
		return pickPayFrequencyDropdownValue;
	}
	public WebElement getFtptIndicatorDropdown() {
		return ftptIndicatorDropdown;
	}
	public List<WebElement> getFtptIndicatorDropdownValues() {
		return ftptIndicatorDropdownValues;
	}
	public WebElement getPickPartTimeIndicator() {
		return pickPartTimeIndicator;
	}
	public WebElement getPickFullTimeIndicator() {
		return pickFullTimeIndicator;
	}
	public WebElement getFtptBlankErrorMessage() {
		return ftptBlankErrorMessage;
	}
	public WebElement getFteEditbox() {
		return fteEditbox;
	}
	public WebElement getFteBlankErrorMessage() {
		return fteBlankErrorMessage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************Utilization******************************/

}
