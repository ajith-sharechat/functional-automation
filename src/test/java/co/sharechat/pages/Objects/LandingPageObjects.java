package co.sharechat.pages.Objects;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;

/**
 * This Class has all the Objects related to Landing Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 09 july 2019
 */
public class LandingPageObjects {

    //TC_005
    @AndroidFindBy(id = "in.mohalla.sharechat:id/select_title")

    public MobileElement select_lang_text;

    @AndroidFindBys
            ({@AndroidBy(id = "in.mohalla.sharechat:id/tv_lang_name")})

    public List<MobileElement> select_lang_boxes;



}
