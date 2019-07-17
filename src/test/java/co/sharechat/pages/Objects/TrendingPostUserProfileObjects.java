package co.sharechat.pages.Objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

/**
 * This Class has all the Objects related to Trending Post User Profile page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 16 july 2019
 */
public class TrendingPostUserProfileObjects {

    //TC_181
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_profile")
    public MobileElement userPF;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement followLink;
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public MobileElement Toast;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/text_follow")})

    public List<MobileElement> otherPFFollowButton;

    //TC_184
    @AndroidFindBy(id = "in.mohalla.sharechat:id/menu_chat")
    public MobileElement chatOption;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/chat_toolbar")
    public MobileElement chatTitle;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_abuse")
    public MobileElement abuceGuidOne;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_spam")
    public MobileElement spamGuidTwo;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_privacy")
    public MobileElement privacyGuidThree;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_message")
    public MobileElement chatBox;


    //TC_185
    @AndroidFindBy(id = "in.mohalla.sharechat:id/menu_share")
    public MobileElement shareMenu;

    @AndroidFindBys({@AndroidBy(id = "android:id/icon")})

    public List<MobileElement> allShareingOption;

    @AndroidFindBys({@AndroidBy(id = "android:id/text1")})

    public List<MobileElement> allShareingOption1;


    //TC_187 & TC_188

    @AndroidFindBys({@AndroidBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/menu_share']//following::android.widget.ImageView")})

    public List<MobileElement> moreOption0;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/title")})

    public List<MobileElement> blockButtonOptoin1;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_block_yes")
    public MobileElement doBlock;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement unBlockButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement doFollow;


}
