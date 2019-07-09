package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.TestRunnerInfo;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.*;
import co.sharechat.test.SignUpTests;
import co.sharechat.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for social test cases common actions
 * Version: 1.0
 */
public class SocialActions extends WebDriverListener {
    DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static HomePageObjects homePostObjects= new HomePageObjects();
    static ChatPageObjects chatPageObjects= new ChatPageObjects();
    static UnknowUsersPageObjects unknownUserObjects = new UnknowUsersPageObjects();
    static PostUserProfileObjects postuserObjects = new PostUserProfileObjects();
    static CommetsPageObjects commentsObjects = new CommetsPageObjects();
    static ProfilePageObjects profileObjects = new ProfilePageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

    public HomePageActions getHomePageActionsInstance(){

        return new HomePageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public ChatPageActions getChatPageActionsInstance(){

        return new ChatPageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public SocialActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePostObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), postuserObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), commentsObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileObjects);
        this.runnerInfo = runnerInfo;
    }

    public void  clickPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        postuserObjects.profileChatIcon.click();
    }

    public void  verifyPostUserchatscreen(){
        deviceHelper.waitForElementToAppear(postuserObjects.postUserMessageField);
        deviceHelper.elementPresentAssertTrue(postuserObjects.sendMessageIcon);
        deviceHelper.elementPresentAssertTrue(postuserObjects.backIcon);
        deviceHelper.elementPresentAssertTrue(postuserObjects.postUserNameLabel);
    }

    public void  clickSendMessageIcon(){
        deviceHelper.waitForElementToAppear(postuserObjects.sendMessageIcon);
        deviceHelper.elementPresentAssertTrue(postuserObjects.sendMessageIcon);
        postuserObjects.sendMessageIcon.click();
        if(deviceHelper.isElementDisplay(chatPageObjects.playPauseButton)){
            deviceHelper.waitTillTheElementIsVisible(chatPageObjects.playPauseButton);

        }else {
            deviceHelper.waitTillTheElementIsVisible(postuserObjects.recentMessagePosted);
        }
    }

    public void  clickLongPressSendAudioIcon(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.sendMessageIcon);
        deviceHelper.longPress(postuserObjects.sendMessageIcon);
        deviceHelper.elementPresentAssertTrue(postuserObjects.sendMessageIcon);
        postuserObjects.sendMessageIcon.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.recentMessagePosted);
    }

    public void  clickBackButton(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postuserObjects.backIcon)==true) {
            deviceHelper.elementPresentAssertTrue(postuserObjects.backIcon);
            postuserObjects.backIcon.click();
        }
    }

    public void  verifyPostUserChatInitiatingFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String userprofileName=homePostObjects.userProfileLink.getText();
        getHomePageActionsInstance().clickUserProfileLink();
        clickPostUserChatIcon();
        verifyPostUserchatscreen();
        clickSendMessageIcon();
        clickBackButton();
        clickBackButton();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserProfileBackButton);
        postuserObjects.postUserProfileBackButton.click();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        String recentKnownUserName=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(recentKnownUserName.toLowerCase(), userprofileName.toLowerCase());
    }

    public void backToHomeScreen(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postuserObjects.backIcon)==true){
            postuserObjects.backIcon.click();
        }
        else {
            getHomePageActionsInstance().clickHomeIcon();
        }

    }
    public void verifyCommentScreen(){
        deviceHelper.waitInSec(9);
        if(deviceHelper.isElementDisplay(commentsObjects.commentUserProfileName)){
            deviceHelper.elementPresentAssertTrue(commentsObjects.trendTagIcon);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserProfileImage);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserTimeStamp);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserReplyIconAndCount);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserLikeIcon);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentPageAudioRecordIcon);
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentPageSendCommentIcon);
        }
        else {
            if(deviceHelper.isElementDisplay(commentsObjects.noCommentlabel)) {
                deviceHelper.isElementDisplay(commentsObjects.noCommentImage);
                deviceHelper.clickAndroidBackButton();
                deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
                deviceHelper.swipeUp();
                getHomePageActionsInstance().clickPostCommentIcon();
                deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserProfileImage);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserTimeStamp);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserReplyIconAndCount);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentUserLikeIcon);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentPageAudioRecordIcon);
                deviceHelper.elementPresentAssertTrue(commentsObjects.commentPageSendCommentIcon);
            }

        }
    }
    public void  clickCommentUserProfile(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
        String commentUserNametext=commentsObjects.commentUserProfileName.getText();
        commentsObjects.commentUserProfileName.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        deviceHelper.elementPresentAssertTrue(postuserObjects.postUserprofileDisplayName);
        String profileUserNametext=postuserObjects.postUserprofileDisplayName.getText();
        Assert.assertEquals(commentUserNametext.toLowerCase(), profileUserNametext.toLowerCase());
    }
    public void  clickPostCommentIcon(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.postCommentIcon);
        homePostObjects.postCommentIcon.click();
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewLikeSection);
    }
    public void  clickPostPreviewLikeSection(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewLikeSection);
        commentsObjects.commentPreviewLikeSection.click();
        if(deviceHelper.isElementDisplay(commentsObjects.commentPreviewUserFollowLink)) {
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
        }
        else{
            deviceHelper.elementPresentAssertTrue(commentsObjects.commentPreviewUserUnfollowLink);
        }
    }
    public void  verifyProfileScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.addFriendIcon);
        deviceHelper.elementPresentAssertTrue(profileObjects.shareIcon);
        deviceHelper.elementPresentAssertTrue(profileObjects.settingIcon);
        deviceHelper.elementPresentAssertTrue(profileObjects.profilePic);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileUserName);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileHandleLabel);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileEditButton);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileFollowerCount);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileFollowingCount);
        deviceHelper.elementPresentAssertTrue(profileObjects.profilePostCount);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileStickersSection);
        deviceHelper.elementPresentAssertTrue(profileObjects.profileGallerySection);
    }
    public void  clickAddFriendIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.addFriendIcon);
        profileObjects.addFriendIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
    }
    public void  verifyPhoneContactsScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
        deviceHelper.elementPresentAssertTrue(profileObjects.connectSection);
        deviceHelper.elementPresentAssertTrue(profileObjects.inviteSection);
        deviceHelper.elementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
    }
    public void  clickFollowLink(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserFollowLink);
        commentsObjects.commentPreviewUserFollowLink.click();
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserUnfollowLink);
    }
    public void  clickUnfollowLink(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserUnfollowLink);
        commentsObjects.commentPreviewUserUnfollowLink.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserProfileFollowingButton);
    }
    public void  clickFollowingButtonAndClickConfirmToUnfollow(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserProfileFollowingButton);
        postuserObjects.postUserProfileFollowingButton.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserUnfollowingPopupQuestion);
        deviceHelper.elementPresentAssertTrue(postuserObjects.postUserUnfollowingPopupYes);
        deviceHelper.elementPresentAssertTrue(postuserObjects.postUserUnfollowingPopupNo);
        postuserObjects.postUserUnfollowingPopupYes.click();
        deviceHelper.clickAndroidBackButton();
        deviceHelper.clickAndroidBackButton();
    }
    public void  clickInviteSection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteSection);
        profileObjects.inviteSection.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteButton);
    }
    public void  clickInviteButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteButton);
        profileObjects.inviteButton.click();
        deviceHelper.waitInSec(10);
        deviceHelper.elementNotPresentAssertTrue(profileObjects.inviteButton);
    }

}
