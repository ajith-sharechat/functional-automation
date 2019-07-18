package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.SignUp;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests implements Constants {

    public SignUp getSignUpPage(){

        return new SignUp(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = true, groups = {"SmokeTest"},
            description = "To verify if user is able to register/Sign up in application with unregistered mobile number")
    public void  TC003_signupRegistered(){

        getSignUpPage().selectHindi();
        getSignUpPage().enterName(userName);
        getSignUpPage().enterPhNo(uniqueNo);
        getSignUpPage().selectAgeGroup();
        getSignUpPage().selectGender();
        getSignUpPage().submit();
        Assert.assertTrue(getSignUpPage().langDDLdisplayed(),
                "User should be logged into account and home screen should open");

    }

    @Test(enabled = true, groups = {"SmokeTest"},
            description = "To verify if user is able to register/Sign up in application with registered mobile number")
    public void TC004_signupRegistered(){

        getSignUpPage().selectHindi();
        getSignUpPage().enterName(userName);
        getSignUpPage().selectCountry();
        getSignUpPage().enterPhNo(registerNumber);
        getSignUpPage().selectAgeGroup();
        getSignUpPage().selectGender();
        getSignUpPage().submit();
        getSignUpPage().enterOTP(otp);
        getSignUpPage().submitOTP();
        Assert.assertTrue(getSignUpPage().langDDLdisplayed(),
                "User should be logged into account and home screen should open");
    }



}
