package com.guru99bank.utilities;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//5. to create a proper report
//implement ITestListener 
public class Reports implements ITestListener{
	//6 take screenshot 
			WebDriver driver;
	//6. make extent report global
	ExtentReports extentreport;
	ExtentTest extenttest;
	//override these methods 
	@Override
	public void onStart(ITestContext context) {
		//6.create reports class object
		extentreport=Extentreporter.generate_Extent_reports();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//gets name of the test
		result.getName();
		extenttest = extentreport.createTest(result.getName());
		extenttest.log(Status.INFO, result.getName()+" Started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		result.getName();
		extenttest.log(Status.PASS, result.getName()+" Got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String className = result.getTestClass().getName();
		 String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
		
		extenttest.log(Status.FAIL, result.getName()+"got failed");
		//6 add ss in report
		String sspath = System.getProperty("user.dir")+"\\Screenshots\\"+simpleClassName+".png";
		File f = new File(sspath);
		if (f.exists()) {
	        extenttest.log(Status.INFO, "Screenshot exists at: " + sspath);

	        // Add the screenshot to the report
	        extenttest.addScreenCaptureFromPath(sspath);
	    } else {
	        // Log an error message if the screenshot doesn't exist
	        extenttest.log(Status.INFO, "Screenshot not found at: " + sspath);
	    }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		result.getName();
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, result.getName()+"got skipped");
	}


	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

}
