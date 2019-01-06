package appiumTests;

import dataObjects.UserDTO;
import io.appium.java_client.android.AndroidDriver;
import mobileUtils.MobileBasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import MobileScreens.HomeScreen;
import MobileScreens.LoginScreen;
import MobileScreens.ShiftsScreen;
import utils.DriverInit;
import utils.UserDataReder;
import java.util.List;

public class YOUniverseAndroid extends MobileBasePage {


    private AndroidDriver driver;

    @Test
    public void Test123() {

        driver = new DriverInit().getAndroidDriverForEmulator();
        driver.launchApp();

        LoginScreen loginPage = new LoginScreen(driver);
        PageFactory.initElements(driver, loginPage);

        UserDTO user = new UserDataReder().getUser("sally");
        loginPage.loginToAPP(user);

        HomeScreen homePage = new HomeScreen(driver);
        PageFactory.initElements(driver, homePage);
        homePage.navigateTosShiftsView();

        ShiftsScreen shiftsScreen = new ShiftsScreen(driver);
        PageFactory.initElements(driver, shiftsScreen);

        List<String> listShiftsInfo = shiftsScreen.getShiftsInfo();

        for (String shift : listShiftsInfo)
            System.out.println(shift);

        driver.closeApp();

    }


}
