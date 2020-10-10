package esp.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;

public class CovidPage extends LandingPage{
 
	/****************Initialization*********************/
	@FindBy(xpath="//span[text()='Covid - Daily Self Declaration Form']")
	private WebElement covidFormTitle;
	@FindBy(id="2840_text")
	private WebElement bodyTemp;
	@FindBy(id="2848_text")
	private WebElement visitingFrom;
	@FindBy(xpath="//html//body//main//div[6]//div//form//div[1]//div[3]//p[1]//label//span")
	private WebElement clickCheckbox;
	@FindBy(xpath="//div[@id='ShowPopupForm']/div/form/div[2]/button")
	private WebElement clickSubmit;
	

	
	/****************Getters Usage*********************/
	public WebElement getCovidFormTitle() {
		return covidFormTitle;
	}
	/****************Utilization
	 * @return 
	 * @throws InterruptedException *********************/
	//Method to check if the covid pop up window has displayed
	public boolean checkCovidForm() {
		LandingPage lp= new LandingPage();
		if (covidFormTitle.isDisplayed()) {
			bodyTemp.sendKeys("98.9");
			visitingFrom.sendKeys("Chennai");
			JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
			js.executeScript("window.scrollBy(0,350)", "");
			WebdriverUtils.waitForElementPresent(BaseClass.driver, clickCheckbox);
			js.executeScript("arguments[0].click();", clickCheckbox);
			WebdriverUtils.waitForElementPresent(BaseClass.driver, clickSubmit);
			clickSubmit.click();
			return true;
		} 
		else if (lp.getAdminIcon().isDisplayed()){
			System.out.println(" Covid details has been already submitted");
			return true;
			} 
		else {
			return false;
		}
		//return covidFormTitle;

	}
}
