package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingScreen extends AbstractScreen {

    @iOSFindBy(xpath = "//UIAButton[@label = 'Sign Up With Email']")
    @AndroidFindBy(id = "textview_mail_register_txt")
    MobileElement signUpButton;

    public LandingScreen(AppiumDriver driver) {
        super(driver);
    }

    public void selectSignUp() {
        signUpButton.click();
    }
}
