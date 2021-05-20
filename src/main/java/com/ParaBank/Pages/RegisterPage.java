package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ParaBank.Base.TestBase;

public class RegisterPage extends TestBase {
	
	@FindBy(id = "customer.firstName")
	WebElement firstNameInput;
	
	@FindBy(id = "customer.lastName")
	WebElement lastNameInput;
	
	@FindBy(id = "customer.address.street")
	WebElement streetAddressInput;
	
	@FindBy(id = "customer.address.city")
	WebElement cityInput;
	
	@FindBy(id = "customer.address.state")
	WebElement stateInput;
	
	@FindBy(id = "customer.address.zipCode")
	WebElement zipcodeInput;
	
	@FindBy(id = "customer.phoneNumber")
	WebElement phoneNoInput;
	
	@FindBy(id = "customer.ssn")
	WebElement ssnInput;
	
	@FindBy(id = "customer.username")
	WebElement userNameInput;
	
	@FindBy(id = "customer.password")
	WebElement passwordInput;
	
	@FindBy(id = "repeatedPassword")
	WebElement confirmPasswordInput;

	@FindBy(xpath = "//input[@type='submit' and @value= 'Register']") 
	WebElement registerButton;
	
	@FindBy(css = "div#rightPanel p")
	WebElement successMessage;
	
	public RegisterPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	public void inputFirstName() {
		firstNameInput.sendKeys("Jane");	
	}
	
	public void inputLastName() {
		lastNameInput.sendKeys("Smith");	
	}
	
	public void inputStreeName() {
		streetAddressInput.sendKeys("1234, Beach drive");	
	}
	
	public void inputCity() {
		cityInput.sendKeys("Annapolis");	
	}
	
	public void inputState() {
		stateInput.sendKeys("Maryland");	
	}
	
	public void inputZipCode() {
		zipcodeInput.sendKeys("45454");	
	}
	
	public void inputPhone() {
		phoneNoInput.sendKeys("1234567890");	
	}
	
	public void inputSSN() {
		ssnInput.sendKeys("123456789");	
	}
	
	public void inputUserName() {
		userNameInput.sendKeys("Tommy");	
	}
	
	public void inputPassword() {
		passwordInput.sendKeys("1234");	
	}
	
	public void confirmPassword() {
		confirmPasswordInput.sendKeys("1234");	
	}
	
	public void clickRegisterButton() {
		registerButton.click();	
	}
	
	public void registerNewCustomer() {
		inputFirstName();
		inputLastName();
		inputStreeName();
		inputCity();
		inputState();
		inputZipCode();
		inputPhone();
		inputSSN();
		inputUserName();
		inputPassword();
		confirmPassword();
		clickRegisterButton();
	}
	
	public String getSuccessMessage() {
		 String message = successMessage.getText();
		 return message;
	}
	
	
}	