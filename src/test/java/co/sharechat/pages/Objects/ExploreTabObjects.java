package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Actions related to Explore Page Objects
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */

public class ExploreTabObjects {

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_explore")

    public static MobileElement exploreButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_search")

    public static MobileElement toolBarSearch;


    @AndroidFindBy(id = "in.mohalla.sharechat:id/search_src_text")

    public static MobileElement searchText;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_search_back")

    public static MobileElement backButton;

    @AndroidFindBys({@AndroidBy(id = "in.mohalla.sharechat:id/tv_viewholder_bucket_main")})


    public static List<MobileElement> allTiles;


}
