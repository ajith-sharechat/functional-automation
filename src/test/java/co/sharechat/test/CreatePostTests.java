package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CommonPageActions;
import co.sharechat.pages.Actions.CreatePostActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickWithouBGBtn();
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
        boolean []permissionsActions = {true, true, true};
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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickCameraBtnOnTextPost();
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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
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
        boolean []permissionsActions = {true, true, true};
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
        Assert.assertTrue(getCreatePost().isFontColorBtnDisplayed(),
                "Font color should appear on screen");
        Assert.assertTrue(getCreatePost().isFontBGBtnDisplayed(),
                "Font background color should appear on screen");

        Assert.assertTrue(getCreatePost().isTextFieldToWriteTextDisplayed(),
                "Text field should appear with placeholder text in middle of the screen");

        Assert.assertTrue(getCreatePost().iswithoutBGBtnDisplayed(),
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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickOnCrossbtn();

        Assert.assertTrue(getCreatePost().istextOnAlertDisplayed(),
                "Description should be present in popup");

        Assert.assertTrue(getCreatePost().isNotNowBtnDisplayed(),
                "YES button should appear on popup");
        Assert.assertTrue(getCreatePost().isYesBtnDisplayed(),
                "NOT NOW button should appear on popup");

        Assert.assertFalse(getCreatePost().isCrossMarkOnTextPostDisplayed(),
                "Post should be discard and Screen should redirect to home screen");
    }

    @Test(enabled = false, description = "Verify Check Mark functionality from post creation screen",
            groups = {"RegressionTest", "Creation"})
    public void TC032_textPostsCheckMarkFunctionality(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickWithouBGBtn();
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
        boolean []permissionsActions = {true, true, true};
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
        boolean []permissionsActions = {true, true, false};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().alllowPermission();

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
        boolean []permissionsActions = {true, true, false};
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
    public void TC040_trendindbucketsOnPost(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Get all trending bucket names
        getCreatePost().clickOnExploreBtn();
        Set<String> bucketNames = getCreatePost().getAllTrendingBuckets();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().clickAddTagBTN();

        Assert.assertEquals(getCreatePost().getAllTrendingBucketsOnPost(), bucketNames,
                "All trending buckets should appear in tag feed");

    }

    @Test(enabled = false,
            description = "Verify that used tags are appearing in recent tag section in tag feed",
            groups = {"RegressionTest", "Creation"})
    public void TC041_textPostUsedTag(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
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
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickWithouBGBtn();//Without BG btn
        getCreatePost().writeTextAboutPost(externalLink);

        Assert.assertTrue(getCreatePost().isLinkPerviewDisplayed(), "Link Perview should apear");

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

    }

    @Test(enabled = false,
            description = "Verify creating link post by pasting ShareChat post link",
            groups = {"RegressionTest", "Creation"})
    public void TC043_textPostWithExternalLink(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //copy the link of any post
        getCreatePost().clickOnPostOptionsBTN();
        getCreatePost().clickOnLinkCopyBTN();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickWithouBGBtn();//Without BG btn
        getCreatePost().enterCopiedLink();

        Assert.assertTrue(getCreatePost().isRepostPerviewDisplayed(), "Repost Perview should apear");

        getCreatePost().submitPost();
       // getCreatePost().submitPost();

    }

    @Test(enabled = false,
            description = "Verify creating link post with ShareChat tag links",
            groups = {"RegressionTest", "Creation"})
    public void TC044_creatingLinkPostWithShareChatTag(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Click on Trending Tag and Share
        getCreatePost().clickOnFirstTagInTrendingTags();
        getCreatePost().clickOnShareBTNOnTagPostsScreen();
        getCreatePost().clickOnShareWithShareChatOption();

        //Submit post
        getCreatePost().submitPost();
        getCreatePost().select3rdTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");
    }

    @Test(enabled = false,
            description = "Verify creating link post with ShareChat user profile link",
            groups = {"RegressionTest", "Creation"})
    public void TC045_createPostWithUserProfileShare(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Click on user profile of post, Share Btn, Share with share-chat.
        getCreatePost().clickOnPostsUserProfileBTN();
        getCreatePost().clickOnShareBTNOnProfileScreen();
        getCreatePost().clickOnShareWithShareChatOption();

        //Submit post
        getCreatePost().submitPost();
        getCreatePost().select3rdTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true,
            description = "Verify creating link post by typing the link",
            groups = {"RegressionTest", "Creation"})
    public void TC047_textPostWithExternalLink(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickWithouBGBtn();//Without BG btn
        getCreatePost().writeTextAboutPost(externalLink);

        Assert.assertTrue(getCreatePost().isLinkPerviewDisplayed(), "Link Perview should apear");

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true,
            description = "Verify text with background post functionality with Color pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC048_textPostWithColorBG(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickOnColorTabInTextPost();
        getCreatePost().clickOnAnyColorTabInBGTextPost();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true,
            description = "Verify text with background post functionality with our country pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC049_textPostWithAnyDefaultPicturesBG(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        getCreatePost().clickOnShareChatCultureTabInTextPost();
        getCreatePost().clickOnAnyColorTabInBGTextPost();

        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true,
            description = "Verify text with background post creation functionality with mobile gallery pictures",
            groups = {"RegressionTest", "Creation"})
    public void TC050_textPostWithAnyDefaultP(){

        //Login in application
        boolean []permissionsActions = {true, true, true};
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
    public void  TC053_textPostWithCameraBackground(){
        //Login in application
        boolean []permissionsActions = {true, true, true};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickCameraBtnOnTextPost();
        getCreatePost().clickPicture();
        getCreatePost().cropPictureOk();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();

        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(5),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = false,
            description = "Verify text post creation functionality by allowing permissions what app asked",
            groups = {"RegressionTest", "Creation"})
    public void  TC054_textPostWithAllowPermission(){
        //Login in application
        boolean []permissionsActions = {true, true, false};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().alllowPermission();

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
    public void TC055_textPostWithDenyPermissionWithColorBG(){

        //Login in application
        boolean []permissionsActions = {true, true, false};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().denyPermission();

        Assert.assertFalse(getCreatePost().iscameraIconPicturepickGalaryPostDisplayed(),
                "Permission should be given and images should appear on create post screen");

        getCreatePost().clickOnColorTabInTextPost();
        getCreatePost().clickOnAnyColorTabInBGTextPost();

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
    public void  TC056_textPostWithSingleTag(){
        //Login in application
        boolean []permissionsActions = {true, true, true};
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
    public void  TC057_textPostWithCreateNewTag(){
        //Login in application
        boolean []permissionsActions = {true, true, true};
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
        getCreatePost().clickCreateTagBTN();
        getCreatePost().selectBucketForNewTag();
        getCreatePost().submitNewTag();
        Assert.assertTrue(getCreatePost().getTextAboutPost().contains("#Automation_"),
                "Tag should be created and attached to the post");

        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }


}
