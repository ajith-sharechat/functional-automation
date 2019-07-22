package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.CommentPostObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

/**
 * This Class has all the Actions related to Comment Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 18 july 2019
 */
public class CommentPostPages extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.CommentPostObjects CommentPostObjects = new CommentPostObjects();

    public CommentPostPages(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), CommentPostObjects);

    }

    public MobileElement element(MobileElement element) {
        try {
            deviceHelper.waitTillTheElementIsVisibleAndClickable(element);
        } catch (NoSuchElementException | TimeoutException e) {
            element(element);
        }
        return element;
    }

    public void imagePostClick() {

        deviceHelper.scrollToMobileElement(CommentPostObjects.imagePost, countTry);
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.imagePost).click();
        deviceHelper.waitInSec(10);
    }

    public int verifyCommentAndCommentCount() {


        deviceHelper.scrollToMobileElement(CommentPostObjects.scrollPoint, countTry);
        deviceHelper.waitInSec(5);
        String commentCount = element(CommentPostObjects.commentCount.get(1)).getText();
        int beforeCommentCount = Integer.parseInt(commentCount);
        System.err.println("total count: " + beforeCommentCount);
        return beforeCommentCount;

    }

    public void tapOnCommentIcon() {

        deviceHelper.scrollToMobileElement(CommentPostObjects.scrollPoint, countTry);
        element(CommentPostObjects.commentPostButton1.get(1)).isDisplayed();
        element(CommentPostObjects.commentPostButton1.get(1)).click();
    }

    public void CheckingComnmentScreenIsOpening() {
        deviceHelper.waitInSec(10);
        if (deviceHelper.isElementPresent(CommentPostObjects.typeComment)) {
            element(CommentPostObjects.typeComment).isDisplayed();
        }
    }

    public void enteringSomeTextInCommentFieldAndTapOnSendButton() {

        if (deviceHelper.isElementPresent(CommentPostObjects.typeComment)) {
            element(CommentPostObjects.typeComment).sendKeys(chat);
            deviceHelper.waitInSec(5);
            element(CommentPostObjects.commentSend).isDisplayed();
            element(CommentPostObjects.commentSend).click();
            deviceHelper.waitInSec(5);

        } else {

            verifyCommentCountAndItIncreasedByOne();
        }

    }

    public int verifyCommentCountAndItIncreasedByOne() {

        deviceHelper.waitInSec(10);
        deviceHelper.clickBackBtn();
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.imagePost).click();
        deviceHelper.waitInSec(10);
        deviceHelper.scrollToMobileElement(CommentPostObjects.scrollPoint, countTry);
        deviceHelper.waitInSec(5);
        String commentCount = element(CommentPostObjects.commentCount.get(1)).getText();
        int afterCommentCount = Integer.parseInt(commentCount);
        System.err.println("total count2 : " + afterCommentCount);

        return afterCommentCount;

    }

    public void tapOnLikeButton() {

        element(CommentPostObjects.likeButton1.get(0)).click();

    }

    public int checkLikeCountBefore() {
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.likeButton1.get(0)).click();
        String beforeLikeCount1 = element(CommentPostObjects.likeCount1.get(0)).getText();
        String beforeLikeCounts = beforeLikeCount1.replaceAll("[^0-9]", "1");
        int beforeLikeCount = Integer.parseInt(beforeLikeCounts);
        return beforeLikeCount;
    }

    public int checkLikeCountAfter() {
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.likeButton1.get(0)).click();
        String afterLikeCount1 = element(CommentPostObjects.likeCount1.get(0)).getText();
        String afterLikeCounts = afterLikeCount1.replaceAll("[^0-9]", "");
        int afterLikeCount = Integer.parseInt(afterLikeCounts);
        return afterLikeCount;
    }

    public int clickAfterLike() {
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.likeButton1.get(0)).click();
        String beforeLikeCount1 = element(CommentPostObjects.likeCount1.get(0)).getText();
        String beforeLikeCounts = beforeLikeCount1.replaceAll("[^0-9]", "1");
        int beforeLikeCount = Integer.parseInt(beforeLikeCounts);
        return beforeLikeCount;

    }

    public int clickBeforeLike() {
        deviceHelper.waitInSec(5);
        String beforeLikeCount1 = element(CommentPostObjects.likeCount1.get(0)).getText();
        String beforeLikeCounts = beforeLikeCount1.replaceAll("[^0-9]", "");
        int beforeLikeCount = Integer.parseInt(beforeLikeCounts);
        return beforeLikeCount;

    }

    public void repostClick() {

        deviceHelper.waitInSec(5);
        deviceHelper.scrollToMobileElement(CommentPostObjects.scrollPoint, countTry);
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.rePostButton3.get(3)).click();
        deviceHelper.waitInSec(5);
    }

    public void postClick() {
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.doPost).click();
        deviceHelper.waitInSec(5);

    }

    public int verifyREPostCountBefore() {
        int beforeREPostCount = 0;
        if (deviceHelper.isElementPresent(CommentPostObjects.rePostCount3.get(3))) {
            String repostCount = element(CommentPostObjects.rePostCount3.get(3)).getText();
            beforeREPostCount = Integer.parseInt(repostCount);
            System.err.println("total count: " + beforeREPostCount);
            return beforeREPostCount;
        }
        return beforeREPostCount;
    }

    public int verifyREPostCountAfter() {

        deviceHelper.waitInSec(5);
        element(CommentPostObjects.toolbarBack).click();
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.imagePost).click();
        deviceHelper.waitInSec(5);
        element(CommentPostObjects.rePostCount3.get(3)).isDisplayed();
        String repostCount = element(CommentPostObjects.rePostCount3.get(3)).getText();
        int afterREPostCount = Integer.parseInt(repostCount);
        System.err.println("total count: " + afterREPostCount);
        return afterREPostCount;
    }
}
