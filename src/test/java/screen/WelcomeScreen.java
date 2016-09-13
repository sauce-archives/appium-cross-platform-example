package screen;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class WelcomeScreen extends AbstractScreen {

    private final String welcomeTextSuffix = ", READY FOR YOUR FIRST ADVENTURE?";

    @iOSFindBy(xpath = "//UIAStaticText[contains(@label, '" + welcomeTextSuffix + "')]")
    @AndroidFindBy(id = "oia_title")
    MobileElement welcomeTitle;

    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean welcomeMessagePresent(User user) {
        String expectedWelcomeText = user.name + welcomeTextSuffix;
        String welcomeText = welcomeTitle.getText();

        return expectedWelcomeText.toUpperCase().equals(welcomeText);
    }
}
