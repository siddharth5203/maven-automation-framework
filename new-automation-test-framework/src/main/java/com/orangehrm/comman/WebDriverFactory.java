package com.orangehrm.comman;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	private static ThreadLocal<WebDriver> threadLocalStorage = new ThreadLocal<WebDriver>(); 

	protected static void setWebDriver(WebDriver dr) {
		threadLocalStorage.set(dr);
	}
	
	public static WebDriver getWebDriver() {
		return threadLocalStorage.get();
		
	}
}
