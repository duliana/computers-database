package utils;

import cases.BaseTest;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestReRunner extends BaseTest implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTryCount = 1;

    @Override
    public boolean retry (ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTryCount) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                logger.log("Test " + iTestResult.getMethod().getMethodName() +
                        " failed and maximum retry count is not exceeded, it will rerun");
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
