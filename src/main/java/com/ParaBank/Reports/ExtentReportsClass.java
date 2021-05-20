package com.ParaBank.Reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass extends TestListenerAdapter {

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Extent Report---" + timeStamp + ".html";

		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extent-Reports/" + reportName);
		extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extentReports = new ExtentReports();

		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Name of the Host", "localhost");
		extentReports.setSystemInfo("Environemnt", "Dev");
		extentReports.setSystemInfo("Tester Name", "Sujith");

		extentHtmlReporter.config().setDocumentTitle("ParaBank QA Automation Project"); // Title of the report generated
		extentHtmlReporter.config().setReportName("Automation Report"); // Name of the report generated
		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart in the report
		extentHtmlReporter.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		extentTest = extentReports.createTest(tr.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}

}
