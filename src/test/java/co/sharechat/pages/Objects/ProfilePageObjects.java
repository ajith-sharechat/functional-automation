package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePageObjects {
    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement profileDetailsLabel;
}
