package com.ParaBank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ParaBank.Base.TestBase;
import com.ParaBank.Pages.BillPay;
import com.ParaBank.Pages.HomePage;
import com.ParaBank.Pages.OverviewPage;

public class PayBillTest extends TestBase {

	HomePage homePage;
	OverviewPage overviewPage;
	BillPay billPay;

	@BeforeMethod
	public void beforeTest() {
		initialization();
		homePage = new HomePage();
		overviewPage = homePage.loginTest();
		billPay = overviewPage.clickBillPayLink();
	}

	@Test
	public void payBillTest() {
		billPay.payBill();
		billPay.clickOverviewLink();
		overviewPage.getBalance();
		Assert.assertNotSame(overviewPage.getBalance(), "$415.50");
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
