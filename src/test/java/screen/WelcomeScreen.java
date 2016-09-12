package screen;

import data.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomeScreen extends AbstractScreen {

    @AndroidFindBy(id = "oia_title")
    MobileElement welcomeTitle;

    public WelcomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean welcomeMessagePresent(User user) {
        String expectedWelcomeText = user.name + ", Ready For Your First Adventure?";
        String welcomeText = welcomeTitle.getText();

        return expectedWelcomeText.equals(welcomeText);
    }
}
