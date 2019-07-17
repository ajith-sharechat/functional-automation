package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CreatePostActions;
import co.sharechat.pages.Actions.SignUpActions;
import co.sharechat.pages.Actions.loginPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class launchAppTest
{
    AppiumDriver driver;

    @Test(enabled = false)
    public void testAppLaunch() throws Exception
    {
     getLoginPage().userlogin();
    }

    public loginPage getLoginPage(){

        return new loginPage(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());


    }

    //========================Meet=========================

    public SignUpActions getSignUpPage(){

        return new SignUpActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = false, description = "To verify if user is able to register/Sign up in application with unregistered mobile number")
    public void  TC003_signupRegistered(){

        getSignUpPage().selectHindi();
        getSignUpPage().enterName("Jasmeet");
        getSignUpPage().enterPhNo("946516167723");
        getSignUpPage().selectAgeGroup();
        getSignUpPage().selectGender();
        getSignUpPage().submit();
        Assert.assertTrue(getSignUpPage().langDDLdisplayed(),
                "User should be logged into account and home screen should open");

    }

    @Test(enabled = false, description = "To verify if user is able to register/Sign up in application with registered mobile number")
    public void TC004_signupRegistered(){

        getSignUpPage().selectHindi();
        getSignUpPage().enterName("Jasmeet");
        getSignUpPage().selectCountry();
        getSignUpPage().enterPhNo("9465161677");
        getSignUpPage().selectAgeGroup();
        getSignUpPage().selectGender();
        getSignUpPage().submit();
        getSignUpPage().enterOTP("765789");
        getSignUpPage().submitOTP();
        Assert.assertTrue(getSignUpPage().langDDLdisplayed(),
                "User should be logged into account and home screen should open");
    }

    //Creation

    public CreatePostActions getCreatePost(){

        return new CreatePostActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = true, description = "Verify create without background button functionality")
    public void  createTextPost(){

        TC004_signupRegistered();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickWithouBGBtn();
        //getCreatePost().writeTextofTextPost("Post to check");
        //getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost("Post Caption");
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(5),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true, description = "Verify create without background button functionality")
    public void  createBackgroundTextPost(){

        TC004_signupRegistered();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost("Post Caption");
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(5),
                "Success message should populate on screen after successful post");

    }


    @Test(enabled = true, description = "Verify create without background button functionality")
    public void  createCameraBackgroundTextPost(){

        TC004_signupRegistered();

        //Create Text Post
        getCreatePost().composePost();
        getCreatePost().textCompose();
        getCreatePost().clickCameraBtnOnTextPost();
        getCreatePost().clickPicture();
        getCreatePost().cropPictureOk();
        getCreatePost().writeTextofTextPost("Post to check");
        getCreatePost().submitTextForTextPost();
        getCreatePost().writeTextAboutPost("Post Caption");
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(5),
                "Success message should populate on screen after successful post");

    }

    @Test(enabled = true, description = "Verify create without background button functionality")
    public void createPollPost(){

        TC004_signupRegistered();

        //Crete Poll Post
        getCreatePost().composePost();
        getCreatePost().createPollPost();
        getCreatePost().writeTextAboutPost("Post Caption");
        String []options ={"Yes", "No"};
        getCreatePost().enterInPollOptions(options);
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().isPostUploaded(10),
                "User should be logged into account and home screen should open");
    }

    @Test(enabled = false, description = "Poll post must be published ")
    public void  TC005_creation(){

        TC004_signupRegistered();

        //Crete Camera Post
        getCreatePost().composePost();
        getCreatePost().openCamera();
        getCreatePost().clickPicture();
        getCreatePost().writeTextAboutPost("Post Caption");
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().checkPostUploadingText(),
                "User should be logged into account and home screen should open");

        //Crete upload Post


        //Crete upload Post
        getCreatePost().composePost();
        getCreatePost().createPollPost();
        getCreatePost().writeTextAboutPost("Post Caption");
        //String []options =
        //getCreatePost().enterInPollOptions();
        getCreatePost().submitPost();
        getCreatePost().selectTagForPost();
        getCreatePost().submitPost();

        Assert.assertTrue(getCreatePost().checkPostUploadingText(),
                "User should be logged into account and home screen should open");

    }

}
