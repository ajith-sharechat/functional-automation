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

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/et_message']//" +
            "preceding::android.widget.TextView[@resource-id='in.mohalla.sharechat:id/tv_message'][1]")
    public MobileElement recentMessageInChatBox;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_profile_status")
    public MobileElement postBioProfileStatusLabel;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_post_caption']")
    public MobileElement postHashTagLink;

    @AndroidFindBy(xpath = "//*[contains(@text,'#')]")
    public MobileElement postTagLink;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_post_profile")
    public MobileElement postUserProfielPic;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_create_stickers")
    public MobileElement createStickersIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_share_dm")
    public MobileElement shareButtonInPostPreview;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/rl_comment_container")
    public MobileElement commentTextfield;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement TagFeedTitle;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/cl_post_bottom_counters']//android.widget.ImageView")
    public MobileElement whatsAppIconInPost;

//    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/cl_post_bottom_counters']//following::android.widget.ImageView")
    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/cl_post_bottom_counters']//following::android.widget.ImageView[1]")
    public MobileElement commentIconInPost;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/cl_post_bottom_counters']//following::android.widget.ImageView[4]")
    public MobileElement rePostIconInPost;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/compose_back_iv']//following::android.widget.TextView")
    public MobileElement createPostLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_post_tick")
    public MobileElement postRightIcon;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/iv_post_tick']//following::android.widget.TextView")
    public MobileElement postButtonLabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/et_compose_text")
    public MobileElement createPostTextField;

    @AndroidFindBy(xpath ="//*[@resource-id='in.mohalla.sharechat:id/layout_exo_actions']//android.widget.ImageView")
    public MobileElement whatsAppIconInVideoPost;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/btn_post_audio")
    public MobileElement playMusicButtonOrPauseButtonForAudioPosts;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_post_audio_disc")
    public MobileElement postAudioDiscIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/exo_overlay")
    public MobileElement audioOverLay;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/exo_progress")
    public MobileElement audioExoProgress;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/player_view_post_gif")
    public MobileElement gifPost;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/exo_subtitles")
    public MobileElement gifPostFrameViewLayout;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_post_gif_button")
    public MobileElement gifButtonInPost;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/search_src_text")
    public MobileElement searchTextFieldInCreatePost;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_tag_name")
    public MobileElement bucketFeedFirstTag;
}