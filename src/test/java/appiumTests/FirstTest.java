package appiumTests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    @Test
    public void LaunchApp(){

        String appPath= "youniversemobileapp.app";
        File applicaitonPath = new File(appPath);

        DesiredCapabilities dcaps = DesiredCapabilities.iphone();
        dcaps.acceptInsecureCerts();
        dcaps.setJavascriptEnabled(true);
        dcaps.setPlatform(Platform.IOS);

        dcaps.setCapability( MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        dcaps.setVersion("12.1");
        dcaps.setCapability(   MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dcaps.setCapability(IOSMobileCapabilityType.APP_NAME , "youniversemobileapp");
//        dcaps.setCapability(MobileCapabilityType.APP,applicaitonPath);
        dcaps.setCapability("appPackage","org.reactjs.native.example.youniversemobileapp");



//        org.reactjs.native.example.youniversemobileapp

        URL url=null;
        try {
            url = new URL("http://localhost:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        IOSDriver driver = new IOSDriver(url,dcaps);

        driver.launchApp();



    }
}
