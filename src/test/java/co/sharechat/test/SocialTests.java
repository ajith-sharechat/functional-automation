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
    public void TC001_verifyChatScreen(){
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
    public void TC002_verifyChatInitiatingFunctionality() {
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
    public void TC005_verifyChatScreenUserRow(){

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
    public void TC007_verifyChatScreenTextMessageFunctionlity(){
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
    public void TC011_verifyChatBoxBlockUserFunctionality(){
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
    public void TC021_verifySharingPostFunctionalityKnownUser(){
        getSignUpInstance().selectTelugu();
        getSignUpInstance().enterPhNo(registerNumber);
        getSignUpInstance().clickOtpButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getHomePageActionsInstance().clickAllowButton();
        getSignUpInstance().enterOTPActions(otp);
        getHomePageActionsInstance().verifyHomeScreenElement();
        getSocialActionsInstance().sharingPostFunctionalityToKnownUser();
    }

    @Test(enabled = true, description = "Verify UNKNOWN chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC022_verifyUnknownChatScreenFunctionality(){
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
    public void TC026_verifyShareAndChatScreen(){
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
    public void TC065_verifyCommentScreenUIPostFunctionality(){
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
    public void TC083_verifyUserProfileFunctionalityInCommentsList(){
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
    public void TC084_verifyLikeLinkFunctionalityBesideCommentLink(){
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
    public void TC098_verifyProfileScreenUI() {
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
    public void TC099_verifyAddFriendFunctionality() {
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

    @Test(enabled = true, description = "Verify Share apk icon functionality from My Contacts screen",groups = {"RegressionTest", "Social"})
    public void TC100_verifyShareAPKIconFunctionalityMyContactsScreen() {
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
        getSocialActionsInstance().clickShareIconInPhoneContactsScreen();
        getSocialActionsInstance().verifyWhatAppWelcomeScreen();
    }

    @Test(enabled = true, description = "Verify share icon functionality",groups = {"RegressionTest", "Social"})
    public void TC101_verifyShareIconFunctionality() {
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
        getSocialActionsInstance().clickShareIconInProfileScreen();
        getSocialActionsInstance().verifySelectAppPopupAndClickWhatAppIcon();
        getSocialActionsInstance().verifyWhatAppWelcomeScreen();
    }

    @Test(enabled = true, description = "Verify settings button functionality",groups = {"RegressionTest", "Social"})
    public void TC102_verifySettingButtonFunctionality() {
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
        getSocialActionsInstance().clickSettingIconInProfileScreen();
        getSocialActionsInstance().verifyProfileSettingScreen();
    }

    @Test(enabled = true, description = "Verify Edit your profile button functionality",groups = {"RegressionTest", "Social"})
    public void TC103_verifyEditProfileButtonFunctionality() {
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
        getSocialActionsInstance().clickEditProfileButton();
        getSocialActionsInstance().verifyEditProfileScreen();
    }

    @Test(enabled = true, description = "Verify updating profile picture functionality with gallery from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC104_verifyUpdatingProfilePictureFunctionalityWithGallery() {
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
        getSocialActionsInstance().clickEditProfileButton();
        getSocialActionsInstance().clickProfileCameraIcon();
        getSocialActionsInstance().verifyProfilePicScreen();
        getSocialActionsInstance().clickGalleryIconChooseOption();
    }

    @Test(enabled = true, description = "Verify updating profile picture functionality with camera from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC105_verifyUpdatingProfilePictureFunctionalityWithCamera() {
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
        getSocialActionsInstance().clickEditProfileButton();
        getSocialActionsInstance().clickProfileCameraIcon();
        getSocialActionsInstance().verifyProfilePicScreen();
        getSocialActionsInstance().clickCameraIconChooseOption();
        getSocialActionsInstance().clickCameraCaptureButton();
        getSocialActionsInstance().clickCameraCaptureSaveButton();
    }

    @Test(enabled = true, description = "Verify update background picture functionality with gallery from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC106_verifyUpdatingProfilePictureFunctionalityWithGallery() {
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
        getSocialActionsInstance().clickEditProfileButton();
        getSocialActionsInstance().clickChangeButtonProfileEditScreen();
        getSocialActionsInstance().verifyProfilePicScreen();
        getSocialActionsInstance().clickGalleryIconChooseOption();
    }

    @Test(enabled = true, description = "Verify update background picture functionality with camera from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC107_verifyEditProfileButtonFunctionality() {
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
        getSocialActionsInstance().clickEditProfileButton();
        getSocialActionsInstance().clickChangeButtonProfileEditScreen();
        getSocialActionsInstance().verifyProfilePicScreen();
        getSocialActionsInstance().clickCameraIconChooseOption();
        getSocialActionsInstance().clickCameraCaptureButton();
        getSocialActionsInstance().clickCameraCaptureSaveButton();
    }

    @Test(enabled = true, description = "Verify single tap functionality on post in my post section",groups = {"RegressionTest", "Social"})
    public void TC122_TC123_myPostsVerifySingleTapFunctionalityOnPost() {
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
        getHomePageActionsInstance().scrollTillPostImageClickPostImage();
        getSocialActionsInstance().verifyPostPreviewScreen();
    }

    @Test(enabled = true, description = "Verify profile picture, name, and bio of the post in my post section",groups = {"RegressionTest", "Social"})
    public void TC124_myPostVerifyProfilePictureNameAndBioOnThePost() {
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
        getHomePageActionsInstance().scrollTillPostImageClickPostImage();
        getSocialActionsInstance().verifyPostPreviewScreen();
        getSocialActionsInstance().verifyHashTagLabelAndHashTagFeedTitle();
    }

    @Test(enabled = true, description = "Verify options button functionality of a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC125_myPostVerifyOptionsButtonFunctionalityOfPost() {
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
        getHomePageActionsInstance().scrollTillPostImageClickPostImage();
        getSocialActionsInstance().verifyPostPreviewScreen();
        getHomePageActionsInstance().clickPostImageOptionTopRightCorner();
        getSocialActionsInstance().verifySharePopupElements();
    }
    @Test(enabled = true, description = "Verify whatsapp share functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC130_myPostVerifyWhatsAppShareFunctionalityForPost() {
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
        getSocialActionsInstance().scrollToWhatsAppIconAndClickInPost();
        getSocialActionsInstance().verifyWhatAppWelcomeScreen();
    }

    @Test(enabled = true, description = "Verify comments functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC131_myPostVerifyCommentFunctionalityForPost(){
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
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().clickPostCommentIcon();
        getSocialActionsInstance().enterCommentAndSend(textMessage);
    }

    @Test(enabled = true, description = "Verify repost functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC133_myPostVerifyRePostFunctionalityForPost() {
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
        getSocialActionsInstance().scrollToRepostIconAndClickInPost();
        getSocialActionsInstance().verifyCreatePostScreen();
        getSocialActionsInstance().uploadingRePostFunctionalityInMyPost();
    }

    @Test(enabled = true, description = "Verify video playing functionality for a video post in my post section",groups = {"RegressionTest", "Social"})
    public void TC134_myPostVerifyVideoPlayFunctionalityForVideoPost() {
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
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().clickVideoPost();
        getSocialActionsInstance().verifyVideoIsPlayingOrNot();
    }

    @Test(enabled = true, description = "Verify audio post functionality for a audio post in my post section",groups = {"RegressionTest", "Social"})
    public void TC135_myPostVerifyAudioPostFunctionalityForAudioPost() {
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
        getSocialActionsInstance().scrollToAudioPostAndClick();
        getSocialActionsInstance().clickPauseButton();
    }

    @Test(enabled = true, description = "Verify GIF motion picture functionality for a GIF post in my post section",groups = {"RegressionTest", "Social"})
    public void TC136_myPostVerifyGIFMotionPictureFunctionalityForGIFPost() {
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
        getSocialActionsInstance().scrollToGIFPostAndClickInPost();
        getSocialActionsInstance().clickGIFButton();
    }

    @Test(enabled = true, description = "Verify tag link functionality of a post in Gallery section",groups = {"RegressionTest", "Social"})
    public void TC140_galleryVerifyTagLinkFunctionalityOfPost(){
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
        getSocialActionsInstance().clickGallerySection();
        getSocialActionsInstance().verifyHashTagFunctionalityOfPost();
    }
}
