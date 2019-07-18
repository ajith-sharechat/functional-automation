package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.TrendingTabObejects;
import co.sharechat.utils.Constants;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class has all the Actions related to Trending Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 08 july 2019
 */


public class TrendingTabPage extends WebDriverListener implements Constants {


    DeviceHelper deviceHelper;
    WebDriver driver;
    TrendingTabObejects TrendingObejects = new TrendingTabObejects();

    public TrendingTabPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), TrendingObejects);
    }

    //TC016
    public boolean trendingCheckFeedsAndClickOnAnyoneVerifyTitle() {
        String tagName, tagTitle;
        deviceHelper.waitInSec(10);
        deviceHelper.swipe(461, 1200, 500, 480);
        deviceHelper.waitInSec(10);
        deviceHelper.swipe(600, 600, 600, 1800);
        tagName = TrendingTabObejects.allTags.get(0).getText();
        deviceHelper.waitInSec(10);
        TrendingTabObejects.allTags.get(0).click();
        deviceHelper.waitInSec(10);
        tagTitle = TrendingTabObejects.tagDetailTitle.getText();
        deviceHelper.waitInSec(10);
        return tagName.equalsIgnoreCase(tagTitle);

    }

    // TC-147

    public boolean[] topFiveTagsAreAppearing() {

        deviceHelper.waitInSec(10);

        boolean TabsAll[] = new boolean[5];

        TabsAll[0] = TrendingTabObejects.allTags.get(0).isDisplayed();
        TabsAll[1] = TrendingTabObejects.allTags.get(1).isDisplayed();
        TabsAll[2] = TrendingTabObejects.allTags.get(2).isDisplayed();
        TabsAll[3] = TrendingTabObejects.allTags.get(3).isDisplayed();
        TabsAll[4] = TrendingTabObejects.allTags.get(4).isDisplayed();
        return TabsAll;

    }

    public boolean[] dragTrendingFeedToBottomVerifyFeedGettingRefreshAndNewTagsAreComingOnTopOfTheFeed() {

        deviceHelper.waitInSec(10);
        deviceHelper.swipe(600, 600, 600, 1800);
        deviceHelper.waitInSec(10);
        boolean TabsAll[] = new boolean[5];

        TabsAll[0] = TrendingTabObejects.allTags.get(0).isDisplayed();
        TabsAll[1] = TrendingTabObejects.allTags.get(1).isDisplayed();
        TabsAll[2] = TrendingTabObejects.allTags.get(2).isDisplayed();
        TabsAll[3] = TrendingTabObejects.allTags.get(3).isDisplayed();
        TabsAll[4] = TrendingTabObejects.allTags.get(4).isDisplayed();
        return TabsAll;

    }

    //TC148
    public boolean tapAnyTagFromTrendingFeedVerifyTagFeedIsOpeningInTrendingDetailScreen() {

        deviceHelper.waitInSec(10);
        String tagName = TrendingTabObejects.allTags.get(0).getText();
        deviceHelper.waitInSec(10);
        TrendingTabObejects.allTags.get(0).click();
        deviceHelper.waitInSec(10);
        String tagTitle = TrendingTabObejects.tagDetailTitle.getText();
        deviceHelper.waitInSec(10);
        return tagName.equalsIgnoreCase(tagTitle);
    }

    public boolean[] verifyBackButtonSearchAndShareButtonsAreAppearingOnTopRowOfTheScreen() {

        deviceHelper.waitInSec(10);


        boolean TabsAll[] = new boolean[3];

        TabsAll[0] = TrendingTabObejects.backButton.isDisplayed();
        TabsAll[1] = TrendingTabObejects.search.isDisplayed();
        TabsAll[2] = TrendingTabObejects.share.isDisplayed();
        return TabsAll;
    }

    public boolean verifySecondRowTitleIsAppearing() {

        return TrendingTabObejects.tagDetailTitle.isDisplayed();

    }

    public boolean[] verifySevenButtonsAreAppearingWithSuitableIcons() {


        boolean TabsAll[] = new boolean[8];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.trending.isDisplayed();
        TabsAll[1] = TrendingTabObejects.fresh.isDisplayed();
        TabsAll[2] = TrendingTabObejects.video.isDisplayed();
        TabsAll[3] = TrendingTabObejects.image.isDisplayed();
        deviceHelper.swipe(1000, 450, 200, 450);
        deviceHelper.waitInSec(10);
        TabsAll[4] = TrendingTabObejects.profile.isDisplayed();
        TabsAll[5] = TrendingTabObejects.audio.isDisplayed();
        TabsAll[6] = TrendingTabObejects.gif.isDisplayed();
        TabsAll[7] = TrendingTabObejects.textButton.isDisplayed();
        deviceHelper.waitInSec(10);
        return TabsAll;

    }

    public boolean verifyRelatedTagLinksAreAppearing() {
        deviceHelper.waitInSec(10);
        return TrendingTabObejects.relatedTags.isDisplayed();
    }


    public boolean verifyComposeButtonAppearingInBottomRightCornerOfTheScreen() {
        deviceHelper.waitInSec(10);
        return TrendingTabObejects.composeButton.isDisplayed();

    }


    // TC-149

    public void tapOnAnyImagePost() {
        try {
            deviceHelper.waitInSec(10);
            TrendingTabObejects.clickPost.click();
            deviceHelper.waitInSec(10);

        } catch (NoSuchElementException e) {

            deviceHelper.waitInSec(10);
            TrendingTabObejects.thumbnailPost.click();
            deviceHelper.waitInSec(10);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public boolean[] verifyBackSHAREButtonStickersAndOptionsButtonsAreAppearingOnTopOfTheScreen() {

        boolean TabsAll[] = new boolean[4];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.postBackClick.isDisplayed();
        TabsAll[1] = TrendingTabObejects.postShare.isDisplayed();
        TabsAll[2] = TrendingTabObejects.stickerCheck.isDisplayed();
        TabsAll[3] = TrendingTabObejects.optionCheck.isDisplayed();
        return TabsAll;
    }

    public boolean[] profileImageWithNameAndStatusWhoPostedThisPostAreAppearingOnScreen() {

        boolean TabsAll[] = new boolean[4];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.pfImage.isDisplayed();
        TabsAll[1] = TrendingTabObejects.pfName.isDisplayed();
        TabsAll[2] = TrendingTabObejects.pfStatus.isDisplayed();
        TabsAll[3] = TrendingTabObejects.optionCheck.isDisplayed();
        return TabsAll;

    }

    public boolean followButtonIsAppearingAtProfile() {

        return TrendingTabObejects.followButton.isDisplayed();

    }

    public boolean imageWithTagAlsoAppearOnScreen() {

        return TrendingTabObejects.postCaption.isDisplayed();

    }

    public boolean[] afterImmediateImageViewsCountAndHowManyDaysBackItWasPostedAlsoComingAtPost() {

        deviceHelper.swipe(600, 1250, 600, 600);
        deviceHelper.waitInSec(10);

        boolean TabsAll[] = new boolean[2];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.postTotalView.isDisplayed();
        TabsAll[1] = TrendingTabObejects.postCreatedTime.isDisplayed();
        deviceHelper.waitInSec(10);
        return TabsAll;
    }

    public boolean[] whatsappShareCommentsLikeRepostAndSaveButtonsAreAppearingWithCount() {

        boolean TabsAll[] = new boolean[5];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(0).isDisplayed();
        TabsAll[1] = TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(1).isDisplayed();
        TabsAll[2] = TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(2).isDisplayed();
        TabsAll[3] = TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(3).isDisplayed();
        TabsAll[4] = TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(4).isDisplayed();
        return TabsAll;

    }

    public boolean[] verifyCOMMENTAndLIKESectionsAreAppearingWithUserDetails() {

        boolean TabsAll[] = new boolean[2];
        deviceHelper.waitInSec(10);
        TrendingTabObejects.whatsapp_Save_Comments_Like_Repost.get(1).isDisplayed();
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.commentAndLike.get(0).isDisplayed();
        TabsAll[1] = TrendingTabObejects.commentAndLike.get(1).isDisplayed();
        return TabsAll;

    }

    public boolean[] verifyAudioRecorderAndSendButtonAreAppearing
            () {
        boolean TabsAll[] = new boolean[4];
        deviceHelper.waitInSec(10);
        TabsAll[0] = TrendingTabObejects.commentField.isDisplayed();
        deviceHelper.waitInSec(10);
        TrendingTabObejects.commentField.sendKeys(chat);
        deviceHelper.waitInSec(10);
        TabsAll[1] = TrendingTabObejects.commentSend.isDisplayed();
        TabsAll[2] = TrendingTabObejects.audioMic.isDisplayed();
        TabsAll[3] = TrendingTabObejects.gifImg.isDisplayed();
        return TabsAll;
    }


}
