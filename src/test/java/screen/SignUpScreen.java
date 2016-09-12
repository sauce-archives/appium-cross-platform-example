package screen;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpScreen extends AbstractScreen {

    @AndroidFindBy(id = "edittext_display_name")
    MobileElement nameField;

    @AndroidFindBy(id = "edittext_email")
    MobileElement emailField;

    @AndroidFindBy(id = "edittext_password")
    MobileElement passwordField;

    @AndroidFindBy(id = "button_register")
    MobileElement submitSignUpButton;

    public SignUpScreen(AppiumDriver driver) {
        super(driver);
    }

    public void signUpUser(User user) {
        nameField.sendKeys(user.name);
        driver.hideKeyboard();

        emailField.sendKeys(user.email);

        passwordField.sendKeys(user.password);
        driver.hideKeyboard();

        submitSignUpButton.click();
    }
}
