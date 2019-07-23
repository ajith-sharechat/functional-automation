package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * @reviewer sheshanandan
 * @since 22-July-2019
 * @purpose This Class is for privacy setting page objects
 * @version 1.0
 */
public class PrivacySettingObjects {
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/toolbar_privacy']//android.widget.TextView")
    public MobileElement privacySettingTitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/privacy_title")
    public MobileElement privacyFollowerList;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/privacy_description")
    public MobileElement privacyFollowerDescription;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/privacy_icon")
    public MobileElement privacyFollowerIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/following_privacy_title")
    public MobileElement privacyFollowingList;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/following_privacy_description")
    public MobileElement privacyFollowingDescription;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/following_privacy_icon")
    public MobileElement privacyFollowingIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tag_privacy_title")
    public MobileElement privacyTagList;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tag_privacy_description")
    public MobileElement privacyTagDescription;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tag_privacy_icon")
    public MobileElement privacyTagIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/block_title")
    public MobileElement privacyBlockTitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/block_description")
    public MobileElement privacyBlockDescription;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/block_icon")
    public MobileElement privacyBlockIcon;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/deactivate_container']//following::android.widget.TextView")
    public MobileElement DeactivateYourAccountLabel;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/deactivate_container']//following::android.widget.ImageView")
    public MobileElement DeactivateYourAccountIcon;
}
