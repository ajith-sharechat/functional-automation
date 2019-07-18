package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.ExploreTabObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 This Class has all the Actions related to Explore Page
 @author Diljeet Singh
 @version 1.0
 @since 01 july 2019
 */

public class ExploreTabPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.ExploreTabObjects ExploreTabObjects = new ExploreTabObjects();

    public ExploreTabPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ExploreTabObjects);

    }

    public boolean checkExploreTab() {
        try {
            deviceHelper.waitInSec(10);
            ExploreTabObjects.exploreButton.click();
            deviceHelper.waitInSec(10);
            ExploreTabObjects.toolBarSearch.click();
            deviceHelper.waitInSec(10);
            ExploreTabObjects.searchText.sendKeys(SearchingText);
            deviceHelper.waitInSec(10);
            ExploreTabObjects.backButton.click();
            deviceHelper.waitInSec(10);
            ExploreTabObjects.allTiles.get(0).click();
            deviceHelper.waitInSec(10);


            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
