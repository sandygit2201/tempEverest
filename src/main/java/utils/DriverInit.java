package utils;

import io.appium.java_client.android.AndroidDriver;
import mobile.utils.MobileBasePage;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    private AndroidDriver driver;
    private DesiredCaps dcaps;

    public AndroidDriver getAndroidDriverForEmulator(String androidVersion) {

        dcaps = new DesiredCaps();
        driver = new AndroidDriver(MobileBasePage.url, dcaps.getDCapsForEmulator(androidVersion));
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        return driver;
    }
}
