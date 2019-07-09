package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.loginPageObjects;
import co.sharechat.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * This Class has all the Actions related to Login Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 09 july 2019
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

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitInSec(5);
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    public void userlogin() throws Exception {
        WebDriverWait wait = null;
        try {

            element(loginPageObjects.selectHindi).click();
            element(loginPageObjects.enterNumber).sendKeys(registerNumber);
            element(loginPageObjects.goToYourAccount).click();
            element(loginPageObjects.allow).click();
            loginPageObjects.allow.click();
            loginPageObjects.allow.click();
            deviceHelper.waitInSec(5);
            for (int i = 0; i <= 5; i++) {
                loginPageObjects.OTPValues.get(i).sendKeys("" + i);

            }

        } catch (Exception e) {

            logger.log(Status.FAIL, "Failed on Customer login");
            webDriverListener.captureScreenShot("loginPage", "userlogin");
            // Flush method will write the test in report- This is mandatory step
            extent.flush();

        }
    }

    public boolean createNewUSer() {

        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.enterNumber).sendKeys(UNRegisteredNumber);
        element(loginPageObjects.goToYourAccount).click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        loginPageObjects.enterName.sendKeys(SearchingText);
        loginPageObjects.selectRadioButton.click();
        loginPageObjects.ageRange.click();
        loginPageObjects.createPFClick.click();
        return element(loginPageObjects.verifySuccessfullCreation).isDisplayed();

    }

    public ArrayList verifyWithWrongOTP() throws Exception {
        ArrayList al = new ArrayList();
        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.enterNumber).sendKeys(OTPVerifiedNumber);
        element(loginPageObjects.goToYourAccount).click();
        element(loginPageObjects.allow).click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        deviceHelper.waitInSec(5);
        for (int i = 0; i <= 5; i++) {
            loginPageObjects.OTPValues.get(i).sendKeys("" + i);
        }
        al.add(loginPageObjects.Toast.getText());
        deviceHelper.waitInSec(5);

        return al;
    }
}

