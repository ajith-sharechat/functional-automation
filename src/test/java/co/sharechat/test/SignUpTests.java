package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.CommonPageActions;
import co.sharechat.pages.Actions.SignUpActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 This Class has all the tests related to the Singup/Login tests
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class SignUpTests implements Constants {

    public SignUpActions getSignUpPage(){

        return new SignUpActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    public CommonPageActions getCommonPage(){

        return new CommonPageActions(new TestRunnerInfo().getDriverSession(), new TestRunnerInfo().getRunnerInfo());

    }

    /**
    * This function will login with registered user and according to the permissionsActions array passed.
     * It will check, if signup screen will come it will do signup.
     * Make sure array is of 3 length.
     *  @author jasmeetsingh
     *  @version 1.1
     *  @since 09 july 2019
    * */

    public void registeredLogin(boolean []permissionsActions){
        getSignUpPage().selectHindi();

        if (getSignUpPage().isSignUpScreen()){//If signup screen then go through signup
            getSignUpPage().enterName(userName);
            getSignUpPage().selectCountry();
            getSignUpPage().enterPhNo(registerNumber);
            getSignUpPage().selectAgeGroup();
            getSignUpPage().selectGender();
            getSignUpPage().submit();

            actonPermissions(permissionsActions);

            getSignUpPage().enterOTP(otp);
            getSignUpPage().submitOTP();
        }
        else {
            getSignUpPage().enterPhNo(registerNumber);
            getSignUpPage().clickLogin();

            actonPermissions(permissionsActions);
            getSignUpPage().enterOTPinLogin(otp);
        }
        getSignUpPage().langDDLdisplayed();
    }

    /**
     * This function will accept or deny the permissions acess according to the permissionsActions array passed.
     * Make sure array is of 3 length.
     *  @author jasmeetsingh
     *  @version 1.0
     *  @since 09 july 2019
     * */
    public void actonPermissions(boolean []permissionsActions) {
        for (boolean action : permissionsActions) {
            if (action == true)
                getCommonPage().alllowPermission();
            else
                getCommonPage().denyPermission();
        }
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
