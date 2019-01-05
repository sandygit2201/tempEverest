package utils;

import io.appium.java_client.android.AndroidDriver;
import mobileUtils.MobileBasePage;
import org.aspectj.weaver.ast.And;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    public AndroidDriver driver;

    public AndroidDriver getAndroidDriverForEmulator(){

        DesiredCaps dcaps = new DesiredCaps();

        driver = new AndroidDriver(MobileBasePage.url,dcaps.getDCapsForEmulator());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

        return driver;
    }
}
