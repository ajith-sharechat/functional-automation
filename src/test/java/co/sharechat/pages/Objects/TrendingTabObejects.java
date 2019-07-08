package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Actions related to Trending Page Objects
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 08 july 2019
 */


public class TrendingTabObejects {

    //TC-147
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_item_explore_trending_v2")

    public static List<MobileElement> allTags;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")

    public static MobileElement tagDetailTitle;


    //TC-148

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_back")

    public static MobileElement backButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_search")

    public static MobileElement search;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_options")

    public static MobileElement share;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_trending")

    public static MobileElement trending;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_fresh")

    public static MobileElement fresh;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_video")

    public static MobileElement video;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_image")

    public static MobileElement image;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_profiles")

    public static MobileElement profile;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_audio")

    public static MobileElement audio;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_gif")

    public static MobileElement gif;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_tag_text")

    public static MobileElement textButton;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")

    public static MobileElement checkPost;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/fab_compose_tag")

    public static MobileElement composeButton;

    @AndroidBy(id = "in.mohalla.sharechat:id/recyclerview_tag_related")

    public static MobileElement relatedTags;


    //TC-149

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")

    public static MobileElement clickPost;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_thumb_preview")

    public static MobileElement thumbnailPost;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_back")

    public static MobileElement postBackClick;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_share_dm")

    public static MobileElement postShare;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_create_stickers")

    public static MobileElement stickerCheck;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_options")

    public static MobileElement optionCheck;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ll_post_follow")

    public static MobileElement followButton;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_profile")

    public static MobileElement pfImage;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_profile")

    public static MobileElement pfName;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_profile_status")

    public static MobileElement pfStatus;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_view_v2")

    public static MobileElement postTotalView;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_caption")

    public static MobileElement postCaption;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_created_v2")

    public static MobileElement postCreatedTime;


    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/text_view_name")})

    public static List<MobileElement> whatsapp_Save_Comments_Like_Repost;

    @AndroidFindBys
            ({@AndroidBy(className = "androidx.appcompat.app.ActionBar$Tab")})

    public static List<MobileElement> commentAndLike;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_comment")

    public static MobileElement commentField;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_comment_send")

    public static MobileElement commentSend;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_reply_mic")

    public static MobileElement audioMic;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_gif_button")

    public static MobileElement gifImg;

}