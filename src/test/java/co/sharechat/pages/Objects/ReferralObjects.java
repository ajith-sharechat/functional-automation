package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


/**
 This Class has all the objects related to the Referral Screen and the screen after Referral screen
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class ReferralObjects {

	@AndroidFindBy(id = "in.mohalla.sharechat:id/rl_toolbar_referrals")
	public MobileElement referralBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_back")
	public MobileElement referralBackBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_my_earnings")
	public MobileElement myEarningsBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_earn_text")
	public MobileElement textForReferral;

	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/crsv_link_share']//*[@resource-id = 'in.mohalla.sharechat:id/tv_custom_referral_header']")//[contains(@text,'इंस्टॉल करवाएँ और कमाएँ')]
	public MobileElement getinstallEarnBtn;

	//*[contains(@text,'मेरा QR कोड प्रिंट करें')]
	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/crsv_qr_share']//*[@resource-id = 'in.mohalla.sharechat:id/tv_custom_referral_header']")
	public MobileElement printMyQRCodeBtn;

	//*[contains(@text,'सेटअप पेमेंट')]
	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/crsv_payment_setup']//*[@resource-id = 'in.mohalla.sharechat:id/tv_custom_referral_header']")
	public MobileElement setupPaymentBtn;

	@AndroidFindBy(xpath = "//*[contains(@text,'शेयरचैट पर अपने दोस्तों को लाए और पैसे कमाने के विभिन्न स्तरों को पूरा करें।')]")
	public MobileElement getinstallEarnText;

	@AndroidFindBy(xpath = "//*[contains(@text,'अपने QR कोड का उपयोग करके इंस्टॉल करें और प्रति इंस्टॉल ₹15 रुपये कमाएँ')]")
	public MobileElement printMyQRCodeText;

	@AndroidFindBy(xpath = "//*[contains(@text,'अपना PayTM मोबाइल नम्बर डालें')]")
	public MobileElement setupPaymentText;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/crsv_link_share")
	public MobileElement getinstallEarnBox;

	//=================My Earning Screen Object ==============

	@AndroidFindBy(id = "in.mohalla.sharechat:id/ib_back")
	public MobileElement myEarningBackBtn;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_total_amount")
	public MobileElement totalEarningsAmount;

	//=================Setup Payment Screen Object ==============

	@AndroidFindBy(id = "in.mohalla.sharechat:id/et_phone")
	public MobileElement setupPaymentMobileNoField;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_submit")
	public MobileElement submitPayTMtMobileNo;

	//*[contains(@text,'नंबर वेरिफिकेशन हो रहा है')]
	@AndroidFindBy(xpath = "//*[@resource-id='in.mohalla.sharechat:id/crsv_payment_setup']//*[@resource-id = 'in.mohalla.sharechat:id/tv_custom_referral']")
	public MobileElement verificationInProgressText;



	@AndroidFindBy(className = "android.widget.EditText")
	public MobileElement writeTextInCreateTextPost;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".className(\"android.widget.ListView\")).scrollIntoView("
			+ "new UiSelector().textContains(\"India\"));")
	public MobileElement INDIACountryCode;

}
