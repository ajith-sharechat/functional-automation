package co.sharechat.pages.Actions;


import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.HomeScreenObject;
import co.sharechat.pages.Objects.LandingPageObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This Class has all the Actions related to Landing Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 09 july 2019
 */

public class LandingPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.LandingPageObjects LandingPageObjects = new LandingPageObjects();

    public LandingPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), LandingPageObjects);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }


    public String verifyTheSharechatLogo() {

        String text = element(LandingPageObjects.select_lang_text).getText();
        return text;

    }

    public int verifyLandingScreenOpeningWithDifferentLanguageBoxes() {
        Set<String> text_Set = new HashSet<String>();
        deviceHelper.waitInSec(10);
        for (MobileElement box : LandingPageObjects.select_lang_boxes) {
            text_Set.add(element(box).getText());
        }
        int width = (int) (deviceHelper.getWidthOfScreen() / 2);
        int startPoint = (int) (deviceHelper.getHeightOfScreen() - 50);
        deviceHelper.waitInSec(2);
        deviceHelper.swipe(width, startPoint, width, 50);
        deviceHelper.waitInSec(2);
        for (MobileElement box : LandingPageObjects.select_lang_boxes) {
            text_Set.add(element(box).getText());

        }
        return text_Set.size();
    }


}
