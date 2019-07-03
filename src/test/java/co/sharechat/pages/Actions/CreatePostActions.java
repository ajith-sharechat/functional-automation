package co.sharechat.pages.Actions;

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
    DeviceHelper deviceHelper;
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
	
	public void selectHindi() {
		signUpObjects.hindiBox.click();
	}
	
	public void enterName(String name) {
		signUpObjects.loginNameBox.sendKeys(name);
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
		signUpObjects.loginSubmitBtn.click();
	}
	
	public boolean langDDLdisplayed() {
		return signUpObjects.langDDL.isDisplayed();
	}

	public void selectCountry(){
		signUpObjects.INDIACountryCode.click();
	}

	public void enterOTP(String otp) {
		signUpObjects.OTPtextbox.sendKeys(otp);
	}

	public void submitOTP() {
		signUpObjects.submitOTP.click();
	}

	
}
