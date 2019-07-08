package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.ReferralObjects;
import co.sharechat.pages.Objects.SignUpPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 This Class has all the actions related to the Referral module
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class ReferralActions extends WebDriverListener {

	DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static ReferralObjects referralObjs = new ReferralObjects();
	static SignUpPageObjects signUpObjects = new SignUpPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

	public ReferralActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), referralObjs);
        this.runnerInfo = runnerInfo;
    }

	public static MobileElement element(MobileElement element){

		deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
		try {
			//deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
		}catch (NoSuchElementException | TimeoutException e){
			signUpObjects.allowPermissionPopUp.click();
			element(element);
		}
		return element;
	}
	
	public void clickRfererralBtn() {
		element(referralObjs.referralBtn).click();
	}

	public void clickBackBtn() {
		element(referralObjs.referralBackBtn).click();
	}

	public void clickMyEarnings() {
		element(referralObjs.myEarningsBtn).click();
	}

	public boolean isBackBtnDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.referralBackBtn));
	}

	public boolean isMyEarningsDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.myEarningsBtn));
	}

	public boolean isTextonreferralDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.textForReferral));
	}

	public boolean isGetInstalandEarnDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.getinstallEarnBtn));
	}

	public void clickGetInstalandEarn() {
		element(referralObjs.getinstallEarnBtn).click();
	}

	public boolean isPrintMyQRCodeDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.printMyQRCodeBtn));
	}

	public void clickPrintMyQRCode() {
		element(referralObjs.printMyQRCodeBtn).click();
	}

	public boolean isSetupPaymentDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.setupPaymentBtn));
	}

	public void clickSetupPayment() {
		element(referralObjs.setupPaymentBtn).click();
	}

	public String getInstalandEarntext() {
		return element(referralObjs.getinstallEarnBox).getText();
	}

	public boolean isGetinstallEarnTextDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.getinstallEarnText));
	}

	public boolean isPrintMyQRCodeTextDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.printMyQRCodeText));
	}

	public boolean isSetupPaymentTextDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.setupPaymentText));
	}


	//=================My Earning Screen Avtions ==============

	public boolean isMyEarningBackBtnDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.myEarningBackBtn));
	}

	public boolean isTotalEarningsAmountDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.totalEarningsAmount));
	}

	//=================Setup Payment Screen Avtions ==============

	public boolean isSetupPaymentMobileNoFieldDisplayed() {
		return deviceHelper.isElementPresent(element(referralObjs.setupPaymentMobileNoField));
	}

	public void enyetNoInSetupPaymentMobileNoField(String number) {
		element(referralObjs.setupPaymentMobileNoField).sendKeys(number);
	}

	public void clickSubmitPayTMtMobileNo() {
		element(referralObjs.submitPayTMtMobileNo).click();
	}

	public String verificationInProgressText() {
		return element(referralObjs.verificationInProgressText).getText();
	}
	
}
