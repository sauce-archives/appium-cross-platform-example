package screen;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.OutputType;

public class SignUpScreen extends AbstractScreen {

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Name:']/../UIATextField")
    @AndroidFindBy(id = "edittext_display_name")
    MobileElement nameField;

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Email:']/../UIATextField")
    @AndroidFindBy(id = "edittext_email")
    MobileElement emailField;

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Password:']/../UIASecureTextField")
    @AndroidFindBy(id = "edittext_password")
    MobileElement passwordField;

    @iOSFindBy(xpath = "//UIAButton[@label = 'Sign Up']")
    @AndroidFindBy(id = "button_register")
    MobileElement submitSignUpButton;

    public SignUpScreen(AppiumDriver driver) {
        super(driver);
    }

    public void signUpUser(User user) {
        nameField.sendKeys(user.name);
        emailField.sendKeys(user.email);
        passwordField.sendKeys(user.password);
        hideKeyboard();
        takeScreenshot();

        submitSignUpButton.click();
        takeScreenshot();
    }
}
