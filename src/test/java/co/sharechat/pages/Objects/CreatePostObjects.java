package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class CreatePostObjects {



	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
	public MobileElement plusIcon;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_next_ib ")
	public MobileElement tickIconTextCompose;

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

	@AndroidFindBy(xpath = "in.mohalla.sharechat:id/tv_create_profile")
	public MobileElement profileSubmitButton;

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

	@AndroidFindBy(id = "in.mohalla.sharechat:id/composeimage_withoutbg_cv")
	public MobileElement withoutBGBtn;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/item_bgimage_iv")
	public List<MobileElement> camerBtnOnTextPost;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/crop_image_menu_crop")
	public MobileElement cropOkBtnOnCamera;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".className(\"android.widget.ListView\")).scrollIntoView("
			+ "new UiSelector().textContains(\"India\"));")
	public MobileElement INDIACountryCode;


}
