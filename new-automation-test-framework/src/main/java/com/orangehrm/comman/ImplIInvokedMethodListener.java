package com.orangehrm.comman;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class ImplIInvokedMethodListener implements IInvokedMethodListener {

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		if (method.isTestMethod()) {
			if(!testResult.isSuccess()) {
				ExtentReportTestFactory.getTest().fail(testResult.getThrowable());
				SeleniumUtils.takeScreenshot(System.getProperty("user.dir") + "\\" + method.getTestMethod().getMethodName() + ".png");
				try {
					ExtentReportTestFactory.getTest().addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + method.getTestMethod().getMethodName() + ".png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			WebDriverFactory.getWebDriver().quit();
		}
		WebDriverFactory.getWebDriver().quit();
		
	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		if (method.isTestMethod()) {
			DesiredCapabilities capability = new DesiredCapabilities();
			capability.setBrowserName("chrome");
			capability.setVersion("79");
			
			WebDriver dr;
			try {
				dr = new RemoteWebDriver(new URL("http://192.168.1.203:4444/wd/hub/"),capability);
				WebDriverFactory.setWebDriver(dr);
				WebDriverFactory.getWebDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");

				WebDriverFactory.getWebDriver().manage().window().maximize();

				ExtentReportTestFactory.createNewTest(method);
				} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
