package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import java.util.List;


/**
 * This Class has all the Objects related to Login Page
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class loginPageObjects {

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_create_profile")

    public MobileElement createPFClick;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_submit")

    public MobileElement createSubmit;

    @AndroidFindBy(xpath = "//*[@text='हिन्दी']")
    public MobileElement selectHindi;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_name")
    public MobileElement enterName;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/et_phone")
    public MobileElement enterNumber;
    @AndroidFindBy(id = "in.mohalla.sharechat:id/rb_male")
    public MobileElement selectRadioButton;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_get_otp")
    public MobileElement goToYourAccount;

    @AndroidFindBy(xpath = "//*[@text='ALLOW']")
    public MobileElement allow;

    @AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
    public List<MobileElement> OTPValues;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/rb_age_range2")

    public MobileElement ageRange;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_feed")

    public MobileElement verifySuccessfullCreation;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_terms_policy")

    public MobileElement termPolicy;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/current_url")


    public MobileElement currentUrl;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/action_share")


    public MobileElement policyShare;


    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public MobileElement Toast;
}
