package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ProfilePage;
import co.sharechat.pages.Actions.StickerFunctionalityPage;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Tests related to Sticker Functionality Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 08 july 2019
 */


public class StickerFunctionalityTest implements Constants {


    @Test(enabled = true, description = "Verify sticker tab functionality", groups = {"RegressionTest", "Social"})
    public void TC0153_verifySticker() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = StickerFunctionalityPage().verifySticker();
        assertTrue(testResponse,
                "Test Fail: Verify that default sticker packs list are appearing in STICKERS section");
    }

    public StickerFunctionalityPage StickerFunctionalityPage() {

        return new StickerFunctionalityPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
