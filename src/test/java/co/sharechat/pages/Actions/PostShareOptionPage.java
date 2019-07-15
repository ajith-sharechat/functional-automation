package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.LandingPageObjects;
import co.sharechat.pages.Objects.PostShareOptionObjects;
import co.sharechat.pages.Objects.StickerPicturePostObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;


/**
 * This Class has all the Actions related to Post option page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */
public class PostShareOptionPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.PostShareOptionObjects PostShareOptionObjects = new PostShareOptionObjects();

    public PostShareOptionPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), PostShareOptionObjects);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    public String checkPostShareOption() {
        deviceHelper.scrollToMobileElement(PostShareOptionObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(PostShareOptionObjects.postOptionClick).click();
        element(PostShareOptionObjects.whatsAppClick).click();
        String result = PostShareOptionObjects.Toast.getText();
        deviceHelper.waitInSec(2);
        return result;
    }

    public boolean checkConvertSticker() {

        deviceHelper.scrollToMobileElement(PostShareOptionObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(PostShareOptionObjects.postOptionClick).click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.convertSticker6.get(4).click();
        deviceHelper.waitInSec(10);
        return element(PostShareOptionObjects.verifyStickerConvertScreen).isDisplayed();

    }

    public boolean[] checkMessageOption() {
        boolean res[] = new boolean[2];
        deviceHelper.scrollToMobileElement(PostShareOptionObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(PostShareOptionObjects.postOptionClick).click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.selectMsg7.get(5).click();
        deviceHelper.waitInSec(10);
        res[0] = PostShareOptionObjects.verifyMsgScreen.isDisplayed();
        PostShareOptionObjects.verifyChatSend.click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.verifyGoToChat.click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.chatMsg.click();
        deviceHelper.waitInSec(10);
        res[1] = PostShareOptionObjects.imagePostCheck.isDisplayed();
        deviceHelper.waitInSec(10);
        return res;

    }

    public boolean checkFollowOption() {

        deviceHelper.waitInSec(10);
        deviceHelper.scrollToMobileElement(PostShareOptionObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(PostShareOptionObjects.postOptionClick).click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.selectFollow8.get(6).click();
        deviceHelper.waitInSec(10);
        return true;


    }

    public boolean checkReportOption() {
        boolean response;
        deviceHelper.waitInSec(10);
        deviceHelper.scrollToMobileElement(PostShareOptionObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(PostShareOptionObjects.postOptionClick).click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.selectReport.get(7).click();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.chooseOption.click();
        deviceHelper.waitInSec(10);
        response = PostShareOptionObjects.reportTitle.isDisplayed();
        deviceHelper.waitInSec(10);
        PostShareOptionObjects.submitReport.click();
        deviceHelper.waitInSec(5);
        return response;


    }
}
