package appiumTests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobileUtils.MobileBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.CommonUtils;
import utils.DesiredCaps;
import utils.DriverInit;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YOUniverseAndroid extends MobileBasePage {


    private AndroidDriver driver;
    private List<String> listShifts= new ArrayList<String>();


    @Test
    public void Test123(){

        driver = new DriverInit().getAndroidDriverForEmulator();

        driver.launchApp();
        driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("sally.mills@ynvr.se");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("MargHerita");

        driver.hideKeyboard();

        try {
            driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();
            driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).click();

        }
        catch (Exception e){
            System.out.println("");
        }

           driver.findElement(By.xpath("//android.view.ViewGroup[@index='2']")).click();


          scrollAndPrintElements();
          scrollAndPrintElements();
          scrollAndPrintElements();


        System.out.println("Shifts Details");
        listShifts.forEach(System.out::println);


    }

    public void scrollAndPrintElements(){
        List<MobileElement> textViews = driver.findElements(By.xpath("//android.widget.ScrollView//android.widget.TextView"));

        for (MobileElement ele: textViews) {

            listShifts.add(ele.getText());
        }

        TouchAction touchAction = new TouchAction((MobileDriver)driver);


        touchAction.press(PointOption.point(350,1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(350,200))
                .release().perform();

    }


    @AfterTest
    public void StopAppiumServer(){

        try{
            driver.closeApp();
        }catch (Exception e){

        }


    }
}
