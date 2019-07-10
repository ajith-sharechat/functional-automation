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
public class ProfilePageObjects {
    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement profileDetailsLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/menu_contact")
    public MobileElement addFriendIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/menu_share")
    public MobileElement shareIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/menu_setting")
    public MobileElement settingIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_profile_pic")
    public MobileElement profilePic;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_username")
    public MobileElement profileUserName;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_handle")
    public MobileElement profileHandleLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement profileEditButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_follower_count")
    public MobileElement profileFollowerCount;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_following_count")
    public MobileElement profileFollowingCount;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_count")
    public MobileElement profilePostCount;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/tabs']//androidx.appcompat.app.ActionBar.Tab")
    public MobileElement profileMyPostSection;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tabs']//following::androidx.appcompat.app.ActionBar.Tab" +
            "//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement profileStickersSection;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tabs']//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement profileGallerySection;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement phoneContactsLabel;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_toolbar_title']//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement connectSection;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_toolbar_title']//following::androidx.appcompat.app.ActionBar.Tab//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement inviteSection;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_user_follow")
    public MobileElement userFollowLink;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_app_share")
    public MobileElement shareIconInPhoneContacts;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_invite")
    public MobileElement inviteButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ll_change_cover_photo")
    public MobileElement changeButtonBackgroundImageInEditScreen;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_profile_photo")
    public MobileElement profilePicEditScreen;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/b_profile_save")
    public MobileElement saveChangeButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_cover")
    public MobileElement coverPicEditScreen;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='android:id/title']")
    public MobileElement selectAppToShareTitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_change_profile_photo")
    public MobileElement profileCameraIconEditScreen;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_close")
    public MobileElement closeIconProfilePicScreen;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_gallery")
    public MobileElement galleryIconChoosePicOption;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='android:id/title']")
    public MobileElement galleryOptionCompleteActionUsingLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_camera")
    public MobileElement cameraIconChoosePicOption;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/camera_takepicture_iv")
    public MobileElement cameraCaptureButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/crop_image_menu_crop")
    public MobileElement cameraCaptureImageSaveIcon;

}
