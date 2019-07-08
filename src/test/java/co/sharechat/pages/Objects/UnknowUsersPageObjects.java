package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for unknown user page objects
 * Version: 1.0
 */
public class UnknowUsersPageObjects {
    @AndroidFindBy(id = "in.mohalla.sharechat:id/fab_create_chat")
    public MobileElement addFriendUnknownUserIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_shake")
    public MobileElement shareAndChatLabel;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_shake']//following::android.widget.TextView")
    public MobileElement sharePhoneToTalkLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_shake")
    public MobileElement sharePhoneIconUnknownUsersScreen;

//    @AndroidFindBy(xpath = "//android.widget.TextView[text()='Shake n Chat']")
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_shake_chat")
    public MobileElement shareNChatLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/info_view")
    public MobileElement sharePhoneTalkStrangersLabel;
}
