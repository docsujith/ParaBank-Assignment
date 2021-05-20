package com.ParaBank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ParaBank.Base.TestBase;
import com.ParaBank.Pages.HomePage;
import com.ParaBank.Pages.OverviewPage;

public class LogoutTest extends TestBase {

	HomePage homePage;
	OverviewPage overviewPage;

	@BeforeMethod
	public void beforeTest() {
		initialization();
		homePage = new HomePage();
		overviewPage = homePage.loginTest();
	}

	@Test
	public void logoutTest() {
		overviewPage.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
