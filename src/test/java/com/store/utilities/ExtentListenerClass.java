package com.store.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		ReadConfig config = new ReadConfig();
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReprot -" + timeStamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "Tecstkdlf");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", config.getBrowser());
		reports.setSystemInfo("User Name", "amitj");

		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start method invoked...............");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finish method invoked..................");
		reports.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started:" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method sucessfully executed:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
		File screenshotFile = new File(screenshotPath);
		if (screenshotFile.exists()) {
			test.fail("Captured screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped:" + result.getName());

		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
