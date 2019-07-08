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
        this.runnerInfo = runnerInfo;
    }

    public void  clickPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        postuserObjects.profileChatIcon.click();
    }

    public void  verifyPostUserchatscreen(){
        deviceHelper.waitForElementToAppear(postuserObjects.postUserMessageField);
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.sendMessageIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.backIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.postUserNameLabel));
    }

    public void  clickSendMessageIcon(){
        deviceHelper.waitForElementToAppear(postuserObjects.sendMessageIcon);
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.sendMessageIcon));
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
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.sendMessageIcon));
        postuserObjects.sendMessageIcon.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.recentMessagePosted);
    }

    public void  clickBackButton(){
        deviceHelper.waitInSec(2);
        if(deviceHelper.isElementDisplay(postuserObjects.backIcon)==true) {
            Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.backIcon));
            postuserObjects.backIcon.click();
        }
    }

    public void  verifyPostUserChatInitiatingFunctionality(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        String text=homePostObjects.userProfileLink.getText();
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
        String test=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(chatPageObjects.recentKnownNameLabel.getText(), text);
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
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.trendTagIcon));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserProfileImage));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserTimeStamp));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserReplyIconAndCount));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserLikeIcon));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentPageAudioRecordIcon));
            Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentPageSendCommentIcon));
        }
        else {
            if(deviceHelper.isElementDisplay(commentsObjects.noCommentlabel)) {
                deviceHelper.isElementDisplay(commentsObjects.noCommentImage);
                deviceHelper.clickAndroidBackButton();
                deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
                deviceHelper.swipeUp();
                getHomePageActionsInstance().clickPostCommentIcon();
                deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserProfileImage));
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserTimeStamp));
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserReplyIconAndCount));
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentUserLikeIcon));
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentPageAudioRecordIcon));
                Assert.assertTrue(deviceHelper.isElementDisplay(commentsObjects.commentPageSendCommentIcon));
            }

        }
    }
    public void  clickCommentUserProfile(){
        deviceHelper.waitTillTheElementIsVisible(commentsObjects.commentUserProfileName);
        String commentUserNametext=commentsObjects.commentUserProfileName.getText();
        System.out.println("text======="+commentUserNametext.toLowerCase());
        commentsObjects.commentUserProfileName.click();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        Assert.assertTrue(deviceHelper.isElementDisplay(postuserObjects.postUserprofileDisplayName));
        String profileUserNametext=postuserObjects.postUserprofileDisplayName.getText();
        System.out.println("test======="+profileUserNametext.toLowerCase());
        Assert.assertEquals(commentUserNametext.toLowerCase(), profileUserNametext.toLowerCase());
    }


}
