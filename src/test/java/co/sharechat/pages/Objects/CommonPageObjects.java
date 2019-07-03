package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CommonPageObjects {

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowPermissionPopUp;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement denyPermissionPopUp;

    @AndroidFindBy(xpath = "//*[@text='ಶೇರ್ ಚಾಟ್']")
    public MobileElement shareChatTextInKannada;

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/et_phone")
    public MobileElement et_Phone;

    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/tv_get_otp")
    public MobileElement tv_get_otp;

}
