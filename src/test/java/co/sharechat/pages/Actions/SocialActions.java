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
    static PrivacySettingObjects privacyObjects = new PrivacySettingObjects();
    static NotificationSettingsObjects notificationObjects = new NotificationSettingsObjects();

    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

    public HomePageActions getHomePageActionsInstance(){

        return new HomePageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public ChatPageActions getChatPageActionsInstance(){

        return new ChatPageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public SignUp getSignUpInstance(){

        return new SignUp(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

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
        PageFactory.initElements(new AppiumFieldDecorator(driver), privacyObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), notificationObjects);
        this.runnerInfo = runnerInfo;
    }

    public void appLoginInitializationAndVerifyHomeScreenElements(String registerNumber, String otp){
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickGoToYourAccountButton();
        getHomePageActionsInstance().tapAllowButton();
        getHomePageActionsInstance().tapAllowButton();
        getHomePageActionsInstance().tapAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElements();
    }

    public void  tapPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.profileChatIcon);
        postUserObjects.profileChatIcon.click();
    }

    public void  verifyPostUserChatScreenElements(){
        deviceHelper.waitForElementToAppear(postUserObjects.postUserMessageField);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.backIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserNameLabel);
    }

    public void  verifySendMessageFunctionality(){
        deviceHelper.waitForElementToAppear(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        postUserObjects.sendMessageIcon.click();
        if(deviceHelper.isElementDisplay(chatPageObjects.playPauseButton)){
            deviceHelper.waitTillTheElementIsVisible(chatPageObjects.playPauseButton);

        }else {
            deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
        }
    }

    public void  tapLongPressSendAudioIcon(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendMessageIcon);
        deviceHelper.longPress(postUserObjects.sendMessageIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.sendMessageIcon);
        postUserObjects.sendMessageIcon.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
    }

    public void  tapBackButton(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postUserObjects.backIcon)==true) {
            deviceHelper.isElementPresentAssertTrue(postUserObjects.backIcon);
            postUserObjects.backIcon.click();
        }
    }

    public void  verifyPostUserChatInitiatingFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String userProfileName=homePostObjects.userProfileLink.getText();
        getHomePageActionsInstance().tapUserProfileLink();
        tapPostUserChatIcon();
        verifyPostUserChatScreenElements(); //Change to verifyPostUserChatScreenElements
        verifySendMessageFunctionality();
        /**Navigating to profile screen
         */
        tapBackButton();
        /**Navigating to Home screen
         */
        tapBackButton();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileBackButton);
        postUserObjects.postUserProfileBackButton.click();
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements(); //Change to verifyChatScreenElements
        String recentKnownUserName=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(recentKnownUserName.toLowerCase().trim(), userProfileName.toLowerCase().trim());
    }

    public void backToHomeScreen(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postUserObjects.backIcon)==true){
            postUserObjects.backIcon.click();
        }
        else {
            getHomePageActionsInstance().tapHomeIcon();
        }

    }
    public void verifyCommentScreenElements(){
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
                deviceHelper.tapAndroidBackButton();
                deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
                deviceHelper.swipeUp();
                deviceHelper.scrollToMobileElement(homePostObjects.postCommentIcon, "3");
                getHomePageActionsInstance().tapPostCommentIcon();
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
    public void  verifyCommentedUserProfileName(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
        String commentUserNameText=commentsObjects.commentUserProfileName.getText();
        commentsObjects.commentUserProfileName.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.profileChatIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserprofileDisplayName);
        String profileUserNameText=postUserObjects.postUserprofileDisplayName.getText();
        Assert.assertEquals(commentUserNameText.toLowerCase().trim(), profileUserNameText.toLowerCase().trim());
    }
    public void  tapPostCommentIcon(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.postCommentIcon);
        homePostObjects.postCommentIcon.click();
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewLikeSection);
    }
    public void  tapPostPreviewLikeSection(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewLikeSection);
        commentsObjects.commentPreviewLikeSection.click();
        if(deviceHelper.isElementDisplay(commentsObjects.commentPreviewUserFollowLink)) {
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
        }
        else{
            deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserUnfollowLink);
        }
    }
    public void  verifyProfileScreenElements(){
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
    public void  tapAddFriendIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.addFriendIcon);
        profileObjects.addFriendIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
    }
    public void  verifyPhoneContactsScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.phoneContactsLabel);
        deviceHelper.isElementPresentAssertTrue(profileObjects.connectSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.inviteSection);
        deviceHelper.isElementPresentAssertTrue(commentsObjects.commentPreviewUserFollowLink);
    }
    public void  tapFollowLink(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserFollowLink);
        commentsObjects.commentPreviewUserFollowLink.click();
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserUnfollowLink);
    }
    public void  tapUnfollowLink(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentPreviewUserUnfollowLink);
        commentsObjects.commentPreviewUserUnfollowLink.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileFollowingButton);
    }
    public void  tapFollowingButtonAndTapConfirmToUnfollow(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserProfileFollowingButton);
        postUserObjects.postUserProfileFollowingButton.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserUnfollowingPopupQuestion);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserUnfollowingPopupYes);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.postUserUnfollowingPopupNo);
        postUserObjects.postUserUnfollowingPopupYes.click();
        deviceHelper.tapAndroidBackButton();
        deviceHelper.waitInSec(3);
        if(deviceHelper.isElementDisplay(profileObjects.inviteSection)==false) {
            deviceHelper.tapAndroidBackButton();
        }
    }
    public void  tapInviteSection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteSection);
        profileObjects.inviteSection.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteButton);
    }
    public void  tapInviteButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.inviteButton);
        profileObjects.inviteButton.click();
        deviceHelper.waitInSec(10);
        deviceHelper.isElementNotPresentAssertTrue(profileObjects.inviteButton);
    }
    public void  tapShareIconInPhoneContactsScreen(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.shareIconInPhoneContacts);
        profileObjects.shareIconInPhoneContacts.click();
        deviceHelper.isElementNotPresentAssertTrue(profileObjects.shareIconInPhoneContacts);
    }
    public void  verifyWhatsAppWelcomeScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.whatsAppAgreeAndContinueButton);
    }
    public void  tapShareIconInProfileScreen(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.shareIcon);
        profileObjects.shareIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
    }
    public void  verifySelectAppPopupAndTapWhatsAppIcon(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.selectAppToShareTitle);
        deviceHelper.isElementPresentAssertTrue(messengerAppObjects.whatsAppIconTitleNamePopupScreen);
        messengerAppObjects.whatsAppIconTitleNamePopupScreen.click();
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
        deviceHelper.isElementNotPresentAssertTrue(messengerAppObjects.whatsAppIconTitleNamePopupScreen);
    }
    public void  tapSettingIconInProfileScreen(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.settingIcon);
        profileObjects.settingIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.profileSettingTitle);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.profileSettingTitle);
    }
    public void  verifyProfileSettingScreenElements(){
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
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.logoutIcon);
    }
    public void  tapEditProfileButton(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileEditButton);
        profileObjects.profileEditButton.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.changeButtonBackgroundImageInEditScreen);
    }
    public void  verifyEditProfileScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.changeButtonBackgroundImageInEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.changeButtonBackgroundImageInEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.profilePicEditScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.saveChangeButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.editButton);
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
    public void  tapProfileCameraIcon(){
        deviceHelper.isElementPresentAssertTrue(profileObjects.profileCameraIconEditScreen);
        profileObjects.profileCameraIconEditScreen.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
    }
    public void  verifyProfilePicScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
        deviceHelper.isElementPresentAssertTrue(profileObjects.closeIconProfilePicScreen);
        deviceHelper.isElementPresentAssertTrue(profileObjects.cameraIconChoosePicOption);
    }
    public void  tapGalleryIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryIconChoosePicOption);
        profileObjects.galleryIconChoosePicOption.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.galleryOptionCompleteActionUsingLabel);
    }
    public void  tapCameraIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraIconChoosePicOption);
        profileObjects.cameraIconChoosePicOption.click();
        getHomePageActionsInstance().tapAllowButton();
        getHomePageActionsInstance().tapAllowButton();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureButton);
    }
    public void  tapCameraCaptureButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureButton);
        profileObjects.cameraCaptureButton.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureImageSaveIcon);
    }
    public void  tapCameraCaptureSaveButton(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cameraCaptureImageSaveIcon);
        profileObjects.cameraCaptureImageSaveIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.saveChangeButton);
    }
    public void  tapChangeButtonInProfileEditScreen(){
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
    public void  tapShareChatMessages(){
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.shareChatMessagesIconInSharePopup);
        messengerAppObjects.shareChatMessagesIconInSharePopup.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sharePostWithTitle);
    }
    public void  tapSendButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendButtonSharePostWithScreen);
        postUserObjects.sendButtonSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gotoIconSharePostWithScreen);
    }
    public void  tapGotoButtonInSharePostWith(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gotoIconSharePostWithScreen);
        postUserObjects.gotoIconSharePostWithScreen.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserNameLabel);
    }
    public void  getRecentMessageSendElement(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessagePosted);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.recentMessageInChatBox);
//        postuserObjects.recentMessageInChatBox.getText();
    }
    public void tapRecentMessageLink(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.recentMessageInChatBox);
        postUserObjects.recentMessageInChatBox.click();
    }
    public void  verifySharingPostFunctionalityToKnownUser() {
        getHomePageActionsInstance().scrollTillPostImageAndTapPostImage();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String postedUserNameInHomeScreen=homePostObjects.userProfileLink.getText();
        getHomePageActionsInstance().tapPostImageOptionOnTopRightCorner();
        verifySharePopupElements();
        tapShareChatMessages();
        tapSendButtonInSharePostWith();
        tapGotoButtonInSharePostWith();
        getRecentMessageSendElement();
        tapRecentMessageLink();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String postedUserNameInChatScreen=homePostObjects.userProfileLink.getText();
        Assert.assertEquals(postedUserNameInHomeScreen.toLowerCase().trim(), postedUserNameInChatScreen.toLowerCase().trim());
    }
    public void  verifyPostPreviewScreenElements(){
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
    public void tapPostTagLink(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        postUserObjects.postTagLink.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.TagFeedTitle);
    }
    public void  verifyHashTagLabelAndHashTagFeedTitle(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        String hashTagLink=postUserObjects.postTagLink.getText();
        String[] hashTag =hashTagLink.split("#");
        String hashTag1 = hashTag[1];
        tapPostTagLink();
        String tagFeedTitleLabel=postUserObjects.TagFeedTitle.getText();
        Assert.assertEquals(hashTag1.toLowerCase().trim(),tagFeedTitleLabel.toLowerCase().trim());
    }
    public void scrollToWhatsAppIconAndTapInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.whatsAppIconInPost, "20");
        postUserObjects.whatsAppIconInPost.click();
        deviceHelper.waitTillTheElementIsVisible(messengerAppObjects.welcomeWhatsAppLabel);
    }
    public void scrollToCommentIconAndTapInPost(){
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
    public void scrollToRepostIconAndTapInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.rePostIconInPost, "20");
        postUserObjects.rePostIconInPost.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.createPostLabel);
    }
    public void verifyCreatePostScreenElements(){
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
    public void scrollToAudioPostAndTap(){
        deviceHelper.scrollToMobileElement(postUserObjects.playMusicButtonOrPauseButtonForAudioPosts, "20");
        postUserObjects.playMusicButtonOrPauseButtonForAudioPosts.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.audioExoProgress);
    }
    public void tapPauseButton(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.playMusicButtonOrPauseButtonForAudioPosts);
        postUserObjects.playMusicButtonOrPauseButtonForAudioPosts.click();
    }
    public void scrollToGIFPostAndTapInPost(){
        deviceHelper.scrollToMobileElement(postUserObjects.gifPost, "20");
        postUserObjects.gifPostFrameViewLayout.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gifButtonInPost);
    }
    public void tapGIFButton(){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.gifButtonInPost);
        if(deviceHelper.isElementPresent(postUserObjects.gifButtonInPost)==true){
        postUserObjects.gifButtonInPost.click();
        }
        else{
            deviceHelper.swipeUp();
            postUserObjects.gifButtonInPost.click();
        }
        deviceHelper.isElementNotPresentAssertTrue(postUserObjects.gifButtonInPost);
    }

    public void tapGallerySection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.gallerySection);
        profileObjects.gallerySection.click();
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
    }

    public void tapStickerSection(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.profileStickersSection);
        profileObjects.profileStickersSection.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.stickerImage);
    }
    public void tapStickerImage(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.stickerImage);
        profileObjects.stickerImage.click();
        deviceHelper.isElementNotPresentAssertTrue(profileObjects.stickerDeleteIcon);
    }

    public void tapStickerDownloadIcon(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.stickerDownloadIcon);
        profileObjects.stickerDownloadIcon.click();
    }

    public void tapMyPostSection(){
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
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postTagLink);
        postUserObjects.postHashTagLink.click();
        postUserObjects.postHashTagLink.click();
        deviceHelper.waitInSec(5);
        String tagFeedTitleLabel=postUserObjects.TagFeedTitle.getText();
        Assert.assertEquals(hashTag1.toLowerCase().trim(),tagFeedTitleLabel.toLowerCase().trim());
    }
    public void verifyUploadingRePostFunctionalityInGallery() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postRightIcon);
        String createPostHashTagTextMessage=postUserObjects.createPostTextField.getText();
        postUserObjects.postRightIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.myPostsSection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.gallerySection);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickersSection);
        tapMyPostSection();
        String myPostHashTagText=deviceHelper.generateTextXpathAndReturnText(createPostHashTagTextMessage);
        Assert.assertEquals(createPostHashTagTextMessage.toLowerCase().trim(), myPostHashTagText.toLowerCase().trim());

    }
    public void verifyPopupElements(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.cancelPopupButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.addPopupButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickerToAddWhatsAppPopupQuestion);
        profileObjects.cancelPopupButton.click();
    }
    public void verifyStickerScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(profileObjects.stickers);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickerSaveButton);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickerDeleteIcon);
        deviceHelper.isElementPresentAssertTrue(profileObjects.stickerTitleLabel);
        deviceHelper.isElementPresentAssertTrue(profileObjects.toolBarBack);
    }

    public void  tapChangeLanguageModeDropDown(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.changeLanguageModeOption);
        profileSettingObjects.changeLanguageModeOption.click();
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.changeLanguageModePopupTitle);
    }
    public void verifyLanguageModePopupElements(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.changeLanguageModePopupTitle);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.defaultRadioButton);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.englishRadioButton);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.hinglishRadioButton);
    }
    public void  tapEnglishRadioButton(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.englishRadioButton);
        profileSettingObjects.englishRadioButton.click();
        deviceHelper.waitInSec(9);
    }
    public void  tapHinglishRadioButton(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.hinglishRadioButton);
        profileSettingObjects.hinglishRadioButton.click();
        deviceHelper.waitInSec(9);
    }
    public void  tapDefaultRadioButton(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.defaultRadioButton);
        profileSettingObjects.defaultRadioButton.click();
        deviceHelper.waitInSec(9);
    }
    public void verifyLanguageModeFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.changeLanguageModeOption);
        String changeLanguageModeDropDown=profileSettingObjects.changeLanguageModeOption.getText();
        profileSettingObjects.changeLanguageModeOption.click();
        verifyLanguageModePopupElements();
        String changeLanguageModePopupTitle=profileSettingObjects.changeLanguageModePopupTitle.getText();
        Assert.assertEquals(changeLanguageModePopupTitle.toLowerCase().trim(), changeLanguageModeDropDown.toLowerCase().trim());
    }
    public void  verifyDataSaverFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.dataSaverSwitch);
        profileSettingObjects.dataSaverSwitch.click();
        deviceHelper.tapAndroidBackButton();
        homePostObjects.homeIcon.click();
        homePostObjects.homeIcon.click();
        deviceHelper.scrollToMobileElement(homePostObjects.postImageDownloadIcon,"20");
        deviceHelper.isElementPresentAssertTrue(homePostObjects.postImage);
    }
    public void  verifyPostDownloadSwitchFunctionality(){
        tapChangeLanguageModeDropDown();
        verifyLanguageModePopupElements();
        tapEnglishRadioButton();
        deviceHelper.waitInSec(5);
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.postDownloadSwitch);
        String galleryDescriptionOffLabel=profileSettingObjects.galleryDescriptionSubTitle.getText();
        Assert.assertEquals(galleryDescriptionOffLabel.toLowerCase().trim(), "Saving download files to ShareChat-Media is OFF".toLowerCase().trim());
        profileSettingObjects.postDownloadSwitch.click();
        deviceHelper.waitInSec(3);
        String galleryDescriptionOnLabel=profileSettingObjects.galleryDescriptionSubTitle.getText();
        Assert.assertEquals(galleryDescriptionOnLabel.toLowerCase().trim(), "Saving download files to ShareChat-Media is ON".toLowerCase().trim());
    }
    public void  tapAccountSettngs(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.accountSettings);;
        profileSettingObjects.accountSettings.click();
    }
    public void  verifyLogoutFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.logoutIcon);
        profileSettingObjects.logoutIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.logoutPopupMessageLabel);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.logoutPopupNo);
        deviceHelper.isElementPresentAssertTrue(profileSettingObjects.logoutPopupYes);
        profileSettingObjects.logoutPopupYes.click();
        deviceHelper.waitTillTheElementIsVisible(signUpObjects.selectLanguageTitle);
    }
    public void verifyPrivacySettingsScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(privacyObjects.privacySettingTitle);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowerList);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowerDescription);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowerIcon);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowingList);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowingDescription);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyFollowingIcon);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyTagList);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyTagDescription);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyTagIcon);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyBlockTitle);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyBlockDescription);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.privacyBlockIcon);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.DeactivateYourAccountLabel);
        deviceHelper.isElementPresentAssertTrue(privacyObjects.DeactivateYourAccountIcon);
    }
    public void  tapPrivacySettngs(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.privacySettings);;
        profileSettingObjects.privacySettings.click();
        deviceHelper.waitTillTheElementIsVisible(privacyObjects.privacySettingTitle);
    }
    public void  tapNotificationSettngs(){
        deviceHelper.waitTillTheElementIsVisible(profileSettingObjects.notificationSettings);;
        profileSettingObjects.notificationSettings.click();
        deviceHelper.waitTillTheElementIsVisible(notificationObjects.notificationSettingTitle);
    }
    public void verifyNotificationSettingsScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(notificationObjects.notificationSettingTitle);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.notificationFollowIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.followNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.followNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.notificationLikeIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.notificationLikeLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.likeNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.notificationShareIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.shareNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.shareNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.notificationCommentIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.commentNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.commentNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.feedNotificationIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.feedNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.feedNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.chatNotificationIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.chatNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.chatNotificationSwitchButton);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.repostNotificationIcon);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.repostNotificationLabel);
        deviceHelper.isElementPresentAssertTrue(notificationObjects.repostNotificationSwitchButton);
    }
    public void  tapExploreIcon(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.searchIcon);;
        homePostObjects.searchIcon.click();
        deviceHelper.waitTillTheElementIsVisible(privacyObjects.privacySettingTitle);
    }
}
