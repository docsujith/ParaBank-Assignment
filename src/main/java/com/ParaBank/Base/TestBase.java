package com.ParaBank.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.ParaBank.Utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor jse;
	public static Logger logger;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src\\main\\java\\com\\ParaBank\\Config\\config.Properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void LoggerSetUp() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");

		if (browser.trim().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.trim().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		if (browser.trim().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public void waitForDocumentCompleteState(int secondsToWait) {
		new WebDriverWait(driver, secondsToWait).until((ExpectedCondition<Boolean>) wd -> {

			while (true) {
				String readyState = getDocumentReadyState();

				if (readyState.equals("complete")) {
					System.out.println("Document Ready State is : " + readyState);
					return true;
				} else {
					System.out.println("Document is not in Ready State : " + readyState);
				}

			}
		});
	}

	private String getDocumentReadyState() {
		jse = (JavascriptExecutor) driver;
		try {
			return jse.executeScript("return document.readyState").toString();
		} catch (WebDriverException e) {
			return null;
		}

	}
}
