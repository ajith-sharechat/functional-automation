package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Objects related to Profile Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class ProfilePageObjects {

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
