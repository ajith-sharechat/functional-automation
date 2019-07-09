package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Objects related to Sticker Functionality Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 08 july 2019
 */

public class StickerFunctionalityObjects {


    //TC-153
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_profile")

    public static MobileElement profileTab;

    @AndroidFindBys
            ({@AndroidBy(className = "androidx.appcompat.app.ActionBar$Tab")})

    public List<MobileElement> stickeTab02;

    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/fl_sticker_save")})

    public List<MobileElement> stickerPackClick;


    @AndroidFindBy(xpath = "//*[@id ='in.mohalla.sharechat:id/tv_toolbar_title'  or @id='in.mohalla.sharechat:id/ll_toolbar_actions']")

    public static MobileElement DetailStickerTitle;


}
