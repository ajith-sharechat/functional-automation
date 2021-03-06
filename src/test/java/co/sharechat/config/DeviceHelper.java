package co.sharechat.config;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.aventstack.extentreports.Status;
import com.report.factory.ExtentTestManager;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import com.sun.tools.internal.jxc.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.clipboard.HasClipboard;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    /**
     *This method will return the Width of the Phone Screen
     * @since 01 July 2019
     * @author Jasmeet
     * */
    public void swipe(int startx, int starty, int endx, int endy) {
        Dimension size = driver.manage().window().getSize();

        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + endx + " y:" + endy);
            new TouchAction((PerformsTouchActions) driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(1)))
                    .moveTo(point(endx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete succesfully.");
        }
    }

    /**
     *This method will return the Width of the Phone Screen
     * @since 08 July 2019
     * @author Jasmeet
     * */
    public int getWidthOfScreen(){
        return driver.manage().window().getSize().width;
    }

    /**
     *This method will return the Height of the Phone Screen
     * @since 08 July 2019
     * @author Jasmeet
     * */
    public int getHeightOfScreen(){
        return driver.manage().window().getSize().height;
    }

    /**
     *This method will click on the Home button
     * @since 09 July 2019
     * @author Jasmeet
     * */
    public void clickHomeBtn(){
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    /**
     *This method will open the notifications on device.
     * @since 15 July 2019
     * @author Jasmeet
     * */
    public void openNotification(){
        ((AndroidDriver) driver).openNotifications();
    }

    /**
     *This method will click on the Back button.
     * @since 15 July 2019
     * @author Jasmeet
     * */
    public void clickBackBtn(){
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));;
    }

    /**
     *This method will return the copied text in the clipboard of device.
     * @since 11 July 2019
     * @author Jasmeet
     * */
    public String getCopiedText(){
        return ((HasClipboard) driver).getClipboardText();
    }

    /**
     * generateRandomPhNo(int length) can return the string of digits as specified length. Maximum 15 digit number could be generated.
     * @param length NO of digits in the number
     * @return String of digits as specified length
     * @author jasmeetsingh
     */
    public String generateRandomPhNo(int length) {
        if (length>15)
            length = 15;
        return  Long.toString((int) ((Math.random() * 100000000)) + 999999999999999l).substring(15-length, 15);
    }

    public void waitTillTheElementIsVisibleAndClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 10);
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
            waitTillTheElementIsVisibleAndClickable(locator);
            if (locator.isDisplayed())
                System.out.println("Element presend on screen ***********" + locator);
            return true;
        } catch (Exception e) {
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
     * This Function is to presents of element
     *
     * @author Ramesh
     * @param: Mobile Element
     */
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
     *
     * @author Ramesh
     * @param: Mobile Element
     */
    public void waitTillTheElementIsVisible(MobileElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Wait till element visible failed");
        }
    }

    /**
     * This Function is to long Press of the element
     *
     * @author Ramesh
     * @param: Mobile Element
     */
    public void longPress(MobileElement locator) {
        TouchActions action = new TouchActions(driver);
        action.longPress(locator);
        action.perform();
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
     * This Function is to Enter OTP with using Actions class method
     *
     * @author Ramesh
     */
    public void writeInputActions(MobileElement element, String otp) {
        try {
            waitForElementToAppear(element);
            Actions a = new Actions(driver);
            a.sendKeys(otp).build().perform();
        } catch (Exception e) {
            System.out.println("Write Input Action failed");
        }
    }

    /**
     * This Function is to scroll to element text
     *
     * @author Ramesh
     * @param: Element text
     */
    public WebElement scrollToAndroidElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    /**
     * This Function is to hide keyboard
     *
     * @author Ramesh
     */
    public void hideKeyBoard() {
        try {
            ((AppiumDriver<MobileElement>) driver).hideKeyboard();
        } catch (Exception e) {
            System.out.println("Hide keyboard failed");
        }
    }

    /**
     * This Function is to Scroll And click the element
     *
     * @author Ramesh
     * @param: Mobile Element and count of scroll
     */
    public void scrollToMobileElementAndTapElement(MobileElement element, String scrollcount) {
        try {
            waitInSec(3);
            int count = Integer.parseInt(scrollcount);
            for (int i = 0; i < count; i++) {
                if (isElementDisplay(element)) {
                    element.click();
                } else {
                    swipeUp();
                }

            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element & click element failed");
        }
    }

    /**
     * This Function is to Scroll to element
     *
     * @author Ramesh
     * @param: Mobile Element & String
     */
    public void scrollToMobileElement(MobileElement element, String scrollcount) {
        try {
            waitInSec(3);
            int count = Integer.parseInt(scrollcount);
            for (int i = 0; i < count; i++) {
                if (isElementDisplay(element)) {
                    isElementDisplay(element);
                } else {
                    swipeUp();
                }

            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }
    }

    /**
     * This Function is to Tap android back button
     *
     * @author Ramesh
     */
    public void tapAndroidBackButton() {
        try {
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        } catch (Exception e) {
            System.out.println("Android Back click failed");
        }
    }

    /**
     * This Function is to check element is not present and return true or false
     *
     * @author Ramesh
     * @param: Mobile Element
     */
    public boolean isElementNotPresent(MobileElement element) {
        if (isElementDisplay(element) == false) {
            return true;
        } else {
            return false;

        }
    }

    /**
     * Asserts that a condition is true. If it isn't,
     * an AssertionError is thrown.
     *
     * @author Ramesh
     * @param: Mobile Element
     */
    public void isElementPresentAssertTrue(MobileElement element) {
        try {
            Assert.assertTrue(isElementDisplay(element));
        } catch (Exception e) {
            System.out.println(element + " The Element not present Assert false failed");
        }
    }

    /**
     * Asserts that a condition is true. If it isn't,
     * an AssertionError is thrown.
     *
     * @author Ramesh
     * @param: Mobile Element
     */
    public void isElementNotPresentAssertTrue(MobileElement element) {
        try {
            Assert.assertTrue(isElementNotPresent(element));
        } catch (Exception e) {
            System.out.println(element + "Element present assert true failed");
        }
    }

    /**
     * This Function is to enter value in text field
     *
     * @author Ramesh
     */
    public void writeInputText(MobileElement element, String value) {
        try {
            waitTillTheElementIsVisible(element);
            element.sendKeys(value);
        } catch (Exception e) {
            System.out.println("Write Input Action failed");
        }
    }

    /**
     * This Function is to swipe Down
     *
     * @author Ramesh
     */
    public void swipeDown() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.2);
        int endy = (int) (size.height * 0.8);
        int startx = (int) (size.width / 2.2);
        try {
            System.out.println("Trying to swipe up from x:" + startx + " y:" + starty + ", to x:" + startx + " y:" + endy);
            new TouchAction((PerformsTouchActions) driver).press(point(startx, starty)).waitAction(waitOptions(ofSeconds(3)))
                    .moveTo(point(startx, endy)).release().perform();
        } catch (Exception e) {
            System.out.println("Swipe did not complete succesfully.");
        }
    }


    /**
     * Tap the screen on the basis of x1,y1 point.
     *
     * @param x1
     * @param y1
     * @author Diljeet Singh Ranaut
     * @since 10 july
     */
    public void tapOnPoint(int x1, int y1) {
        new TouchAction((AppiumDriver<MobileElement>) driver).tap(PointOption.point(x1, y1)).perform();
    }

    /**
     * This Function is to Scroll to element
     *
     * @author Ramesh
     * @param: Mobile Element & String
     */
    public void scrollToMobileElementTopToBottom(MobileElement element, String scrollcount) {
        try {
            waitInSec(3);
            int count = Integer.parseInt(scrollcount);
            for (int i = 0; i < count; i++) {
                if (isElementDisplay(element)) {
                } else {
                    swipeDown();
                }
            }
        } catch (Exception e) {
            System.out.println("Scroll to mobile element failed");
        }

    }
    /**
     * This Function is to Scroll to element
     *
     * @author Ramesh
     * @param: String
     */
    public String generateTextXpathAndReturnText(String value) {
        String text = ((AppiumDriver<MobileElement>) driver).findElement(By.xpath("//*[@text='" + value + "']")).getText();
        return text;
    }

    /**
     * This Function is to Select Language
     *
     * @author Ramesh
     * @param: String
     */
    public void selectLanguageUsingText(String value) {
        waitInSec(5);
        ((AppiumDriver<MobileElement>) driver).findElement(By.xpath("//*[@text='" + value + "']")).click();
    }
}
