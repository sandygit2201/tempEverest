package appiumTests;

import dataStore.UserDTO;
import mobile.screens.HomeScreen;
import mobile.screens.LoginScreen;
import mobile.screens.ShiftsScreen;
import io.appium.java_client.android.AndroidDriver;
import mobile.utils.MobileBasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.CommonUtils;
import utils.DriverInit;
import utils.ShiftsUtils;
import utils.UserDataReder;

public class YOUniverseAndroid extends MobileBasePage {


    private AndroidDriver driver;
    private ShiftsUtils shiftsUtils = new ShiftsUtils();
    private CommonUtils commonUtils = new CommonUtils();

    @Test
    @Parameters({"androidVersion", "user"})
    public void getShifts(String androidVersion, String user) {

        driver = new DriverInit().getAndroidDriverForEmulator(androidVersion);
        driver.launchApp();
        commonUtils.sleep(2);

        LoginScreen loginPage = new LoginScreen(driver);
        PageFactory.initElements(driver, loginPage);

        UserDTO userDTO = new UserDataReder().getUser(user);
        loginPage.loginToAPP(userDTO);

        HomeScreen homePage = new HomeScreen(driver);
        PageFactory.initElements(driver, homePage);
        homePage.navigateTosShiftsView();

        ShiftsScreen shiftsScreen = new ShiftsScreen(driver);
        PageFactory.initElements(driver, shiftsScreen);

        shiftsUtils.printShiftDetails(shiftsScreen.getShiftsInfo());


    }

    @AfterTest
    public void closeApp() {
        driver.closeApp();
    }


}
