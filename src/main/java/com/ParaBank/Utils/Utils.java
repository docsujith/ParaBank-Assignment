package com.ParaBank.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ParaBank.Base.TestBase;

public class Utils extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;

	public static void takeFailedTestCasesScreenshot(String testMethodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestsScreenShotFolder\\" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
