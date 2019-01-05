package appiumTests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class YOUniverseAndroid {

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
//        dcaps.setCapability("noreset","true");
//        dcaps.setCapability("fullreset","false");
        dcaps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        dcaps.setCapability("platformName", "Android");
        dcaps.setCapability("platformVersion", "9");
        dcaps.setCapability("appPackage","au.com.youniverse");
//        dcaps.setCapability("appActivity","au.com.youniverse");

        dcaps.setCapability("app","/Users/sandeep/Documents/Youniverse/mobileAutomaiton/src/test/resources/apkFiles/YOUniverse.apk");

       sleep(10);

        driver = new AndroidDriver(url,dcaps);
        driver.launchApp();


        sleep(5);

        driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("sally.mills@ynvr.se");

        sleep(2);
        driver.hideKeyboard();
        sleep(2);
        driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("MargHerita");

        sleep(2);
        driver.hideKeyboard();
        sleep(2);
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Sign in']")).click();

        try {
            driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();
            sleep(2);
            driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();
            sleep(2);
            driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();

            sleep(5);
        }
        catch (Exception e){
            System.out.println("");
        }
        sleep(5);

           driver.findElement(By.xpath("//android.view.ViewGroup[@index='2']")).click();

           sleep(2);

          scrollAndPrintElements();
          scrollAndPrintElements();
          scrollAndPrintElements();

    }

    public void scrollAndPrintElements(){
        List<MobileElement> textViews = driver.findElements(By.xpath("//android.widget.ScrollView//android.widget.TextView"));

        for (MobileElement ele: textViews) {

            System.out.println(ele.getText());
        }

        TouchAction touchAction = new TouchAction((MobileDriver)driver);


        touchAction.press(PointOption.point(350,1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(350,200))
                .release().perform();
        sleep(5);

    }

    public void sleep(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void StopAppiumServer(){

        sleep(30);

//        appiumService.stop();


    }
}
