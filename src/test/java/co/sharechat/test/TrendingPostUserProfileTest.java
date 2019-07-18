package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Actions.StickerPicturePostPages;
import co.sharechat.pages.Actions.TrendingPostUserProfilePages;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TrendingPostUserProfileTest extends WebDriverListener implements Constants {

    /**
     * This Class has all the Tests related to Trending Post User Profile page
     *
     * @author Diljeet Singh
     * @version 1.0
     * @since 16 july 2019
     */

    @Test(enabled = true, description = "Verify trending post user profile follow option", groups = {"RegressionTest", "Creation"})
    public void TC181_checkUserPostFollowOption() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getTrendingPostUserProfilePages().checkUserPostFollowOption();
        assertTrue(testResponse, "Test Fail: Verify trending post user profile follow option.");


    }

    @Test(enabled = true, description = "Verify trending post user profile chat option", groups = {"RegressionTest", "Creation"})
    public void TC184_checkUserPostChatOption() throws Exception {
        getLoginPage().userlogin();
        boolean[] testResponse = getTrendingPostUserProfilePages().checkUserPostChatOption();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i], "Test Fail: Verify trending post user profile chat option.");
        }

    }

    @Test(enabled = true, description = "Verify trending post user profile share option", groups = {"RegressionTest", "Creation"})
    public void TC185_checkUserPostShareOption() throws Exception {
        getLoginPage().userlogin();
        int testResponse = getTrendingPostUserProfilePages().checkUserPostShareOption();

        assertTrue(testResponse == testResponse, "Test Fail: Verify trending post user profile share option.");
    }

    @Test(enabled = true, description = "Verify trending post user profile block option", groups = {"RegressionTest", "Creation"})
    public void TC187_checkUserBlockOption() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getTrendingPostUserProfilePages().checkingBlockSpecificUser();

        assertTrue(testResponse, "Test Fail: Verify trending post user profile block option.");
    }

    @Test(enabled = true, description = "Verify trending post user profile unblock option", groups = {"RegressionTest", "Creation"})
    public void TC188_checkUserUNBlockOption() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getTrendingPostUserProfilePages().checkingUNBlockSpecificUser();

        assertTrue(testResponse, "Test Fail: Verify trending post user profile unblock option.");
    }

    public TrendingPostUserProfilePages getTrendingPostUserProfilePages() {

        return new TrendingPostUserProfilePages(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
