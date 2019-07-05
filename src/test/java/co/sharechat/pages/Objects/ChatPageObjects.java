package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChatPageObjects {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='in.mohalla.sharechat:id/anim_view']//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement knownNameLabel;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='in.mohalla.sharechat:id/anim_view']//following::androidx.appcompat.app.ActionBar.Tab//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement unKnownName;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_user_name")
    public MobileElement recentKnownNameLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/fab_create_chat")
    public MobileElement addFriendIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_chat_time")
    public MobileElement knownRecentChatTime;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_user_image")
    public MobileElement recentKnownImage;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/anim_view")
    public MobileElement shareMobileIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_toolbar_search")
    public MobileElement topSearchIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement chatScreenTitle;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/et_message']/preceding::android.widget.TextView[2]")
    public MobileElement recentMessageInChatBox;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_play_pause")
    public MobileElement playPauseButton;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/tv_user_name']//following::android.widget.ImageView")
    public MobileElement rightConerOptionListChatBox;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/title")
    public MobileElement blockOption;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_unblock_user")
    public MobileElement unblockButton;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/title']//following::android.widget.TextView")
    public MobileElement hideChatOption;

}
