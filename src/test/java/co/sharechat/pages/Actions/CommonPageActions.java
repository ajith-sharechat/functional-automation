package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.CommonPageObjects;
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
 This Class has all the actions related to the create Pots(Text/Camera/Upload/Poll)
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class CommonPageActions extends WebDriverListener {

	DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static CommonPageObjects commonPageObjects = new CommonPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

	public CommonPageActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), commonPageObjects);
        this.runnerInfo = runnerInfo;
    }

	public static MobileElement element(MobileElement element){
		try {
			deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
		}catch (NoSuchElementException | TimeoutException e){
			commonPageObjects.allowPermissionPopUp.click();
			element(element);
		}
		return element;
	}

	public void alllowPermission(){
		commonPageObjects.allowPermissionPopUp.click();
	}

	public void denyPermission(){
		commonPageObjects.denyPermissionPopUp.click();
	}

	public boolean isAndroidAlertDisplayed() {
		return deviceHelper.isElementPresent(commonPageObjects.allowPermissionPopUp);
	}

	public void acceptAlert(){
		commonPageObjects.alertAcceptBtn.click();
	}

	public void rejectAlert(){
		commonPageObjects.alertDismissBtn.click();
	}

	public String getAlertPopupText(){
		return commonPageObjects.alertaMessageText.getText();
	}

	public boolean isAppGeneratedAlertDisplayed() {
		return deviceHelper.isElementPresent(commonPageObjects.alertGeneratedByApplication);
	}

	public void hardWait(int timeInSecs){
		try {
			Thread.sleep(timeInSecs*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
