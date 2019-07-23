package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

/**
 * This Class has all the Objects related to Profile Page
 *
 * @author Diljeet Singh/Ramesh
 * @version 1.0
 * @since 01 july 2019
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

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tabs']//following::androidx.appcompat.app.ActionBar.Tab[3]")
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

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[1]")
    public MobileElement fullNameTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[2]")
    public MobileElement handleTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[3]")
    public MobileElement bioTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[4]")
    public MobileElement birthdayTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[5]")
    public MobileElement locationTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[6]")
    public MobileElement mobileNumberTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']" +
            "//following::android.widget.EditText[5]//following::android.widget.TextView")
    public MobileElement privateInformationLabel;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/row_name']//following::android.widget.EditText[5]" +
            "//following::android.widget.TextView//following::android.widget.TextView")
    public MobileElement privateInformationDescriptionLabel;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/tabs']//androidx.appcompat.app.ActionBar.Tab [2]")
    public MobileElement gallerySection;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/tabs']//androidx.appcompat.app.ActionBar.Tab [1]")
    public MobileElement myPostsSection;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/tabs']//androidx.appcompat.app.ActionBar.Tab [3]")
    public MobileElement stickersSection;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_repost_user")
    public MobileElement rePostUserLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_sticker_start_download")
    public MobileElement stickerDownloadIcon;

    @AndroidFindBy(id ="com.whatsapp:id/cancel_button")
    public MobileElement cancelPopupButton;

    @AndroidFindBy(id ="com.whatsapp:id/add_button")
    public MobileElement addPopupButton;

    @AndroidFindBy(xpath ="//*[contains(@text,'Would you like to add')]")
    public MobileElement stickerToAddWhatsAppPopupQuestion;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_sticker_pack")
    public MobileElement stickerImage;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_sticker_pack")
    public MobileElement stickerImageLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_sticker_delete")
    public MobileElement stickerDeleteIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement stickerTitleLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_toolbar_search")
    public MobileElement stickerSaveButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_sticker_save")
    public MobileElement stickers;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/ll_change_cover_photo']//following::android.widget.TextView")
    public MobileElement editButton;

    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/image_view")})
    public List<MobileElement> saveButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/md_buttonDefaultNegative")
    public MobileElement phoneGalleryDailog;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_profile")
    public MobileElement profileLink;

    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"गुल्लक\"]")
    public MobileElement gallery;

    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"स्टिकर्स\"]")
    public MobileElement stickersTab;

    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/btn_sticker_start_download")})
    public List<MobileElement> downLoadbutton;

    @AndroidFindBy(id = "com.whatsapp:id/add_button")
    public MobileElement addOnWhatsApp;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public MobileElement Toast;


    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/fl_sticker_save")})
    public List<MobileElement> stickerPackClick;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_back")
    public MobileElement toolBarBack;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/menu_setting")
    public MobileElement Setting;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/skin_change_area")
    public MobileElement SkinChange;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[2]")

    public MobileElement chooseEnglish;

    @AndroidFindBy(xpath = "//*[@text='Profile settings']")

    public MobileElement checkSelectedSkin;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@content-desc,\"\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200F\u200F\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200E\u200E\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200F\u200E\u200F\u200E\u200E\u200E\u200E\u200E\u200F\u200F\u200E\u200F\u200F\u200E\u200E\u200F\u200E\u200F\u200E\u200F\u200F\u200F\u200F\u200F\u200E\u200ENavigate up\u200E\u200F\u200E\u200E\u200F\u200E\")]")

    public MobileElement skinBackButton;

    @AndroidFindBy(xpath = "//*[@text='Chat']")

    public MobileElement checkChat;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/logout_container_main")

    public MobileElement logoutCheck;
    @AndroidFindBy(id = "android:id/button1")

    public MobileElement logoutAlert;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/select_title")

    public MobileElement confirmAfterLogoutScreen;
}
