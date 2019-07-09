package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ProfilePage;
import co.sharechat.pages.Actions.loginPage;
import co.sharechat.utils.Constants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * This Class has all the Tests related to Profile Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class ProfilePageTest implements Constants {


    @Test(enabled = true, description = "Verify that post is coming to gallery with APP GALLERY option", groups = {"SmokeTest"})
    public void TC011_VerifySaveAndGallery() throws Exception {
        getLoginPage().userlogin();
        boolean testResponse = getProfilePage().checkingSaveAndGallery();
        assertTrue(testResponse,
                "Test Fail Tap on any Post save button  and check same post in gallery.");
    }

    @Test(enabled = true, description = "Verify adding sticker pack to whatsapp functionality ", groups = {"SmokeTest"})
    public void TC012_VerifyStickers() throws Exception {
        getLoginPage().userlogin();
        String testResponse = getProfilePage().verifySticker();

        assertTrue(testResponse.contains(shareOnwhatsApp) || testResponse.contains("Test Pass"),
                "Test Fail Tap on any Profile then stickers tab and  check stickers");
    }

    @Test(enabled = true, description = "Verify Change Language Mode functionality with English", groups = {"SmokeTest"})
    public void TC013_verifySkinChangeFunctionality() throws Exception {
        getLoginPage().userlogin();
        String[] testResponse = getProfilePage().verifyChangeSkin();
        assertTrue(testResponse[0].contains(profileSettingText) || testResponse[1].contains(chat),
                "Test Fail Tap on Settings and change skin and verify the selected skin text in the app.");
    }


    @Test(enabled = true, description = "Verify Logout link functionality", groups = {"SmokeTest"})
    public void TC014_verifyLogoutButton() throws Exception {
        getLoginPage().userlogin();
        String testResponse = getProfilePage().checkLogout();
        assertTrue(testResponse.contains(AfterlogoutPageText),
                "Test Fail Tap on Settings and logout from the App.");
    }

    public ProfilePage getProfilePage() {

        return new ProfilePage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public loginPage getLoginPage() {

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
}
