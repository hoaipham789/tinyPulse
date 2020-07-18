package TestClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        result.getMethod().getMethodName();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        //screenshot
        String testMethodName = iTestResult.getMethod().getMethodName();
        try {
            getScreenShot(testMethodName);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
