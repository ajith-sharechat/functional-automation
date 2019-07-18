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
//            tests.add("launchAppTest");
//            tests.add("CreatePostTests");
//            tests.add("TC001_verifyChatScreenFunctionality");
            tests.add("TC002_verifyChatInitiatingFunctionalityNormalUser");
//            tests.add("TC005_verifyUserRowFunctionality");
//            tests.add("TC007_verifyTextMessageFunctionality");
//            tests.add("TC008_verifyAudioRecordingFunctionality");
//            tests.add("TC011_verifyBlockUserFunctionality");
//            tests.add("SocialTests");
            parallelThread.runner("co.sharechat.test.SocialTestcases", tests);
//            parallelThread.runner("co.sharechat.test", tests);
        }
        catch(Exception e4)
        {
            System.out.println(e4);
        }
    }

}
