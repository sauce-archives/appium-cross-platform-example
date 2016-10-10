package screen;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignUpScreen extends AbstractScreen {

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Name:']/../UIATextField")
    @AndroidFindBy(id = "edittext_display_name")
    private MobileElement nameField;

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Email:']/../UIATextField")
    @AndroidFindBy(id = "edittext_email")
    private MobileElement emailField;

    @iOSFindBy(xpath = "//UIAStaticText[@value = 'Password:']/../UIASecureTextField")
    @AndroidFindBy(id = "edittext_password")
    private MobileElement passwordField;

    @iOSFindBy(xpath = "//UIAButton[@label = 'Sign Up']")
    @AndroidFindBy(id = "button_register")
    private MobileElement submitSignUpButton;

    private final String expectedWrongEmailText = "Please Enter Correct Email";

    private final String expectedWrongPasswordText = "Please Enter Your Full Password";

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
    }

    public boolean wrongEmailAlertPresent() {

        String wrongEmailText = getAlertTitle();

        takeScreenshot();

        return wrongEmailText.contains(expectedWrongEmailText);
    }

    public boolean wrongPasswordAlertPresent() {

        String wrongPasswordText = getAlertTitle();

        takeScreenshot();

        return wrongPasswordText.contains(expectedWrongPasswordText);
    }
}
