package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.loginPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Tests related to Login Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */

public class LoginPageTest {


//    @Test(enabled = true, description = "Verify install and uninstall app", groups = {"SmokeTest"})
//    public void testAppLaunch() throws Exception {
//
//        getLoginPage().userlogin();
//
//    }
//
//    @Test(enabled = true, description = "Create new user with new detail.", groups = {"RegressionTest", "Creation"})
//    public void TC008_createNewUSer() throws Exception {
//
//        boolean testResponse = getLoginPage().createNewUSer();
//        assertTrue(testResponse,
//                "Test Fail User should be logged into account and on home screen.");
//    }
//
//
//    @Test(enabled = true, description = "check login with verified number with wrong OTP.", groups = {"RegressionTest", "Creation"})
//    public void TC012_createNewUSer() throws Exception {
//
//        ArrayList testResponse = getLoginPage().verifyWithWrongOTP();
//        assertTrue(testResponse.get(0).equals(testResponse.get(0)),
//                "Test Fail check login with verified number with wrong OTP");
//    }
//
//    @Test(enabled = true, description = "check login with invalid number.", groups = {"RegressionTest", "Creation"})
//    public void TC013_loginWithInvalidNumber() throws Exception {
//
//        ArrayList testResponse = getLoginPage().verifyLoginWithInvalidNumber();
//        System.err.println(" Checking :" + testResponse.get(0));
//        assertTrue(testResponse.get(0).equals(testResponse.get(0)),
//                "Test Fail check login with invalid then button should be disabled .");
//    }
//    @Test(enabled = true, description = "User try to submit the empty form", groups = {"RegressionTest", "Creation"})
//    public void TC014_verifyProceedWithEmptyForm() throws Exception {
//
//        String testResponse = getLoginPage().verifyProceedWithEmptyForm();
//        System.err.println(" Checking :" + testResponse);
//        assertTrue(testResponse.contains(testResponse),
//                "Test Fail User try to submit the empty form.");
//    }
//
//
//        @Test(enabled = true, description = "User try to submit the  form without user name", groups = {"RegressionTest", "Creation"})
//    public void TC015_verifyProceedWithoutName() throws Exception {
//
//        String testResponse = getLoginPage().verifyProceedWithoutName();
//        System.err.println(" Checking :" + testResponse);
//        assertTrue(testResponse.contains(testResponse),
//                "Test Fail User try to submit the  form without user name.");
//    }
//    @Test(enabled = true, description = "User try to submit the  form without mobile number", groups = {"RegressionTest", "Creation"})
//    public void TC016_verifyProceedWithoutMobileNumber() throws Exception {
//
//        String testResponse = getLoginPage().verifyProceedWithoutMobileNumber();
//        System.err.println(" Checking :" + testResponse);
//        assertTrue(testResponse.contains(testResponse),
//                "Test Fail User try to submit the  form without mobile number.");
//    }
//
//
//    @Test(enabled = true, description = "User try to submit the  form without gender selection", groups = {"RegressionTest", "Creation"})
//    public void TC017_verifyProceedWithoutGenderSelection() throws Exception {
//
//        String testResponse = getLoginPage().verifyProceedWithoutGenderSelection();
//        System.err.println(" Checking :" + testResponse);
//        assertTrue(testResponse.contains(testResponse),
//                "Test Fail User try to submit the  form without gender selection.");
//    }
//
//    @Test(enabled = true, description = "User try to submit the  form without age selection", groups = {"RegressionTest", "Creation"})
//    public void TC018_verifyProceedWithoutAgeSelection() throws Exception {
//
//        String testResponse = getLoginPage().verifyProceedWithoutAgeSelection();
//        System.err.println(" Checking :" + testResponse);
//        assertTrue(testResponse.contains(testResponse),
//                "Test Fail User try to submit the  form without age selection.");
//    }

    @Test(enabled = true, description = "Checking term & policy page is displayed", groups = {"RegressionTest", "Creation"})
    public void TC019_verifyTermPolicy() {

        boolean testResponse1[] = getLoginPage().verifyTermPolicyPages();
        System.err.println(" Checking :" + testResponse1);
        for (int i = 0; i< testResponse1.length; i++) {
            System.err.println(" Checking :" + testResponse1[i]);
            assertTrue(testResponse1[i],
                    "Test Fail Checking term & policy page is displayed .");
        }

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}