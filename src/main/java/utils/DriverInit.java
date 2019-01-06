package utils;

import io.appium.java_client.android.AndroidDriver;
import mobileUtils.MobileBasePage;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    private AndroidDriver driver;
    private DesiredCaps dcaps;

    public AndroidDriver getAndroidDriverForEmulator() {

        dcaps = new DesiredCaps();
        driver = new AndroidDriver(MobileBasePage.url, dcaps.getDCapsForEmulator());
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        return driver;
    }
}
