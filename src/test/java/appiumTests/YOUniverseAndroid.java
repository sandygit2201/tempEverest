package appiumTests;

import MobileScreens.HomeScreen;
import MobileScreens.LoginScreen;
import MobileScreens.ShiftsScreen;
import dataObjects.UserDTO;
import io.appium.java_client.android.AndroidDriver;
import mobileUtils.MobileBasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.DriverInit;
import utils.ShiftsUtils;
import utils.UserDataReder;

public class YOUniverseAndroid extends MobileBasePage {


    private AndroidDriver driver;
    private ShiftsUtils shiftsUtils = new ShiftsUtils();

    @Test
    public void getShifts() {

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

        shiftsUtils.printShiftDetails(shiftsScreen.getShiftsInfo());

        driver.closeApp();

    }


}
