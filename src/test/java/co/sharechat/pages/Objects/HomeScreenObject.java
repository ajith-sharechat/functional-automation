package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Objects related to Home Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class HomeScreenObject {

    // TC-022
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_feed")
    public MobileElement HomeIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
    public MobileElement Rupeicon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_notification")
    public MobileElement NotificationIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_explore")
    public MobileElement Explore;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement LangDD;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
    public MobileElement PluseIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_chat")
    public MobileElement ChatIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_profile")
    public MobileElement Profile;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/tv_title")})

    public List<MobileElement> ThirteenTitles;


    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_item_explore_trending_v2']")
    public MobileElement Tags;


    // TC-023
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement LangSelection;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/toolbar_language_change")
    public MobileElement CheckLangScreen;
    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/rb_holder_language")})

    public List<MobileElement> ChooseLang;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/tv_item_explore_trending_v2")})

    public List<MobileElement> CheckTags;
    // TC-024
    @AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
    public MobileElement RupeClick;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_my_earnings")
    public MobileElement VeryfyRupeScreen;

    //TC-025
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_notification")
    public MobileElement NotificationIconClick;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_title")
    public MobileElement VerifyNotifiScreen;

    //TC-026
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_search")
    public MobileElement searchExplore;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/tv_viewholder_bucket_main")})

    public static List<MobileElement> bucketCheck;


    //TC-029

    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement pfScreenCheck;

    //PopUp Unexpected
    @AndroidFindBy(id = "in.mohalla.sharechat:id/cancel_answers")
    public MobileElement CancelPop;


}
