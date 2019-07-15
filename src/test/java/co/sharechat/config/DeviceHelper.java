package co.sharechat.config;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.aventstack.extentreports.Status;
import com.report.factory.ExtentTestManager;
import com.sun.tools.internal.jxc.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


/**
 * Created by Qualitrix Technologies Pvt Ltd.
 *
 * @author: Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	Generic Methods
 */

public class DeviceHelper {

    PropertyReader propertyReader;
    public WebDriver driver;
    static WebDriverWait wait = null;

    public DeviceHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.2);
        int startx = (int) (size.width / 2.2);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction((PerformsTouchActions) driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(3)))
                    .moveTo(point(startx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete succesfully.");
        }
    }


    public void waitTillTheElementIsVisibleAndClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillTheElementInVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementState(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(id));

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForPageToLoad(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public void waitForElementToDisAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public void waitForElementToDisAppear(List<WebElement> id, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public MobileElement waitForElementToAppear(MobileElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElementToAppear(WebElement id, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public void WaitForFrameAndSwitchToIt(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void WaitForFrameAndSwitchToIt(int id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void ScrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElements(List<WebElement> arg) {
        waitForPageToLoad(arg);
    }

    public MobileElement waitForElementToAppearOnScreen(MobileElement arg) {
        waitForElementToAppear(arg);
        MobileElement el = arg;
        return el;
    }

    public void clickUntilElementExists(WebElement clickLocator, By by) {
        boolean elementOnScreen;
        int i = 0;
        do {
            if (i == 25) {
                break;
            }
            try {
                driver.findElement(by);
                break;
            } catch (NoSuchElementException e) {
                clickLocator.click();
                elementOnScreen = false;
                System.out.println(i);
            }
            i++;
        } while (!elementOnScreen);
    }

    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void logStepIntoExtentReport(String elementDescription, String action,
                                        String typeString) {
        ExtentTestManager.getTest().log(Status.INFO,
                elementDescription + "; " + withBoldHTML("Text") + ": " + typeString);
    }

    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty()) {
            return "<b>" + string + "</b>";
        } else {
            return "";
        }
    }

    public String getPageObjectElemetDescription(Object pageObject, String fieldName) {
        try {
            return this.getClass().getAnnotation(PageName.class).value() + "::" +
                    pageObject.getClass().getField(fieldName).getAnnotation(ElementDescription.class)
                            .value();
        } catch (NoSuchFieldException e) {

            e.printStackTrace();
        }
        return "";
    }

    public boolean isElementPresent(WebElement locator) {
        try {
            if (locator.isDisplayed())
                System.out.println("Element presend on screen ***********" + locator);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        }
    }

    public String getCurrentMonth(int month) {
        int i = Calendar.getInstance().get(Calendar.MONTH);
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month + i];
    }

    public void refreshWebPage() {
        driver.navigate().refresh();
    }

    //Method to wait for time
    public static void waitWebDriver(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

        }
    }

    public void switchToNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    /**
     * This Method to perform any swipe action
     *
     * @author Diljeet Singh
     * @version 1.0
     * @since 05 july 2019
     */

    public void swipe(int x1, int y1, int x2, int y2) {
        new TouchAction(((AppiumDriver<MobileElement>) driver)).press(PointOption.point(x1, y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x2, y2))
                .release().perform();
    }

    public String GetTextOfElement(By value) {

        WebElement element = driver.findElement(value);

        return element.getText();
    }


    /**
     * This Method for wait when explicit wait not working
     *
     * @author Diljeet Singh
     * @version 1.0
     * @since 01 july 2019
     */

    public void waitInSec(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * This Method to check element is displayed or not
     *
     * @author Diljeet Singh
     * @version 1.0
     * @since 01 july 2019
     */


    public boolean isDisplayed(MobileElement locator) {


        return locator.isDisplayed();
    }

    /**
     * This method will return the Width of the Phone Screen
     *
     * @author Jasmeet
     * @since 08 July 2019
     */
    public int getWidthOfScreen() {
        return driver.manage().window().getSize().width;
    }

    /**
     * This method will return the Height of the Phone Screen
     *
     * @author Jasmeet
     * @since 08 July 2019
     */
    public int getHeightOfScreen() {
        return driver.manage().window().getSize().height;
    }


    /* Tap the screen on the basis of x1,y1 point.
     * @author Diljeet Singh Ranaut
     * @param x1
     * @param y1
     * @since 10 july
     */
    public void tapOnPoint(int x1, int y1) {
        new TouchAction((AppiumDriver<MobileElement>) driver).tap(PointOption.point(x1, y1)).perform();
    }
    /**
     * This Function is to Scroll to element
     * @author Ramesh
     * @param: Mobile Element & String
     *
     */
    public void scrollToMobileElement(MobileElement element, String scrollcount) {
        try {
            waitInSec(3);
            int count = Integer.parseInt(scrollcount);
            for (int i = 0; i < count; i++) {
                if (isDisplayed(element)) {
                    isDisplayed(element);
                } else {
                    swipeUp();
                }

            }
        }
        catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

}
