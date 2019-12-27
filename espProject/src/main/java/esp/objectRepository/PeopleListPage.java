package esp.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PeopleListPage
{
/****************Initialization**********************/
@FindBy(xpath="//tbody[@id='TBody']/tr[14]/td[1]/a/i")
private WebElement pickEmployee;
@FindBy(linkText="//ul[@id='Drop_13']/li[4]/a")
private List<WebElement> adminActions;
@FindBy(xpath="//html//body//main//div//div[2]//div[2]//div//div[6]//table//tbody//tr[14]//td[1]//ul//li[4]//a")
private WebElement clickSeparationSection;
/*****************Getters Usage*********************/
public WebElement getClickSeparationSection()
{
	return clickSeparationSection;
}
public WebElement getPickEmployee()
{
	return pickEmployee;
}
/****************Utilization************************/
public void clickSeparationOption()
{
for (int i=0; i<adminActions.size(); i++)
{
  if(adminActions.get(i).getText().equalsIgnoreCase("Separation"))
  {
	  adminActions.get(i).click();
  }
}
}
}