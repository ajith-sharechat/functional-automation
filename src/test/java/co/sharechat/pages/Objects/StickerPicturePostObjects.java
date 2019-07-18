package co.sharechat.pages.Objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


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

    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_share_dm")
    public MobileElement chatShare;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/toolbar")
    public MobileElement chatScreenTitle;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_chat_send")
    public MobileElement sendChat;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_chat_goto")
    public MobileElement arrowIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_message")

    public MobileElement chatMsg;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")

    public MobileElement imagePostCheck;


}
