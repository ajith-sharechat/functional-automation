package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for chat page actions
 * Version: 1.0
 */
public class ChatPageActions  extends WebDriverListener {
    static DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    static ChatPageObjects chatPageObjects= new ChatPageObjects();
    static PostUserProfileObjects postUserObjects= new PostUserProfileObjects();
    static UnknowUsersPageObjects unknownUserObjects = new UnknowUsersPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();

    public ChatPageActions(WebDriver driver, DeviceInterface runnerInfo) {
        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatPageObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), postUserObjects);
        PageFactory.initElements(new AppiumFieldDecorator(driver), unknownUserObjects);
        this.runnerInfo = runnerInfo;
    }

    public void verifyChatScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.chatScreenTitle);
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.knownNameLabel);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.knownNameLabel);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.knownRecentChatTime);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.unKnownName);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.recentKnownNameLabel);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.addFriendIcon);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.recentKnownImage);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.shareMobileIcon);
        deviceHelper.isElementPresentAssertTrue(chatPageObjects.topSearchIcon);
    }

    public void verifyRecentKnownUserFromKnownUserList(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentKnownNameLabel);
        String userName=chatPageObjects.recentKnownNameLabel.getText();
        chatPageObjects.recentKnownNameLabel.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentMessageInChatBox);
        String chatBoxUserName=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(userName.toLowerCase().trim(), chatBoxUserName.toLowerCase().trim());
    }

    public void enterTextMessage(String message){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserMessageField);
        postUserObjects.postUserMessageField.sendKeys(message);
    }

    public void enterTextMessageActions(String message){
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.postUserMessageField);
        Actions a=new Actions(driver);
        a.sendKeys(message).build().perform();
    }
    public void tapRightTopConerOption(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.rightConerOptionListChatBox);
        chatPageObjects.rightConerOptionListChatBox.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.blockOption);
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.hideChatOption);
    }
    public void tapBlockOption(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.blockOption);
        chatPageObjects.blockOption.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unblockButton);
    }
    public void tapUnblockButton(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unblockButton);
        chatPageObjects.unblockButton.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendMessageIcon);
    }
    public void tapUknownUser(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unKnownName);
        chatPageObjects.unKnownName.click();
    }
    public void verifyUnknownUserScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.addFriendUnknownUserIcon);
        deviceHelper.isElementPresentAssertTrue(unknownUserObjects.shareAndChatLabel);
        deviceHelper.isElementPresentAssertTrue(unknownUserObjects.sharePhoneToTalkLabel);
        deviceHelper.isElementPresentAssertTrue(unknownUserObjects.sharePhoneIconUnknownUsersScreen);
    }
    public void tapShareAndChatLink(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.addFriendUnknownUserIcon);
        unknownUserObjects.shareAndChatLabel.click();
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.shareNChatLabel);
    }
    public void verifyShareAndChatScreenElements(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.shareNChatLabel);
        deviceHelper.isElementPresentAssertTrue(unknownUserObjects.sharePhoneTalkStrangersLabel);
        deviceHelper.isElementPresentAssertTrue(postUserObjects.backIcon);
    }
}
