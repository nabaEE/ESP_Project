package esp.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PeopleListPage
{
/****************Initialization**********************/
@FindBy(xpath="//tbody[@id='TBody']/tr[14]/td[1]/a/i")
private WebElement pickSeparation;
/*****************Getters Usage*********************/
public WebElement getPickSeparation()
{
	return pickSeparation;
}
/****************Utilization************************/
}
