package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
/**
 * Created by TestingXperts Pvt Ltd.
 * @author: Ramesh
 * Reviewer: sheshanandan
 * Date: 07/04/2019
 * Purpose: This Class is for profile page objects
 * Version: 1.0
 */
public class ProfilePageObjects {
    @AndroidFindBy(xpath = "in.mohalla.sharechat:id/btn_profile_action")
    public MobileElement profileDetailsLabel;
}
