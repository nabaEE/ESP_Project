package com.orgDesignData;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import esp.genericLibraries.BaseClass;
import esp.genericLibraries.WebdriverUtils;
import esp.objectRepository.ConfigurationSetupPage;
import esp.objectRepository.CostCenterManagementPage;
import esp.objectRepository.LandingPage;

public class CostCenterManagementTest  extends BaseClass
{
@Test()
public static void submitNewCostCenter()
{
	log.debug("------submitNewCostCenter: Test started--------");
	LandingPage lnp= PageFactory.initElements(driver, LandingPage.class);
	//Click on admin icon
	WebdriverUtils.waitForElementPresent(driver, lnp.getAdminIcon());
	lnp.getAdminIcon().click();
	//Click on Configuration setup
	lnp.getConfigurationSetupAdminValue().click();
	//Call the ConfigurationSetup page
	ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
	//Click on org design data
	csp.getOrgDesignData().click();
	//Click on cost center management
	csp.getClickDepartment().click();	
	csp.getClickCostCenterManagement().click();
	//Call cost center management page
	CostCenterManagementPage cmp= PageFactory.initElements(driver, CostCenterManagementPage.class);
	//Click on add new button
	cmp.getAddNewButton().click();
	//Enter cost center code
	cmp.getCostCenterCode().sendKeys("");
	//Enter cost center name
	cmp.getCostCenterNameEditbox().sendKeys("");
	//Pick the effective from date
	cmp.getEffectiveFromDateCalenderWin().click();
	cmp.getCurrentDate().click();
	//Enter the remarks
	cmp.getRemarksEditbox().sendKeys("");
	//Click on submit
	cmp.getSubmitButton().click();
	
	
}
}
