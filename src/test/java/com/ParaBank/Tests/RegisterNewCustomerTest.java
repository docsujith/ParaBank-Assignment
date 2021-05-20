package com.ParaBank.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ParaBank.Base.TestBase;
import com.ParaBank.Pages.HomePage;
import com.ParaBank.Pages.RegisterPage;

public class RegisterNewCustomerTest extends TestBase {

	HomePage homePage;
	RegisterPage registerPage;

	@BeforeMethod
	public void beforeTest() {
		initialization();
		homePage = new HomePage();
		registerPage = homePage.clickRegisterLogin();
	}

	@Test
	public void registerCustomerTest() {
		registerPage.registerNewCustomer();
		Assert.assertEquals(registerPage.getSuccessMessage(),
				"Your account was created successfully. You are now logged in.");
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
