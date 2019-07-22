package co.sharechat.pages.Objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

/**
 * This Class has all the Objects related to Comment Post Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 18 july 2019
 */
public class CommentPostObjects {

    //TC_211
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")
    public MobileElement imagePost;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/image_view")

    public static List<MobileElement> commentPostButton1;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/text_view")})


    public static List<MobileElement> commentCount;


    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/ll_comment_content")})
    public static List<MobileElement> verifyCommentScreen;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_comment")
    public MobileElement typeComment;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_comment_send")
    public MobileElement commentSend;

    @AndroidFindBy(id = " in.mohalla.sharechat:id/tv_comment_state")
    public MobileElement scrollPoint;

    //TC_214

    @AndroidFindBy(id = "in.mohalla.sharechat:id/image_view")
    public List<MobileElement> likeButton1;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/text_comment_like")
    public List<MobileElement> likeCount1;

    //TC_217

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_back")
    public MobileElement toolbarBack;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/image_view")
    public static List<MobileElement> rePostButton3;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_tick")
    public MobileElement doPost;
    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/text_view")})
    public static List<MobileElement> rePostCount3;

}
