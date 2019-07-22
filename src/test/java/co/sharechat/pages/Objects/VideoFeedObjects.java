package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * This Class has all the Objects related to Video Feed Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 19 july 2019
 */

public class VideoFeedObjects {

    //TC-225
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_image")

    public static List<MobileElement> videoTab2;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_video_thumb")

    public static List<MobileElement> chooseAnyVideo0;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/exo_pause")

    public static MobileElement pauseButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_video_prev")

    public static MobileElement previousButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_video_next")

    public static MobileElement nextButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/exo_subtitles")

    public static MobileElement subTitle;

    //TC230

    @AndroidFindBy(id = "in.mohalla.sharechat:id/image_view")

    public static List<MobileElement> videoCommentButton1;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/text_view")

    public static List<MobileElement> videoLikesCountButton2;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_comment")

    public static MobileElement typeComment;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_comment_send")

    public static MobileElement sendComment;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_comment")

    public static List<MobileElement> videoCommentPosition0;

    //TC_233
    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_error")
    public static MobileElement loadError;
   //TC_236

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_tick")
    public static MobileElement doPost;


}
