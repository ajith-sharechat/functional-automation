package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.TrendingTabPage;
import co.sharechat.pages.Actions.loginPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


/**
 This Class has all the Tests related to Trending Page
 @author Diljeet Singh
 @version 1.0
 @since 08 july 2019
 */

public class TrendingTabTest {


    @Test(enabled = true, description = "To verify if user is able to access and scroll through latest feeds", groups = {"SmokeTest"})
    public void TC016_checkingTrendingPage() throws Exception {
        getLoginPage().userlogin();
        assertTrue(getTrendingTabPage().trendingCheckFeedsAndClickOnAnyoneVerifyTitle(),
                "Test Fail Tap on any tag from trending tag and Verify Title");
    }


    @Test(enabled = true, description = "Verify Trending tab functionality", groups = {"RegressionTest", "Creation"})
    public void TC147_Verify_Trending_tab_functionality() throws Exception {

        getLoginPage().userlogin();
        boolean testResponse[] = getTrendingTabPage().topFiveTagsAreAppearing();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i],
                    "Test Fail For Top five tags are appearing in starting of the trending feed");
        }

        boolean testResponse1[] = getTrendingTabPage().dragTrendingFeedToBottomVerifyFeedGettingRefreshAndNewTagsAreComingOnTopOfTheFeed();
        for (int i = 0; i < testResponse1.length; i++) {
            assertTrue(testResponse[i],
                    "Test Fail  Drag the trending feed to bottom and Verify that feed is getting refresh and new tags are coming on top of the feed");
        }

        boolean testResponse2 = getTrendingTabPage().trendingCheckFeedsAndClickOnAnyoneVerifyTitle();
        assertTrue(testResponse2,
                "Test Fail Tap on any tag from trending feed and Verify that tag feed is opening");

    }


    @Test(enabled = true, description = "Verify Trending tab functionality", groups = {"RegressionTest", "Creation"})
    public void TC148_Verify_Trending_tab_functionality() throws Exception {

        getLoginPage().userlogin();

        boolean testResponse2 = getTrendingTabPage().tapAnyTagFromTrendingFeedVerifyTagFeedIsOpeningInTrendingDetailScreen();
        assertTrue(testResponse2,
                "Test Fail Tap on any tag from trending feed and Verify that tag feed is opening in trending detail screen");


        boolean testResponse[] = getTrendingTabPage().verifyBackButtonSearchAndShareButtonsAreAppearingOnTopRowOfTheScreen();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i],
                    "Test Fail for to verify that back button, search, and share buttons are appearing on top row of the screen");
        }

        boolean testResponse3 = getTrendingTabPage().verifySecondRowTitleIsAppearing();
        assertTrue(testResponse3,
                "Test Fail for title is appearing");


        boolean testResponse1[] = getTrendingTabPage().verifySevenButtonsAreAppearingWithSuitableIcons();
        for (int i = 0; i < testResponse1.length; i++) {
            assertTrue(testResponse1[i],
                    "Test Fail for seven buttons are appearing with suitable icons and the buttons are Trending, Fresh, Video, GIF, Text, Audio, and Image");
        }

        boolean testResponse4 = getTrendingTabPage().verifyRelatedTagLinksAreAppearing();

        assertTrue(testResponse4,
                "Test Fail for related tag links are not appearing");

        boolean testResponse5 = getTrendingTabPage().verifyComposeButtonAppearingInBottomRightCornerOfTheScreen();
        assertTrue(testResponse5,
                "Test Fail for Verify that Compose button is appearing in bottom right corner of the screen");


    }

    @Test(enabled = true, description = "Verify Trending tab functionality", groups = {"RegressionTest", "Creation"})
    public void TC149_Verify_Trending_tab_functionality() throws Exception {

        getLoginPage().userlogin();

        getTrendingTabPage().tapOnAnyImagePost();

        boolean testResponse2[] = getTrendingTabPage().verifyBackSHAREButtonStickersAndOptionsButtonsAreAppearingOnTopOfTheScreen();
        for (int i = 0; i < testResponse2.length; i++) {
            assertTrue(testResponse2[i],
                    "Test Fail for Verify that back, SHARE button, Stickers, and options buttons are appearing on top of the screen");
        }


        boolean testResponse[] = getTrendingTabPage().profileImageWithNameAndStatusWhoPostedThisPostAreAppearingOnScreen();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i],
                    "Test Fail for Profile image with name and status who posted this post are appearing on screen");
        }

        boolean testResponse3 = getTrendingTabPage().followButtonIsAppearingAtProfile();
        assertTrue(testResponse3,
                "Test Fail for Follow button is appearing at profile");

        boolean testResponse4 = getTrendingTabPage().imageWithTagAlsoAppearOnScreen();
        assertTrue(testResponse4,
                "Test Fail for Image with tag also appear on screen");


        boolean testResponse1[] = getTrendingTabPage().afterImmediateImageViewsCountAndHowManyDaysBackItWasPostedAlsoComingAtPost();
        for (int i = 0; i < testResponse1.length; i++) {
            assertTrue(testResponse1[i],
                    "Test Fail for views count and how many days back it was posted also coming at post");
        }

        boolean testResponse7[] = getTrendingTabPage().whatsappShareCommentsLikeRepostAndSaveButtonsAreAppearingWithCount();
        for (int i = 0; i < testResponse7.length; i++) {
            assertTrue(testResponse7[i],
                    "Test Fail for WhatsApp share, Comments, Like, Repost, and Save buttons are appearing with count");
        }

        boolean testResponse8[] = getTrendingTabPage().verifyCOMMENTAndLIKESectionsAreAppearingWithUserDetails();
        for (int i = 0; i < testResponse8.length; i++) {
            assertTrue(testResponse8[i],
                    "Test Fail for COMMENT and LIKE sections are appearing with user details");
        }

        boolean testResponse9[] = getTrendingTabPage().verifyAudioRecorderAndSendButtonAreAppearing();
        for (int i = 0; i < testResponse9.length; i++) {
            assertTrue(testResponse9[i],
                    "Test Fail for In bottom of the screen, user profile picture, text field, audio recorder, and send button are appearing");
        }


    }

    public TrendingTabPage getTrendingTabPage() {

        return new TrendingTabPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
    }
}
