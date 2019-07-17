package co.sharechat.pages.Objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 This Class has all the objects related to the Home Screen
 @author jasmeetsingh
 @version 1.0
 @since 11 july 2019
 */
public class HomePageObjects extends CommonPageObjects {


	@AndroidFindBy(id = "in.mohalla.sharechat:id/iv_home_compose")
	public MobileElement plusIcon;

	@AndroidFindBy(id = "in.mohalla.sharechat:id/tv_home_explore")
	public MobileElement exploreBTN;




}
