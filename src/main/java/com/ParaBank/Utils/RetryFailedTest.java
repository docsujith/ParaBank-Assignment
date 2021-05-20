package com.ParaBank.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ParaBank.Base.TestBase;

public class RetryFailedTest extends TestBase implements IRetryAnalyzer {
	
	int counter;
	int maxCounter=2;

	@Override
	public boolean retry(ITestResult result) {
		
		if (counter<maxCounter) {
			counter++;
			return true;
		}
		
		return false;
	}

}
