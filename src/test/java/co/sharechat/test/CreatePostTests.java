package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CreatePostActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePostTests implements Constants {


    public CreatePostActions getCreatePost(){

        return new CreatePostActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = true, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC001_createTextPost(){

        new SignUpTests().TC004_signupRegistered();

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

    @Test(enabled = true, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC002_createBackgroundTextPost(){

        new SignUpTests().TC004_signupRegistered();

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


    @Test(enabled = true, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void  TC003_createCameraBackgroundTextPost(){

        new SignUpTests().TC004_signupRegistered();

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

    @Test(enabled = true, description = "Verify create without background button functionality", groups = {"SmokeTest"})
    public void TC004_createPollPost(){

        new SignUpTests().TC004_signupRegistered();

        //Crete Poll Post
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
}
