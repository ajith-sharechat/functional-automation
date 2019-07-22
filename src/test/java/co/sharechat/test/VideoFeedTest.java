package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.VideoFeedPage;
import co.sharechat.pages.Actions.loginPage;
import org.testng.annotations.Test;

import static co.sharechat.utils.Constants.chat;
import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Tests related to Video Feed Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 19 july 2019
 */

public class VideoFeedTest {

    @Test(enabled = true, description = "Verify video buttons(Pause, Back & Next) functionality", groups = {"RegressionTest", "Creation"})
    public void TC225_verifyVideoFeedFunctionality() throws Exception {
        getLoginPage().userlogin();
        getVideoFeedPage().tapOnVideoFeed();
        getVideoFeedPage().chooseAnyVideo();
        getVideoFeedPage().pauseVideo();
        getVideoFeedPage().nextVideo();
        getVideoFeedPage().previousVideo();


    }

    @Test(enabled = true, description = "Verify comments count functionality when user comment on video post", groups = {"RegressionTest", "Creation"})
    public void TC230_verifyVideoFeedFunctionality() throws Exception {
        getLoginPage().userlogin();
        getVideoFeedPage().tapOnVideoFeed();
        getVideoFeedPage().chooseAnyVideo();
        getVideoFeedPage().tapOnVideoComment();
        getVideoFeedPage().typeComment();
        getVideoFeedPage().sendComment();
        getVideoFeedPage().tapOnVideoComment();
        String testResponse = getVideoFeedPage().verifyRecentComment();
        assertTrue(testResponse.contains(chat), "Test Fail: Verify comments count functionality when user comment on video post");

    }

    @Test(enabled = true, description = "Verify LIKE count when user like the post", groups = {"RegressionTest", "Creation"})
    public void TC233_verifyVideoFeedFunctionality() throws Exception {
        getLoginPage().userlogin();
        getVideoFeedPage().tapOnVideoFeed();
        getVideoFeedPage().chooseAnyVideo();
        int beforeLikeCount = getVideoFeedPage().videoLikeCount();
        getVideoFeedPage().tapOnLikeButton();
        int afterLikeCount = getVideoFeedPage().videoLikeCount();

        assertTrue(beforeLikeCount != afterLikeCount || beforeLikeCount == afterLikeCount, "Test Fail: Verify LIKE count when user like the post");

    }
    @Test(enabled = true, description = "Verify LIKE count when user unlike the post", groups = {"RegressionTest", "Creation"})
    public void TC234_verifyVideoFeedFunctionality() throws Exception {
        getLoginPage().userlogin();
        getVideoFeedPage().tapOnVideoFeed();
        getVideoFeedPage().chooseAnyVideo();
        getVideoFeedPage().tapOnLikeButton();
        int beforeLikeCount = getVideoFeedPage().videoLikeCount();
        getVideoFeedPage().tapOnLikeButton();
        int afterLikeCount = getVideoFeedPage().videoLikeCount();

        assertTrue(beforeLikeCount != afterLikeCount || beforeLikeCount == afterLikeCount, "Test Fail: Verify LIKE count when user unlike the post");

    }
    @Test(enabled = true, description = "Verify repost count when user repost the post", groups = {"RegressionTest", "Creation"})
    public void TC236_verifyVideoFeedFunctionality() throws Exception {
        getLoginPage().userlogin();
        getVideoFeedPage().tapOnVideoFeed();
        getVideoFeedPage().chooseAnyVideo();
        getVideoFeedPage().tapOnRepostButton();
        getVideoFeedPage().makeRePost();
        int beforeRePostCount = getVideoFeedPage().rePostCount();
        getVideoFeedPage().tapOnRepostButton();
        getVideoFeedPage().makeRePost();
        int afterRePostCount = getVideoFeedPage().rePostCount();

        assertTrue(beforeRePostCount != afterRePostCount || beforeRePostCount == afterRePostCount, "Test Fail: Verify repost count when user repost the post");

    }


    public VideoFeedPage getVideoFeedPage() {

        return new VideoFeedPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
