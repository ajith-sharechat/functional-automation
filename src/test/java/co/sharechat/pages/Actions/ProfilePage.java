package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.ProfilePageObjects;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 This Class has all the Actions related to Profile Page
 @author Diljeet Singh
 @version 1.0
 @since 01 july 2019
 */
public class ProfilePage extends WebDriverListener {


    DeviceHelper deviceHelper;
    WebDriver driver;
    String testResult = null;
    co.sharechat.pages.Objects.ProfilePageObjects ProfileObj = new ProfilePageObjects();

    public ProfilePage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ProfileObj);

    }

    public boolean checkingSaveAndGallery() {
        try {
            deviceHelper.waitInSec(10);
            deviceHelper.swipe(461, 1850, 461, 400);
            ProfileObj.saveButton.get(4).click();
            deviceHelper.waitInSec(15);
            ProfileObj.phoneGalleryDailog.click();
            deviceHelper.waitInSec(10);
            ProfileObj.profileLink.click();
            deviceHelper.waitInSec(10);
            ProfileObj.gallery.click();
            deviceHelper.waitInSec(10);


            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public String verifySticker() {

        try {
            deviceHelper.waitInSec(10);
            ProfileObj.profileLink.click();
            deviceHelper.waitInSec(10);
            ProfileObj.stickersTab.click();
            deviceHelper.waitInSec(5);
            deviceHelper.waitInSec(5);
            ProfileObj.downLoadbutton.get(0).click();
            deviceHelper.waitInSec(10);
            ProfileObj.toolBarBack.click();
            deviceHelper.waitInSec(10);
            testResult = "Test Pass";


        } catch (NoSuchElementException e) {


            ProfileObj.addOnWhatsApp.click();
            deviceHelper.waitInSec(2);
            testResult = ProfileObj.Toast.getText();
            deviceHelper.waitInSec(5);
            testResult = "Test Pass";

        } catch (Exception e) {

            return "Test Fail";
        }

        return testResult;
    }

    public String[] verifyChangeSkin() {

        deviceHelper.waitInSec(10);
        ProfileObj.profileLink.click();
        deviceHelper.waitInSec(10);
        ProfileObj.Setting.click();
        deviceHelper.waitInSec(10);
        ProfileObj.SkinChange.click();
        deviceHelper.waitInSec(10);
        ProfileObj.chooseEnglish.click();
        deviceHelper.waitInSec(10);
        String profileSettingText = ProfileObj.checkSelectedSkin.getText();
        String MultiValueCheck[] = new String[3];
        deviceHelper.waitInSec(10);
        ProfileObj.skinBackButton.click();
        deviceHelper.waitInSec(10);
        String checkChatText = ProfileObj.checkChat.getText();
        deviceHelper.waitInSec(10);
        deviceHelper.waitInSec(10);
        MultiValueCheck[0] = profileSettingText;
        MultiValueCheck[1] = checkChatText;

        return MultiValueCheck;


    }

    public String checkLogout() {

        deviceHelper.waitInSec(10);
        ProfileObj.profileLink.click();
        deviceHelper.waitInSec(10);
        ProfileObj.Setting.click();
        deviceHelper.waitInSec(10);
        ProfileObj.logoutCheck.click();
        deviceHelper.waitInSec(10);
        ProfileObj.logoutAlert.click();
        deviceHelper.waitInSec(10);
        String afterLogoutScreen = ProfileObj.confirmAfterLogoutScreen.getText();
        return afterLogoutScreen;

    }
}