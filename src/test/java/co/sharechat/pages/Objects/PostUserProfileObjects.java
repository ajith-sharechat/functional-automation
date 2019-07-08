package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PostUserProfileObjects {
//    @AndroidFindBy(id = "in.mohalla.sharechat:id/menu_chat")
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/menu_chat'][@index='0']")
    public MobileElement profileChatIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_message")
    public MobileElement postUserMessageField;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/fab_send_or_record")
    public MobileElement sendMessageIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_back")
    public MobileElement backIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_user_name")
    public MobileElement postUserNameLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_message")
    public MobileElement recentMessagePosted;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_options")
    public MobileElement postImageToolOptions;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/fl_profile_labels']/following::android.widget.ImageButton")
    public MobileElement postUserProfileBackButton;
}
