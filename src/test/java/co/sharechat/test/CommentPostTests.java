package co.sharechat.test;


import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CommentPostPages;
import co.sharechat.pages.Actions.loginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Objects related to Comment Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 18 july 2019
 */
public class CommentPostTests {

    @Test(enabled = true, description = "Verify post comment functionality", groups = {"RegressionTest", "Creation"})
    public void TC211_verifyPostCommentFunctionality() throws Exception {
        getLoginPage().userlogin();
        getCommentPostPages().imagePostClick();
        int beforeCommentCount = getCommentPostPages().verifyCommentAndCommentCount();
        getCommentPostPages().tapOnCommentIcon();
        getCommentPostPages().CheckingComnmentScreenIsOpening();
        getCommentPostPages().enteringSomeTextInCommentFieldAndTapOnSendButton();

        int afterCommentCount = getCommentPostPages().verifyCommentCountAndItIncreasedByOne();

        assertTrue(beforeCommentCount != afterCommentCount,
                "Test Fail: Verify post comment functionality");


    }

    @Test(enabled = true, description = "Verify post comment functionality", groups = {"RegressionTest", "Creation"})
    public void TC214_verifyPostCommentFunctionality() throws Exception {
        getLoginPage().userlogin();

        getCommentPostPages().tapOnCommentIcon();
        getCommentPostPages().CheckingComnmentScreenIsOpening();
        getCommentPostPages().enteringSomeTextInCommentFieldAndTapOnSendButton();
        getCommentPostPages().tapOnLikeButton();
        int beforeLikeCount = getCommentPostPages().checkLikeCountBefore();
        int afterLikeCount = getCommentPostPages().checkLikeCountAfter();
        assertTrue(beforeLikeCount != afterLikeCount,
                "Test Fail: Verify post comment functionality");


    }

    @Test(enabled = true, description = "Verify post comment functionality", groups = {"RegressionTest", "Creation"})
    public void TC215_verifyPostCommentFunctionality() throws Exception {
        getLoginPage().userlogin();

        getCommentPostPages().tapOnCommentIcon();
        getCommentPostPages().CheckingComnmentScreenIsOpening();
        getCommentPostPages().enteringSomeTextInCommentFieldAndTapOnSendButton();
        getCommentPostPages().tapOnLikeButton();
        int beforeLikeCount = getCommentPostPages().clickBeforeLike();
        int afterLikeCount = getCommentPostPages().clickAfterLike();
        assertTrue(beforeLikeCount != afterLikeCount,
                "Test Fail: Verify post comment functionality");


    }

    @Test(enabled = true, description = "Verify repost  functionality", groups = {"RegressionTest", "Creation"})
    public void TC217_verifyREPostFunctionality() throws Exception {
        getLoginPage().userlogin();
        getCommentPostPages().imagePostClick();
        getCommentPostPages().repostClick();
        getCommentPostPages().postClick();

        int beforeRePostCount = getCommentPostPages().verifyREPostCountBefore();
        int afterRePostCount = getCommentPostPages().verifyREPostCountAfter();
        assertTrue(beforeRePostCount != afterRePostCount,
                "Test Fail: Verify repost  functionality");


    }

    public CommentPostPages getCommentPostPages() {

        return new CommentPostPages(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
