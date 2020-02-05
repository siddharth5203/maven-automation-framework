package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.comman.BaseSelenium;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseSelenium {

	@Test(dataProvider="excelData")
	public void validUNameNPWord(String userName, String passWord, String welcomeTxt) {
		LoginPage lp = new LoginPage();
		lp.login(userName, passWord).verifyWelComeText(welcomeTxt);
	}
}
