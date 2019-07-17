package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.StickerFunctionalityObjects;
import co.sharechat.pages.Objects.StickerPicturePostObjects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

import static co.sharechat.utils.Constants.*;

/**
 * This Class has all the Actions related to Sticker Picture Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */

public class StickerPicturePostPages extends WebDriverListener {


    DeviceHelper deviceHelper;
    WebDriver driver;
    boolean testResult;
    co.sharechat.pages.Objects.StickerPicturePostObjects StickerPicturePostObjects = new StickerPicturePostObjects();

    public StickerPicturePostPages(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), StickerPicturePostObjects);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitInSec(5);
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    public void createNewPackOfSticker() {
        deviceHelper.waitInSec(10);
        deviceHelper.scrollToMobileElement(StickerPicturePostObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        StickerPicturePostObjects.imagePost.click();
        deviceHelper.waitInSec(5);
        StickerPicturePostObjects.stickerTab.click();
        deviceHelper.waitInSec(5);
        StickerPicturePostObjects.stickerDropDown.click();
        deviceHelper.waitInSec(10);
        //Not Able to perform other steps due to no limitation of appium not able to interact with window dialogs as discussed with developer and team

    }

    public boolean[] checkPostViewOption() {
        boolean res[] = new boolean[3];
        deviceHelper.scrollToMobileElement(StickerPicturePostObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(StickerPicturePostObjects.imagePost).click();
        element(StickerPicturePostObjects.chatShare).click();
        deviceHelper.waitInSec(10);
        res[0] = element(StickerPicturePostObjects.chatScreenTitle).isDisplayed();
        element(StickerPicturePostObjects.sendChat).click();
        deviceHelper.waitInSec(10);
        res[1] = element(StickerPicturePostObjects.arrowIcon).isDisplayed();
        element(StickerPicturePostObjects.arrowIcon).click();
        element(StickerPicturePostObjects.chatMsg).click();
        res[2] = element(StickerPicturePostObjects.imagePostCheck).isDisplayed();
        return res;

    }

}
