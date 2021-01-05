package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestNGListener {

    private final MyITestListener iTestListener = new MyITestListener();

    public void onTestStart(ITestResult result) {
        iTestListener.onTestStart(result);
    }

    public void onTestSuccess(ITestResult result) {
        iTestListener.onTestSuccess(result);
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver =null;
        try {
            driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        }catch (Exception e){
            e.getStackTrace();
        }

        iTestListener.onTestFailure(result);

       String testMethodName =  result.getMethod().getMethodName();
        getScreenshot(testMethodName,driver);
    }

    public void onTestSkipped(ITestResult result) {
        iTestListener.onTestSkipped(result);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        iTestListener.onTestFailedButWithinSuccessPercentage(result);
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        iTestListener.onTestFailedWithTimeout(result);
    }

    public void onStart(ITestContext context) {
        iTestListener.onStart(context);
    }

    public void onFinish(ITestContext context) {
        iTestListener.onFinish(context);
    }

    private class MyITestListener implements ITestListener {
    }
}
