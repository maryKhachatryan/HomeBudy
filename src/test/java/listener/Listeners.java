package listener;

import autoTests.BaseTest;
import core.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(final ITestResult result) {
        final String testName = result.getMethod().getMethodName();
        System.out.println("🚀 Starting test: " + testName);
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        final WebDriver driver = BaseTest.getDriver();

        final String testName = result.getMethod().getMethodName();
        final String screenshotPath = ScreenshotUtil.takeScreenshot(testName, driver);

        System.out.println("❌ Test failed: " + testName);
        System.out.println("📸 Screenshot saved at: " + screenshotPath);
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        final String testName = result.getMethod().getMethodName();
        System.out.println("✅ Test passed: " + testName);
    }

    @Override
    public void onTestSkipped(final ITestResult result) {
        final String testName = result.getMethod().getMethodName();
        System.out.println("⚠️ Test skipped: " + testName);

        Throwable skipReason = result.getThrowable();
        if (skipReason != null) {
            System.out.println("⛔ Skip reason: " + skipReason.getMessage());
        }
    }

}


