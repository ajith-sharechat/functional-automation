package co.sharechat.config;

import com.annotation.values.ElementDescription;
import com.annotation.values.PageName;
import com.aventstack.extentreports.Status;
import com.report.factory.ExtentTestManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.clipboard.HasClipboard;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
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

    /**
     * This Function is to Enter OTP with using Actions class method
     * @author Ramesh
     *
     */
    public void writeInputActions(MobileElement element,String otp){
        try {
            waitForElementToAppear(element);
            Actions a = new Actions(driver);
            a.sendKeys(otp).build().perform();
        }
        catch (Exception e) {
            System.out.println("Write Input Action failed");
        }
    }


    public void waitTillTheElementIsVisibleAndClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 5);
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
            waitTillTheElementIsVisibleAndClickable(locator);
            if (locator.isDisplayed())
                System.out.println("Element presend on screen ***********" + locator);
            return true;
        } catch (Exception e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        }
    }
/*
    public void doActionAfterScroll(By locator){
        List <WebElement> listOfElements = driver.findElements(locator);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        for ( int i = 0; listOfElements.size() == 0 || i < 5 ; i++ )//Maxmium 5 baar scroll krega
        {
            //Do Scroll jitni tuje chahiye
            je.executeScript("javascript:window.scrollBy(250,350)");
            listOfElements = driver.findElements(locator);
        }

        listOfElements.get(0).click();//Do what you want to do on the element
        je.executeScript("window.scrollBy(0,500)");
    }

    public WebElement getElement(By locator){
        try {
            return driver.findElement(locator);
        }catch (NoSuchElementException e){
            List <WebElement> loderElements = driver.findElements(By.id("Tera loader da element"));
            if (loderElements.size() > 0 )
                wait.until(ExpectedConditions.invisibilityOfAllElements(loderElements));
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        }
    }*/


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
}
