package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/08/2019
 * Purpose: This Class is for chat page objects
 * Version: 1.0
 */
public class CommetsPageObjects {
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_comment_state")
    public MobileElement trendTagIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_user_name")
    public MobileElement commentUserProfileName;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_user_image")
    public MobileElement commentUserProfileImage;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_timestamp")
    public MobileElement commentUserTimeStamp;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_comment_reply_count")
    public MobileElement commentUserReplyIconAndCount;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/image_view")
    public MobileElement commentUserLikeIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/ib_reply_mic")
    public MobileElement commentPageAudioRecordIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/iv_comment_send")
    public MobileElement commentPageSendCommentIcon;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_no_comment")
    public MobileElement noCommentlabel;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/lt_chat_empty")
    public MobileElement noCommentImage;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_post_caption']" +
            "//following::android.widget.TextView//following::android.widget.TextView")
    public MobileElement commentPreviewLikeSection;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tv_post_caption']" +
            "//following::android.widget.TextView")
    public MobileElement commentPreviewCommentSection;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_user_follow")
    public MobileElement commentPreviewUserFollowLink;

    @AndroidFindBy(id ="in.mohalla.sharechat:id/tv_user_unfollow")
    public MobileElement commentPreviewUserUnfollowLink;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tablayout_post']//androidx.appcompat.app.ActionBar.Tab")
    public MobileElement commentSection;

    @AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/tablayout_post']//following::androidx.appcompat.app.ActionBar.Tab")
    public MobileElement likeSection;

}
