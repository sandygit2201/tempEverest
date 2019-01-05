package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {

    private AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//android.view.ViewGroup[@index='2']")
    private WebElement navElementSchedule;



    public void ScrollToBottom() {
        TouchAction touchAction = new TouchAction((MobileDriver) driver);
        touchAction.press(PointOption.point(350, 1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(350, 200))
                .release().perform();
    }

    public void navigateTosShiftsView(){
        navElementSchedule.click();
    }



}
