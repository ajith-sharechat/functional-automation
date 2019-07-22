package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.VideoFeedObjects;
import co.sharechat.utils.Constants;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class has all the Actions related to Video Feed Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 19 july 2019
 */

public class VideoFeedPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    co.sharechat.pages.Objects.VideoFeedObjects VideoFeedObjects = new VideoFeedObjects();

    public VideoFeedPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), VideoFeedObjects);
    }

    public void tapOnVideoFeed() {

        deviceHelper.waitInSec(5);
        VideoFeedObjects.videoTab2.get(2).click();
        deviceHelper.waitInSec(5);

    }

    public void chooseAnyVideo() {
        deviceHelper.waitInSec(5);
        if (deviceHelper.isElementPresent(VideoFeedObjects.loadError)) {
            deviceHelper.waitInSec(5);
            VideoFeedObjects.loadError.click();
            deviceHelper.waitInSec(5);
        } else {
            deviceHelper.waitInSec(5);
            VideoFeedObjects.chooseAnyVideo0.get(0).click();
            deviceHelper.waitInSec(5);
        }
    }

    public void pauseVideo() {
        deviceHelper.waitInSec(5);
        VideoFeedObjects.subTitle.click();
        VideoFeedObjects.pauseButton.click();
        deviceHelper.waitInSec(5);
    }

    public void nextVideo() {
        deviceHelper.waitInSec(5);
        VideoFeedObjects.subTitle.click();
        VideoFeedObjects.nextButton.click();
        deviceHelper.waitInSec(5);
    }

    public void previousVideo() {
        deviceHelper.waitInSec(5);
        VideoFeedObjects.subTitle.click();
        VideoFeedObjects.previousButton.click();
        deviceHelper.waitInSec(5);
    }

    public void tapOnVideoComment() {


        deviceHelper.waitInSec(5);
        VideoFeedObjects.videoCommentButton1.get(1).click();
        deviceHelper.waitInSec(5);
    }

    public void typeComment() {
        deviceHelper.waitInSec(5);
        VideoFeedObjects.typeComment.sendKeys(chat);
        deviceHelper.waitInSec(5);
    }

    public void sendComment() {
        deviceHelper.waitInSec(5);
        VideoFeedObjects.sendComment.click();
        deviceHelper.waitInSec(5);

    }

    public String verifyRecentComment() {

        return VideoFeedObjects.videoCommentPosition0.get(0).getText();
    }

    public void tapOnLikeButton() {


        deviceHelper.waitInSec(5);
        VideoFeedObjects.videoCommentButton1.get(2).click();
        deviceHelper.waitInSec(5);
    }

    public int videoLikeCount() {

        deviceHelper.waitInSec(5);
        if (VideoFeedObjects.videoLikesCountButton2.get(2).isDisplayed()) {
            String videoLikeCount = VideoFeedObjects.videoLikesCountButton2.get(2).getText();
            if (videoLikeCount.contains("K") || videoLikeCount.contains("M")) {
                String likeCountNumber1 = videoLikeCount.replaceAll("[^0-9]", "");
                int likeCountNumber = Integer.parseInt(likeCountNumber1);
                return likeCountNumber;

            } else {
                int likeCountNumber = Integer.parseInt(videoLikeCount);
                return likeCountNumber;
            }
        } else {
            tapOnLikeButton();
            String videoLikeCount = VideoFeedObjects.videoLikesCountButton2.get(2).getText();
            int likeCountNumber = Integer.parseInt(videoLikeCount);
            return likeCountNumber;
        }


    }

    public void tapOnRepostButton(){
        deviceHelper.waitInSec(5);
        VideoFeedObjects.videoCommentButton1.get(3).click();
        deviceHelper.waitInSec(5);
    }

    public void makeRePost(){
        deviceHelper.waitInSec(5);
        VideoFeedObjects.doPost.click();
        deviceHelper.waitInSec(5);

    }

    public int rePostCount(){
        deviceHelper.waitInSec(5);
        if (VideoFeedObjects.videoLikesCountButton2.get(3).isDisplayed()) {
            String videoRePostCount = VideoFeedObjects.videoLikesCountButton2.get(3).getText();
            if (videoRePostCount.contains("K") || videoRePostCount.contains("M")) {
                String rePostCountNumber1 = videoRePostCount.replaceAll("[^0-9]", "");
                int rePostCountNumber = Integer.parseInt(rePostCountNumber1);
                System.err.println("Count one one: "+rePostCountNumber);
                return rePostCountNumber;

            } else {
                int rePostCountNumber = Integer.parseInt(videoRePostCount);
                System.err.println("Count one two: "+rePostCountNumber);
                return rePostCountNumber;
            }
        } else {
            tapOnLikeButton();
            String videoRePostCount = VideoFeedObjects.videoLikesCountButton2.get(3).getText();
            int rePostCountNumber = Integer.parseInt(videoRePostCount);

            System.err.println("Count one Three: "+rePostCountNumber);
            return rePostCountNumber;
        }


    }

}
