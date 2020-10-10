package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovalPage {
 /*****************/
	@FindBy(xpath="//div[@id='Display_ul']/div[3]")
	private WebElement organizationApprovalpage;
	@FindBy(xpath="//table[@id='E2ProTable']/tbody/tr[1]/td/a[2]")
	private WebElement approvalButton;
	@FindBy(xpath="//table[@id='E2ProTable']/tbody/tr[1]/td/a[3]")
	private WebElement rejectButton;
	@FindBy(xpath="//nav[@class='custom-navbar']/div/ul/li[3]")
	private WebElement clickHomeIcon;
	
/**************************************/
	public WebElement getClickHomeIcon() {
		return clickHomeIcon;
	}
	public WebElement getRejectButton() {
		return rejectButton;
	}
	public WebElement getOrganizationApprovalpage() {
		return organizationApprovalpage;
	}
	public WebElement getApprovalButton() {
		return approvalButton;
	}
	
}
