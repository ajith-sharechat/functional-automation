package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.HomeScreenPage;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Actions related to Home Page Test
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class HomeScreenTest implements Constants {


    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC022_verifyHomeScreenFunctionality() throws Exception {
        getLoginPage().userlogin();

        boolean testResponse = getHomeScreenPage().verifyChangingLanguageOptionIsappearingInTopLeftCorner();
        assertTrue(testResponse,
                "Test Fail Verify Changing language option is appearing in top left corner.");

        boolean testResponse1 = getHomeScreenPage().verifyRupeeIconAndNotificationsIconOnTopRightCornerOfTheScreen();
        assertTrue(testResponse1,
                "Test Fail Verify Rupee icon and notifications icon on top right corner of the screen.");

        boolean testResponse2 = getHomeScreenPage().verifyByDefaultTrendingIsSelected();
        assertTrue(testResponse2,
                "Test Fail for Verify By default Trending is selected");

        boolean testResponse3[] = getHomeScreenPage().verifyThirteenTabsDifferentTabsAreArrangedHorizontallyAndTheTabsAreLikeFollowing();


        for (int i = 0; i < testResponse3.length; i++) {
            System.err.println("Checking Array : " + testResponse3[i]);
            assertTrue(testResponse3[i],
                    "Test Fail for Verify thirteen  tabs different tabs are arranged horizontally");
        }


        boolean testResponse4[] = getHomeScreenPage().verifyFiveButtonsArePlacedInHomeExploreCreatePost();
        for (int i = 0; i < testResponse4.length; i++) {

            assertTrue(testResponse4[i],
                    "Test Fail for Verify five buttons are placed constantly with suitable icons which are Home, Explore, Create Post, Chat, and Profile in bottom of the screen");
        }


    }

    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC023_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();

        boolean testResponse = getHomeScreenPage().tapOnDefaultLanguageDropDownField();
        assertTrue(testResponse,
                "Test Fail Tap on default Language drop down field.");

        boolean testResponse1 = getHomeScreenPage().screenRedirectingToChangeLanguageScreen();
        assertTrue(testResponse1,
                "Test Fail for Screen is redirecting to Change you language screen");

        getHomeScreenPage().selectOneLanguageFromScreen();

        boolean testRespons2[] = getHomeScreenPage().verifyWholeScreenChangingToSelectedLanguage();
        for (int i = 0; i < testRespons2.length; i++) {
            System.err.println("Checking Array : " + testRespons2[i]);
            assertTrue(testRespons2[i],
                    "Test Fail for Verify whole screen is changing to that selected language");
        }

        boolean testResponse3 = getHomeScreenPage().checkWithAllTheOptionsSelectLanguages();
        assertTrue(testResponse3,
                "Test Fail for Check with all the options Select Languages.");


        boolean testRespons4 = getHomeScreenPage().verifyPostsAndTagsAppearingBasedOnLanguageRegion();
        assertTrue(testRespons4,
                "Test Fail for Verify that posts and tags are appearing based on language region");
    }


    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC024_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();

        boolean testResponse = getHomeScreenPage().verifyRupeeIconTopRightCornerOfTheHomeScreen();
        assertTrue(testResponse,
                "Test Fail for Verify that tap on rupee icon from top right corner of the home screen and Verify that home screen is redirecting to user money screen.");

    }

    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC025_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();

        boolean testResponse = getHomeScreenPage().verifyNotificationsButtonTopRightCornerOfTheHomeScreen();
        assertTrue(testResponse,
                "Test Fail for Verify Tap on notifications button from top right corner of the home screen and Verify that home screen is redirecting to notifications screen");

    }

    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC026_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();
        getHomeScreenPage().verifyExploreButtonFromHomeScreen();

        boolean testResponse[] = getHomeScreenPage().verifySearchBarAppear();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i],
                    "Test Fail for Verify that search bar should appear");
        }

        boolean testResponse1 = getHomeScreenPage().differentTypesOfTrendingBucketsAppearingOnScreen();

        assertTrue(testResponse1,
                "Test Fail for different types of trending buckets appearing on screen.");
    }

    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC028_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();
        getHomeScreenPage().verifyChatButtonFromHomeScreen();

        boolean testResponse1 = getHomeScreenPage().verifyChatScreenOpening();

        assertTrue(testResponse1,
                "Test Fail for Verify that Chat screen is opening.");
    }

    @Test(enabled = true, description = "Verify home screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC029_verifyHomeScreenFunctionality() throws Exception {

        getLoginPage().userlogin();
        getHomeScreenPage().verifyProfileButtonFromHomeScreen();

        boolean testResponse1 = getHomeScreenPage().verifyUserProfileScreenOpening();

        assertTrue(testResponse1,
                "Test Fail for Verify that user profile screen is opening.");
    }


    public HomeScreenPage getHomeScreenPage() {

        return new HomeScreenPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

}
