package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Actions related to Home Page Objects
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class HomeScreenObject {

    // TC-022
    @AndroidFindBy(xpath = "//*[@text='होम']")
    public MobileElement HomeIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
    public MobileElement Rupeicon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_notification")
    public MobileElement NotificationIcon;

    @AndroidFindBy(xpath = "//*[@text='ख़ज़ाना']")
    public MobileElement Explore;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement LangDD;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
    public MobileElement PluseIcon;

    @AndroidFindBy(xpath = "//*[@text='चैट']")
    public MobileElement ChatIcon;

    @AndroidFindBy(xpath = "//*[@text='प्रोफ़ाइल']")
    public MobileElement Profile;

    @AndroidFindBy(xpath = "//*[@text='फॉलोइंग']")
    public MobileElement Following;

    @AndroidFindBy(xpath = "//*[@text='लोकप्रिय']")
    public MobileElement Trending;

    @AndroidFindBy(xpath = "//*[@text='वीडियो']")
    public MobileElement Video;
    @AndroidFindBy(xpath = "//*[@text='क्रिकेट']")
    public MobileElement Cricket;
    @AndroidFindBy(xpath = "//*[@text='फ़िल्म - गाने']")
    public MobileElement FilmSong;
    @AndroidFindBy(xpath = "//*[@text='ख़बरें']")
    public MobileElement News;
    @AndroidFindBy(xpath = "//*[@text='लव']")
    public MobileElement Love;
    @AndroidFindBy(xpath = "//*[@text='शुभकामनाएं']")
    public MobileElement Wishes;
    @AndroidFindBy(xpath = "//*[@text='वाट्सएप']")
    public MobileElement WhatsApp;
    @AndroidFindBy(xpath = "//*[@text='भक्ति']")
    public MobileElement Devotion;
    @AndroidFindBy(xpath = "//*[@text='मजेदार']")
    public MobileElement Funny;
    @AndroidFindBy(xpath = "//*[@text='फैशन']")
    public MobileElement Fashion;
    @AndroidFindBy(xpath = "//*[@text='स्वास्थ्य']")
    public MobileElement LifeStyle;
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_item_explore_trending_v2']")
    public MobileElement Tags;


    // TC-023
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement LangSelection;
    @AndroidFindBy(xpath = "//*[@text='अपनी भाषा को बदलें']")
    public MobileElement CheckLangScreen;
    @AndroidFindBy(xpath = "//*[@text='मराठी (Marathi)']")
    public MobileElement ChooseLang;
    @AndroidFindBy(xpath = "//*[@text='व्हिडीओ']")
    public MobileElement checklangTab;
    @AndroidFindBy(xpath = "//*[@text='ट्रेंडिंग टॅग्स']")
    public MobileElement CheckTags;
    @AndroidFindBy(xpath = "//*[@text='खजिना']")
    public MobileElement CheckExploreTabs;
    @AndroidFindBy(xpath = "//*[@text='मराठी']")
    public MobileElement CheckSelectedLang;

    // TC-024
    @AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
    public MobileElement RupeClick;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_my_earnings")
    public MobileElement VeryfyRupeScreen;

    //TC-025
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_notification")
    public MobileElement NotificationIconClick;
    @AndroidFindBy(xpath = "//*[@text='सूचनाएं']")
    public MobileElement VerifyNotifiScreen;

    //TC-026
    @AndroidFindBy(xpath = "//*[@text='ख़ज़ाना']")
    public MobileElement exploreButton;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_search")
    public MobileElement searchExplore;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/tv_viewholder_bucket_main")})

    public static List<MobileElement> bucketCheck;

    //TC-028
    @AndroidFindBy(xpath = "//*[@text='चैट']")
    public MobileElement chatBox;

    //TC-029
    @AndroidFindBy(xpath = "//*[@text='प्रोफ़ाइल']")
    public MobileElement PfButton;
    @AndroidFindBy(xpath = "//*[@text='प्रोफाइल में बदलाव करें']")
    public MobileElement pfScreenCheck;

    //PopUp Unexpected
    @AndroidFindBy(id = "in.mohalla.sharechat:id/cancel_answers")
    public MobileElement CancelPop;


}
