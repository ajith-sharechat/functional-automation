package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.loginPageObjects;
import co.sharechat.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 This Class has all the Actions related to Login Page
 @author Diljeet Singh
 @version 1.0
 @since 01 july 2019
 */
public class loginPage extends WebDriverListener implements Constants {
    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    co.sharechat.pages.Objects.loginPageObjects loginPageObjects = new loginPageObjects();
    ExtentHtmlReporter reporter = new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();


    public loginPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
        this.runnerInfo = runnerInfo;
    }

    public void userlogin() throws Exception {
        WebDriverWait wait = null;
        try {
            deviceHelper.waitInSec(10);
            loginPageObjects.selectHindi.click();
            deviceHelper.waitInSec(10);
            loginPageObjects.enterNumber.sendKeys(registerNumber);
            deviceHelper.waitInSec(10);
            loginPageObjects.goToYourAccount.click();
            deviceHelper.waitInSec(10);
            loginPageObjects.allow.click();
            loginPageObjects.allow.click();
            loginPageObjects.allow.click();
            deviceHelper.waitInSec(5);
            for (int i = 0; i <= 5; i++) {
                loginPageObjects.OTPValues.get(i).sendKeys("" + i);

            }

        } catch (Exception e) {

            logger.log(Status.FAIL, "Failed on Customer login");
            webDriverListener.captureScreenShot("loginPage", "loginPage");
            // Flush method will write the test in report- This is mandatory step
            extent.flush();

        }
    }


}

