package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AbstractScreen {
    protected final AppiumDriver driver;

    public AbstractScreen(AppiumDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
    }

    public void hideKeyboard() {
        if (isAndroid()) {
            driver.hideKeyboard();
        } else {
            IOSDriver iosDriver = (IOSDriver) driver;
            iosDriver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
        }
    }

    public boolean isAndroid() {
        return driver instanceof AndroidDriver;
    }

    public boolean isIOS() {
        return driver instanceof IOSDriver;
    }

    public void takeScreenshot() {
        driver.getScreenshotAs(OutputType.BASE64);
    }

    public String getAlertTitle() {
        if (isIOS()) {
            return driver.findElement(By.xpath("//UIAAlert/UIAScrollView/UIAStaticText[1]")).getText();
        } else {
            return driver.findElement(By.id("android:id/alertTitle")).getText();
        }
    }
}
