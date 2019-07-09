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

    public void verifyChatScreen(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.chatScreenTitle);
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.knownNameLabel);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.knownNameLabel);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.knownRecentChatTime);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.unKnownName);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.recentKnownNameLabel);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.addFriendIcon);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.recentKnownImage);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.shareMobileIcon);
        deviceHelper.elementPresentAssertTrue(chatPageObjects.topSearchIcon);
    }

    public void clickKnownUserList(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentKnownNameLabel);
        String username=chatPageObjects.recentKnownNameLabel.getText();
        chatPageObjects.recentKnownNameLabel.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.recentMessageInChatBox);
        String chatboxusername=chatPageObjects.recentKnownNameLabel.getText();
        Assert.assertEquals(username.toLowerCase(), chatboxusername.toLowerCase());
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
    public void clickRightTopConerOption(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.rightConerOptionListChatBox);
        chatPageObjects.rightConerOptionListChatBox.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.blockOption);
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.hideChatOption);
    }
    public void clickBlockOption(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.blockOption);
        chatPageObjects.blockOption.click();
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unblockButton);
    }
    public void clickUnblockButton(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unblockButton);
        chatPageObjects.unblockButton.click();
        deviceHelper.waitTillTheElementIsVisible(postUserObjects.sendMessageIcon);
    }
    public void clickUknownUser(){
        deviceHelper.waitTillTheElementIsVisible(chatPageObjects.unKnownName);
        chatPageObjects.unKnownName.click();
    }
    public void verifyUnknownUserScreen(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.addFriendUnknownUserIcon);
        deviceHelper.elementPresentAssertTrue(unknownUserObjects.shareAndChatLabel);
        deviceHelper.elementPresentAssertTrue(unknownUserObjects.sharePhoneToTalkLabel);
        deviceHelper.elementPresentAssertTrue(unknownUserObjects.sharePhoneIconUnknownUsersScreen);
    }
    public void clickShareAndChatLink(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.addFriendUnknownUserIcon);
        unknownUserObjects.shareAndChatLabel.click();
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.shareNChatLabel);
    }
    public void verifyShareAndChatScreen(){
        deviceHelper.waitTillTheElementIsVisible(unknownUserObjects.shareNChatLabel);
        deviceHelper.elementPresentAssertTrue(unknownUserObjects.sharePhoneTalkStrangersLabel);
        deviceHelper.elementPresentAssertTrue(postUserObjects.backIcon);
    }
}
