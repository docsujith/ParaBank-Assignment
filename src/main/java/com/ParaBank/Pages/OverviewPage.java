package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends HomePage {

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(1) a")
	WebElement openNewLink;

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(3) a")
	WebElement transferFundsLink;

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(4) a")
	WebElement billPay;

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(8) a")
	WebElement logoutLink;

	@FindBy(css = "#accountTable tbody tr:nth-of-type(1) td a")
	WebElement accountNo;

	@FindBy(css = "#accountTable tbody tr:nth-of-type(1) td:nth-child(2)")
	WebElement balanceAmount;

	public OverviewPage() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	public OpenAccount clickOpenNewAccount() {
		openNewLink.click();
		return new OpenAccount();
	}

	public TransferFunds clickTransferLink() {
		transferFundsLink.click();
		return new TransferFunds();
	}

	public BillPay clickBillPayLink() {
		billPay.click();
		return new BillPay();
	}

	public HomePage logout() {
		logoutLink.click();
		return new HomePage();
	}

	public String compareFromAccount() {
		String accountNumber = accountNo.getText();
		return accountNumber;
	}

	public String getBalance() {
		String balance = balanceAmount.getText();
		return balance;
	}
}
