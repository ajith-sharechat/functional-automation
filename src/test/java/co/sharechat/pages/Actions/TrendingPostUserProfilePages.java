package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.PostShareOptionObjects;
import co.sharechat.pages.Objects.TrendingPostUserProfileObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;


/**
 * This Class has all the Actions related to Trending Post User Profile page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 16 july 2019
 */
public class TrendingPostUserProfilePages extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.TrendingPostUserProfileObjects TrendingPostUserProfileObjects = new TrendingPostUserProfileObjects();

    public TrendingPostUserProfilePages(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), TrendingPostUserProfileObjects);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    public boolean checkUserPostFollowOption() {

        deviceHelper.waitInSec(5);
        element(TrendingPostUserProfileObjects.userPF).click();
        element(TrendingPostUserProfileObjects.followLink).click();
        deviceHelper.waitInSec(5);
        boolean res = TrendingPostUserProfileObjects.otherPFFollowButton.get(0).isDisplayed();
        System.err.println("Data is : " + res);
        return res;
    }

    public boolean[] checkUserPostChatOption() {
        boolean res[] = new boolean[5];
        deviceHelper.waitInSec(5);
        element(TrendingPostUserProfileObjects.userPF).click();
        element(TrendingPostUserProfileObjects.chatOption).click();
        deviceHelper.waitInSec(5);
        res[0] = TrendingPostUserProfileObjects.chatTitle.isDisplayed();
        res[1] = TrendingPostUserProfileObjects.abuceGuidOne.isDisplayed();
        res[2] = TrendingPostUserProfileObjects.spamGuidTwo.isDisplayed();
        res[3] = TrendingPostUserProfileObjects.privacyGuidThree.isDisplayed();
        String result = TrendingPostUserProfileObjects.chatBox.getText();
        res[4] = result.length() > 0;
        return res;
    }

    public int checkUserPostShareOption() {

        Set<String> text_Set = new HashSet<String>();
        deviceHelper.waitInSec(5);
        element(TrendingPostUserProfileObjects.userPF).click();
        element(TrendingPostUserProfileObjects.shareMenu).click();
        deviceHelper.waitInSec(5);
        deviceHelper.waitInSec(10);
        for (MobileElement box : TrendingPostUserProfileObjects.allShareingOption1) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        deviceHelper.swipe(760, 1590, 280, 1590);
        deviceHelper.waitInSec(2);
        for (MobileElement box : TrendingPostUserProfileObjects.allShareingOption1) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        deviceHelper.swipe(760, 1590, 280, 1590);
        deviceHelper.waitInSec(2);
        deviceHelper.waitInSec(2);
        for (MobileElement box : TrendingPostUserProfileObjects.allShareingOption1) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        deviceHelper.swipe(760, 1590, 280, 1590);
        deviceHelper.waitInSec(2);
        for (MobileElement box : TrendingPostUserProfileObjects.allShareingOption1) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        System.err.println("Size : " + text_Set.size());

//       boolean [] res =  new boolean[TrendingPostUserProfileObjects.allShareingOption.size()];
//        deviceHelper.waitInSec(5);
//        element(TrendingPostUserProfileObjects.userPF).click();
//        element(TrendingPostUserProfileObjects.shareMenu).click();
//        deviceHelper.waitInSec(5);
//        deviceHelper.waitInSec(10);
//        for (int i = 0; i < TrendingPostUserProfileObjects.allShareingOption.size(); i++) {
//            res[i] = TrendingPostUserProfileObjects.allShareingOption.get(i).isDisplayed();
//            System.err.println("check Name : " + res[i]);
//        }
////        int width = (int) (deviceHelper.getWidthOfScreen() / 2);
////        int startPoint = (int) (deviceHelper.getHeightOfScreen() - 50);
////        deviceHelper.waitInSec(2);
//        deviceHelper.swipe(760, 1590, 280, 1590);
//        deviceHelper.waitInSec(2);
//        for (int i = 0; i < TrendingPostUserProfileObjects.allShareingOption.size(); i++) {
//            res[i] = TrendingPostUserProfileObjects.allShareingOption.get(i).isDisplayed();
//            System.err.println("check Name : " + res[i]);
//        }
//        deviceHelper.swipe(760, 1590, 280, 1590);
//        deviceHelper.waitInSec(2);
//        deviceHelper.waitInSec(10);
//        for (int i = 0; i < TrendingPostUserProfileObjects.allShareingOption.size(); i++) {
//            res[i] = TrendingPostUserProfileObjects.allShareingOption.get(i).isDisplayed();
//            System.err.println("check Name : " + res[i]);
//        }
//        deviceHelper.swipe(760, 1590, 280, 1590);
//        deviceHelper.waitInSec(2);
//        for (int i = 0; i < TrendingPostUserProfileObjects.allShareingOption.size(); i++) {
//            res[i] = TrendingPostUserProfileObjects.allShareingOption.get(i).isDisplayed();
//            System.err.println("check Name : " + res[i]);
//        }
//
//        System.err.println("Size : " + optionAdd.size());
        return text_Set.size();
    }

}
