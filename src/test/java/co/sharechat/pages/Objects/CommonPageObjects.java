package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 This Class has all the objects related to the android popups or alerts
 @author jasmeetsingh
 @version 1.0
 @since 01 july 2019
 */
public class CommonPageObjects {

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public MobileElement allowPermissionPopUp;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public MobileElement denyPermissionPopUp;

    @AndroidFindBy(id = "android:id/message")
    public MobileElement alertaMessageText;

    @AndroidFindBy(id = "android:id/button2")
    public MobileElement alertDismissBtn;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement alertAcceptBtn;

    @AndroidFindBy(id = "in.mohalla.sharechat:id/snackbar_text")
    public MobileElement alertGeneratedByApplication;


}
