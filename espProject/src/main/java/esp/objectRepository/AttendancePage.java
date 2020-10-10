package esp.objectRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;

public class AttendancePage extends BaseClass{
/****************Initialization******************/
	@FindBy(xpath="//div[@id='PopUpDiv']/div/div/table/thead/tr[1]/th")
	private List<WebElement> attendanceDates;
	@FindBy(xpath="//div[@id='PopUpDiv']/div/div/table/tbody/tr[2]/td")
	private List<WebElement> attendanceStringValues; 
	@FindBy(xpath="//div[@id='PopUpDiv']/div/div/button/i")
	private WebElement closeAttendanceWindow;
	
/******************Getters Usage**************/
	public WebElement getCloseAttendanceWindow() {
		return closeAttendanceWindow;
	}
/*********************Utilization*****************/
	 //Method to get attendance string
		public ArrayList<String> getAttendanceString() {
		 String atString=null;
		 String atDate=null;
		 TreeMap<String, String> values= new TreeMap<String, String>();
		 ArrayList<String> vAbsentList = new ArrayList<String>();
		 log.info("--Attendnace String--");
		 log.info("---------------------------");
		 for(int i=1 ; i<31; i++) {
			values.put(attendanceDates.get(i).getText(), attendanceStringValues.get(i).getText());
		 }
		 for(Entry<String, String> entry: values.entrySet()) {
			  atDate= entry.getKey();
			  System.out.println(atDate  +"--"+entry.getValue());
			  log.info(atDate  +"--"+entry.getValue());			 
			 if (entry.getValue().equals("A")) {
				 vAbsentList.add(atDate);
			 } 
			 
		 }
		return vAbsentList;
		
  }
}