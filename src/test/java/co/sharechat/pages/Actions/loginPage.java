package co.sharechat.pages.Actions;

import co.sharechat.config.DeviceHelper;
import co.sharechat.config.DeviceInterface;
import co.sharechat.config.WebDriverListener;
import co.sharechat.pages.Objects.loginPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginPage extends WebDriverListener {
    DeviceInterface runnerInfo;
    DeviceHelper deviceHelper;
    WebDriver driver;
    WebDriverListener webDriverListener = new WebDriverListener();
    co.sharechat.pages.Objects.loginPageObjects loginPageObjects = new loginPageObjects();
    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/ExtentReport.html");
    ExtentReports extent = new ExtentReports();



    public loginPage(WebDriver driver, DeviceInterface runnerInfo) {

        this.driver = driver;
        deviceHelper = new DeviceHelper(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObjects);
        this.runnerInfo = runnerInfo;
    }

    public void userlogin() throws Exception {

        try {
            extent.attachReporter(reporter);
            ExtentTest logger=extent.createTest("CustomerLogin");
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            //loginPageObjects.selectKannada.click();
            //Assert.assertEquals("ಶೇರ್ ಚಾಟ್", loginPageObjects.shareChatTextInKannada.getText());
            //((AppiumDriver <MobileElement>)driver).hideKeyboard();
            //Assert.assertEquals(loginPageObjects.et_Phone.getText(), "ಮೊಬೈಲ್ ನಂಬರ್");
            System.out.println("Edit Phone number text box found in ಕನ್ನಡ");
            //Assert.assertEquals(loginPageObjects.tv_get_otp.getText(), "ಅಕೌಂಟ್ ಗೆ ಹೋಗಲು");
            // Flush method will write the test in report- This is mandatory step
            //extent.flush();

        }
        catch (Exception e) {

            logger.log(Status.FAIL, "Failed on Customer login");
            webDriverListener.captureScreenShot("loginPage","loginPage");
            Assert.assertTrue(false,e.getMessage());

            // Flush method will write the test in report- This is mandatory step
            extent.flush();

        }
    }

    public loginPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}

