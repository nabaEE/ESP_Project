package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimeAndAttendancePage {

	/********* Initialization **************/
	@FindBy(xpath = "//div[@class='card']/div[3]/ul/div[2]/div[6]/li/p")
	private WebElement clickLeaveListByEmployee;
	@FindBy(xpath = "//div[@id='div_Employee_Name']/input[1]")
	private WebElement searchEmployeeInLeaveListByEmployee;
	@FindBy(xpath = "//div[@id='div_Employee_Name']/ul/li[1]")
	private WebElement clickEmpInEmpLeaveListByEmp;
	@FindBy(xpath = "//table[@id='E2ProTable']/tbody/tr[1]/td[2]")
	private WebElement selectLeave1ToCancel;
	@FindBy(xpath = "//div[@id='Approve_Button_Div']/div/button")
	private WebElement clickSubmitToCancel;
	@FindBy(xpath="//div[@class='card']/div[3]/ul/div[2]/div/li")
	private List<WebElement> timeAndAttendanceValues;

	/********* Getters Usage **************/
	
	public WebElement getClickLeaveListByEmployee() {
		return clickLeaveListByEmployee;
	}

	public WebElement getSearchEmployeeInLeaveListByEmployee() {
		return searchEmployeeInLeaveListByEmployee;
	}

	public WebElement getClickEmpInEmpLeaveListByEmp() {
		return clickEmpInEmpLeaveListByEmp;
	}

	public WebElement getSelectLeave1ToCancel() {
		return selectLeave1ToCancel;
	}

	public WebElement getClickSubmitToCancel() {
		return clickSubmitToCancel;
	}

	/********* Utilization **************/
//Method to select Leave list by Employee
 public void clickLeaveListByEmployee() {
	 for(int i=0; i<timeAndAttendanceValues.size(); i++) {
		 if(timeAndAttendanceValues.get(i).getText().equalsIgnoreCase("Leave List By Employee")) {
			 timeAndAttendanceValues.get(i).click();
		 }
	 }
 }
}
