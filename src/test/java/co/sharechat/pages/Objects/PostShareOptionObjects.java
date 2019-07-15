package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Objects related to Post option page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 12 july 2019
 */
public class PostShareOptionObjects {

    //TC_168
    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_post_options")

    public MobileElement postOptionClick;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/sharing_bs_appicon_iv")

    public MobileElement whatsAppClick;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public MobileElement Toast;

    //TC_173
    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/sharing_bs_appicon_iv")})

    public List<MobileElement> convertSticker6;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/ImageView_image")

    public MobileElement verifyStickerConvertScreen;
//TC_174

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/sharing_bs_appname_tv")})

    public List<MobileElement> selectMsg7;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/toolbar")

    public MobileElement verifyMsgScreen;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/btn_chat_send")

    public MobileElement verifyChatSend;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_chat_goto")

    public MobileElement verifyGoToChat;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_message")

    public MobileElement chatMsg;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")

    public MobileElement imagePostCheck;

//TC_175

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/sharing_bs_appicon_iv")})

    public List<MobileElement> selectFollow8;

    //TC_176
    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/sharing_bs_appicon_iv")})

    public List<MobileElement> selectReport;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/rb_report1")

    public MobileElement chooseOption;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_report_submit")

    public MobileElement submitReport;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_report_title")

    public MobileElement reportTitle;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_image")
    public MobileElement imagePost;


}
