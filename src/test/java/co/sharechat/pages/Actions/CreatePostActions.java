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

	public void tapOnExploreButton() {
		createPostObjects.exploreBTN.click();
	}

	public void tapOnPostOptionsButton() {
		createPostObjects.postOptionsBTN.click();
	}

	public void tapOnLinkCopyButton() {
		createPostObjects.postShareOptions.get(0).click();
	}

	public void tapOnPostsUserProfileButton() {
		createPostObjects.userProfilelinkOnPostsScreen.get(0).click();
	}

	public void tapOnFirstTagInTrendingTags() {
		createPostObjects.trendingTagsOnTrendingScreen.get(0).click();
	}

	public void tapOnShareButtonOnTagPostsScreen() {
		createPostObjects.shareBTnOnTagRelatedPostsScreen.click();
	}

	public void tapOnShareButtonOnProfileScreen() {
		createPostObjects.shareBTnOnUsersProfileScreen.click();
	}

	public void tapOnShareWithShareChatOption() {
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

	public boolean isFontColorButtonDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.fontColorBtn);
	}

	public boolean isFontBGButtonDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.fontBGColorBtn);
	}

	public boolean isTextFieldToWriteTextDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.writeTextTextField);
	}

	public boolean isWithoutBGButtonDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.withoutBGBtn);
	}

	public boolean isLinkPreviewDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.linkPreview);
	}

	public boolean isRepostPreviewDisplayed() {
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

	public void tapOnColorTabInTextPost(){
		createPostObjects.selectColor.click();
	}

	public void tapOnShareChatCultureTabInTextPost(){
		createPostObjects.selectShareChatCulture.click();
	}

	public void tapOnAnyColorTabInBGTextPost(){
		createPostObjects.BGcolorTabs.get(1).click();
	}

	public void tapOnCrossbtn(){
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

	public void searchForTag(String tagName) {
		element(createPostObjects.searchTagTextBox).sendKeys(tagName);
	}

	public void tapCreateTagButton() {
		element(createPostObjects.createTagBTN).click();
	}

	public void createUniqueNewTag(String tagName) {
		searchForTag(tagName+ deviceHelper.generateRandomPhNo(6));
	}

	public void selectBucketForNewTag(){
		createPostObjects.newTagBucketsRadioBtns.get(0).click();
	}

	public void submitNewTag(){
		createPostObjects.submitNewTagBTN.click();
	}

	public String selectTagForPost(int whichTag) {
		for (byte i = 1; createPostObjects.tagsListToSelect.size() == 0 || i < 10; i++)
			hardWait(1);
		String tagName = createPostObjects.tagsListToSelect.get(whichTag - 1).getText();
		createPostObjects.tagsListToSelect.get(whichTag - 1).click();
		return tagName;
	}

	public String selectFriendForPost(int whichFriend) {
		for (byte i = 1; createPostObjects.nameOfFriends.size() == 0 || i < 10; i++)
			hardWait(1);
		String friendName = element(createPostObjects.nameOfFriends.get(whichFriend - 1)).getText();
		createPostObjects.nameOfFriends.get(whichFriend - 1).click();
		return friendName;
	}

	public void tapFollowingTabInAddFriend() {
		for (byte i = 1; createPostObjects.friendlistTabs.size() == 0 || i < 10; i++)
			hardWait(1);
		createPostObjects.nameOfFriends.get(1).click();
	}

	public void tapFollowersTabInAddFriend() {
		for (byte i = 1; createPostObjects.friendlistTabs.size() == 0 || i < 10; i++)
			hardWait(1);
		createPostObjects.nameOfFriends.get(2).click();
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

	public void tapAddTagButton() {
		element(createPostObjects.addTagBtn).click();
	}

	public void tapAddFriendButton() {
		element(createPostObjects.addFriendsBTN).click();
	}

	public void enterInPollOptions(String[] options) {
		for(byte i =0; i < options.length; i++)
			createPostObjects.pollOptions.get(i).sendKeys(options[i]);
	}

	public void tapWithouBGButton(){
		element(createPostObjects.withoutBGBtn).click();
	}

	public void tapCameraButtonOnTextPost(){
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

	public boolean isTextOnAlertDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertaMessageText);
	}

	public boolean isNotNowButtonDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertDismissBtn);
	}

	public boolean isYesBtnDisplayed() {
		return deviceHelper.isElementPresent(createPostObjects.alertAcceptBtn);
	}

	public void tapYesOnAlert() {
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
