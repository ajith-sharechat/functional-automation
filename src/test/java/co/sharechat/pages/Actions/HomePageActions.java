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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for home page actions
 * Version: 1.0
 */
public class HomePageActions extends WebDriverListener {
    DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static HomePageObjects homePostObjects= new HomePageObjects();
    static ChatPageObjects chatPageObjects= new ChatPageObjects();
    static SignUpPageObjects signUpObjects = new SignUpPageObjects();
    static ProfilePageObjects profileObjects = new ProfilePageObjects();
    static PostUserProfileObjects postUserObjects = new PostUserProfileObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

    public HomePageActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePostObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), profileObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), postUserObjects);
        this.runnerInfo = runnerInfo;
    }

    public void  verifyHomeScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.languageTitle);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.notificationIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.rupeeIcon);
        verifyHomeScreenBottomTabs();
    }

    public void  verifyHomeScreenBottomTabs(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.homeIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.searchIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.composeIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.chatIcon);
        deviceHelper.isElementPresentAssertTrue(homePostObjects.profileIcon);
    }
    public void  tapHomeIcon(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.homeIcon);
        homePostObjects.homeIcon.click();
    }

    public void tapChatIcon(){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(homePostObjects.chatIcon);
        homePostObjects.chatIcon.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentKnownNameLabel);
    }
    public void tapProfileIcon(){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(homePostObjects.profileIcon);
        homePostObjects.profileIcon.click();
    }
    public void tapAllowButton() {
        deviceHelper.waitInSec(3);
        if(deviceHelper.isElementDisplay(signUpObjects.allowPermissionPopUp)==true){
            signUpObjects.allowPermissionPopUp.click();
        }
    }
    public void tapUserProfileLink() {
        if(deviceHelper.isElementDisplay(homePostObjects.userProfileLink)) {
            homePostObjects.userProfileLink.click();
        }
    }
    public void scrollTillPostImageAndTapPostImage() {
        if(deviceHelper.isElementDisplay(homePostObjects.postImage)==true) {
            homePostObjects.postImage.click();
        }
        else{
            deviceHelper.scrollToMobileElement(homePostObjects.postImage, "20");
            homePostObjects.postImage.click();
        }
    }
    public void tapPostImageOptionOnTopRightCorner() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postImageToolOptions);
        postUserObjects.postImageToolOptions.click();
    }
    public void scrollToPostComment() {
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        deviceHelper.scrollToMobileElement(homePostObjects.postCommentIcon, "3");
    }

    public void tapPostCommentIcon() {
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.postCommentIcon);
        homePostObjects.postCommentIcon.click();
        deviceHelper.waitInSec(3);
        if(deviceHelper.isElementDisplay(homePostObjects.postCommentSendIcon)) {
            deviceHelper.isElementPresentAssertTrue(homePostObjects.postCommentSendIcon);
        }
        else{
            deviceHelper.swipeUp();
            homePostObjects.postCommentIcon.click();
        }
    }
    public void scrollToVideoPost() {
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.userProfileLink);
        deviceHelper.scrollToMobileElement(homePostObjects.postVideoPlayIcon, "20");
    }
    public void tapOnVideoPost() {
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.postVideoPlayIcon);
        homePostObjects.postVideoPlayIcon.click();
    }
    public void verifyVideoPostPreviewScreenElements() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.videoPostCommentIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.videoPostShareIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.videoPostRepostIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.videoPostLikeIcon);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.videoPostFavouriteIcon);
    }


}
