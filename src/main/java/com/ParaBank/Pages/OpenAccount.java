package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ParaBank.Base.TestBase;

public class OpenAccount extends TestBase {

	@FindBy(id = "type")
	WebElement accountType;

	@FindBy(css = "div input[type='submit']")
	WebElement openAccountButton;

	@FindBy(css = "div#rightPanel div p:nth-of-type(1)")
	WebElement confirmation;

	public OpenAccount() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	public void selectAccountType() {
		Select select = new Select(accountType);
		select.selectByVisibleText("SAVINGS");
	}

	public void clickOpenAccountButton() {
		openAccountButton.click();
	}

	public void openNewAccount() {
		selectAccountType();
		clickOpenAccountButton();
	}

}
