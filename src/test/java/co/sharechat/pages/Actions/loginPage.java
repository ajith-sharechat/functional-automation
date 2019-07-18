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
<<<<<<< HEAD
            extent.attachReporter(reporter);
            ExtentTest logger=extent.createTest("CustomerLogin");
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            //loginPageObjects.selectKannada.click();
            //Assert.assertEquals("ಶೇರ್ ಚಾಟ್", loginPageObjects.shareChatTextInKannada.getText());
            //((AppiumDriver <MobileElement>)driver).hideKeyboard();
            //Assert.assertEquals(loginPageObjects.et_Phone.getText(), "ಮೊಬೈಲ್ ನಂಬರ್");
            System.out.println("Edit Phone number text box found in ಕನ್ನಡ");
            //Assert.assertEquals(loginPageObjects.tv_get_otp.getText(), "ಅಕೌಂಟ್ ಗೆ ಹೋಗಲು");
=======

            element(loginPageObjects.selectHindi).click();
            element(loginPageObjects.enterNumber).sendKeys(uniqueNo);
            element(loginPageObjects.goToYourAccount).click();
            element(loginPageObjects.allow).click();
            loginPageObjects.allow.click();
            loginPageObjects.allow.click();
            deviceHelper.waitInSec(5);
            for (int i = 0; i <= 5; i++) {
                deviceHelper.waitInSec(1);
                loginPageObjects.OTPValues.get(i).sendKeys("" + i);
            }

        } catch (Exception e) {

            logger.log(Status.FAIL, "Failed on Customer login");
            webDriverListener.captureScreenShot("loginPage", "userlogin");
>>>>>>> diljeet_05July2019
            // Flush method will write the test in report- This is mandatory step
            //extent.flush();

        }
    }

    public boolean createNewUser() {

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

    public boolean verifyWithWrongOTP() throws Exception {
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

        return loginPageObjects.Toast.isDisplayed();
    }

    public ArrayList verifyLoginWithInvalidNumber() {

        ArrayList al = new ArrayList();
        try {
            element(loginPageObjects.selectHindi).click();
            element(loginPageObjects.enterNumber).sendKeys(invalidNumber);
            element(loginPageObjects.goToYourAccount).click();

            al.add(loginPageObjects.Toast.getText());
            return al;

        } catch (NoSuchElementException e) {

            element(loginPageObjects.enterNumber).sendKeys(invalidNumber);
            loginPageObjects.enterName.sendKeys(SearchingText);
            loginPageObjects.selectRadioButton.click();
            loginPageObjects.ageRange.click();
            al.add(loginPageObjects.createSubmit.isEnabled());
            return al;
        }

    }

    public boolean verifyProceedWithEmptyForm() {
        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.goToYourAccount).click();

        return loginPageObjects.Toast.isDisplayed();


    }

    public boolean verifyProceedWithoutName() {

        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.enterNumber).sendKeys(UNRegisteredNumber);
        element(loginPageObjects.goToYourAccount).click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        element(loginPageObjects.selectRadioButton).click();
        element(loginPageObjects.ageRange).click();
        loginPageObjects.createPFClick.click();
        return loginPageObjects.Toast.isDisplayed();
    }

    public boolean verifyProceedWithoutMobileNumber() {
        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.goToYourAccount).click();

        return loginPageObjects.Toast.isDisplayed();


    }

    public boolean verifyProceedWithoutGenderSelection() {

        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.enterNumber).sendKeys(UNRegisteredNumber);
        element(loginPageObjects.goToYourAccount).click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        element(loginPageObjects.enterName).sendKeys(SearchingText);
        element(loginPageObjects.ageRange).click();
        loginPageObjects.createPFClick.click();
        return loginPageObjects.Toast.isDisplayed();
    }

    public boolean verifyProceedWithoutAgeSelection() {

        element(loginPageObjects.selectHindi).click();
        element(loginPageObjects.enterNumber).sendKeys(UNRegisteredNumber);
        element(loginPageObjects.goToYourAccount).click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        loginPageObjects.allow.click();
        element(loginPageObjects.enterName).sendKeys(SearchingText);
        element(loginPageObjects.selectRadioButton).click();
        loginPageObjects.createPFClick.click();
        return loginPageObjects.Toast.isDisplayed();
    }

    public boolean[] verifyTermPolicyPages() {
        boolean res[] = new boolean[2];
        element(loginPageObjects.selectHindi).click();
        deviceHelper.waitInSec(10);
        int leftX = loginPageObjects.termPolicy.getLocation().getX();
        int middleX = leftX + 200;
        int upperY = loginPageObjects.termPolicy.getCenter().y;
        deviceHelper.tapOnPoint(middleX, upperY);
        deviceHelper.waitInSec(10);
        res[0] = loginPageObjects.policyShare.isDisplayed();
        res[1] = loginPageObjects.currentUrl.isDisplayed();
        return res;
    }

}

