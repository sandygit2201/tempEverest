package mobile.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import mobile.LaunchAVDs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBasePage {

    private AppiumDriverLocalService appiumService;

    public static URL url = null;
    private LaunchAVDs launchAVDs = new LaunchAVDs();


    @BeforeSuite
    public void startAppiumServerAndEmulator() {

        launchAVDs.startAndroidEmulators();

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        System.out.println("Appium service Started");
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterSuite
    public void stopAppiumServerAndEmulator() {

        appiumService.stop();
        launchAVDs.stopAndroidEmulators();

    }


}
