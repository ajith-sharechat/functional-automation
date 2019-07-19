package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/10/2019
 * Purpose: This Class is for profile page objects
 * Version: 1.0
 */
public class ProfileSettingPageObjects {
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/change_skin_title']//preceding::android.widget.TextView//preceding::android.widget.TextView")
    public MobileElement profileSettingTitle;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/change_skin_title']//preceding::android.widget.TextView//following::android.widget.TextView")
    public MobileElement quickSettingSubtitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/change_skin_title")
    public MobileElement changeLanguageModeOption;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/saver_title")
    public MobileElement dataSaverOption;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/gallery_title")
    public MobileElement postDownloadOption;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/account_title")
    public MobileElement accountSettings;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/privacy_title")
    public MobileElement privacySettings;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/notif_title")
    public MobileElement notificationSettings;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/help_title")
    public MobileElement helpFeedbackSettings;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/logout_icon")
    public MobileElement logoutIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/skin_default")
    public MobileElement defaultRadioButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/skin_english")
    public MobileElement englishRadioButton;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/skin_english']//following::android.widget.RadioButton")
    public MobileElement hinglishRadioButton;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/appskin_container']//preceding::android.widget.TextView")
    public MobileElement changeLanguageModePopupTitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/data_saver_switch")
    public MobileElement dataSaverSwitch;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/post_download_switch")
    public MobileElement postDownloadSwitch;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_gallery_description")
    public MobileElement galleryDescriptionSubTitle;

}
