package com.orangehrm.comman;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(ImplIInvokedMethodListener.class)
public class BaseSelenium {

	protected static String getClassFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		
		return strSourceClassName.replace(".class", ".xlsx");
	}
	
	int no_ofRow=0;
	int no_ofCol=0;
	
	@AfterSuite
	public  void afterSuite() {
		ExtentReportTestFactory.flushReport();
	}

	@DataProvider(name="excelData", parallel=true)
	public String[][] getDataFromExcel(Method m) throws Exception{
		System.out.println(m.getName());
		System.out.println(m.getDeclaringClass());
		return ExcelReader.getExcelTableArray(getClassFilePath(m.getDeclaringClass()), m.getName());
	}
	
}
