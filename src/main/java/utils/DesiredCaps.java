package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCaps {

    private DesiredCapabilities dcaps;

    public DesiredCapabilities getDCapsForEmulator(String androidVersion) {

        dcaps = DesiredCapabilities.android();
        dcaps.setCapability("browserName", "");
        dcaps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        dcaps.setCapability("platformName", "Android");
        dcaps.setCapability("platformVersion", androidVersion);
        dcaps.setCapability("appPackage", "au.com.youniverse");
        dcaps.setCapability("app", new CommonUtils().getYOUnivereseAPKPath());

        return dcaps;
    }


}
