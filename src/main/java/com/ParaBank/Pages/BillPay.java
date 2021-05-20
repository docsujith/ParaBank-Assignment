package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ParaBank.Base.TestBase;

public class BillPay extends TestBase {

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(1) td:nth-child(2) input")
	WebElement payee;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(2) td:nth-child(2) input")
	WebElement addressInput;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(3) td:nth-child(2) input")
	WebElement cityInput;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(4) td:nth-child(2) input")
	WebElement stateInput;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(5) td:nth-child(2) input")
	WebElement zipcodeInput;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(6) td:nth-child(2) input")
	WebElement phoneNoInput;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(8) td:nth-child(2) input")
	WebElement toAccount;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(9) td:nth-child(2) input")
	WebElement verifyAccount;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(11) td:nth-child(2) input")
	WebElement amount;

	@FindBy(css = "table[class='form2'] tbody tr:nth-of-type(14) td:nth-child(2) input")
	WebElement sendButton;

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(2) a")
	WebElement overviewPageLink;

	public BillPay() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	public void inputPayee() {
		payee.sendKeys("Tom");
	}

	public void inputAddress() {
		addressInput.sendKeys("5689, Long drive");
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
		phoneNoInput.sendKeys("0987654321");
	}

	public void inputToAccount() {
		toAccount.sendKeys("78945");
	}

	public void verifyAccount() {
		verifyAccount.sendKeys("78945");
	}

	public void amountToSend() {
		amount.sendKeys("100");
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public void payBill() {
		inputPayee();
		inputAddress();
		inputCity();
		inputState();
		inputZipCode();
		inputPhone();
		inputToAccount();
		verifyAccount();
		amountToSend();
		clickSendButton();
	}

	public OverviewPage clickOverviewLink() {
		overviewPageLink.click();
		return new OverviewPage();
	}

}
