package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCaps {

    public DesiredCapabilities getDCapsForEmulator(){

        DesiredCapabilities dcaps = DesiredCapabilities.android();
        dcaps.setCapability("browserName","");
        dcaps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        dcaps.setCapability("platformName", "Android");
        dcaps.setCapability("platformVersion", "9");
        dcaps.setCapability("appPackage","au.com.youniverse");
        dcaps.setCapability("app",new CommonUtils().getYOUnivereseAPKPath());

        return dcaps;
    }


}
