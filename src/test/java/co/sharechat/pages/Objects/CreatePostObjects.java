package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 This Class has all the objects related to the create Pots(Text/Camera/Upload/Poll)
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class CreatePostObjects extends CommonPageObjects {

	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
	public MobileElement plusIcon;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_explore")
	public MobileElement exploreBTN;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_viewholder_bucket_main")
	public List<MobileElement> bucktNamesOnExplorePage;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_compose_text")
	public MobileElement writeSomethingAbtPost;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_tick")
	public MobileElement tickIconCreatePost;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/search_src_text")
	public MobileElement searchTagTextBox;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/bt_create_tag")
	public MobileElement createTagBTN;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/search_close_btn")
	public MobileElement submitNewTagBTN;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/rb_bucket_select")
	public List<MobileElement> newTagBucketsRadioBtns;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_tag_name")
	public MobileElement tagsToSelect;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_tag_name")
	public List<MobileElement> tagsListToSelect;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ll_compose_text_post")
	public MobileElement createText;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'अपलोड हो र')]")
	public MobileElement uploadMsgAlert;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement writeTextInCreateTextPost;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/bt_compose_tag")
	public MobileElement addTagBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/bt_add_friends")
	public MobileElement addFriendsBTN;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_user_name")
	public List<MobileElement> nameOfFriends;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/contact_tabs']//android.widget.TextView")
	public List<MobileElement> friendlistTabs;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ll_link_type_preview")
	public MobileElement linkPreview;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ll_root_repost")
	public MobileElement repostPreview;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ib_post_options")
	public MobileElement postOptionsBTN;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/sharing_bs_appname_tv")
	public List<MobileElement> postShareOptions;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_post_profile")
	public List<MobileElement> userProfilelinkOnPostsScreen;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_item_explore_trending_v2")
	public List<MobileElement> trendingTagsOnTrendingScreen;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ib_toolbar_options")
	public MobileElement shareBTnOnTagRelatedPostsScreen;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/menu_share")
	public MobileElement shareBTnOnUsersProfileScreen;

	@AndroidFindBy(xpath = "//*[@resource-id='android:id/text1'][@text='ShareChat']")
	public MobileElement shareWithShareChatOption;

	//Text post objects

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_next_ib")
	public MobileElement tickIconTextCompose;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_back_ib")
	public MobileElement crossIconTextCompose;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_textbold_ib")
	public MobileElement textBoldBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_textcolor_previewview")
	public MobileElement fontColorBtn;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/item_textcolor_iv']")
	public List<MobileElement> fontColorOptions;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_texthighlight_previewview")
	public MobileElement fontBGColorBtn;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/composeimage_textcreaterview']/android.widget.EditText")
	public MobileElement writeTextTextField;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_withoutbg_cv")
	public MobileElement withoutBGBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/item_bgimage_iv")
	public List<MobileElement> cameraBtnOnTextPost;

	@AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab")
	public List<MobileElement> bottomTabsinTextPost;//content-desc

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".className(\"androidx.appcompat.app.ActionBar$Tab\")).setAsHorizontalList();")
	public List<MobileElement> tabs;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/crop_image_menu_crop")
	public MobileElement cropOkBtnOnCamera;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_bucket_name")
	public List<MobileElement> bucketNames;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".resourceId(\"in.mohalla.sharechat:id/composeimage_categories_tablayout\")).setAsHorizontalList().scrollIntoView("
			+ "new UiSelector().descriptionContains(\"रंग\"));")
	public MobileElement selectColor;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".resourceId(\"in.mohalla.sharechat:id/composeimage_categories_tablayout\")).setAsHorizontalList().scrollIntoView("
			+ "new UiSelector().descriptionContains(\"शेयरचैट साहित्य\"));")
	public MobileElement selectShareChatCulture;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/item_bgimage_iv")
	public List<MobileElement> BGcolorTabs;

	//===================

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_open_camera")
	public MobileElement slectCameraPost;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/camera_takepicture_iv")
	public MobileElement clickPicBtn;

	//===================

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ll_upload_gallery")
	public MobileElement uploadFromGalaryBtn;

	//===================

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_compose_poll")//
	public MobileElement createPoll;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/option_text")
	public List<MobileElement> pollOptions;

	//===================

	@AndroidFindBy(xpath = "//*[contains(@text,'अपलोड हो चुका है')]")
	public MobileElement uploadedNotification;


}
