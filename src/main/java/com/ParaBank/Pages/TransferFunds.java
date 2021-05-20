package com.ParaBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ParaBank.Base.TestBase;

public class TransferFunds extends TestBase {

	@FindBy(id = "amount")
	WebElement amountInputBox;

	@FindBy(id = "fromAccountId")
	WebElement fromAccountBox;

	@FindBy(css = "#fromAccountId option:nth-child(1)")
	WebElement fromAccount;

	@FindBy(id = "toAccountId")
	WebElement toAccountBox;

	@FindBy(css = "#toAccountId option:nth-child(1)")
	WebElement toAccount;

	@FindBy(css = "div input[class='button']")
	WebElement transferButton;

	@FindBy(css = "div#bodyPanel div#leftPanel li:nth-child(2) a")
	WebElement overviewPageLink;

	public TransferFunds() {
		waitForDocumentCompleteState(10);
		PageFactory.initElements(driver, this);
	}

	public void enterAmount() {
		amountInputBox.sendKeys("10");
	}

	public void selectfromAccount() {
		fromAccountBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(fromAccount));
		fromAccount.click();
	}

	public void selectToAccount() {
		toAccountBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(toAccount));
		toAccount.click();
	}

	public void clickTransferButton() {
		transferButton.click();
	}

	public void transferFunds() {
		enterAmount();
		selectfromAccount();
		selectToAccount();
		clickTransferButton();
	}

	public OverviewPage clickOverviewLink() {
		overviewPageLink.click();
		return new OverviewPage();
	}

}
