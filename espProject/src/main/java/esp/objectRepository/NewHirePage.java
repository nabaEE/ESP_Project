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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************************Getters Usage********************************/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************Utilization******************************/

}
