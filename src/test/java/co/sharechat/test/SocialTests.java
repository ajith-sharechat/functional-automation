package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ChatPageActions;
import co.sharechat.pages.Actions.HomePageActions;
import co.sharechat.pages.Actions.SignUp;
import co.sharechat.pages.Actions.SocialActions;
import co.sharechat.utils.Constants;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SocialTests  implements Constants {
    public HomePageActions getHomePageActionsInstance(){

        return new HomePageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public ChatPageActions getChatPageActionsInstance(){

        return new ChatPageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public SignUp getSignUpInstance(){

        return new SignUp(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public SocialActions getSocialActionsInstance(){

        return new SocialActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
//    @AfterTest
//    public void backToHomeScreen(){
//        getSocialActionsInstance().backToHomeScreen();
//    }

    @Test(enabled = true, description = "Verify chat screen functionality")
    public void TC001_verifyChatScreen() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
    }

    @Test(enabled = true, description = "Verify chat initiating functionality from normal user profile screen")
    public void TC002_verifyChatInitiatingFunctionality() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getSocialActionsInstance().verifyPostUserChatInitiatingFunctionality();
    }

    @Test(enabled = true, description = "Verify user row functionality")
    public void TC005_verifyChatScreenUserRow() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        getChatPageActionsInstance().clickKnownUserList();
        getSocialActionsInstance().clickBackButton();
        getHomePageActionsInstance().clickHomeIcon();
    }
    @Test(enabled = true, description = "Verify sending text message functionality to known user")
    public void TC007_verifyChatScreenTextMessageFunctionlity() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        getChatPageActionsInstance().clickKnownUserList();
        getChatPageActionsInstance().enterTextMessageActions(textMessage);
        getSocialActionsInstance().clickSendMessageIcon();

    }
    @Test(enabled = true, description = "Verify audio recording functionality from user chat session")
    public void TC008_verifyChatBoxAudioRecording() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        getChatPageActionsInstance().clickKnownUserList();
        getSocialActionsInstance().clickLongPressSendAudioIcon();
        getHomePageActionsInstance().clickAllowButton();
        getSocialActionsInstance().clickLongPressSendAudioIcon();
        getSocialActionsInstance().clickSendMessageIcon();

    }
    @Test(enabled = true, description = "Verify Block User functionality form chat session")
    public void TC011_verifyChatBoxBlockUserFunctionality() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickChatIcon();
        getChatPageActionsInstance().verifyChatScreen();
        getChatPageActionsInstance().clickKnownUserList();
        getChatPageActionsInstance().clickRightTopConerOption();
        getChatPageActionsInstance().clickBlockOption();
        getChatPageActionsInstance().clickUnblockButton();
    }

}
