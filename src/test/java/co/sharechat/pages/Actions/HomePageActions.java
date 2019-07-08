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
        this.runnerInfo = runnerInfo;
    }

    public void  verifyHomeScreenElement(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.headerMenuBar);
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.languageTitle));
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.notificationIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.rupeeIcon));
        verifyHomeScreenBottomTabs();
    }

    public void  verifyHomeScreenBottomTabs(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.homeIcon);
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.searchIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.composeIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.chatIcon));
        Assert.assertTrue(deviceHelper.isElementDisplay(homePostObjects.profileIcon));
    }
    public void  clickHomeIcon(){
        deviceHelper.waitTillTheElementIsVisible(homePostObjects.homeIcon);
        homePostObjects.homeIcon.click();
    }

    public void clickChatIcon(){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(homePostObjects.chatIcon);
        homePostObjects.chatIcon.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentKnownNameLabel);
    }
    public void clickProfileIcon(){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(homePostObjects.profileIcon);
        homePostObjects.profileIcon.click();
        deviceHelper.waitTillTheElementIsVisible(profileObjects.profileDetailsLabel);
    }
    public void clickAllowButton() {
        if(deviceHelper.isElementDisplay(signUpObjects.allowPermissionPopUp)) {
            signUpObjects.allowPermissionPopUp.click();
        }
    }
    public void clickUserProfileLink() {
        if(deviceHelper.isElementDisplay(homePostObjects.userProfileLink)) {
            homePostObjects.userProfileLink.click();
        }
    }
    public void scrollTillPostImageOnHomeScreenClickPostImage() {
        if(deviceHelper.isElementDisplay(homePostObjects.postImage)) {
            homePostObjects.postImage.click();
        }
        else{
            deviceHelper.scrollToMobileElement(homePostObjects.postImage);
            homePostObjects.postImage.click();
        }
    }
    public void clickPostImageOptionTopRightCorner() {
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postImageToolOptions);
        postUserObjects.postImageToolOptions.click();

    }
}
