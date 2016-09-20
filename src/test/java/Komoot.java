import io.appium.java_client.AppiumDriver;
import screen.LandingScreen;
import screen.SignUpScreen;

public class Komoot {
    private AppiumDriver driver;

    public Komoot(AppiumDriver driver) {
        this.driver = driver;
    }

    public LandingScreen landingScreen() {
        return new LandingScreen(driver);
    }

    public SignUpScreen signUpScreen() {
        return new SignUpScreen(driver);
    }
}
