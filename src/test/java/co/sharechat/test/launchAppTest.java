package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.loginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;


public class launchAppTest
{
    AppiumDriver driver;

    @Test
    public void testAppLaunch() throws Exception
    {
     getLoginPage().userlogin();
    }

    public loginPage getLoginPage(){

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
