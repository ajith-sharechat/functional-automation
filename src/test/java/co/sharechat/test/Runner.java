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
            tests.add("SocialTests");

            parallelThread.runner("co.sharechat.test", tests);
        }
        catch(Exception e4)
        {
            System.out.println(e4);
        }
    }

}
