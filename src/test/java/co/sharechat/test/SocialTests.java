package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ChatPageActions;
import co.sharechat.pages.Actions.HomePageActions;
import co.sharechat.pages.Actions.SignUp;
import co.sharechat.pages.Actions.SocialActions;
import co.sharechat.utils.Constants;
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

    @Test(enabled = true, description = "Verify chat screen functionality", groups = {"RegressionTest", "Social"})
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

    @Test(enabled = true, description = "Verify chat initiating functionality from normal user profile screen", groups = {"RegressionTest", "Social"})
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

    @Test(enabled = true, description = "Verify user row functionality", groups = {"RegressionTest", "Social"})
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

    @Test(enabled = true, description = "Verify sending text message functionality to known user", groups = {"RegressionTest", "Social"})
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

    @Test(enabled = true, description = "Verify Block User functionality form chat session", groups = {"RegressionTest", "Social"})
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

    @Test(enabled = true, description = "Verify sharing a post functionality to known user", groups = {"RegressionTest", "Social"})
    public void TC021_verifySharingPostFunctionalityKnownUser() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().scrollTillPostImageOnHomeScreenClickPostImage();
        getHomePageActionsInstance().clickPostImageOptionTopRightCorner();
    }

    @Test(enabled = true, description = "Verify UNKNOWN chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC022_verifyUnknownChatScreenFunctionality() throws Exception {
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
        getChatPageActionsInstance().clickUknownUser();
        getChatPageActionsInstance().verifyUnknownUserScreen();
    }

    @Test(enabled = true, description = "Verify Shake and Chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC026_verifyShareAndChatScreen() throws Exception {
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
        getChatPageActionsInstance().clickUknownUser();
        getChatPageActionsInstance().verifyUnknownUserScreen();
        getChatPageActionsInstance().clickShareAndChatLink();
        getChatPageActionsInstance().verifyShareAndChatScreen();
    }

    @Test(enabled = true, description = "Verify comment screen UI for a picture post",groups = {"RegressionTest", "Social"})
    public void TC065_verifyCommentScreenUIPostFunctionality() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().clickPostCommentIcon();
        getSocialActionsInstance().verifyCommentScreen();
    }

    @Test(enabled = true, description = "Verify user profile functionality from comments list",groups = {"RegressionTest", "Social"})
    public void TC083_verifyUserProfileFunctionalityInCommentsList() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().clickPostCommentIcon();
        getSocialActionsInstance().verifyCommentScreen();
        getSocialActionsInstance().clickCommentUserProfile();
    }

    @Test(enabled = true, description = "Verify Like link functionality beside to comment link",groups = {"RegressionTest", "Social"})
    public void TC084_verifyLikeLinkFunctionalityBesideCommentLink() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().clickVideoPost();
        getHomePageActionsInstance().verifyVideoPostPreviewScreen();
        getSocialActionsInstance().clickPostCommentIcon();
        getSocialActionsInstance().clickPostPreviewLikeSection();
    }

    @Test(enabled = true, description = "Verify profile screen UI",groups = {"RegressionTest", "Social"})
    public void TC098_verifyProfileScreenUI() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickProfileIcon();
        getSocialActionsInstance().verifyProfileScreen();
    }

    @Test(enabled = true, description = "Verify Add Friend button functionality",groups = {"RegressionTest", "Social"})
    public void TC099_verifyAddFriendFunctionality() throws Exception {
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getHomePageActionsInstance().clickProfileIcon();
        getSocialActionsInstance().verifyProfileScreen();
        getSocialActionsInstance().clickAddFriendIcon();
        getSocialActionsInstance().verifyPhoneContactsScreen();
        getSocialActionsInstance().clickFollowLink();
        getSocialActionsInstance().clickUnfollowLink();
        getSocialActionsInstance().clickFollowingButtonAndClickConfirmToUnfollow();
        getSocialActionsInstance().clickInviteSection();
        getSocialActionsInstance().clickInviteButton();
    }
}
