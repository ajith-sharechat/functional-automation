package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.loginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/**
 * This Class has all the Actions related to Login Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */

public class UserLoginTest {


    @Test(enabled = true, description = "Verify install and uninstall app", groups = {"SmokeTest"})
    public void testAppLaunch() throws Exception {

        getLoginPage().userlogin();

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
