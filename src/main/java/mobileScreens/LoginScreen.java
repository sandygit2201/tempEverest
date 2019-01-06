package mobileScreens;

import dataObjects.UserDTO;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;

public class LoginScreen {

    private AndroidDriver driver;

    public LoginScreen(AndroidDriver driver) {
        new CommonUtils().sleep(2);
        this.driver = driver;
    }

    @FindBy(xpath = "//android.widget.EditText[@index='1']")
    private WebElement txtLogin;

    @FindBy(xpath = "//android.widget.EditText[@index='3']")
    private WebElement txtPassword;

    @FindBy(xpath = "//android.view.ViewGroup[@index='4']")
    private WebElement btnSignIn;

    public void loginToAPP(UserDTO userDTO) {

        txtLogin.sendKeys(userDTO.getEmailAddress());
        driver.hideKeyboard();
        txtPassword.sendKeys(userDTO.getPassword());
        driver.hideKeyboard();
        try {
            btnSignIn.click();
            btnSignIn.click();
        } catch (Exception e) {
            System.out.println("");
        }

    }

}
