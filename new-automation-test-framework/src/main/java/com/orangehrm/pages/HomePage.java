package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.comman.WebDriverFactory;

public class HomePage {

	@FindBy(id="welcome")
	WebElement welcomeText;

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;

	WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), 30);
	
	public HomePage isHomePageLoaded() {
		wait.until(ExpectedConditions.elementToBeClickable(welcomeText));
		return this;
	}
	
	public HomePage() {
		
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}

	public HomePage verifyWelComeText(String txt) {
		Assert.assertEquals(welcomeText.getText(), txt);
		return this;
	}
	

}
