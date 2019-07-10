package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for profile page objects
 * Version: 1.0
 */

public class MessengerAppPageObjects {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to WhatsApp']")
    public MobileElement welcomeWhatsAppLabel;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.whatsapp:id/eula_accept']")
    public MobileElement whatsAppAgreeAndContinueButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WhatsApp']")
    public MobileElement whatsAppIconTitleNamePopupScreen;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/sharing_bottomsheet_action_rl']//android.widget.LinearLayout")
    public MobileElement notificationsOffIconInSharePopup;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/sharing_bottomsheet_action_rl']//android.widget.LinearLayout[2]")
    public MobileElement convertToStickerIconInSharePopup;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/sharing_bottomsheet_action_rl']//android.widget.LinearLayout[3]")
    public MobileElement shareChatMessagesIconInSharePopup;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/sharing_bottomsheet_action_rl']//android.widget.LinearLayout[4]")
    public MobileElement followIconInSharePopup;
}
