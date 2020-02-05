package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.comman.ExtentReportTestFactory;
import com.orangehrm.comman.WebDriverFactory;

public class LoginPage {

	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement passWord;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(id="logInPanelHeading" )
	WebElement loginPanel;

	@FindBy(id="spanMessage")
	WebElement spanMSG;
	
	@FindBy(id="footer")
	WebElement ohrmLink;
	
	WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), 30);
	public LoginPage isLoginPageLoaded() {

		wait.until(ExpectedConditions.elementToBeClickable(userName));
		wait.until(ExpectedConditions.elementToBeClickable(passWord));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		ExtentReportTestFactory.getTest().info("In login method");

		return this;
	}
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	public HomePage login(String uname, String pword) {
		ExtentReportTestFactory.getTest().info("In login method");

		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		loginButton.click();
		return (new HomePage().isHomePageLoaded());
	}

}
