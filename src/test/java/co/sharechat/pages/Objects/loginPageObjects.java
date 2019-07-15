package co.sharechat.pages.Objects;

import com.sun.tools.javac.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

public class loginPageObjects {

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/select_title")
    public MobileElement selectTitle;

    @AndroidFindBy(xpath = "//*[@text='ಕನ್ನಡ']")
    public MobileElement selectKannada;

    @AndroidFindBy(xpath = "//*[@text='ಶೇರ್ ಚಾಟ್']")
    public MobileElement shareChatTextInKannada;

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/et_phone")
    public MobileElement et_Phone;

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/tv_get_otp")
    public MobileElement tv_get_otp;

    @AndroidFindBys({@AndroidBy(className = "android.widget.EditText")})
    public List<MobileElement> OTPValues;

}
