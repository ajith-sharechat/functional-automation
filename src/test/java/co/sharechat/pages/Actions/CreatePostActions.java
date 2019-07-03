package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.CreatePostObjects;
import co.sharechat.pages.Objects.SignUpPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CreatePostActions extends WebDriverListener {

	DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static CreatePostObjects createPostObjects= new CreatePostObjects();
	static SignUpPageObjects signUpObjects = new SignUpPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

	public CreatePostActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), createPostObjects);
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
	
	public void composePost() {
		createPostObjects.plusIcon.click();
	}
	
	public void textCompose() {
		element(createPostObjects.createText).click();
	}
	
	public void writeTextofTextPost(String text) {
		element(createPostObjects.writeTextInCreateTextPost).sendKeys(text);
	}
	
	public void submitTextForTextPost() {
		createPostObjects.tickIconTextCompose.click();
	}
	
	public void writeTextAboutPost(String text) {
		element(createPostObjects.writeSomethingAbtPost).sendKeys(text);
	}
	
	public void submitPost() {
		hardWait(2);
		createPostObjects.tickIconCreatePost.click();
	}
	
	public void selectTagForPost() {
		element(createPostObjects.tagsToSelect).click();
	}

	public boolean checkPostUploadingText(){
		return deviceHelper.isElementPresent(element(createPostObjects.uploadMsgAlert));
	}

	public void openCamera() {
		element(createPostObjects.slectCameraPost).click();
	}

	public void clickPicture() {
		element(createPostObjects.clickPicBtn).click();
	}

	public void uploadPost() {
		createPostObjects.uploadFromGalaryBtn.click();
	}

	public void createPollPost() {
		element(createPostObjects.createPoll).click();
	}

	public void enterInPollOptions(String[] options) {
		for(byte i =0; i < options.length; i++)
			createPostObjects.pollOptions.get(i).sendKeys(options[i]);
	}

	public void clickWithouBGBtn(){
		element(createPostObjects.withoutBGBtn).click();
	}

	public void clickCameraBtnOnTextPost(){
		createPostObjects.camerBtnOnTextPost.get(1).click();
	}

	public void cropPictureOk() {
		element(createPostObjects.cropOkBtnOnCamera).click();
	}

	public boolean isPostUploaded(int timeInSecs){

		hardWait(timeInSecs);
		deviceHelper.swipe(400, 0, 400, 800);
		return deviceHelper.isElementPresent(element(createPostObjects.uploadedNotification));
	}

	public void hardWait(int timeInSecs){
		try {
			Thread.sleep(timeInSecs*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
