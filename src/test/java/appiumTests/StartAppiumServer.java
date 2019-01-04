package appiumTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class StartAppiumServer {

    AppiumDriverLocalService appiumService ;


    @BeforeTest
    public void startAppiumServer(){

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
    }

    @Test
    public void Test123(){

        System.out.println("Appium service Started");

        DesiredCapabilities dcaps = DesiredCapabilities.iphone();
        dcaps.setPlatform(Platform.IOS);
        dcaps.setAcceptInsecureCerts(true);
        dcaps.setJavascriptEnabled(true);
        dcaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        dcaps.setCapability(   MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dcaps.setCapability(IOSMobileCapabilityType.APP_NAME , "youniversemobileapp");
        dcaps.setCapability("appPackage","org.reactjs.native.example.youniversemobileapp");

        URL url=null;
        try {
            url = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        IOSDriver driver = new IOSDriver(url,dcaps);
        driver.launchApp();
    }

    @AfterTest
    public void StopAppiumServer(){

        appiumService.start();


    }
}
