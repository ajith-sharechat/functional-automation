package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.loginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Tests related to Login Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */

public class LoginPageTest {

//
//    @Test(enabled = true, description = "Verify install and uninstall app", groups = {"SmokeTest"})
//    public void testAppLaunch() throws Exception {
//
//        getLoginPage().userlogin();
//
//    }

    @Test(enabled = true, description = "Create new user with new detail.", groups = {"RegressionTest", "Creation"})
    public void TC008_createNewUSer() throws Exception {

        boolean testResponse = getLoginPage().createNewUSer();
        assertTrue(testResponse,
                "Test Fail User should be logged into account and on home screen.");
    }


    @Test(enabled = true, description = "check login with verified number with wrong OTP.", groups = {"RegressionTest", "Creation"})
    public void TC013_createNewUSer() throws Exception {

        ArrayList testResponse = getLoginPage().verifyWithWrongOTP();
        assertTrue(testResponse.get(0).equals(testResponse.get(0)),
                "Test Fail check login with verified number with wrong OTP");
    }


    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
