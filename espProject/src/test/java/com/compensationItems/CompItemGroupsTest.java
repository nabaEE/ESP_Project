package com.compensationItems;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.LandingPage;

public class CompItemGroupsTest extends BaseClass
{
@Test(groups="Smoke")
public static void submitNewCompensationGroup() throws InterruptedException
{
// driver.switchTo().frame(driver.findElement(By.xpath("//html//frameset//frame")));
//Call the landing page
LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
//Click on admin icon
lnp.getAdminIcon().click();
//Click on Configuration setup
lnp.getConfigurationSetupAdminValue().click();
}
@Test(enabled=false)
public static void submitAnexistingCompensationGroup()
{

}
}
