import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.*;

import java.net.URL;

public class BasicTest {

    private AppiumDriver driver;

    @Before
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "testDevice");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void signUp() {
        WebElement signUpButton = driver.findElement(By.id("textview_mail_register_txt"));
        signUpButton.click();

        WebElement nameField = driver.findElement(By.id("edittext_display_name"));
        nameField.sendKeys("Max");
        driver.hideKeyboard();

        WebElement emailField = driver.findElement(By.id("edittext_email"));
        emailField.sendKeys("maxmustermann@testobject.com");

        WebElement passwordField = driver.findElement(By.id("edittext_password"));
        passwordField.sendKeys("securepassword");
        driver.hideKeyboard();

        WebElement submitSignUpButton = driver.findElement(By.id("button_register"));
        submitSignUpButton.click();

        WebElement welcomeTitle = driver.findElement(By.id("oia_title"));

        String welcomeText = "Max, Ready For Your First Adventure?";
        assertEquals(welcomeText, welcomeTitle.getText());

    }
}
