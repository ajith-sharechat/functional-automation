package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import java.util.List;


/**
 * This Class has all the Actions related to Login Page Objects
 *
 * @author Diljeet Singh
 * @version 1.0
 * @since 01 july 2019
 */
public class loginPageObjects {

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/select_title")

    public MobileElement selectTitle;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/tv_lang_name")
    public MobileElement languageBoxTab;

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


}
