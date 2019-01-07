package mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class ShiftsScreen extends HomeScreen {

    private AndroidDriver driver;
    private List<String> listShifts = new ArrayList<String>();

    @FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView")
    private List<WebElement> eleSchedule;

    public ShiftsScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public List<String> getShiftsInfo() {
        scrollAndGetShifts();
        ScrollToBottom();
        scrollAndGetShifts();

        return listShifts;
    }

    public void scrollAndGetShifts() {

        for (WebElement ele : eleSchedule)
            listShifts.add(ele.getText());

    }

}
