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

	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_compose_text")
	public MobileElement writeSomethingAbtPost;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_post_tick")
	public MobileElement tickIconCreatePost;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_tag_name")
	public MobileElement tagsToSelect;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ll_compose_text_post")
	public MobileElement createText;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'अपलोड हो र')]")
	public MobileElement uploadMsgAlert;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement writeTextInCreateTextPost;


	//Text post objects

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_next_ib")
	public MobileElement tickIconTextCompose;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_back_ib")
	public MobileElement crossIconTextCompose;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_textbold_ib")
	public MobileElement textBoldBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_textcolor_previewview")
	public MobileElement fontColorBtn;

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
