package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.PostShareOptionPage;
import co.sharechat.pages.Actions.TrendingTabPage;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Tests related to Post option page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */
public class PostShareOptionTest implements Constants {


    //    @Test(enabled = true, description = "Verify post share options ", groups = {"RegressionTest", "Creation"})
//    public void TC168_checkingPostShareOption() throws Exception {
//        getLoginPage().userlogin();
//        String testResponse = getPostShareOptionPage().checkPostShareOption();
//        assertTrue(testResponse.contains(testResponse), "Test Fail Verify post share options");
//
//    }
//    @Test(enabled = true, description = "Verify post share option of convert sticker", groups = {"RegressionTest", "Creation"})
//    public void TC173_verifyConvertSticker() throws Exception {
//        getLoginPage().userlogin();
//        boolean testResponse = getPostShareOptionPage().checkConvertSticker();
//        assertTrue(testResponse, "Test Fail Verify post share option of convert sticker");
//
//    }
//
//    @Test(enabled = true, description = "Verify post share option of message", groups = {"RegressionTest", "Creation"})
//    public void TC174_checkingMessageOption() throws Exception {
//        getLoginPage().userlogin();
//        boolean[] testResponse = getPostShareOptionPage().checkMessageOption();
//        for (int i = 0; i < testResponse.length; i++) {
//            assertTrue(testResponse[i], "Test Fail Verify post share option of message.");
//        }
//
//
//    }
//
//    @Test(enabled = true, description = "Verify post share option of Follow ", groups = {"RegressionTest", "Creation"})
//    public void TC175_checkingFollowOption() throws Exception {
//        getLoginPage().userlogin();
//        boolean testResponse = getPostShareOptionPage().checkFollowOption();
//        assertTrue(testResponse, "Verify post share option of Follow");
//
//    }


    @Test(enabled = true, description = "Verify post share option of Report", groups = {"RegressionTest", "Creation"})
    public void TC176_checkingReportOption() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getPostShareOptionPage().checkReportOption();
        assertTrue(testResponse, "Verify post share option of Report");

    }

    @Test(enabled = true, description = "Verify post share option of Download", groups = {"RegressionTest", "Creation"})
    public void TC177_checkingDownloadOption() throws Exception {
        getLoginPage().userlogin();
        boolean[] testResponse = getPostShareOptionPage().checkDownloadOption();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i], "Test Fail Verify post share option of Download.");
        }
    }


    public PostShareOptionPage getPostShareOptionPage() {

        return new PostShareOptionPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());
    }
}
