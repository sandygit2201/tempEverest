package mobileUtils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBasePage {

    private AppiumDriverLocalService appiumService ;

    private URL url=null;

    @BeforeTest
    public void startAppiumServerAndEmulator(){

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        System.out.println("Appium service Started");
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @AfterTest
    public void stopAppiumServerAndEmulator(){


    }




}
