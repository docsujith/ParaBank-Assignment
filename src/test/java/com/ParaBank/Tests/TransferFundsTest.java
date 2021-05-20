package com.ParaBank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ParaBank.Base.TestBase;
import com.ParaBank.Pages.HomePage;
import com.ParaBank.Pages.OpenAccount;
import com.ParaBank.Pages.OverviewPage;
import com.ParaBank.Pages.TransferFunds;

public class TransferFundsTest extends TestBase {

	HomePage homePage;
	OverviewPage overviewPage;
	TransferFunds transferFunds;
	OpenAccount openAccount;

	@BeforeMethod
	public void beforeTest() {
		initialization();
		homePage = new HomePage();
		overviewPage = homePage.loginTest();
		openAccount = overviewPage.clickOpenNewAccount();
		transferFunds = overviewPage.clickTransferLink();
	}

	@Test
	public void transferFundsTest() {
		transferFunds.transferFunds();
		transferFunds.clickOverviewLink();
		overviewPage.getBalance();
		Assert.assertNotSame(overviewPage.getBalance(), "$415.50");
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
