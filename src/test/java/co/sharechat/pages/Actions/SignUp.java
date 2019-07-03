package co.sharechat.pages.Actions;

import co.sharechat.config.TestRunnerInfo;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.SignUpPageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUp extends WebDriverListener {
	
	DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static SignUpPageObjects signUpObjects = new SignUpPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

	public SignUp(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        this.runnerInfo = runnerInfo;
    }

    public static MobileElement element(MobileElement element){
		try {
			deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
		}catch (NoSuchElementException | TimeoutException e){
			signUpObjects.allowPermissionPopUp.click();
			element(element);
		}
		return element;
	}

	public void selectHindi() {

		element(signUpObjects.hindiBox).click();
	}
	
	public void enterName(String name) {
		element(signUpObjects.loginNameBox).sendKeys(name);
	}
	
	public void enterPhNo(String phNo) {
		signUpObjects.loginPhBox.sendKeys(phNo);
	}
	
	public void selectGender() {
		signUpObjects.loginGenderBtn.click();
	}
	
	public void selectAgeGroup() {
		signUpObjects.loginAgeGrpBtn.click();
	}
	
	public void submit() {
		element(signUpObjects.loginSubmitBtn).click();
	}
	
	public boolean langDDLdisplayed() {
		return deviceHelper.isElementPresent(element(signUpObjects.langDDL));
	}

	public void selectCountry(){
		signUpObjects.countryCodeDDL.click();
		signUpObjects.INDIACountryCode.click();
	}

	public void enterOTP(String otp) {
		element(signUpObjects.OTPtextbox).sendKeys(otp);
	}

	public void submitOTP() {
		signUpObjects.submitOTP.click();
	}

	public void acceptPermission(){
		signUpObjects.allowPermissionPopUp.click();
	}

}
