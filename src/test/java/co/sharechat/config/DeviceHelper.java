package co.sharechat.config;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.aventstack.extentreports.Status;
import com.report.factory.ExtentTestManager;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;


/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author:	Ajith Manjunath
 * Date:		07/17/2018
 * Purpose:	Generic Methods
 */

public class DeviceHelper {

    PropertyReader propertyReader;
    public WebDriver driver;

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


    public void swipe(int startx, int starty, int endx, int endy) {
        Dimension size = driver.manage().window().getSize();

        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + endx + " y:" + endy);
            new TouchAction((PerformsTouchActions) driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(2)))
                    .moveTo(point(endx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete succesfully.");
        }
    }


    public void waitTillTheElementIsVisibleAndClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillTheElementInVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitTillMobileElementInVisible(MobileElement element) {

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

    public void WaitForFrameAndSwitchToIt(String id){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void WaitForFrameAndSwitchToIt(int id){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void ScrollToElement(WebElement element){
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

    public boolean isElementDisplay(MobileElement locator) {
        try {
            locator.isDisplayed();
            System.out.println("Element presend on screen ***********" + locator);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        }
    }
    /**
     * This Function is to wait till element present
     * @author Ramesh
     * @param: Mobile Element
     *
     */
    public void waitTillTheElementIsVisible(MobileElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * This Function is to long Press of the element
     * @author Ramesh
     * @param: Mobile Element
     *
     */
    public void longPress(MobileElement locator) {
        TouchActions action = new TouchActions(driver);
        action.longPress(locator);
        action.perform();
    }
    /**
     * This Function will pause the execution for given secs.
     *
     * @param secs : No of seconds to be paused.
     * @author jasmeetsingh
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
     * This Function is to Enter OTP with using Actions class method
     * @author Ramesh
     *
     */
    public void writeInputActions(MobileElement element,String otp){
        waitForElementToAppear(element);
        Actions a=new Actions(driver);
        a.sendKeys(otp).build().perform();
    }
    /**
     * This Function is to scroll to element text
     * @author Ramesh
     * @param: Element text
     *
     */
    public WebElement scrollToAndroidElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }
    /**
     * This Function is to hide keyboard
     * @author Ramesh
     *
     */
    public void hideKeyBoard(){
        ((AppiumDriver <MobileElement>)driver).hideKeyboard();
    }
    /**
     * This Function is to Scroll And click the element
     * @author Ramesh
     * @param: Mobile Element and count of scroll
     *
     */
    public void scrollToMobileElementAndClickElement(MobileElement element, String scrollcount) {
        waitInSec(3);
        int count=Integer.parseInt(scrollcount);
        for (int i = 0; i < count; i++) {
            if (isElementDisplay(element)) {
                element.click();
            } else {
                swipeUp();
            }

        }
    }
    /**
     * This Function is to Scroll to element
     * @author Ramesh
     * @param: Mobile Element & String
     *
     */
    public void scrollToMobileElement(MobileElement element, String scrollcount) {
        waitInSec(3);
        int count=Integer.parseInt(scrollcount);
        for (int i = 0; i < count; i++) {
            if (isElementDisplay(element)) {
                isElementDisplay(element);
            } else {
                swipeUp();
            }

        }
    }
    /**
     * This Function is to click android back button
     * @author Ramesh
     *
     */
    public void clickAndroidBackButton() {
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
    }
    /**
     * This Function is to check element is not present and return true or false
     * @author Ramesh
     * @param: Mobile Element
     *
     */
    public boolean isElementNotPresent(MobileElement element) {
        if (isElementDisplay(element) == false) {
            return true;
        } else {
            return false;

        }
    }
    /**
     *
     * Asserts that a condition is true. If it isn't,
     *  an AssertionError is thrown.
     * @author Ramesh
     * @param: Mobile Element
     *
     */
    public void isElementPresentAssertTrue(MobileElement element) {

        Assert.assertTrue(isElementDisplay(element));
    }
    /**
     * Asserts that a condition is true. If it isn't,
     * an AssertionError is thrown.
     * @author Ramesh
     * @param: Mobile Element
     *
     */
    public void isElementNotPresentAssertTrue(MobileElement element) {

        Assert.assertTrue(isElementNotPresent(element));
    }
}
