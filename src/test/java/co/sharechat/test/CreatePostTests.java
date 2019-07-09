package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CommonPageActions;
import co.sharechat.pages.Actions.CreatePostActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;


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

    @Test(enabled = false, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC001_createTextPost(){


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

    @Test(enabled = false, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC002_createBackgroundTextPost(){

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


    @Test(enabled = false, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC003_createCameraBackgroundTextPost(){

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

    @Test(enabled = false, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void TC004_createPollPost(){

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

        new SignUpTests().TC004_signupRegistered();

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

        new SignUpTests().TC004_signupRegistered();

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

    @Test(enabled = true, description = "Verify allow permissions functionality for creation functionality with text",
            groups = {"RegressionTest", "Creation"})
    public void TC035_textPostAllowPermission(){

        boolean []permissionsActions = {true, true, false};
        new SignUpTests().registeredLogin(permissionsActions);

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();

        Assert.assertTrue(getCommonPage().isAndroidAlertDisplayed(),
                " Files Access permission popup should appear on screen");
        getCommonPage().alllowPermission();

        /*Assert.assertTrue(getCreatePost().noOfBottomTabsDisplayed() >= 9,
                "Permission should be given and images should appear on create post screen");*/
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost(textAboutPost);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(1),
                "Success message should populate on screen after successful post");

    }

}
