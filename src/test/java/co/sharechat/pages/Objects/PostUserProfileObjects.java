package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for post user profile page objects
 * Version: 1.0
 */
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

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_username")
    public MobileElement postUserprofileDisplayName;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_share")
    public MobileElement videoPostShareIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_comment")
    public MobileElement videoPostCommentIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_repost")
    public MobileElement videoPostRepostIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_like")
    public MobileElement videoPostLikeIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_favourite")
    public MobileElement videoPostFavouriteIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/fab")
    public MobileElement videoPostAddFabIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/fabInside")
    public MobileElement videoPostAddFabInsideIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement postUserProfileFollowingButton;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_unfollow_text")
    public MobileElement postUserUnfollowingPopupQuestion;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_unfollow_yes")
    public MobileElement postUserUnfollowingPopupYes;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_unfollow_no")
    public MobileElement postUserUnfollowingPopupNo;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/toolbar']//android.widget.TextView")
    public MobileElement sharePostWithTitle;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_chat_send")
    public MobileElement sendButtonSharePostWithScreen;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_chat_goto")
    public MobileElement gotoIconSharePostWithScreen;
}