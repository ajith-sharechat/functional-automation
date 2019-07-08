package co.sharechat.pages.Actions;


import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * This Class has all the Actions related to App install & Uninstall
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class CheckAppInstallAndUninstall extends WebDriverListener implements Constants {

    WebDriver driver;

    public CheckAppInstallAndUninstall(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public boolean checkInstall(String pkgName) {


        return ((AppiumDriver<MobileElement>) driver).isAppInstalled(pkgName);

    }

    public boolean checkUnInstall(String pkgName) {

        ((AppiumDriver<MobileElement>) driver).removeApp(pkgName);
        return ((AppiumDriver<MobileElement>) driver).isAppInstalled(pkgName);
    }
}
