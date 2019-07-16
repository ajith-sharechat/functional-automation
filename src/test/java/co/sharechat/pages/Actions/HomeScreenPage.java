package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.HomeScreenObject;
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
 * This Class has all the Actions related to Home Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class HomeScreenPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.HomeScreenObject HomeScreenObject = new HomeScreenObject();

    public HomeScreenPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), HomeScreenObject);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    //TC022
    public boolean verifyChangingLanguageOptionIsappearingInTopLeftCorner() {


        return HomeScreenObject.LangDD.isDisplayed();
    }

    public boolean verifyRupeeIconAndNotificationsIconOnTopRightCornerOfTheScreen() {

        return HomeScreenObject.Rupeicon.isDisplayed();

    }

    public boolean verifyByDefaultTrendingIsSelected() {

        return HomeScreenObject.ThirteenTitles.get(1).isDisplayed();

    }

    public int verifyThirteenTabsDifferentTabsAreArrangedHorizontallyAndTheTabsAreLikeFollowing() {

        Set<String> text_Set = new HashSet<String>();
        deviceHelper.waitInSec(10);
        for (MobileElement box : HomeScreenObject.ThirteenTitles) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        deviceHelper.waitInSec(5);
        deviceHelper.swipe(890, 316, 190, 316);
        deviceHelper.waitInSec(10);
        for (MobileElement box : HomeScreenObject.ThirteenTitles) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }

        deviceHelper.waitInSec(5);
        deviceHelper.swipe(890, 316, 190, 316);
        deviceHelper.waitInSec(10);
        for (MobileElement box : HomeScreenObject.ThirteenTitles) {
            text_Set.add(element(box).getText());
            System.err.println("Name is :" + box.getText());

        }
        return text_Set.size();
    }

    public boolean[] verifyFiveButtonsArePlacedInHomeExploreCreatePost() {
        boolean TabsAll[] = new boolean[5];
        deviceHelper.waitInSec(10);
        TabsAll[0] = HomeScreenObject.HomeIcon.isDisplayed();
        TabsAll[1] = HomeScreenObject.Explore.isDisplayed();
        TabsAll[2] = HomeScreenObject.PluseIcon.isDisplayed();
        deviceHelper.waitInSec(10);
        TabsAll[3] = HomeScreenObject.ChatIcon.isDisplayed();
        TabsAll[4] = HomeScreenObject.Profile.isDisplayed();
        deviceHelper.waitInSec(10);
        return TabsAll;

    }

    //TC023
    public boolean tapOnDefaultLanguageDropDownField() {

        HomeScreenObject.LangSelection.click();

        return true;

    }

    public boolean screenRedirectingToChangeLanguageScreen() {

        return HomeScreenObject.CheckLangScreen.isDisplayed();

    }

    public void selectOneLanguageFromScreen() {

        HomeScreenObject.ChooseLang.get(1).click();


    }

    public boolean[] verifyWholeScreenChangingToSelectedLanguage() {

        boolean TabsAll[] = new boolean[2];

        TabsAll[0] = HomeScreenObject.ThirteenTitles.get(2).isDisplayed();
        TabsAll[1] = HomeScreenObject.Explore.isDisplayed();
        return TabsAll;

    }

    public boolean checkWithAllTheOptionsSelectLanguages() {

        return HomeScreenObject.CheckLangScreen.isDisplayed();

    }

    public boolean verifyPostsAndTagsAppearingBasedOnLanguageRegion() {

        return HomeScreenObject.CheckTags.get(0).isDisplayed();


    }

    //TC024
    public boolean verifyRupeeIconTopRightCornerOfTheHomeScreen() {

        deviceHelper.waitInSec(10);
        HomeScreenObject.RupeClick.click();
        deviceHelper.waitInSec(10);
        return HomeScreenObject.VeryfyRupeScreen.isDisplayed();

    }

    //TC025
    public boolean verifyNotificationsButtonTopRightCornerOfTheHomeScreen() {

        deviceHelper.waitInSec(10);
        HomeScreenObject.NotificationIconClick.click();
        deviceHelper.waitInSec(10);
        return HomeScreenObject.VerifyNotifiScreen.isDisplayed();
    }

    //TC026
    public void verifyExploreButtonFromHomeScreen() {

        deviceHelper.waitInSec(10);
        HomeScreenObject.Explore.click();
        deviceHelper.waitInSec(10);

    }

    public boolean[] verifySearchBarAppear() {

        boolean TabsAll[] = new boolean[2];

        TabsAll[0] = HomeScreenObject.Explore.isDisplayed();
        TabsAll[1] = HomeScreenObject.searchExplore.isDisplayed();
        return TabsAll;

    }

    public boolean differentTypesOfTrendingBucketsAppearingOnScreen() {

        return HomeScreenObject.bucketCheck.get(0).isDisplayed();


    }

    //TC028
    public void verifyChatButtonFromHomeScreen() {
        deviceHelper.waitInSec(10);
        HomeScreenObject.ChatIcon.click();
        deviceHelper.waitInSec(10);

    }

    public boolean verifyChatScreenOpening() {

        deviceHelper.waitInSec(10);
        return HomeScreenObject.ChatIcon.isDisplayed();


    }

    //TC029
    public void verifyProfileButtonFromHomeScreen() {

        deviceHelper.waitInSec(10);
        HomeScreenObject.Profile.click();
        deviceHelper.waitInSec(10);
    }

    public boolean verifyUserProfileScreenOpening() {

        deviceHelper.waitInSec(10);
        return HomeScreenObject.pfScreenCheck.isDisplayed();
    }


}
