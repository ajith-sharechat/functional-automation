package co.sharechat.pages.Objects;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SignUpPageObjects {
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/select_title")
	public MobileElement selectLangText;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_lang_name")
	public MobileElement selectLangBoxes;
	
	@AndroidFindBy(xpath = "//*[@text='हिन्दी']")
	public MobileElement hindiBox;

	@AndroidFindBy(xpath = "//*[@text='తెలుగు']")
	public MobileElement teluguBox;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_name")
	public MobileElement loginNameBox;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_phone")
	public MobileElement loginPhBox;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/rb_male")
	public MobileElement loginGenderBtn;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/rb_age_range2")
	public MobileElement loginAgeGrpBtn;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_submit")
	public MobileElement loginSubmitBtn;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_toolbar_title")
	public MobileElement langDDL;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_country_code")
	public MobileElement countryCodeDDL;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_otp")
	public MobileElement OTPtextbox;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/pin_view']//following::android.widget.EditText")
	public MobileElement OTPtextfield1;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/pin_view']//android.widget.EditText")
	public MobileElement OTPtextfield;
	
	@AndroidFindBy(id = "in.mohalla.sharechat:id/bt_submit")
	public MobileElement submitOTP;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public MobileElement allowPermissionPopUp;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_get_otp")
	public MobileElement getOTPButton;

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public MobileElement allowButton;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".className(\"android.widget.ListView\")).scrollIntoView("
			+ "new UiSelector().textContains(\"India\"));")
	public MobileElement INDIACountryCode;




}
