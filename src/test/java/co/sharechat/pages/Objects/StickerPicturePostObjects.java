package co.sharechat.pages.Objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

/**
 * This Class has all the Objects related to Sticker Picture Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */
public class StickerPicturePostObjects {


    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")
    public MobileElement imagePost;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
    public MobileElement stickerTab;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_spinner_selection")
    public MobileElement stickerDropDown;

    @AndroidFindBy(id = "android:id/iv_sticker_pack ")
    public MobileElement itemSelect;


    @AndroidFindBy(xpath = "//*[@text='हिन्दी']")
    public MobileElement selectHindi;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_name")
    public MobileElement enterName;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_phone")
    public MobileElement enterNumber;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/rb_male")
    public MobileElement selectRadioButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_get_otp")
    public MobileElement goToYourAccount;

    @AndroidFindBy(xpath = "//*[@text='ALLOW']")
    public MobileElement allow;
    @AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})

    public List<MobileElement> OTPValues;

//    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
//    public MobileElement stickerTab;
//    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
//    public MobileElement stickerTab;
//    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
//    public MobileElement stickerTab;
//    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
//    public MobileElement stickerTab;
//    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")
//    public MobileElement stickerTab;


}
