package appiumTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAndroid {

    private AppiumDriverLocalService appiumService ;
    private AndroidDriver driver;
    private URL url=null;


    @BeforeTest
    public void startAppiumServer(){
//        appiumService = AppiumDriverLocalService.buildDefaultService();
//        appiumService.start();
        System.out.println("Appium service Started");
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test123(){


        DesiredCapabilities dcaps = DesiredCapabilities.android();
        dcaps.setCapability("browserName","");
        dcaps.setCapability("noreset","true");
        dcaps.setCapability("fullreset","false");
        dcaps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        dcaps.setCapability("platformName", "Android");
        dcaps.setCapability("platformVersion", "9");
        dcaps.setCapability("appPackage","com.android.chrome");
        dcaps.setCapability("appActivity","com.google.android.apps.chrome.Main");

//        dcaps.setCapability(MobileCapabilityType.VERSION,"9.0");


        driver = new AndroidDriver(url,dcaps);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("everest engineering");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @AfterTest
    public void StopAppiumServer(){

        appiumService.stop();


    }
}
