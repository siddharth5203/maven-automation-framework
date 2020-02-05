package com.orangehrm.comman;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

public class SeleniumUtils {
	public static void takeScreenshot(String fileNameWithPath) {
		File scrFile = ((TakesScreenshot) WebDriverFactory.getWebDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileNameWithPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
