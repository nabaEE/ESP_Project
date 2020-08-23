package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage {
	/**********Initialization***************/
	@FindBy(xpath="//div[@id='showGroups']/div[2]/div[1]/div/div/p[3]")
	private WebElement clickStatutoryReport;
	@FindBy(xpath="//div[@id='Display_ul']/div[3]/li/p")
	private WebElement clickCovidFormDeclaration;
	
	
	
	/*************Getters Usage**********/
	public WebElement getClickStatutoryReports() {
		return clickStatutoryReport;
	}
	public WebElement getClickCovidFormDeclaration() {
		return clickCovidFormDeclaration;
	}
	/*************Utilization************/

}
