package appiumTests;

import mobileScreens.HomeScreen;
import mobileScreens.LoginScreen;
import mobileScreens.ShiftsScreen;
import dataObjects.UserDTO;
import io.appium.java_client.android.AndroidDriver;
import mobileUtils.MobileBasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
    @Parameters("androidVersion")
    public void getShifts(String androidVersion) {

        driver = new DriverInit().getAndroidDriverForEmulator(androidVersion);
        driver.launchApp();
        commonUtils.sleep(2);

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



    }

    @AfterTest
    public void closeApp(){
        driver.closeApp();
    }


}
