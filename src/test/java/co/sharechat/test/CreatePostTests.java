package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CommonPageActions;
import co.sharechat.pages.Actions.CreatePostActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CreatePostTests implements Constants {


    public CreatePostActions getCreatePost(){

        return new CreatePostActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }
    public CommonPageActions getCommonPage(){

        return new CommonPageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    /*@BeforeMethod(alwaysRun = true, description = "Login with Registered Number and Click on compose post",
            groups = {"SmokeTest", "RegressionTest", "Creation"})
    public void beforeCreatePost(){
        new SignUpTests().TC004_signupRegistered();

        //Create Text Post
        getCreatePost().composePost();
    }*/

    @Test(enabled = false, description = "Verify create without background button functionality",
            groups = {"SmokeTest"})
    public void  TC001_createTextPost(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().tapWithouBGButton();
        //getCreatePost().writeTextofTextPost("Post to check");
        //getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify create text post with background functionality",
            groups = {"SmokeTest"})
    public void  TC002_createBackgroundTextPost(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }


    @Test(enabled = false, description = "Verify create post with camera background functionality",
            groups = {"SmokeTest"})
    public void  TC003_createCameraBackgroundTextPost(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().tapCameraButtonOnTextPost();
        getCreatePost().clickPicture();
        getCreatePost().cropPictureOk();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(5),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify create poll post functionality", groups = {"SmokeTest"})
    public void TC004_createPollPost(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Poll Post
        getCreatePost().composePost();
        getCreatePost().createPollPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        String []options ={"Yes", "No"};
        getCreatePost().enterInPollOptions(options);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(2),
                "User should be logged into account and home screen should open");
    }

    @Test(enabled = false, description = "Verify text button functionality from creation options",
            groups = {"RegressionTest", "Creation"})
    public void TC030_textPosts(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCreatePost().isCrossMarkOnTextPostDisplayed(),
                "Close button should appear on top of the screen");
        Assert.assertTrue(getCreatePost().isTickMarkOnTextPostDisplayed(),
                "Submit button should appear on top of the screen");

        Assert.assertTrue(getCreatePost().isTextBoldDisplayed(),
                "Bold should appear on screen");
        Assert.assertTrue(getCreatePost().isFontColorButtonDisplayed(),
                "Font color should appear on screen");
        Assert.assertTrue(getCreatePost().isFontBGButtonDisplayed(),
                "Font background color should appear on screen");

        Assert.assertTrue(getCreatePost().isTextFieldToWriteTextDisplayed(),
                "Text field should appear with placeholder text in middle of the screen");

        Assert.assertTrue(getCreatePost().isWithoutBGButtonDisplayed(),
                "Crete without background button should be there on screen");

        Assert.assertTrue(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Picture pick and camera icon should appear with recent gallery pictures on bottom section");

        Assert.assertTrue(getCreatePost().noOfBottomTabsDisplayed() >= 9,
                "9 tabs should appear on bottom of the screen");
    }

    @Test(enabled = false, description = "Verify Close button functionality from post creation screen",
            groups = {"RegressionTest", "Creation"})
    public void TC031_textPostsCloseFunctionality(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().tapOnCrossbtn();

        Assert.assertTrue(getCreatePost().isTextOnAlertDisplayed(),
                "Description should be present in popup");

        Assert.assertTrue(getCreatePost().isNotNowButtonDisplayed(),
                "YES button should appear on popup");
        Assert.assertTrue(getCreatePost().isYesBtnDisplayed(),
                "NOT NOW button should appear on popup");

        Assert.assertFalse(getCreatePost().isCrossMarkOnTextPostDisplayed(),
                "Post should be discarded and Screen should redirect to home screen");
    }

    @Test(enabled = false, description = "Verify Check Mark functionality from post creation screen",
            groups = {"RegressionTest", "Creation"})
    public void TC032_textPostsCheckMarkFunctionality(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().submitTextForTextPost();

        Assert.assertTrue(getCreatePost().isAlertMessageByApplicationIsDisplayed(),
                "Error message should populate on screen");

    }

    @Test(enabled = false, description = "Verify create without background button functionality",
            groups = {"RegressionTest", "Creation"})
    public void TC033_textPostWithoutBG(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapWithouBGButton();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify post creation functionality with plan text",
            groups = {"RegressionTest", "Creation"})
    public void TC034_textPostSimpleText(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify allow permissions functionality for creation functionality with text",
            groups = {"RegressionTest", "Creation"})
    public void TC035_textPostAllowPermission(){

        //Login in application
        boolean []permissionsActions = {allow, allow, deny};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().allowPermission();

        Assert.assertTrue(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Permission should be given and images should appear on create post screen");

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify deny permissions functionality while creating post functionality with text",
            groups = {"RegressionTest", "Creation"})
    public void TC036_textPostDenyPermission(){

        //Login in application
        boolean []permissionsActions = {allow, allow, deny};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().denyPermission();

        Assert.assertFalse(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Permission should be given and images should appear on create post screen");

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify that all trending buckets are appearing in tag feed while posting a post",
            groups = {"RegressionTest", "Creation"})
    public void TC040_trendingBucketsOnPost(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Get all trending bucket names
        getCreatePost().tapOnExploreButton();
        Set<String> bucketNames = getCreatePost().getAllTrendingBuckets();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().tapAddTagButton();

        Assert.assertEquals(getCreatePost().getAllTrendingBucketsOnPost(), bucketNames,
                "All trending buckets should appear in tag feed");

    }

    @Test(enabled = false,
            description = "Verify that used tags are appearing in recent tag section in tag feed",
            groups = {"RegressionTest", "Creation"})
    public void TC041_textPostUsedTag(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        String tagUsed = getCreatePost().getTagUsed();
        getCreatePost().submitPost();

        getCreatePost().hardWait(4);
        //Create 2nd Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();

        Assert.assertEquals(getCreatePost().getTagUsed(), tagUsed,
                "Recently used tag should be appear in Recent Tags bucket in tag feed");
    }

    @Test(enabled = false,
            description = "Verify creating link post by pasting external link",
            groups = {"RegressionTest", "Creation"})
    public void TC042_textPostWithExternalLink(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapWithouBGButton();//Without BG btn
        getCreatePost().writeTextAboutPost(externalLink);

        Assert.assertTrue(getCreatePost().isLinkPreviewDisplayed(), "Link Preview should appear");

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

    }

    @Test(enabled = false,
            description = "Verify creating link post by pasting ShareChat post link",
            groups = {"RegressionTest", "Creation"})
    public void TC043_textPostWithExternalLink(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //copy the link of any post
        getCreatePost().tapOnPostOptionsButton();
        getCreatePost().tapOnLinkCopyButton();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapWithouBGButton();//Without BG btn
        getCreatePost().enterCopiedLink();

        Assert.assertTrue(getCreatePost().isRepostPreviewDisplayed(), "Repost Preview should appear");

        getCreatePost().submitPost();
       // getCreatePost().submitPost();

    }

    @Test(enabled = false,
            description = "Verify creating link post with ShareChat tag links",
            groups = {"RegressionTest", "Creation"})
    public void TC044_creatingLinkPostWithShareChatTag(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Click on Trending Tag and Share
        getCreatePost().tapOnFirstTagInTrendingTags();
        getCreatePost().tapOnShareButtonOnTagPostsScreen();
        getCreatePost().tapOnShareWithShareChatOption();

        //Submit post
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(3);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");
    }

    @Test(enabled = false,
            description = "Verify creating link post with ShareChat user profile link",
            groups = {"RegressionTest", "Creation"})
    public void TC045_createPostWithUserProfileShare(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Click on user profile of post, Share Btn, Share with share-chat.
        getCreatePost().tapOnPostsUserProfileButton();
        getCreatePost().tapOnShareButtonOnProfileScreen();
        getCreatePost().tapOnShareWithShareChatOption();

        //Submit post
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(3);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify creating link post by typing the link",
            groups = {"RegressionTest", "Creation"})
    public void TC047_textPostWithExternalLink(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapWithouBGButton();//Without BG btn
        getCreatePost().writeTextAboutPost(externalLink);

        Assert.assertTrue(getCreatePost().isLinkPreviewDisplayed(), "Link Preview should appear");

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text with background post functionality with Color pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC048_textPostWithColorBG(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapOnColorTabInTextPost();
        getCreatePost().tapOnAnyColorTabInBGTextPost();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text with background post functionality with our country pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC049_textPostWithAnyDefaultPicturesBG(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().tapOnShareChatCultureTabInTextPost();
        getCreatePost().tapOnAnyColorTabInBGTextPost();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text with background post creation functionality with mobile gallery pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC050_textPostWithAnyDefaultP(){

        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        if(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed()){
            getCreatePost().selectGalaryPickForBG();
        }

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text with background post creation functionality with camera pictures",
            groups = {"RegressionTest", "Creation"})
    public void  AR52_textPostWithCameraBackground(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().tapCameraButtonOnTextPost();
        getCreatePost().clickPicture();
        getCreatePost().cropPictureOk();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(
                5),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text post creation functionality by allowing permissions what app asked",
            groups = {"RegressionTest", "Creation"})
    public void  AR53_textPostWithAllowPermission(){
        //Login in application
        boolean []permissionsActions = {allow, allow, deny};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().allowPermission();

        Assert.assertTrue(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Permission should be given and images should appear on create post screen");
        if(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed()){
            getCreatePost().selectGalaryPickForBG();
        }
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text post creation functionality by denying permissions what mobile asked",
            groups = {"RegressionTest", "Creation"})
    public void AR54_textPostWithDenyPermissionWithColorBG(){

        //Login in application
        boolean []permissionsActions = {allow, allow, deny};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().denyPermission();

        Assert.assertFalse(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Permission should be given and images should appear on create post screen");

        getCreatePost().tapOnColorTabInTextPost();
        getCreatePost().tapOnAnyColorTabInBGTextPost();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by single tag",
            groups = {"RegressionTest", "Creation"})
    public void  AR55_textPostWithSingleTag(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by creating new tag",
            groups = {"RegressionTest", "Creation"})
    public void  AR56_textPostWithCreateNewTag(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().submitPost();
        //Create new Tag
        getCreatePost().createUniqueNewTag("Automation_");
        getCreatePost().tapCreateTagButton();
        getCreatePost().selectBucketForNewTag();
        getCreatePost().submitNewTag();
        Assert.assertTrue(getCreatePost().getTextAboutPost().contains("#Automation_"),
                "Tag should be created and attached to the post");

        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by multiple tag",
            groups = {"RegressionTest", "Creation"})
    public void  AR57_textPostWithMultipleTags(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().submitPost();

        //Select Multiple tegs and Save them in list
        List<String > tags= new ArrayList<>();
        tags.add(getCreatePost().selectTagForPost(1));
        tags.add(getCreatePost().selectTagForPost(2));
        tags.add(getCreatePost().selectTagForPost(3));

        for (String tagText: tags) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(tagText),
                    "Tag should be attached to the post");
        }

        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by adding single friend",
            groups = {"RegressionTest", "Creation"})
    public void  AR58_textPostWithSingleFriend(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        //Select First Friend and Save him in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by adding multiple friends",
            groups = {"RegressionTest", "Creation"})
    public void  AR59_textPostWithMultipleFriends(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        //Select Multiple Friends and Save them in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));
        friends.add(getCreatePost().selectFriendForPost(2));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text post creation functionality by attaching single person who user is following",
            groups = {"RegressionTest", "Creation"})
    public void  AR60_textPostWithSingleFollowingFriend(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        getCreatePost().tapFollowingTabInAddFriend();//Tap on Following tab

        //Select First Friend and Save him in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }
    //==============================================Today======================================
    @Test(enabled = false,
            description = "Verify text post creation functionality by attaching multiple persons who user is following",
            groups = {"RegressionTest", "Creation"})
    public void  AR61_textPostWithMultipleFollowingFriends(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        getCreatePost().tapFollowingTabInAddFriend();//Tap on Following tab

        //Select Multiple Friends and Save them in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));
        friends.add(getCreatePost().selectFriendForPost(2));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by attaching single follower",
            groups = {"RegressionTest", "Creation"})
    public void  AR62_textPostWithSingleFollowerFriend(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        getCreatePost().tapFollowersTabInAddFriend();//Tap on Followers tab

        //Select First Friend and Save him in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false, description = "Verify text post creation functionality by attaching multiple follower",
            groups = {"RegressionTest", "Creation"})
    public void  AR63_textPostWithMultipleFollowersFriends(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);

        getCreatePost().tapAddFriendButton();//Tap on Add friend Button
        getCreatePost().tapFollowersTabInAddFriend();//Tap on Followers tab

        //Select Multiple Friends and Save them in list
        List<String > friends= new ArrayList<>();
        friends.add(getCreatePost().selectFriendForPost(1));
        friends.add(getCreatePost().selectFriendForPost(2));

        for (String friendName: friends) {
            Assert.assertTrue(getCreatePost().getTextAboutPost().contains(friendName),
                    "Friend should be attached to the post");
        }
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost(1);
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }
    //==============================================Today======================================
    //========================================Create Camera Starts======================================

    @Test(enabled = true, description = "Verify Camera button functionality from Creation POPUP",
            groups = {"RegressionTest", "Creation"})
    public void  AR64_cameraPostFunctionality(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Open Camera and click on permissions.
        getCreatePost().composePost();
        getCreatePost().openCamera();
        boolean []cameraPermissions = {allow, allow};
        new SignUpTests().actionPermissions(cameraPermissions);

        Assert.assertTrue(getCreatePost().isCameraCloseButtonDisplayed(),
                "Camera close button should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraFlashButtonDisplayed(),
                "Flash Button should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraVideoSpeedButtonDisplayed(),
                "Video Speed Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraTimerButtonDisplayed(),
                "Timer Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraBeautyButtonDisplayed(),
                "BeautyFy Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isFlipCameraButtonDisplayed(),
                "Flip Camera Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraMagicStickersButtonDisplayed(),
                "Emoji Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCaptureButtonDisplayed(),
                "Capture Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraMusicButtonDisplayed(),
                "Music Button Should be Displayed");

        Assert.assertTrue(getCreatePost().isCameraInstructionsDisplayed(),
                "Camera Instructions Should be Displayed");

    }

    @Test(enabled = true, description = "Verify Close button functionality from camera screen",
            groups = {"RegressionTest", "Creation"})
    public void  AR65_cameraPostCloseButtonFunctionality(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Open Camera and click on permissions.
        getCreatePost().composePost();
        getCreatePost().openCamera();

        getCreatePost().tapOnCloseCameraButton();

        Assert.assertTrue(new  SignUpTests().getSignUpPage().isLanguageDropDownListDisplayed(),
                "Camera should closed and home screen should open");

    }

    @Test(enabled = true, description = "Verify video speed button functionality from camera screen",
            groups = {"RegressionTest", "Creation"})
    public void  AR69_cameraPostVideoSpeedFunctionality(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Open Camera and click on permissions.
        getCreatePost().composePost();
        getCreatePost().openCamera();

        getCreatePost().tapOnVideoSpeedButton();

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureTextDisplayed(),
                "Popup should have proper text at below the video");

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureDownloadButtonDisplayed(),
                "Popup should have DOWNLOAD button.");

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureSkipDisplayed(),
                "Popup should have SKIP button");

        getCreatePost().tapOnDownloadCameraPopupSkipButton();

        Assert.assertFalse(getCreatePost().isDownloadCameraFeatureTextDisplayed(),
                "Popup should be closed");

    }

    @Test(enabled = true, description = "Verify timer button functionality from camera screen",
            groups = {"RegressionTest", "Creation"})
    public void  AR70_cameraPostTimerFunctionality(){
        //Login in application
        boolean []permissionsActions = {allow, allow, allow};
        new SignUpTests().registeredLogin(permissionsActions);

        //Open Camera and click on permissions.
        getCreatePost().composePost();
        getCreatePost().openCamera();

        getCreatePost().tapOnTimerButton();

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureTextDisplayed(),
                "Popup should have proper text at below the video");

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureDownloadButtonDisplayed(),
                "Popup should have DOWNLOAD button.");

        Assert.assertTrue(getCreatePost().isDownloadCameraFeatureSkipDisplayed(),
                "Popup should have SKIP button");

        getCreatePost().tapOnDownloadCameraPopupSkipButton();

        Assert.assertFalse(getCreatePost().isDownloadCameraFeatureTextDisplayed(),
                "Popup should be closed");

    }




    //========================================Create Camera Ends========================================


}
