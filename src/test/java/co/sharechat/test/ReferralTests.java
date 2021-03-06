package co.sharechat.test;

import co.sharechat.config.TestRunnerInfo;
import co.sharechat.pages.Actions.ReferralActions;
import co.sharechat.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 This Class has all the tests related to the Referral Module
 @author jasmeetsingh
 @version 1.0
 @since 05 july 2019
 */
public class ReferralTests implements Constants {


    public ReferralActions getReferral(){

        return new ReferralActions(new TestRunnerInfo().getDriverSession(),
                new TestRunnerInfo().getRunnerInfo());

    }

    @Test(enabled = true, description = "Verify Referral screen UI", groups = {"RegressionTest", "Growth"})
    public void  TC048_ReferralScreenUI(){

        new SignUpTests().TC004_signupRegistered();

        getReferral().tapReferralButton();//Go to referrals screen

        Assert.assertTrue(getReferral().isMyEarningsDisplayed(),
                "My Winnings button should appear in top of the screen");

        Assert.assertTrue(getReferral().isBackButtonDisplayed(),
                "Back button should appear in top of the screen");

        Assert.assertTrue(getReferral().isTextonreferralDisplayed(),
                "Text should appear on screen after My Winnings button");

        Assert.assertTrue(getReferral().isGetInstalandEarnDisplayed() &&
                        getReferral().isGetinstallEarnTextDisplayed(),
                "\"Get installs and Earn\" button should appear with text");

        Assert.assertTrue(getReferral().isPrintMyQRCodeDisplayed() &&
                        getReferral().isPrintMyQRCodeTextDisplayed(),
                "\"Print My QR Code\" button should appear with text");

        Assert.assertTrue(getReferral().isSetupPaymentDisplayed() ,
                "\"Setup Payment\" button should appear with text");


    }

    @Test(enabled = true, description = "Verify My Winnings screen UI", groups = {"RegressionTest", "Growth"})
    public void  TC099_MyWinningScreenUI(){

        new SignUpTests().TC004_signupRegistered();

        getReferral().tapReferralButton();//Go to referrals screen
        getReferral().tapMyEarnings();//Tap on My Earnings


        Assert.assertTrue(getReferral().isMyEarningBackButtonDisplayed(),
                "Back button should appear on top left corner of the screen");

        Assert.assertTrue(getReferral().isTotalEarningsAmountDisplayed(),
                "Total Earnings amount should appear on screen");

    }

    @Test(enabled = true, description = "Verify Setup Payment link functionality",
            groups = {"RegressionTest", "Growth"})
    public void  TC108_SetupPaymentLinkFunctionality(){

        new SignUpTests().TC004_signupRegistered();

        getReferral().tapReferralButton();//Go to referrals screen
        getReferral().tapSetupPayment();//Tap on Setup Payment

        Assert.assertTrue(getReferral().isSetupPaymentMobileNoFieldDisplayed(),
                "Paytm Mobile number field should open with keyboard");

    }

    @Test(enabled = true, description = "Verify update mobile number functionality",
            groups = {"RegressionTest", "Growth"})
    public void  TC109_SetupPaymentLinkFunctionality(){

        new SignUpTests().TC004_signupRegistered();

        getReferral().tapReferralButton();//Go to referrals screen
        getReferral().tapSetupPayment();//Tap on Setup Payment

        getReferral().enterNoInSetupPaymentMobileNoField(registerNumber);
        getReferral().tapSubmitPayTMMobileNo();//Click on Submit

        Assert.assertTrue(getReferral().verificationInProgressText().contains(varificationText),
                "Total Earnings amount should appear on screen");

    }

}
