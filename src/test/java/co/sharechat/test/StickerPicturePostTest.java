package co.sharechat.test;


import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.StickerPicturePostPages;
import co.sharechat.pages.Actions.loginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This Class has all the Tests related to Sticker Picture Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */
public class StickerPicturePostTest {


    @Test(enabled = true, description = "Verify Post sticker Dropdown and create new pack", groups = {"RegressionTest", "Creation"})
    public void TC157_verifyPostStickerDropdown() throws Exception {
        getLoginPage().userlogin();
        getStickerPicturePostPages().createNewPackOfSticker();

    }

    @Test(enabled = true, description = "Verify post view option ", groups = {"RegressionTest", "Creation"})
    public void TC200_checkingPostViewOption() throws Exception {
        getLoginPage().userlogin();
        boolean[] testResponse = getStickerPicturePostPages().checkPostViewOption();
        for (int i = 0; i < testResponse.length; i++) {
            assertTrue(testResponse[i], "Test Fail: Verify post view option.");
        }


    }


    public StickerPicturePostPages getStickerPicturePostPages() {

        return new StickerPicturePostPages(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
