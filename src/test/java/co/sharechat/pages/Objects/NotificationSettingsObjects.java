package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * @reviewer sheshanandan
 * @since 22-July-2019
 * @purpose This Class is for notification setting page objects
 * @version 1.0
 */
public class NotificationSettingsObjects {
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/toolbar_notification']//android.widget.TextView")
    public MobileElement notificationSettingTitle;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_notif_follow")
    public MobileElement notificationFollowIcon;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/ic_notif_follow']//following::android.widget.TextView")
    public MobileElement followNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_follow_notif")
    public MobileElement followNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_notif_post_like")
    public MobileElement notificationLikeIcon;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/ic_notif_post_like']//following::android.widget.TextView")
    public MobileElement notificationLikeLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_like_notif")
    public MobileElement likeNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_notif_share")
    public MobileElement notificationShareIcon;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/ic_notif_share']//following::android.widget.TextView")
    public MobileElement shareNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_share_notif")
    public MobileElement shareNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_notif_comment")
    public MobileElement notificationCommentIcon;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/ic_notif_comment']//following::android.widget.TextView")
    public MobileElement commentNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_comment_notif")
    public MobileElement commentNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_notif_feed")
    public MobileElement feedNotificationIcon;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/ic_notif_feed']//following::android.widget.TextView")
    public MobileElement feedNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_feed_notif")
    public MobileElement feedNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_dm_feed")
    public MobileElement chatNotificationIcon;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/ic_dm_feed']//following::android.widget.TextView")
    public MobileElement chatNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_dm_notif")
    public MobileElement chatNotificationSwitchButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ic_repost")
    public MobileElement repostNotificationIcon;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/ic_repost']//following::android.widget.TextView")
    public MobileElement repostNotificationLabel;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/sc_repost_notif")
    public MobileElement repostNotificationSwitchButton;
}