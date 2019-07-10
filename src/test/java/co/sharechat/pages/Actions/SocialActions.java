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
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

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
    static ProfileSettingPageObjects profileSettingObjects = new ProfileSettingPageObjects();
    static MessengerAppPageObjects MessengerAppObjects = new MessengerAppPageObjects();
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
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileSettingObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), MessengerAppObjects);
        this.runnerInfo = runnerInfo;
    }

    public void  clickPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        postuserObjects.profileChatIcon.click();
    }

    public void  verifyPostUserchatscreen(){
        deviceHelper.waitForElementToAppear(postuserObjects.postUserMessageField);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.backIcon);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.postUserNameLabel);
    }

    public void  clickSendMessageIcon(){
        deviceHelper.waitForElementToAppear(postuserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.sendMessageIcon);
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
        deviceHelper.isElementPresentAssertTrue(postuserObjects.sendMessageIcon);
        postuserObjects.sendMessageIcon.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.recentMessagePosted);
    }

    public void  clickBackButton(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postuserObjects.backIcon)==true) {
            deviceHelper.isElementPresentAssertTrue(postuserObjects.backIcon);
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
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentSection);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.likeSection);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.trendTagIcon);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserProfileImage);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserTimeStamp);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserReplyIconAndCount);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserLikeIcon);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPageAudioRecordIcon);
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPageSendCommentIcon);

        }
        else {
            if(deviceHelper.isElementDisplay(commentsObjects.noCommentlabel)) {
                deviceHelper.isElementDisplay(commentsObjects.noCommentImage);
                deviceHelper.clickAndroidBackButton();
                deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
                deviceHelper.swipeUp();
                deviceHelper.scrollToMobileElement(homePostObjects.postCommentIcon, "3");
                getHomePageActionsInstance().clickPostCommentIcon();
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentSection);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.likeSection);
                deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserProfileImage);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserTimeStamp);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserReplyIconAndCount);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentUserLikeIcon);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPageAudioRecordIcon);
                deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPageSendCommentIcon);
            }

        }
    }
    public void  clickCommentUserProfile(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
        String commentUserNametext=commentsObjects.commentUserProfileName.getText();
        commentsObjects.commentUserProfileName.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.postUserprofileDisplayName);
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
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
        }
        else{
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserUnfollowLink);
        }
    }
    public void  verifyProfileScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.addFriendIcon);
        deviceHelper.isElementPresentAssertTrue(profileObjects.shareIcon);
        deviceHelper.isElementPresentAssertTrue(profileObjects.settingIcon);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profilePic);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileUserName);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileHandleLabel);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileEditButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileFollowerCount);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileFollowingCount);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profilePostCount);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileMyPostSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileStickersSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileGallerySection);
    }
    public void  clickAddFriendIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.addFriendIcon);
        profileObjects.addFriendIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
    }
    public void  verifyPhoneContactsScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
        deviceHelper.isElementPresentAssertTrue(profileObjects.connectSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.inviteSection);
        deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
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
        deviceHelper.isElementPresentAssertTrue(postuserObjects.postUserUnfollowingPopupYes);
        deviceHelper.isElementPresentAssertTrue(postuserObjects.postUserUnfollowingPopupNo);
        postuserObjects.postUserUnfollowingPopupYes.click();
        deviceHelper.clickAndroidBackButton();
        deviceHelper.waitInSec(3);
        if(deviceHelper.isElementDisplay(profileObjects.inviteSection)==false) {
            deviceHelper.clickAndroidBackButton();
        }
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
        deviceHelper.isElementNotPresentAssertTrue(profileObjects.inviteButton);
    }
    public void  clickShareIconInPhoneContactsScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.shareIconInPhoneContacts);
        profileObjects.shareIconInPhoneContacts.click();
        deviceHelper.isElementNotPresentAssertTrue(profileObjects.shareIconInPhoneContacts);
    }
    public void  verifyWhatAppWelcomeScreen(){
        deviceHelper.waitTillTheElementIsVisible(MessengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.whatsAppAgreeAndContinueButton);
    }
    public void  clickShareIconInProfileScreen(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.shareIcon);
        profileObjects.shareIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
    }
    public void  verifySelectAppPopupAndClickWhatAppIcon(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.whatsAppIconTitleNamePopupScreen);
        MessengerAppObjects.whatsAppIconTitleNamePopupScreen.click();
        deviceHelper.waitTillTheElementIsVisible(MessengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementNotPresentAssertTrue(MessengerAppObjects.whatsAppIconTitleNamePopupScreen);
    }
    public void  clickSettingIconInProfileScreen(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.settingIcon);
        profileObjects.settingIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.profileSettingTitle);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.profileSettingTitle);
    }
    public void  verifyProfileSettingScreen(){
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.profileSettingTitle);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.quickSettingSubtitle);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.changeLanguageModeOption);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.dataSaverOption);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.postDownloadOption);
        deviceHelper.scrollToMobileElement(profileSettingObjects.logoutIcon, "2");
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.accountSettings);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.privacySettings);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.notificationSettings);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.helpFeedbackSettings);
    }
    public void  clickEditProfileButton(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileEditButton);
        profileObjects.profileEditButton.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.changeButtonBackgroundImageInEditScreen);
    }
    public void  verifyEditProfileScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.changeButtonBackgroundImageInEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.changeButtonBackgroundImageInEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profilePicEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.saveChangeButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.coverPicEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileCameraIconEditScreen);
    }
    public void  clickProfileCameraIcon(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileCameraIconEditScreen);
        profileObjects.profileCameraIconEditScreen.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
    }
    public void  verifyProfilePicScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
        deviceHelper.isElementPresentAssertTrue(profileObjects.closeIconProfilePicScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.cameraIconChoosePicOption);
    }
    public void  clickGalleryIconChooseOption(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
        profileObjects.galleryIconChoosePicOption.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryOptionCompleteActionUsingLabel);
    }
    public void  clickCameraIconChooseOption(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraIconChoosePicOption);
        profileObjects.cameraIconChoosePicOption.click();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureButton);
    }
    public void  clickCameraCaptureButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureButton);
        profileObjects.cameraCaptureButton.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureImageSaveIcon);
    }
    public void  clickCameraCaptureSaveButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureImageSaveIcon);
        profileObjects.cameraCaptureImageSaveIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.saveChangeButton);
    }
    public void  clickChangeButtonProfileEditScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.changeButtonBackgroundImageInEditScreen);
        profileObjects.changeButtonBackgroundImageInEditScreen.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
    }
    public void  verifySharePopupElements(){
        deviceHelper.waitTillTheElementIsVisible(MessengerAppObjects.notificationsOffIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.notificationsOffIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.convertToStickerIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.shareChatMessagesIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(MessengerAppObjects.followIconInSharePopup);
    }
    public void  clickShareChatMessages(){
        deviceHelper.waitTillTheElementIsVisible(MessengerAppObjects.shareChatMessagesIconInSharePopup);
        MessengerAppObjects.shareChatMessagesIconInSharePopup.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.sharePostWithTitle);
    }
    public void  clickSendButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.sendButtonSharePostWithScreen);
        postuserObjects.sendButtonSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.gotoIconSharePostWithScreen);
    }
    public void  clickGotoButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.gotoIconSharePostWithScreen);
        postuserObjects.gotoIconSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserNameLabel);
    }
    public void  getRecentMessageSendElement(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.recentMessagePosted);
        deviceHelper.getCountOfElements(postuserObjects.recentMessagePosted);

//        postuserObjects.recentMessagePosted.getText();
    }
}
