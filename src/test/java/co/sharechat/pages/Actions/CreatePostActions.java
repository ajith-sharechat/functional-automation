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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
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

	public void clickOnExploreBtn() {
		createPostObjects.exploreBTN.click();
	}

	public void clickOnPostOptionsBTN() {
		createPostObjects.postOptionsBTN.click();
	}

	public void clickOnLinkCopyBTN() {
		createPostObjects.postShareOptions.get(0).click();
	}

	public void clickOnPostsUserProfileBTN() {
		createPostObjects.userProfilelinkOnPostsScreen.get(0).click();
	}

	public void clickOnFirstTagInTrendingTags() {
		createPostObjects.trendingTagsOnTrendingScreen.get(0).click();
	}

	public void clickOnShareBTNOnTagPostsScreen() {
		createPostObjects.shareBTnOnTagRelatedPostsScreen.click();
	}

	public void clickOnShareBTNOnProfileScreen() {
		createPostObjects.shareBTnOnUsersProfileScreen.click();
	}

	public void clickOnShareWithShareChatOption() {
		createPostObjects.shareWithShareChatOption.click();
	}

	public Set<String> getAllTrendingBuckets(){
		Set<String> buckets = new HashSet<String>();
		int initialSize ,finalSize ;
		do {;
			initialSize = buckets.size();
			for (MobileElement box : createPostObjects.bucktNamesOnExplorePage) {
				buckets.add(box.getText());
			}
			finalSize = buckets.size();
			int x = (int) (deviceHelper.getWidthOfScreen() / 2);
			int starty = deviceHelper.getHeightOfScreen() - 300;
			deviceHelper.swipe(x, starty, x, 800);
		}while (initialSize != finalSize);

		return buckets;
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

	public boolean isLinkPerviewDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.linkPreview);
	}

	public boolean isRepostPerviewDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.repostPreview);
	}

	public boolean iscameraIconPicturepickGalaryPostDisplayed() {
		return createPostObjects.cameraBtnOnTextPost.size() >= 2;
	}

	public void selectGalaryPickForBG() {
		createPostObjects.cameraBtnOnTextPost.get(2).click();
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

	public void clickOnColorTabInTextPost(){
		createPostObjects.selectColor.click();
	}

	public void clickOnShareChatCultureTabInTextPost(){
		createPostObjects.selectShareChatCulture.click();
	}

	public void clickOnAnyColorTabInBGTextPost(){
		createPostObjects.BGcolorTabs.get(1).click();
	}

	public void clickOnCrossbtn(){
		createPostObjects.crossIconTextCompose.click();
	}

	public void writeTextAboutPost(String text) {
		element(createPostObjects.writeSomethingAbtPost).sendKeys(text);
	}

	public void enterCopiedLink() {
		element(createPostObjects.writeSomethingAbtPost).sendKeys(deviceHelper.getCopiedText()+"  ");
	}

	public String getTextAboutPost() {
		return createPostObjects.writeSomethingAbtPost.getText();
	}
	
	public void submitPost() {
		hardWait(2);
		createPostObjects.tickIconCreatePost.click();
	}
	
	public void selectTagForPost() {
		element(createPostObjects.tagsToSelect).click();
	}

	public void serchForTag(String tagName) {
		element(createPostObjects.searchTagTextBox).sendKeys(tagName);
	}

	public void clickCreateTagBTN() {
		element(createPostObjects.createTagBTN).click();
	}

	public void createUniqueNewTag(String tagName) {
		serchForTag(tagName+ deviceHelper.generateRandomPhNo(6));
	}

	public void selectBucketForNewTag(){
		createPostObjects.newTagBucketsRadioBtns.get(0).click();
	}

	public void submitNewTag(){
		createPostObjects.submitNewTagBTN.click();
	}

	public void select3rdTagForPost() {
		element(createPostObjects.tagsListToSelect.get(2)).click();
	}

	public String getTagUsed() {
		return createPostObjects.tagsToSelect.getText();
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

	public void clickAddTagBTN() {
		element(createPostObjects.addTagBtn).click();
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

	public Set<String> getAllTrendingBucketsOnPost(){
		Set<String> buckets = new HashSet<String>();
		int initialSize ,finalSize ;
		do {;
			initialSize = buckets.size();
			for (MobileElement box : createPostObjects.bucketNames) {
				buckets.add(box.getText());
			}
			finalSize = buckets.size();
			int x = (int) (deviceHelper.getWidthOfScreen() / 2);
			int starty = deviceHelper.getHeightOfScreen() - 200;
			deviceHelper.swipe(x, starty, x, 1100);
		}while (initialSize != finalSize);

		return buckets;
	}

	public boolean checkTrendingBucketInTagBuckets() {
		for (MobileElement bucket: createPostObjects.bucketNames) {
			if(bucket.getText().contains("trends"))
				return true;
		}
		deviceHelper.swipe(500, 1600, 500, 1400);// Little swipe
		for (MobileElement bucket: createPostObjects.bucketNames) {
			if(bucket.getText().contains("trends"))
				return true;
		}
		return false;
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
		deviceHelper.openNotification();
		boolean notification =  deviceHelper.isElementPresent(createPostObjects.uploadedNotification);
		deviceHelper.clickBackBtn();
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
