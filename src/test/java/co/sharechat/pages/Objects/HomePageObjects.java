package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for home page objects
 * Version: 1.0
 */
public class HomePageObjects {

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_feed")
    public MobileElement homeIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_explore")
    public MobileElement searchIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
    public MobileElement composeIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_chat")
    public MobileElement chatIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_profile")
    public MobileElement profileIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tabLayout")
    public MobileElement headerMenuBar;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
    public MobileElement languageTitle;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_notification")
    public MobileElement notificationIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
    public MobileElement rupeeIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_profile")
    public MobileElement userProfileLink;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")
    public MobileElement postImage;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_comment")
    public MobileElement postCommentIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_comment_send")
    public MobileElement postCommentSendIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_post_video_play")
    public MobileElement postVideoPlayIcon;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_post_image_download")
    public MobileElement postImageDownloadIcon;

}
