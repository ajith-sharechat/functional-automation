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
    static PostUserProfileObjects postUserObjects = new PostUserProfileObjects();
    static CommetsPageObjects commentsObjects = new CommetsPageObjects();
    static ProfilePageObjects profileObjects = new ProfilePageObjects();
    static ProfileSettingPageObjects profileSettingObjects = new ProfileSettingPageObjects();
    static MessengerAppPageObjects messengerAppObjects = new MessengerAppPageObjects();
    static SignUpPageObjects signUpObjects = new SignUpPageObjects();
    static loginPageObjects loginObjects = new loginPageObjects();
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
        PageFactory.initElements(new AppiumFieldDecorator(driver), postUserObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), commentsObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileSettingObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), messengerAppObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        this.runnerInfo = runnerInfo;
    }

    public void  clickPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.profileChatIcon);
        postUserObjects.profileChatIcon.click();
    }

    public void  verifyPostUserchatscreen(){
        deviceHelper.waitForElementToAppear(postUserObjects.postUserMessageField);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.backIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserNameLabel);
    }

    public void  clickSendMessageIcon(){
        deviceHelper.waitForElementToAppear(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        postUserObjects.sendMessageIcon.click();
        if(deviceHelper.isElementDisplay(chatPageObjects.playPauseButton)){
            deviceHelper.waitTillTheElementIsVisible(chatPageObjects.playPauseButton);

        }else {
            deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
        }
    }

    public void  clickLongPressSendAudioIcon(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendMessageIcon);
        deviceHelper.longPress(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        postUserObjects.sendMessageIcon.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
    }

    public void  clickBackButton(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postUserObjects.backIcon)==true) {
            deviceHelper.isElementPresentAssertTrue(postUserObjects.backIcon);
            postUserObjects.backIcon.click();
        }
    }

    public void  verifyPostUserChatInitiatingFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String userProfileName=homePostObjects.userProfileLink.getText();
        getHomePageActionsInstance().clickUserProfileLink();
        clickPostUserChatIcon();
        verifyPostUserchatscreen();
        clickSendMessageIcon();
        clickBackButton();
        clickBackButton();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileBackButton);
        postUserObjects.postUserProfileBackButton.click();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        String recentKnownUserName=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(recentKnownUserName.toLowerCase(), userProfileName.toLowerCase());
    }

    public void backToHomeScreen(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postUserObjects.backIcon)==true){
            postUserObjects.backIcon.click();
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
        String commentUserNameText=commentsObjects.commentUserProfileName.getText();
        commentsObjects.commentUserProfileName.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.profileChatIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserprofileDisplayName);
        String profileUserNameText=postUserObjects.postUserprofileDisplayName.getText();
        Assert.assertEquals(commentUserNameText.toLowerCase(), profileUserNameText.toLowerCase());
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
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileFollowingButton);
    }
    public void  clickFollowingButtonAndClickConfirmToUnfollow(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileFollowingButton);
        postUserObjects.postUserProfileFollowingButton.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserUnfollowingPopupQuestion);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserUnfollowingPopupYes);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserUnfollowingPopupNo);
        postUserObjects.postUserUnfollowingPopupYes.click();
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
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.whatsAppAgreeAndContinueButton);
    }
    public void  clickShareIconInProfileScreen(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.shareIcon);
        profileObjects.shareIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
    }
    public void  verifySelectAppPopupAndClickWhatAppIcon(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.whatsAppIconTitleNamePopupScreen);
        messengerAppObjects.whatsAppIconTitleNamePopupScreen.click();
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementNotPresentAssertTrue(messengerAppObjects.whatsAppIconTitleNamePopupScreen);
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
        deviceHelper.isElementPresentAssertTrue(profileObjects.fullNameTextField);
        deviceHelper.isElementPresentAssertTrue(profileObjects.handleTextField);
        deviceHelper.isElementPresentAssertTrue(profileObjects.bioTextField);
        deviceHelper.scrollToMobileElement(profileObjects.mobileNumberTextField, "5");
        deviceHelper.isElementPresentAssertTrue(profileObjects.birthdayTextField);
        deviceHelper.isElementPresentAssertTrue(profileObjects.locationTextField);
        deviceHelper.isElementPresentAssertTrue(profileObjects.mobileNumberTextField);
        deviceHelper.isElementPresentAssertTrue(profileObjects.privateInformationLabel);
        deviceHelper.isElementPresentAssertTrue(profileObjects.privateInformationDescriptionLabel);
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
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.notificationsOffIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.notificationsOffIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.convertToStickerIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.shareChatMessagesIconInSharePopup);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.followIconInSharePopup);
    }
    public void  clickShareChatMessages(){
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.shareChatMessagesIconInSharePopup);
        messengerAppObjects.shareChatMessagesIconInSharePopup.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sharePostWithTitle);
    }
    public void  clickSendButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendButtonSharePostWithScreen);
        postUserObjects.sendButtonSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gotoIconSharePostWithScreen);
    }
    public void  clickGotoButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gotoIconSharePostWithScreen);
        postUserObjects.gotoIconSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserNameLabel);
    }
    public void  getRecentMessageSendElement(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.recentMessageInChatBox);
//        postuserObjects.recentMessageInChatBox.getText();
    }
    public void clickRecentMessageLink(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessageInChatBox);
        postUserObjects.recentMessageInChatBox.click();
    }
    public void  sharingPostFunctionalityToKnownUser() {
        getHomePageActionsInstance().scrollTillPostImageClickPostImage();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String postedUserNameInHomeScreen=homePostObjects.userProfileLink.getText();
        getHomePageActionsInstance().clickPostImageOptionTopRightCorner();
        verifySharePopupElements();
        clickShareChatMessages();
        clickSendButtonInSharePostWith();
        clickGotoButtonInSharePostWith();
        getRecentMessageSendElement();
        clickRecentMessageLink();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String postedUserNameInChatScreen=homePostObjects.userProfileLink.getText();
        Assert.assertEquals(postedUserNameInHomeScreen.toLowerCase(), postedUserNameInChatScreen.toLowerCase());
    }
    public void  verifyPostPreviewScreen(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postBioProfileStatusLabel);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postTagLink);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserProfielPic);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.createStickersIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.shareButtonInPostPreview);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.commentTextfield);
        deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPageSendCommentIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.postImage);
    }
    public void clickPostTagLink(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        postUserObjects.postTagLink.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.TagFeedTitle);
    }
    public void  verifyHashTagLabelAndHashTagFeedTitle(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        String hashTagLink=postUserObjects.postTagLink.getText();
        String[] hashTag =hashTagLink.split("#");
        String hashTag1 = hashTag[1];
        System.out.println("hashTag1================="+hashTag1);
        clickPostTagLink();
        String tagFeedTitleLabel=postUserObjects.TagFeedTitle.getText();
        System.out.println("tagFeedTitleLabel================="+tagFeedTitleLabel);
        Assert.assertEquals(hashTag1.toLowerCase().trim(),tagFeedTitleLabel.toLowerCase().trim());
    }
    public void scrollToWhatsAppIconAndClickInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.whatsAppIconInPost, "20");
        postUserObjects.whatsAppIconInPost.click();
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
    }
    public void scrollToCommentIconAndClickInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.commentIconInPost, "20");
        postUserObjects.commentIconInPost.click();
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentTextField);
    }
    public void enterCommentAndSend(String value){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentTextField);
        commentsObjects.commentTextField.sendKeys(value);
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPageSendCommentIcon);
        commentsObjects.commentPageSendCommentIcon.click();
    }
    public void scrollToRepostIconAndClickInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.rePostIconInPost, "20");
        postUserObjects.rePostIconInPost.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.createPostLabel);
    }
    public void verifyCreatePostScreen(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.createPostLabel);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postRightIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postButtonLabel);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.createPostTextField);
    }
    public void uploadingRePostFunctionalityInMyPost() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postRightIcon);
        postUserObjects.postRightIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.myPostsSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.gallerySection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickersSection);
        deviceHelper.scrollToMobileElementTopToBottom(profileObjects.rePostUserLabel,"20");
        deviceHelper.isElementPresentAssertTrue(profileObjects.rePostUserLabel);
    }
    public void verifyVideoIsPlayingOrNot() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.whatsAppIconInVideoPost);
        deviceHelper.isElementNotPresentAssertTrue(homePostObjects.postVideoPlayIcon);
    }
    public void scrollToAudioPostAndClick(){
        deviceHelper.scrollToMobileElement(postUserObjects.playMusicButtonOrPauseButtonForAudioPosts, "20");
        postUserObjects.playMusicButtonOrPauseButtonForAudioPosts.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.audioExoProgress);
    }
    public void clickPauseButton(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.playMusicButtonOrPauseButtonForAudioPosts);
        postUserObjects.playMusicButtonOrPauseButtonForAudioPosts.click();
    }
    public void scrollToGIFPostAndClickInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.gifPost, "20");
        postUserObjects.gifPostFrameViewLayout.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gifButtonInPost);
    }
    public void clickGIFButton(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gifButtonInPost);
        postUserObjects.gifButtonInPost.click();
        deviceHelper.isElementNotPresentAssertTrue(postUserObjects.gifButtonInPost);
    }

    public void clickGallerySection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.gallerySection);
        profileObjects.gallerySection.click();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
    }

    public void clickMyPostSection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.myPostsSection);
        profileObjects.myPostsSection.click();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        deviceHelper.waitInSec(10);
    }
    public void verifyHashTagFunctionalityOfPost(){
        deviceHelper.scrollToMobileElement(homePostObjects.userProfileLink, "20");
        deviceHelper.scrollToMobileElement(postUserObjects.postTagLink, "20");
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        String hashTagLink=postUserObjects.postTagLink.getText();
        String[] hashTag =hashTagLink.split("#");
        String hashTag1 = hashTag[1];
        System.out.println("hashTag1================="+hashTag1);
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        postUserObjects.postHashTagLink.click();
        postUserObjects.postHashTagLink.click();
        deviceHelper.waitInSec(5);
        String tagFeedTitleLabel=postUserObjects.TagFeedTitle.getText();
        System.out.println("tagFeedTitleLabel================="+tagFeedTitleLabel);
        Assert.assertEquals(hashTag1.toLowerCase().trim(),tagFeedTitleLabel.toLowerCase().trim());
    }
    public void verifyUploadingRePostFunctionalityInGallery() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postRightIcon);
        String createPostHashTagTextMessage=postUserObjects.createPostTextField.getText();
        postUserObjects.postRightIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.myPostsSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.gallerySection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickersSection);
        clickMyPostSection();
        String myPostHashTagText=deviceHelper.generateTextXpathAndReturnText(createPostHashTagTextMessage);
        Assert.assertEquals(createPostHashTagTextMessage.toLowerCase().trim(), myPostHashTagText.toLowerCase().trim());

    }

}
