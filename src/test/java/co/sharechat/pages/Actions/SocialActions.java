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

public class SocialActions extends WebDriverListener {
    DeviceInterface runnerInfo;
    static DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static HomePageObjects homePostObjects= new HomePageObjects();
    static ChatPageObjects chatPageObjects= new ChatPageObjects();
    static UnknowUsersPageObjects unknownUserObjects = new UnknowUsersPageObjects();
    static PostUserProfileObjects postuserObjects = new PostUserProfileObjects();
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
//        PageFactory.initElements(new AppiumFieldDecorator(driver), signUpObjects);
        this.runnerInfo = runnerInfo;
    }

    public void  clickPostUserChatIcon(){
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
        postuserObjects.profileChatIcon.click();}
//        try {
//            if(deviceHelper.isElementDisplay(postuserObjects.profileChatIcon)){
//            deviceHelper.waitTillTheElementIsVisible(postuserObjects.profileChatIcon);
//            postuserObjects.profileChatIcon.click();}
//        }
//        catch (Exception e) {
//            System.out.println("Exception==="+ e);
//        }

//    }
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
        System.out.println("text============================="+text);
        getHomePageActionsInstance().clickUserProfileLink();
        clickPostUserChatIcon();
        verifyPostUserchatscreen();
        clickSendMessageIcon();
        clickBackButton();
        clickBackButton();
//        clickBackButton();
        deviceHelper.waitTillTheElementIsVisible(postuserObjects.postUserProfileBackButton);
        postuserObjects.postUserProfileBackButton.click();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        String test=chatPageObjects.recentKnownNameLabel.getText();
        System.out.println("test============================="+test);
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
//    public void r(){
//        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.);
//
//    }

}
