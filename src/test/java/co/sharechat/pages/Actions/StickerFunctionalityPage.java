package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.StickerFunctionalityObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 This Class has all the Actions related to Sticker Functionality Page
 @author Diljeet Singh
 @version 1.0
 @since 08 july 2019
 */

public class StickerFunctionalityPage extends WebDriverListener {


    DeviceHelper deviceHelper;
    WebDriver driver;
    boolean testResult;
    co.sharechat.pages.Objects.StickerFunctionalityObjects ProfileObj = new StickerFunctionalityObjects();

    public StickerFunctionalityPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ProfileObj);

    }

    public boolean verifySticker() {

        deviceHelper.waitInSec(10);
        ProfileObj.profileTab.click();
        deviceHelper.waitInSec(10);
        ProfileObj.stickeTab02.get(2).click();
        deviceHelper.waitInSec(10);
        testResult = ProfileObj.stickerPackClick.get(0).isDisplayed();

        return testResult;
    }

}
