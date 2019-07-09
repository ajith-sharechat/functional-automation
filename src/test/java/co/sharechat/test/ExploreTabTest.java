package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ExploreTabPage;
import co.sharechat.pages.Actions.loginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Tests related to Explore Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */

public class ExploreTabTest {

    @Test(enabled = true, description = "Verify all tag links functionality from bucket feed", groups = {"SmokeTest"})
    public void TC015_checkingTrendingPage() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getExploreTabTest().checkExploreTab();
        assertTrue(testResponse,
                "Test Fail Tap on any explore tab and check search and tiles functionality");
    }

    public ExploreTabPage getExploreTabTest() {

        return new ExploreTabPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}

