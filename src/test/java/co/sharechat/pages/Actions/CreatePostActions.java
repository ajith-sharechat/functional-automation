package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.CreatePostObjects;
import co.sharechat.pages.Objects.SignUpPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 This Class has all the actions related to the create Pots(Text/Camera/Upload/Poll)
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
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

	//===========================Text Post Screen Actions==================================
	public void textCompose() {
		element(createPostObjects.createText).click();
	}
	
	public void writeTextofTextPost(String text) {
		element(createPostObjects.writeTextInCreateTextPost).sendKeys(text);
	}
	
	public void submitTextForTextPost() {
		createPostObjects.tickIconTextCompose.click();
	}

	public boolean isTickMarkOnTextPostDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.tickIconTextCompose);
	}

	public boolean isCrossMarkOnTextPostDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.crossIconTextCompose);
	}

	public boolean isTextBoldDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.textBoldBtn);
	}

	public boolean isFontColorBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.fontColorBtn);
	}

	public boolean isFontBGBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.fontBGColorBtn);
	}

	public boolean isTextFieldToWriteTextDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.writeTextTextField);
	}

	public boolean iswithoutBGBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.withoutBGBtn);
	}

	public boolean iscameraIconPicturepickGalaryPostDisplayed() {
		return createPostObjects.cameraBtnOnTextPost.size() >= 2;
	}

	public int noOfBottomTabsDisplayed() {

		hardWait(1);
		if (createPostObjects.tabs.size() > 6){
			System.out.println("===========================Done==================================");
			return createPostObjects.tabs.size();
		}


		if (createPostObjects.bottomTabsinTextPost.size()==0)
			hardWait(2);
		if (createPostObjects.bottomTabsinTextPost.size()==0)
			return 0;
		int y = createPostObjects.bottomTabsinTextPost.get(0).getCenter().y;
		int startx = deviceHelper.getWidthOfScreen() - 50;

		Set<String> text_Set = new HashSet<>();

		for (MobileElement box : createPostObjects.bottomTabsinTextPost) {
			text_Set.add(box.getAttribute("content-desc"));
		}

		deviceHelper.swipe(startx, y, 100, y);

		for (MobileElement box : createPostObjects.bottomTabsinTextPost) {
			text_Set.add(box.getAttribute("content-desc"));
		}

		deviceHelper.swipe(startx, y, 50, y);

		for (MobileElement box : createPostObjects.bottomTabsinTextPost) {
			text_Set.add(box.getAttribute("content-desc"));
		}
		return text_Set.size();
	}

	public void clickOnCrossbtn(){
		createPostObjects.crossIconTextCompose.click();
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
		createPostObjects.cameraBtnOnTextPost.get(1).click();
	}

	public void cropPictureOk() {
		element(createPostObjects.cropOkBtnOnCamera).click();
	}


	//Alert Actions

	public boolean isAlertMessageByApplicationIsDisplayed(){
		return deviceHelper.isElementPresent(createPostObjects.alertGeneratedByApplication);
	}

	public boolean istextOnAlertDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertaMessageText);
	}

	public boolean isNotNowBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertDismissBtn);
	}

	public boolean isYesBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertAcceptBtn);
	}

	public void clickYesOnAlert() {
		createPostObjects.alertAcceptBtn.click();
	}

	public boolean isPostUploaded(int timeInSecs){

		hardWait(timeInSecs);
		deviceHelper.swipe(400, 0, 400, 1000);
		boolean notification =  deviceHelper.isElementPresent(element(createPostObjects.uploadedNotification));
		deviceHelper.swipe(400, deviceHelper.getHeightOfScreen()-300, 400, 10);
		//deviceHelper.clickHomeBtn();
		return notification;
	}

	public void hardWait(int timeInSecs){
		try {
			Thread.sleep(timeInSecs*1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
