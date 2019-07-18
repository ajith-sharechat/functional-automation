package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CheckAppInstallAndUninstall;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Tests related to App install & Uninstall
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class CheckAppInstallAndUninstallTest implements Constants {

    @Test(enabled = true, description = "Verify install and uninstall app", groups = {"SmokeTest"})
    public void TC001_checkAppInstallAndUninstall() {

        assertTrue(getCheckAppInstallAndUninstall().checkInstall(appPackage), "Test Fail: User not able to install the App.");
        assertFalse(getCheckAppInstallAndUninstall().checkUnInstall(appPackage), "Test Fail: User not able to uninstall the App.");
    }

    public CheckAppInstallAndUninstall getCheckAppInstallAndUninstall() {

        return new CheckAppInstallAndUninstall(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
