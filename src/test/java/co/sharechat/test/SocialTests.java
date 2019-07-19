package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ChatPageActions;
import co.sharechat.pages.Actions.HomePageActions;
import co.sharechat.pages.Actions.SignUpActions;
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
    public SignUpActions getSignUpInstance(){

        return new SignUpActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public SocialActions getSocialActionsInstance(){

        return new SocialActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = true, description = "Verify chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC001_verifyChatScreen(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
    }

    @Test(enabled = true, description = "Verify chat initiating functionality from normal user profile screen", groups = {"RegressionTest", "Social"})
    public void TC002_verifyChatInitiatingFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getSocialActionsInstance().verifyPostUserChatInitiatingFunctionality();
    }

    @Test(enabled = true, description = "Verify user row functionality", groups = {"RegressionTest", "Social"})
    public void TC005_verifyChatScreenUserRow(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
        getChatPageActionsInstance().verifyRecentKnownUserFromKnownUserList();
        getSocialActionsInstance().tapBackButton();
        getHomePageActionsInstance().tapHomeIcon();
    }

    @Test(enabled = true, description = "Verify sending text message functionality to known user", groups = {"RegressionTest", "Social"})
    public void TC007_verifyChatScreenTextMessageFunctionlity(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
        getChatPageActionsInstance().verifyRecentKnownUserFromKnownUserList();
        getChatPageActionsInstance().enterTextMessageActions(textMessage);
        getSocialActionsInstance().verifySendMessageFunctionality();

    }

    @Test(enabled = true, description = "Verify Block User functionality form chat session", groups = {"RegressionTest", "Social"})
    public void TC011_verifyChatBoxBlockUserFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
        getChatPageActionsInstance().verifyRecentKnownUserFromKnownUserList();
        getChatPageActionsInstance().tapRightTopConerOption();
        getChatPageActionsInstance().tapBlockOption();
        getChatPageActionsInstance().tapUnblockButton();
    }

    @Test(enabled = true, description = "Verify sharing a post functionality to known user", groups = {"RegressionTest", "Social"})
    public void TC021_verifySharingPostFunctionalityKnownUser(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getSocialActionsInstance().verifySharingPostFunctionalityToKnownUser();
    }

    @Test(enabled = true, description = "Verify UNKNOWN chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC022_verifyUnknownChatScreenFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
        getChatPageActionsInstance().tapUknownUser();
        getChatPageActionsInstance().verifyUnknownUserScreenElements();
    }

    @Test(enabled = true, description = "Verify Shake and Chat screen functionality", groups = {"RegressionTest", "Social"})
    public void TC026_verifyShareAndChatScreen(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapChatIcon();
        getChatPageActionsInstance().verifyChatScreenElements();
        getChatPageActionsInstance().tapUknownUser();
        getChatPageActionsInstance().verifyUnknownUserScreenElements();
        getChatPageActionsInstance().tapShareAndChatLink();
        getChatPageActionsInstance().verifyShareAndChatScreenElements();
    }

    @Test(enabled = true, description = "Verify comment screen UI for a picture post",groups = {"RegressionTest", "Social"})
    public void TC065_verifyCommentScreenUIPostFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().tapPostCommentIcon();
        getSocialActionsInstance().verifyCommentScreenElements();
    }

    @Test(enabled = true, description = "Verify user profile functionality from comments list",groups = {"RegressionTest", "Social"})
    public void TC083_verifyUserProfileFunctionalityInCommentsList(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().tapPostCommentIcon();
        getSocialActionsInstance().verifyCommentScreenElements();
        getSocialActionsInstance().verifyCommentedUserProfileName();
    }

    @Test(enabled = true, description = "Verify Like link functionality beside to comment link",groups = {"RegressionTest", "Social"})
    public void TC084_verifyLikeLinkFunctionalityBesideCommentLink(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().tapOnVideoPost();
        getHomePageActionsInstance().verifyVideoPostPreviewScreenElements();
        getSocialActionsInstance().tapPostCommentIcon();
        getSocialActionsInstance().tapPostPreviewLikeSection();
    }

    @Test(enabled = true, description = "Verify profile screen UI",groups = {"RegressionTest", "Social"})
    public void TC098_verifyProfileScreenUI(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
    }

    @Test(enabled = true, description = "Verify Add Friend button functionality",groups = {"RegressionTest", "Social"})
    public void TC099_verifyAddFriendFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapAddFriendIcon();
        getSocialActionsInstance().verifyPhoneContactsScreenElements();
        getSocialActionsInstance().tapFollowLink();
        getSocialActionsInstance().tapUnfollowLink();


        getSocialActionsInstance().tapFollowingButtonAndTapConfirmToUnfollow();//verifyFollowingButtonFunctionality


        getSocialActionsInstance().tapInviteSection();
        getSocialActionsInstance().tapInviteButton();
    }

    @Test(enabled = true, description = "Verify Share apk icon functionality from My Contacts screen",groups = {"RegressionTest", "Social"})
    public void TC100_verifyShareAPKIconFunctionalityMyContactsScreen(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapAddFriendIcon();
        getSocialActionsInstance().tapShareIconInPhoneContactsScreen();
        getSocialActionsInstance().verifyWhatsAppWelcomeScreenElements();
    }

    @Test(enabled = true, description = "Verify share icon functionality",groups = {"RegressionTest", "Social"})
    public void TC101_verifyShareIconFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapShareIconInProfileScreen();
        getSocialActionsInstance().verifySelectAppPopupAndTapWhatsAppIcon();
        getSocialActionsInstance().verifyWhatsAppWelcomeScreenElements();
    }

    @Test(enabled = true, description = "Verify settings button functionality",groups = {"RegressionTest", "Social"})
    public void TC102_verifySettingButtonFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapSettingIconInProfileScreen();
        getSocialActionsInstance().verifyProfileSettingScreenElements();
    }

    @Test(enabled = true, description = "Verify Edit your profile button functionality",groups = {"RegressionTest", "Social"})
    public void TC103_verifyEditProfileButtonFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapEditProfileButton();
        getSocialActionsInstance().verifyEditProfileScreenElements();
    }

    @Test(enabled = true, description = "Verify updating profile picture functionality with gallery from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC104_verifyUpdatingProfilePictureFunctionalityWithGallery(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapEditProfileButton();
        getSocialActionsInstance().tapProfileCameraIcon();
        getSocialActionsInstance().verifyProfilePicScreenElements();
        getSocialActionsInstance().tapGalleryIcon();
    }

    @Test(enabled = true, description = "Verify updating profile picture functionality with camera from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC105_verifyUpdatingProfilePictureFunctionalityWithCamera(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapEditProfileButton();
        getSocialActionsInstance().tapProfileCameraIcon();
        getSocialActionsInstance().verifyProfilePicScreenElements();
        getSocialActionsInstance().tapCameraIcon();
        getSocialActionsInstance().tapCameraCaptureButton();
        getSocialActionsInstance().tapCameraCaptureSaveButton();
    }

    @Test(enabled = true, description = "Verify update background picture functionality with gallery from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC106_verifyUpdatingProfilePictureFunctionalityWithGallery(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapEditProfileButton();
        getSocialActionsInstance().tapChangeButtonInProfileEditScreen();
        getSocialActionsInstance().verifyProfilePicScreenElements();
        getSocialActionsInstance().tapGalleryIcon();
    }

    @Test(enabled = true, description = "Verify update background picture functionality with camera from EDIT PROFILE screen",groups = {"RegressionTest", "Social"})
    public void TC107_verifyEditProfileButtonFunctionality(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapEditProfileButton();
        getSocialActionsInstance().tapChangeButtonInProfileEditScreen();
        getSocialActionsInstance().verifyProfilePicScreenElements();
        getSocialActionsInstance().tapCameraIcon();
        getSocialActionsInstance().tapCameraCaptureButton();
        getSocialActionsInstance().tapCameraCaptureSaveButton();
    }

    @Test(enabled = true, description = "Verify single tap functionality on post in my post section",groups = {"RegressionTest", "Social"})
    public void TC122_TC123_myPostsVerifySingleTapFunctionalityOnPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getHomePageActionsInstance().scrollTillPostImageAndTapPostImage();
        getSocialActionsInstance().verifyPostPreviewScreenElements();
    }

    @Test(enabled = true, description = "Verify profile picture, name, and bio of the post in my post section",groups = {"RegressionTest", "Social"})
    public void TC124_myPostVerifyProfilePictureNameAndBioOnThePost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getHomePageActionsInstance().scrollTillPostImageAndTapPostImage();
        getSocialActionsInstance().verifyPostPreviewScreenElements();
        getSocialActionsInstance().verifyHashTagLabelAndHashTagFeedTitle();
    }

    @Test(enabled = true, description = "Verify options button functionality of a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC125_myPostVerifyOptionsButtonFunctionalityOfPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getHomePageActionsInstance().scrollTillPostImageAndTapPostImage();
        getSocialActionsInstance().verifyPostPreviewScreenElements();
        getHomePageActionsInstance().tapPostImageOptionOnTopRightCorner();
        getSocialActionsInstance().verifySharePopupElements();
    }
    @Test(enabled = true, description = "Verify whatsapp share functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC130_myPostVerifyWhatsAppShareFunctionalityForPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().scrollToWhatsAppIconAndTapInPost();
        getSocialActionsInstance().verifyWhatsAppWelcomeScreenElements();
    }

    @Test(enabled = true, description = "Verify comments functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC131_myPostVerifyCommentFunctionalityForPost(){
        getSignUpInstance().selectTelugu();
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getHomePageActionsInstance().scrollToPostComment();
        getHomePageActionsInstance().tapPostCommentIcon();
        getSocialActionsInstance().enterCommentAndSend(textMessage);
    }

    @Test(enabled = true, description = "Verify repost functionality for a post in my post section",groups = {"RegressionTest", "Social"})
    public void TC133_myPostVerifyRePostFunctionalityForPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().scrollToRepostIconAndTapInPost();
        getSocialActionsInstance().verifyCreatePostScreenElements();
        getSocialActionsInstance().uploadingRePostFunctionalityInMyPost();//Note:-No upload action
    }

    @Test(enabled = true, description = "Verify video playing functionality for a video post in my post section",groups = {"RegressionTest", "Social"})
    public void TC134_myPostVerifyVideoPlayFunctionalityForVideoPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().tapOnVideoPost();
        getSocialActionsInstance().verifyVideoIsPlayingOrNot();
    }

    @Test(enabled = true, description = "Verify audio post functionality for a audio post in my post section",groups = {"RegressionTest", "Social"})
    public void TC135_myPostVerifyAudioPostFunctionalityForAudioPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().scrollToAudioPostAndTap();
        getSocialActionsInstance().tapPauseButton();
    }

    @Test(enabled = true, description = "Verify GIF motion picture functionality for a GIF post in my post section",groups = {"RegressionTest", "Social"})
    public void TC136_myPostVerifyGIFMotionPictureFunctionalityForGIFPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().scrollToGIFPostAndTapInPost();
        getSocialActionsInstance().tapGIFButton();
    }

    @Test(enabled = true, description = "Verify tag link functionality of a post in Gallery section",groups = {"RegressionTest", "Social"})
    public void TC140_galleryVerifyTagLinkFunctionalityOfPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber, otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapGallerySection();
        getSocialActionsInstance().verifyHashTagFunctionalityOfPost();
    }

    @Test(enabled = true, description = "Verify whatsapp share functionality for a post in gallery section",groups = {"RegressionTest", "Social"})
    public void TC145_galleryVerifyWhatsAppShareFunctionalityForPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapGallerySection();
        getSocialActionsInstance().scrollToWhatsAppIconAndTapInPost();
        getSocialActionsInstance().verifyWhatsAppWelcomeScreenElements();
    }
    @Test(enabled = true, description = "Verify repost functionality for a post in gallery section",groups = {"RegressionTest", "Social"})
    public void TC148_galleryVerifyRePostFunctionalityForPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapGallerySection();
        getSocialActionsInstance().scrollToRepostIconAndTapInPost();
        getSocialActionsInstance().verifyCreatePostScreenElements();
        getSocialActionsInstance().verifyUploadingRePostFunctionalityInGallery();
    }

    @Test(enabled = true, description = "Verify video playing functionality for a video post in gallery section",groups = {"RegressionTest", "Social"})
    public void TC150_galleryVerifyVideoPlayingFunctionalityForVideoPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapGallerySection();
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().tapOnVideoPost();
        getSocialActionsInstance().verifyVideoIsPlayingOrNot();
    }

    @Test(enabled = true, description = "Verify audio post functionality for a audio post in gallery section",groups = {"RegressionTest", "Social"})
    public void TC151_galleryVerifyAudioPostFunctionalityForAudioPost(){
        getSignUpInstance().selectLanguage(Language);
        getSocialActionsInstance().appLoginInitializationAndVerifyHomeScreenElements(registerNumber,otp);
        getHomePageActionsInstance().tapProfileIcon();
        getSocialActionsInstance().verifyProfileScreenElements();
        getSocialActionsInstance().tapGallerySection();
        getHomePageActionsInstance().scrollToVideoPost();
        getHomePageActionsInstance().tapOnVideoPost();
        getSocialActionsInstance().verifyVideoIsPlayingOrNot();
    }
}
