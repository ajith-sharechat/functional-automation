package co.sharechat.test;


import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.HomeScreenPage;
import co.sharechat.pages.Actions.LandingPage;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Tests related to Landing Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 09 july 2019
 */
public class LandingPageTest implements Constants {


    @Test(enabled = true, description = "Verify Landing screen functionality", groups = {"RegressionTest", "Creation"})
    public void TC005_verifyLandingScreenFunctionality() throws Exception {
        String testResponse = getLandingPage().verifyTheSharechatLogo();
        assertTrue(testResponse.contains(SELECTYOURLANGUAGE),
                "Test Fail: Text should be 'Select your language'.");

        int testResponse1 = getLandingPage().getCountOfDifferentLanguageOptionsOnLandingPage();
        assertTrue(testResponse1 == LANGUAGEBOXCOUNT,
                "Test Fail: There should be" + LANGUAGEBOXCOUNT + " language boxes");


    }

    public LandingPage getLandingPage() {

        return new LandingPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
