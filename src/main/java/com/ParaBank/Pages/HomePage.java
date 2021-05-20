package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ParaBank.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css = "div#loginPanel p:nth-child(3) a")
	WebElement registerLink;
	
	@FindBy(css = "input[name='username']")
	WebElement userNameInput;

	@FindBy(css = "input[name='password']")
	WebElement passwordInput;
	
	@FindBy(css = "input[type='submit']")
	WebElement loginButton;

	
	public HomePage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}
	
	public RegisterPage clickRegisterLogin() {
		registerLink.click();
		return new RegisterPage();
	}
	
	public void inputUsername() {
		userNameInput.sendKeys("Tommy");
	}
	
	public void inputPassword() {
		passwordInput.sendKeys("1234");
	}
	
	public OverviewPage clickLoginButton() {
		loginButton.click();
		return new OverviewPage();
	}
	
	public OverviewPage loginTest() {
		inputUsername();
		inputPassword();
		return clickLoginButton();
	}
	
	
}
