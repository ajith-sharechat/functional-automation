package co.sharechat.test;

import com.appium.manager.ParallelThread;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    @Test
    public void testApplication() throws Exception {

        try {
            ParallelThread parallelThread = new ParallelThread();

            List<String> tests = new ArrayList<>();
//            tests.add("CheckAppInstallAndUninstallTest");
//            tests.add("LoginPageTest");
//            tests.add("ExploreTabTest");
//            tests.add("ProfilePageTest");
//            tests.add("TrendingTabTest");
            tests.add("HomeScreenTest");
//            tests.add("StickerFunctionalityTest");
//            tests.add("LandingPageTest");
//            tests.add("LoginPageTest");
//            tests.add("StickerPicturePostTest");
//            tests.add("PostShareOptionTest");
//            tests.add("TrendingPostUserProfileTest");

            parallelThread.runner("co.sharechat.test", tests);

        } catch (Exception e4) {
            System.out.println(e4);
        }
    }

}
